import React from "react";
import { useNavigate, Link } from "react-router-dom";

const Navbar = () => {
  return (
    <div className="navbar">
      <Link className="link" to="/search">
        <button className="back">Back</button>
      </Link>

      <span className="logo">Farm 2 Table</span>
      <div className="user">
        <img
          src="https://images.pexels.com/photos/1704488/pexels-photo-1704488.jpeg?cs=srgb&dl=pexels-suliman-sallehi-1704488.jpg&fm=jpg"
          alt=""
        />
        <span>Display Name</span>
      </div>
    </div>
  );
};

export default Navbar;
