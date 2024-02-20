<h2>留言板及商城</h2>
<h3>
專案採用前後端分離，後端 Spring boot+Mybatis 使用eclipse開發，前端React+css 使用VsCode開發，資料庫MySQL有帳號、貼文、留言、商品、購物車的表，使用foreign key串聯，用join整合成view。
<br><br>
專案內容分為兩部分
<br>
第一部分為留言版:
	登入能看到全部帳號的貼文，並做按讚與回覆，包含新增、修改及刪除。
<br>
第二部分為商城:
	販賣電子商品，手機、電腦、電動與其他相關物件，能在商城頁加入商品進購物車，並在購物車內修改數量與結帳。
<br><br>
內容:
<br>
帳號註冊及登入畫面，註冊畫面會及時用正則表示法檢視email格式是否正確，並確保資料不為空白，註冊成功發送email到註冊者信箱。登入後，前端使用useContext儲存帳號資料並升級至全域，方便後續頁面接收並帶入api，使用useNavigate跳轉進首頁。
<br>
首頁開始後的所有頁面皆使用axios套件呼叫api，使用useEffect及useState hook來做資料的更新及儲存，使用Link跳轉並傳輸特定資料，使用useParams接收。
結帳流程，掛入綠界支付Ecpay的專案，連接綠界測試商家的結帳網站，達到線上支付的結帳流程。
</h3>
