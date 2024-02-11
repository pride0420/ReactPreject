import React, { useEffect, useState, useContext } from 'react'
import './about.css'
import { MemberContext } from '../MemberContext';
import axios from 'axios';
export default function UserChatItem(props) {
    const { userChatListInfo, queryUserChat } = props;
    const { chatId, name, content, firsttime } = userChatListInfo;

    // 将时间戳转换为 Date 对象
    const date = new Date(firsttime);

    // 获取日期部分
    const dateString = date.toLocaleDateString();

    // 获取时间部分
    const timeString = date.toLocaleTimeString();

    const deleteChat = () => {
        let url = `http://localhost:8080/chat/deleteChat?chatId=${chatId}`;
        axios.post(url)
            .then(response => {
                alert(response.data);
                props.queryUserChat();
            })
    }

    return (
        <>
            <table align='center' border={1} className='table'>
                <tr>
                    <td>{name}</td>
                    <td>{dateString} {timeString}</td>
                </tr>
                <tr>
                    <td colSpan={2} className='chat-content'>{content}</td>
                </tr>
                <tr>
                    <td colSpan={2} >
                        <button className='button-right' onClick={() => { deleteChat(chatId); queryUserChat(); }}>刪除</button>
                    </td>
                </tr>
            </table>
        </>
    )
}

