import axios from 'axios';
import React, { useContext, useEffect, useState } from 'react'
import CarItem from './CarItem';
import { Link } from 'react-router-dom';
import Navibar from '../Navibar/Navibar';
import Footer from '../Footer/Footer';
import { MemberContext } from '../MemberContext';
export default function Car() {

    const { member } = useContext(MemberContext);
    const memberId = member.memberId;
    const [carList, setCarList] = useState(null);
    const [sum, setSum] = useState(0);
    const test = () => {
        axios.get(`http://localhost:8080/car/queryCar?memberId=${memberId}`)
            .then(response => {
                setCarList(response.data);
                console.log(response.data);
            })
    }
    const car = () => {
        axios.get(`http://localhost:8080/shop/querySum?memberId=${memberId}`)
            .then(response => {
                setSum(response.data);
            }).catch(error => {
                console.error('Error fetching sum:', error);

            });
    }
    const handleCar = () => {
        test();
        car();
    }

    useEffect(() => {
        test();
        car();
    }, [memberId])

    const btn = () => {
        if (sum == 0) {
            alert("請先加入商品");
        } else {
            let Click = window.confirm("總金額:" + sum + "元，是否確定結帳");
            if (Click) {
                axios.post('http://localhost:8080/shop/ecpayCheckout')
                    .then(response => {
                        document.write(response.data);
                    })
            }
        }
    }
    return (
        <>
            <Navibar />
            <img src="image/05.jpg" className="img-responsive" id="banner" alt="" />
            <div id="content" className="container">
                <div className='shop-con'>
                    <h3 className="title">| 購物車<small>Car</small></h3>
                    <span><Link to='/shop'><button className='btn btn-default'>繼續購物</button></Link></span>
                    <div className="right">
                        <span>購物車金額: $<span>{sum}</span>
                            <button className='btn btn-default' id='btn1' onClick={btn}>結帳</button>
                            <Link to="/pay"><button className='btn btn-default' id='btn1'>結帳(內部)</button></Link>
                        </span>
                    </div>
                </div>

                {carList && carList.length > 0 ? (

                    <div>
                        {carList.map((carInfo) => <CarItem key={carInfo.carId} carInfo={carInfo} handleCar={handleCar} />)}
                    </div>
                ) : (

                    <div className='shoop'><Link to='/shop'><button className='btn btn-default'>前去購物</button></Link></div>
                )}
            </div>
            <Footer />

        </>
    )



}


