import React, { createContext, useState } from 'react';

export const MemberContext = createContext();

export const MemberProvider = ({ children }) => {
  const [member, setMember] = useState(null);
  const [isLoggin, setIsLoggin] = useState(false); // 添加 isLoggedIn 状态

  const updateMember = (newMember) => {
    setMember(newMember);
    setIsLoggin(true);
  };

  const restMember = () => {
    setMember(null);
    setIsLoggin(false); // 在登出时设置为 false
  }

  return (
    <MemberContext.Provider value={{ member, updateMember, restMember, isLoggin }}>
      {children}
    </MemberContext.Provider>
  );
};