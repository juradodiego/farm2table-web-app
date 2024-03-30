import React from "react";
import Messaging from "./Messaging";
import Input from "./Input";

const Chat = () => {
  return (
    <div className="chat">
      <div className="chatInfo">
        <span>Display Name1</span>
        <div className="chatIcons">
          <img src="" alt="" />
          <img src="" alt="" />
          <img src="" alt="" />
        </div>
      </div>
      <Messaging />
      <Input />
    </div>
  );
};

export default Chat;
