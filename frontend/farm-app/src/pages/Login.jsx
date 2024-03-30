import React from "react";
import { useNavigate, Link } from "react-router-dom";
import "../style/login.scss";
const handleSubmit = () => {
  navigate("/messages");
};

const Login = () => {
  const navigate = useNavigate();
  return (
    <div className="formContainer">
      <div className="formWrapper">
        <span className="title">Login</span>
        <span className="logo">Farm 2 Table Connect</span>
        <form onSubmit={handleSubmit}>
          <input type="email" placeholder="email" />
          <input type="password" placeholder="password" />

          <button>Login</button>
        </form>
        <p>
          You do not have an account? <Link to="/register">Register</Link>
        </p>
      </div>
    </div>
  );
};

export default Login;
