import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './components/Home/Home';
import About from './components/About/About';
import Shop from './components/shop/Shop';
import Product from './components/Product/Product';
import Car from './components/Car/Car';
import Pay from './components/Pay/Pay';
import Chat from './components/chat/Chat';
import Comment from './components/comment/Comment';
import { MemberProvider } from './components/MemberContext'
function App() {
  return (
    <MemberProvider>
      <Router>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/chat" element={<Chat />} />
          <Route path="/shop" element={<Shop />} />
          <Route path='/products' element={<Product />} />
          <Route path='/products/:items' element={<Product />} />
          <Route path='/car' element={<Car />} />
          <Route path='/pay' element={<Pay />} />
          <Route path="/about" element={<About />} />
          <Route path='/comment' element={<Comment />} />
          <Route path='/comment/:chatId' element={<Comment />} />
        </Routes>
      </Router>
    </MemberProvider>
  );
}

export default App;
