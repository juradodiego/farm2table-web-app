import React from "react";
import { useNavigate, Link } from "react-router-dom";

const Settings = () => {
  const navigate = useNavigate();
  const goToSearch = () => {
    navigate("/search");
  };
  return (
    <div>
      <p>This is the settings</p>
      <button onClick={goToSearch}> Back</button>
    </div>
  );
};

export default Settings;
