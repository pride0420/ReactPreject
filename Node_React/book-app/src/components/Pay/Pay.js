import React, { useContext, useEffect, useState } from 'react';
import Navibar from '../Navibar/Navibar';
import { MemberContext } from '../MemberContext';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';
import Footer from '../Footer/Footer';
export default function Pay() {
    const { member } = useContext(MemberContext);
    const [email, setEmail] = useState(member.email);
    const [isEmailValid, setIsEmailValid] = useState(true);
    const [sum, setSum] = useState(0);
    const memberId = member.memberId;
    const navigate = useNavigate();

    const checkEmail = (value) => {
        setIsEmailValid(/^\w+@\w+\.\w+$/.test(value) || value === "");
    }
    const changeEmail = (e) => {
        const { name, value } = e.target;
        if (name === 'email') {
            setEmail(value);
            checkEmail(value);
        }
    }

    const querySum = () => {
        axios.get(`http://localhost:8080/shop/querySum?memberId=${memberId}`)
            .then(response => {
                setSum(response.data);
            }).catch(error => {
                console.error('Error fetching sum:', error);

            });
    }

    const checkSubmit = (e) => {
        e.preventDefault();
        if (!isEmailValid) {
            alert("信箱錯誤");
            return;
        } else {
            axios.post(`http://localhost:8080/car/checkCar?memberId=${memberId}&email=${email}`)
                .then(response => {
                    alert("購買成功");
                    navigate("/shop");
                })
        }
    }

    const resetEmail = () => {
        setEmail(member.email);
    }

    useEffect(() => {
        querySum();
    })
    return (
        <>
            <Navibar />
            <img src="image/05.jpg" className="img-responsive" id="banner" alt="" />
            <table align='center' border={1} width="500">
                <caption><h2>訂單資訊</h2></caption>
                <tr>
                    <td>商家:</td>
                    <td>神龍</td>
                </tr>
                <tr>
                    <td>購買者:</td>
                    <td>{member.name}</td>
                </tr>
                <td>商品金額:</td>
                <td>{sum}</td>
                <tr align="right">
                    <td colspan="2">實際付款金額:&nbsp;&nbsp;&nbsp;NT$<b>{sum}</b></td>
                </tr>
                <tr>
                    <td colSpan={2}>
                        <Link to="/shop"><button>回商城</button></Link>
                    </td>
                </tr>
            </table>

            <hr />
            <form onSubmit={checkSubmit}>
                <table width="610" border="1" align="center">
                    <tr align="center">
                        <td>信用卡號:</td>
                        <td align="left"><input type="text" maxlength="4" minlength="4" required size="4" /> -
                            <input type="text" maxlength="4" minlength="4" required size="4" /> -
                            <input type="text" maxlength="4" minlength="4" required size="4" /> -
                            <input type="text" maxlength="4" minlength="4" required size="4" /></td>
                    </tr>
                    <tr align="center">
                        <td>有效年月:</td>
                        <td align="left"><input type="text" placeholder="MM" maxlength="2" minlength="2" size="3" required />&nbsp;
                            <input type="text" placeholder="YY" maxlength="2" minlength="2" size="3" required /></td>
                    </tr>
                    <tr align="center">
                        <td>安全碼:</td>
                        <td align="left"><input type="text" maxlength="3" minlength="3" size="3" required /></td>
                    </tr>
                    <tr align="center">
                        <td>持卡人姓名:</td>
                        <td align="left"><input type="text" size="5" required /></td>
                    </tr>
                    <tr align="center">
                        <td>送貨地址:</td>
                        <td align="left"><input type="text" required /></td>
                    </tr>
                    <tr align="center">
                        <td>信箱:</td>
                        <td align="left"><input type="text" name="email" value={email} placeholder={member.email} onChange={changeEmail} required /></td>
                    </tr>
                    <tr align="center">
                        <td colspan="2">
                            <input type="submit" value="立即付款" />
                            <input type='reset' value="重設" onClick={resetEmail} />
                        </td>
                    </tr>
                </table>
            </form>
            <Footer />
        </>
    )
}

