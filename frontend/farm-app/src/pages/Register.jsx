import React from "react";
import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import "../style/register.scss";
import Add from "../img/addAvatar.png";
import "../dropdown";

const Register = () => {
  const [isFarmer, setFarmer] = useState(false);
  return (
    <div className="formContainer2">
      <div className="formWrapper">
        <div className="button">
          <button
            onClick={() => {
              useState(true);
            }}
          >
            Farmer
          </button>
          <button
            onClick={() => {
              useState(false);
            }}
          >
            Customer
          </button>
        </div>
        <span className="title"> Register</span>
        <span className="logo">Farm 2 Table Connect</span>
        <form onSubmit={() => {}}>
          <input type="text" placeholder="display name" />
          <input type="email" placeholder="email" />
          <input type="password" placeholder="password" />
          <input type="location" placeholder="location" />
          <div id="list1" class="dropdown-check-list" tabindex="100">
            <span class="anchor">Select Fruits</span>
            <ul class="items">
              <li>
                <input type="checkbox" />
                Apple{" "}
              </li>
              <li>
                <input type="checkbox" />
                Orange
              </li>
              <li>
                <input type="checkbox" />
                Grapes{" "}
              </li>
              <li>
                <input type="checkbox" />
                Berry{" "}
              </li>
              <li>
                <input type="checkbox" />
                Mango{" "}
              </li>
              <li>
                <input type="checkbox" />
                Banana{" "}
              </li>
              <li>
                <input type="checkbox" />
                Tomato
              </li>
            </ul>
          </div>
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
