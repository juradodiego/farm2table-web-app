import React from "react";
import Chat from "../components/Chat";
import SideBar from "../components/SideBar";

const Messages = () => {
  return (
    <div className="home">
      <div className="container">
        <SideBar />
        <Chat />
      </div>
    </div>
  );
};

export default Messages;
