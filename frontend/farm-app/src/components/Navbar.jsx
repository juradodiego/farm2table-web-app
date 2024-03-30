import React from "react";

const Navbar = () => {
  return (
    <div className="navbar">
      <button>logout</button>
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
