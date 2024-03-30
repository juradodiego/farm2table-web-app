import React, { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import "../style/settings.scss";

const Settings = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [edit, setEdit] = useState(false);
  const farmer = true;
  const navigate = useNavigate();
  const [clicked, setClicked] = useState(false);

  const handleSubmit = () => {
    navigate("/search");
  };

  return (
    <div className="formContainer">
      <div className="formWrapper">
        <span className="title">Settings</span>
        <span className="logo">Farm 2 Table Connect</span>
        <form onSubmit={handleSubmit}>
          <div className="changeEmail">
            <label htmlFor="">
              <p>Change Email:</p>
            </label>
            <input
              type="email"
              placeholder="Current Email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
          </div>
          <div className="changeEmail">
            <label htmlFor="">
              <p>Change Password:</p>
            </label>
            <input
              type="password"
              placeholder="Current Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
          </div>

          {farmer && (
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
                  <div className="boxes2">
                    <label htmlFor="one">
                      <input type="checkbox" id="one" />
                      <p>Lettuce</p>
                    </label>
                    <label htmlFor="one">
                      <input type="checkbox" id="one" />
                      <p>Tomatoes</p>
                    </label>
                    <label htmlFor="one">
                      <input type="checkbox" id="one" />
                      <p>Onions</p>
                    </label>
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
          )}

          <button>Save</button>
        </form>
      </div>
    </div>
  );
};

export default Settings;
