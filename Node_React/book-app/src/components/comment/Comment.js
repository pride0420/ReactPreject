import React, { useEffect, useContext, useState } from 'react'
import axios from 'axios'
import Navibar from '../Navibar/Navibar'
import Footer from '../Footer/Footer'
import './comment.css';
import CommentItem from './CommentItem';
import { useParams, useLocation } from 'react-router-dom';
import { MemberContext } from '../MemberContext';
import CommentList from './CommentList';
function Comment() {
    const { member } = useContext(MemberContext); // 使用 useContext 获取 Member 数据
    const memberId = member ? member.memberId : null;
    const { chatId } = useParams();
    const [comment, setComment] = useState("");
    const [commentItem, setCommentItem] = useState(null);
    const [commentList, setCommentList] = useState(null);

    const chlickComment = (e) => {
        const { name, value } = e.target;
        if (name === 'comment') {
            setComment(value);
        }
    }
    const handlcommentList = () => {
        queryList(); // 重新执行 queryList 函数
    }
    const addComment = (e) => {
        e.preventDefault();
        let data = {
            memberId: memberId,
            chatId: chatId,
            comment: comment
        }
        axios.post("http://localhost:8080/comment/addComment", data, {
            headers: { 'Content-Type': 'application/json' }
        })
            .then(response => {
                alert("新增成功");
            }).catch(error => {
                console.error('Error adding chat:', error);
                alert("新增失败");
            });
    }

    useEffect(() => {
        queryItem();
        queryList();

    }, [memberId, member, handlcommentList]);

    const queryItem = () => {
        const url = `http://localhost:8080/chat/queryChat?chatId=${chatId}`;
        axios.get(url, { headers: { 'Content-Type': 'applicato=ion/json' } })
            .then(response => {
                setCommentItem(response.data);
            }).catch(error => {
                console.error('Error fetching commentItem :', error);
            })
    }
    const queryList = () => {
        const url = `http://localhost:8080/comment/queryAllComment?chatId=${chatId}&memberId=${memberId}`;

        axios.get(url, { headers: { 'Content-Type': 'application/json' } })
            .then(response => {
                console.log(response.data);
                setCommentList(response.data);
            }).catch(error => {
                console.error('Error fetching commentList :', error);
            })
    }
    const handleSubmit = (e) => {
        console.log('Event:', e); // 查看事件对象的内容
        e.preventDefault();
        addComment(e); // 调用 addComment 函数
        queryItem(); // 重新执行 queryItem 函数
        queryList(); // 重新执行 queryList 函数
    }

    return (
        <>
            <Navibar />
            <img src="image/05.jpg" className="img-responsive" id="banner" alt="" />
            {commentItem && <CommentItem commentInfo={commentItem} />}
            <form onSubmit={handleSubmit}>
                <table align='' border={1} className='table'>
                    <tr>
                        <td>
                            <textarea name='comment' rows={5} cols={70} onChange={chlickComment} required></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type='submit' value="ok" />
                            <input type='reset' value='清除' />
                        </td>
                    </tr>
                </table>
            </form>
            {commentList && commentList.map((commentInfo) => (<CommentList key={commentInfo.commentId} commentInfo={commentInfo} memberId={memberId} handlcommentList={handlcommentList} />))}
            <Footer />
        </>
    )
}
export default Comment;