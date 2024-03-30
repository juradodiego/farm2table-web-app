import React from "react";
import Receipt from "./Receipt";

const Input = () => {
  return (
    <div className="input">
      <input type="text" placeholder="Type something..." />
      <div className="send">
        <input type="file" style={{ display: "none" }} id="file" />
        <Receipt />
        <button>Send</button>
      </div>
    </div>
  );
};

export default Input;
