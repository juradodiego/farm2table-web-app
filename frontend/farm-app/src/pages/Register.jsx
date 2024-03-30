import React from "react";
import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import "../style/register.scss";
import Add from "../img/addAvatar.png";
import "../style/dropdown.js";

const Register = () => {
  const [isFarmer, setFarmer] = useState(false);
  const [clicked, setClicked] = useState(false);
  return (
    <div className="formContainer2">
      <div className="formWrapper">
        <div className="button">
          <button
            onClick={() => {
              setFarmer(true);
            }}
            style={{ backgroundColor: isFarmer ? "#283618" : "#b5651d" }}
          >
            Farmer
          </button>
          <button
            onClick={() => {
              setFarmer(false);
            }}
            style={{ backgroundColor: !isFarmer ? "#283618" : "#b5651d" }}
          >
            Customer
          </button>
        </div>
        <span className="title"> Register</span>
        <span className="logo">Farm 2 Table Connect</span>
        <form onSubmit={() => {}}>
          <input type="text" placeholder="First Name, Last Name" />
          <input type="email" placeholder="email" />
          <input type="password" placeholder="password" />
          {isFarmer && (
            <div>
              <input type="location" placeholder="location" />
              <div className="multiselect">
                <div
                  className="selectBox"
                  onClick={() => {
                    setClicked(!clicked);
                  }}
                >
                  <select>
                    <option>Select Produce to Sell</option>
                  </select>
                  <div className="overSelect"></div>
                </div>
                <div id="checkboxes">
                  {clicked && (
                    <div className="boxes">
                      <label htmlFor="one">
                        <input type="checkbox" id="one" />
                        <p>Watermelon</p>
                      </label>
                      <label htmlFor="two">
                        <input type="checkbox" id="two" />
                        <p>Blueberries</p>
                      </label>
                      <label htmlFor="three">
                        <input type="checkbox" id="three" />
                        <p>Strawberries</p>
                      </label>
                    </div>
                  )}
                </div>
              </div>
            </div>
          )}
          <input style={{ display: "none" }} type="file" id="file" />
          <label htmlFor="file">
            <img src={Add} alt="" />
            <span>Add an avatar</span>
          </label>

          <button>Login</button>
        </form>
        <p>
          You do have an account?<Link to="/">Login</Link>
        </p>
      </div>
    </div>
  );
};

export default Register;
