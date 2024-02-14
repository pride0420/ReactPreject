import React, { useContext, useState } from 'react'
import { MemberContext } from '../MemberContext'
import './about.css';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
export default function SetUser() {
    const { member, updateMember ,restMember} = useContext(MemberContext);
    const memberId = member.memberId;
    const username = member.username;
    const [name, setName] = useState(member.name);
    const [password, setPassword] = useState(member.password);
    const [phone, setPhone] = useState(member.phone);
    const [email, setEmail] = useState(member.email);
    const [isEmailValid, setIsEmailValid] = useState(true);
    const [emailError, setEmailError] = useState('');
    const navigate = useNavigate();

    const changeUser = (e) => {
        const { name, value } = e.target;
        if (name === 'name') {
            setName(value);
        }
        if (name === 'password') {
            setPassword(value);
        }
        if (name === 'phone') {
            setPhone(value);
        }
        if (name === 'email') {
            setEmail(value);
            setIsEmailValid(/^\w+@\w+\.\w+$/.test(value));
            setEmailError(/^\w+@\w+\.\w+$/.test(value) ? '' : '信箱格式不正確');
        }
    }

    const checkSubmit = (e) => {
        e.preventDefault();
            let data = {
                username: username,
                name: name,
                password: password,
                phone: phone,
                email: email
            }
            axios.post("http://localhost:8080/member/updateMember", data, {
                headers: { 'Content-Type': 'application/json' }
            })
                .then(response => {
                    updateMember(response.data);
                    alert("修改成功");
                })
                .catch(error => {
                    // 处理错误
                    console.error("修改失败:", error);
                });
        }

    const handleReset = () => {
        // 将输入框的值恢复为 member 原来的值
        setName(member.name);
        setPassword(member.password);
        setPhone(member.phone);
        setEmail(member.email);
        setIsEmailValid(true); // 重置邮箱验证状态
    }

    const btnDelete = () => {
        let Click = window.confirm("是否確定註銷");
        if (Click) {
            axios.post(`http://localhost:8080/member/deleteMember?memberId=${memberId}`)
                .then(response => {
                    restMember();
                    navigate("/");
                })
        }
    }
    return (

        <div className='Box'>
            <form onSubmit={checkSubmit}>
                <table align='center' border={1} width="600">
                    <tr>
                        <td>暱稱</td>
                        <td><input type='text' name='name' value={name} placeholder={member.name} onChange={changeUser} required /></td>
                    </tr>
                    <tr>
                        <td>密碼</td>
                        <td><input type='password' name='password' value={password} placeholder={member.password} onChange={changeUser} required /></td>
                    </tr>
                    <tr>
                        <td>電話</td>
                        <td><input type='text' name='phone' pattern="\d*" value={phone} placeholder={member.phone} onChange={changeUser} required /></td>
                    </tr>
                    <tr>
                        <td>信箱</td>
                        <td><input type='text' name='email' value={email} placeholder={member.email} onChange={changeUser} required /><br />
                            {emailError && <span className='error' style={{ color: 'red' }}>{emailError}</span>}
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2}>
                            <input type='submit' value="修改" disabled={!isEmailValid} />
                            <input type='reset' value='復原' onClick={handleReset} />
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2}><button onClick={btnDelete}>註銷帳號</button></td>
                    </tr>
                </table>
            </form>
        </div>
    )
}

