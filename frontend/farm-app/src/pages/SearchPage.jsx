import React from "react";
import "../style/search.scss";
import FarmerReturn from "../components/FarmerReturn";
import { useNavigate, Link } from "react-router-dom";

const SearchPage = () => {
  const navigate = useNavigate();
  const sendToMessage = () => {
    navigate("/messages");
  };

  const logout = () => {
    navigate("/");
  };

  const settings = () => {
    navigate("/settings");
  };

  const sendToReceipts = () => {
    navigate("/pastReceipts");
  };
  return (
    <div>
      <div className="alignButton">
        <button onClick={logout} className="navigation">
          {" "}
          Logout
        </button>
        <button onClick={sendToMessage} className="navigation">
          {" "}
          Messages
        </button>
        <button onClick={sendToReceipts} className="navigation">
          {" "}
          Receipts
        </button>
        <button onClick={settings} className="navigation">
          {" "}
          Settings
        </button>
      </div>
      <form action="" className="main">
        <div className="search-container">
          <input type="text" id="searchField1" placeholder="Location" />
          <select name="" id="">
            <option value="">Strawberry</option>
            <option value="">Strawberry</option>
            <option value="">Strawberry</option>
            <option value="">Strawberry</option>
            <option value="">Strawberry</option>
            <option value="">Strawberry</option>
            <option value="">Strawberry</option>
          </select>
          <button type="button">Search</button>
        </div>
      </form>
      <div className="farmerItems">
        <div onClick={sendToMessage}>
          <FarmerReturn />
        </div>
        <div onClick={sendToMessage}>
          <FarmerReturn />
        </div>
        <div onClick={sendToMessage}>
          <FarmerReturn />
        </div>
        <div onClick={sendToMessage}>
          <FarmerReturn />
        </div>
        <div onClick={sendToMessage}>
          <FarmerReturn />
        </div>
        <div onClick={sendToMessage}>
          <FarmerReturn />
        </div>
        <div onClick={sendToMessage}>
          <FarmerReturn />
        </div>
      </div>
    </div>
  );
};

export default SearchPage;
