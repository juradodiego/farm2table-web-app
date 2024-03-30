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
  return (
    <div>
      <button onClick={logout} className="navigation">
        {" "}
        Logout
      </button>
      <div className="alignButton">
        <button onClick={sendToMessage} className="navigation">
          {" "}
          Messages
        </button>
        <button className="navigation"> Receipts</button>
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
        <FarmerReturn />
        <FarmerReturn />
        <FarmerReturn />
        <FarmerReturn />
        <FarmerReturn />
        <FarmerReturn />
        <FarmerReturn />
        <FarmerReturn />
        <FarmerReturn />
        <FarmerReturn />
      </div>
    </div>
  );
};

export default SearchPage;
