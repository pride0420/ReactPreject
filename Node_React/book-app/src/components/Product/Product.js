import axios from 'axios';
import React, { useState, useEffect, useContext } from 'react';
import { useParams, useLocation } from 'react-router-dom';
import ProductItem from './ProductItem';
import Footer from '../Footer/Footer';
import { Link } from 'react-router-dom';
import Navibar from '../Navibar/Navibar';
import { MemberContext } from '../MemberContext';
import './product.css';
function Product() {
    const { items } = useParams();
    const [productList, setProductList] = useState(null);
    const [sum, setSum] = useState(null);
    const { member } = useContext(MemberContext);
    const memberId = member.memberId;

    useEffect(() => {
        queryItems(items);
        querySum();
    }, [items]); // 当 URL 参数变化时重新加载数据

    const queryItems = (items) => {
        axios.get(`http://localhost:8080/porder/queryItems?items=${items}`)
            .then(response => {
                setProductList(response.data);
            })
            .catch(error => {
                console.error('Error fetching data:', error);
                // 处理错误情况
            });
    }
    const querySum = () => {
        axios.get(`http://localhost:8080/shop/querySum?memberId=${memberId}`)
            .then(response => {
                if (response && response.data) {
                    setSum(response.data);
                } else {
                    console.error('Response data is undefined:', response);
                }
            }).catch(error => {
                console.error('Error fetching sum:', error);
            });
    }
    
    const updateProductList = () => {
        // 更新 productList 数据
        querySum();
    }
    
    return (
        <>
            <Navibar />
            <img src="/image/05.jpg" className="img-responsive" id="banner" alt="" />
            <div id="content" className="container">
                <div className='shop-con'>
                    <h3 className="title">| 產品介紹<small>Product</small></h3>
                    <span><Link to='/shop'><button className='btn btn-default'>回上一頁</button></Link></span>

                    <div className="right">
                        <span>購物車金額: $<span>{sum !== null ? sum : '0'}</span>
                            <Link to="/car"><button className="btn btn-default">查看購物車</button></Link></span>
                    </div>
                </div>
                <div className="list-container">
                    {productList && productList.map((productInfo) => <ProductItem key={productInfo.productId} productInfo={productInfo} updateProductList={updateProductList} />)}
                </div>
            </div>
            <div className='butoon-shop'>
                <button className="btn btn-default" onClick={() => { queryItems("手機") }}>手機</button>
                <button className="btn btn-default" onClick={() => { queryItems("電腦") }}>電腦</button>
                <button className="btn btn-default" onClick={() => { queryItems("電動") }}>電動</button>
                <button className="btn btn-default" onClick={() => { queryItems("其他") }}>其他</button>
            </div>
            <Footer />
        </>
    );
}

export default Product;