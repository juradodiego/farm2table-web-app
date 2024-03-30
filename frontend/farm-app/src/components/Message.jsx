import React from "react";

const Message = () => {
  return (
    <div className={"message owner"}>
      <div className="messageInfo">
        <img
          src="https://images.pexels.com/photos/1704488/pexels-photo-1704488.jpeg?cs=srgb&dl=pexels-suliman-sallehi-1704488.jpg&fm=jpg"
          alt=""
        />
        <span>just now</span>
      </div>
      <div className="messageContent">
        <p>Message Text</p>
      </div>
    </div>
  );
};

export default Message;
