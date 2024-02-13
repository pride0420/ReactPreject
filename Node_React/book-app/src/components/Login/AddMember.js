import React, { Component } from 'react'
import './login.css';
import axios from 'axios';

export default class AddMember extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: null,
            password: null,
            name: null,
            phone: null,
            email: null,
            x: false // 新增 x 狀態
        }
        this.checkEmail = this.checkEmail.bind(this); // 綁定 checkEmail 方法
    }

    render() {
        return (
            <>
                <div className="background-divs">
                    <div className="words text-center">
                        <form name='myAddMember' onSubmit={this.test.bind(this)}>
                            <table align='center' border={1}>
                                <tr>
                                    <td>帳號:</td>
                                    <td><input type='text' name='username' onKeyDown={this.handleKeyDown} required /></td>
                                </tr>
                                <tr>
                                    <td>密碼:</td>
                                    <td><input type='password' name='password' onKeyDown={this.handleKeyDown} required /></td>
                                </tr>
                                <tr>
                                    <td>暱稱:</td>
                                    <td><input type='text' name='name' onKeyDown={this.handleKeyDown} required /></td>
                                </tr>
                                <tr>
                                    <td>電話:</td>
                                    <td><input type='text' name='phone' onKeyDown={this.handleKeyDown} required /></td>
                                </tr>
                                <tr>
                                    <td>信箱:</td>
                                    <td><input type='text' name='email' onBlur={this.checkEmail} onKeyDown={this.handleKeyDown} required /></td>
                                </tr>
                                <tr>
                                    <td colSpan={2} id="tdId" style={{ display: this.state.x ? "table-cell" : "none" }}>
                                        <input type='submit' name='ok' />
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </>
        )
    }

    test(e) {
        e.preventDefault(); // 防止表單的預設提交行為
        let data = {
            username: document.myAddMember.username.value,
            password: document.myAddMember.password.value,
            name: document.myAddMember.name.value,
            phone: document.myAddMember.phone.value,
            email: document.myAddMember.email.value
        }

        if (!/^\w+@\w+\.\w+$/.test(data.email) && data.email != "") {
            alert("信箱格式不正確");
            this.setState({ x: false }); // 設定 x 為 false
            e.preventDefault();
        } else {
            axios.post("http://localhost:8080/member/addMember", data, {
                header: { 'Content-Type': 'application/json' }
            })
                .then(response => {
                    if (response.data) {
                        alert("新增成功");
                    } else {
                        alert("帳號重複");
                    }
                }).catch(error => {
                    console.error("發生錯誤:", error);
                    alert("新增失敗");
                });
        }
    }

    checkEmail(e) {

        let str = e.target.value;
        if (!/^\w+@\w+\.\w+$/.test(str) && str != "") {
            alert("信箱格式不正確");
            this.setState({ x: false }); // 設定 x 為 false

        } else if (str == '') {
            this.setState({ x: false }); // 設定 x 為 false

        } else {
            this.setState({ x: true }); // 設定 x 為 true
        }
    };

    handleKeyDown(event) {
        // 檢查按鍵是否為空格，如果是則阻止默認行為
        if (event.key === ' ') {
            event.preventDefault();
        }
    }
}

