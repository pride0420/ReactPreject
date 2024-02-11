import React, { Component, useState } from 'react'
import './comment.css';
import axios from 'axios';
export default class CommentList extends Component {

    constructor(props) {
        super(props);
    }
    render() {
        const { commentInfo, memberId, handlcommentList } = this.props;
        const { name, firsttime, comment, commentId, chatId, item } = commentInfo;

        // 将时间戳转换为 Date 对象
        const date = new Date(firsttime);

        // 获取日期部分
        const dateString = date.toLocaleDateString();

        // 获取时间部分
        const timeString = date.toLocaleTimeString();

        const goodcomment = () => {
            let data = {
                commentId: commentId,
                memberId: memberId,
                chatId: chatId
            }
            axios.post("http://localhost:8080/goodComment/addGoodComment", data, {
                headers: { 'Content-Type': 'application/json' }
            })
                .then(response => {
                    alert(response.data);
                })
        }
        return (
            <>
                <table border={1} align='center' className='table'>
                    <tr>
                        <td>留言者:{name}</td>
                        <td>{dateString} {timeString}</td>
                    </tr>
                    <tr>
                        <td colSpan={2} className='comment'>
                            {comment}
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2} >
                            <button className='left' onClick={() => { goodcomment(memberId, chatId, commentId); handlcommentList(); }}>{item ? "已收藏" : "收藏"}</button>
                        </td>
                    </tr>
                </table>
            </>
        )
    }
}

