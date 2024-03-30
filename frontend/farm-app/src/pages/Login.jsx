import React from "react";
import { useNavigate, Link } from "react-router-dom";
import "../style/login.scss";
import { login } from "../services/UserService"



const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const navigate = useNavigate();

  const handleSubmit = () => {
      login(email, password);
      navigate("/messages");
  };

  return (
    <div className="formContainer">
      <div className="formWrapper">
        <span className="title">Login</span>
        <span className="logo">Farm 2 Table Connect</span>
        <form onSubmit={handleSubmit}>
          <input type="email" placeholder="email"  value={email} onChange={(e) => setEmail(e.target.value)}/>
          <input type="password" placeholder="password" value={password} onChange={(e) => setPassword(e.target.value)}/>

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
