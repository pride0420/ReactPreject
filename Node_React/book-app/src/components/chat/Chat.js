import React, { useState, useEffect, useContext } from 'react';
import { useLocation } from 'react-router-dom';
import Navibar from '../Navibar/Navibar';
import axios from 'axios';
import ChatItems from './ChatItems';
import './chat.css';
import Footer from '../Footer/Footer';
import { MemberContext } from '../MemberContext';

function Chat() {
    const [chatList, setChatList] = useState(null);
    const location = useLocation();
    const { member } = useContext(MemberContext);
    const [content, setContent] = useState("");
    const memberId = member.memberId;
    
    const changeChat = (e) => {
        const { name, value } = e.target;
        if (name === "content") setContent(value);
    }

    const queryAll = () => {

        const url = `http://localhost:8080/chat/queryAll?memberId=${memberId}`;
        axios.get(url, {
            headers: { 'Content-Type': 'application/json' }
        })
            .then(response => {
                setChatList(response.data);
                //console.log(response.data);
            })
            .catch(error => {
                console.error('Error fetching chat list:', error);
            });
    }

    useEffect(() => {
        queryAll();
    }, [queryAll]);

    const addChat = (e) => {
        e.preventDefault();

        const data = {
            content: content,
            memberId: memberId
        }
        axios.post("http://localhost:8080/chat/addChat", data, {
            headers: { 'Content-Type': 'application/json' }
        })
            .then(response => {
                document.getElementsByName("content")[0].value = ""; // 设置 textarea 的值为空
                alert("新增成功");

            }).catch(error => {
                console.error('Error adding chat:', error);
                alert("新增失败");
            });
    }

    return (
        <>
            <Navibar />
            <img src="image/05.jpg" className="img-responsive" id="banner" alt="" />
            <div id="content" className="container">
                <div className='chatBox'>
                    <form name='myChat' onSubmit={addChat}>
                        <table border={1} align='center' className='table'>
                            <tr>
                                <td>發文者:</td>
                                <td name='name'>{member.name}</td>
                            </tr>
                            <tr>
                                <td>內容:</td>
                                <td><textarea name='content' rows={5} cols={70} onChange={changeChat} required /></td>
                            </tr>
                            <tr>
                                <td colSpan={2}>
                                    <input type='submit' value="ok" />
                                    <input type='reset' value='清除' />
                                </td>
                            </tr>
                        </table>
                    </form>
                    <div>
                        {chatList && chatList.map((chatInfo) => (
                            <ChatItems key={chatInfo.chatId} chatInfo={chatInfo} memberId={memberId} queryAll={queryAll} />
                        ))}
                    </div>
                </div>
            </div>
            <Footer />
        </>
    );
}

export default Chat;