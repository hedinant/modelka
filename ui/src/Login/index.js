import { useState } from "react";
import "./index.css";
import { Link } from "react-router-dom";

async function loginUser(username, password) {
  return fetch("http://localhost:8080/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ username, password }),
  })
    .then((data) => "token" /*data.json()*/)
    .catch((reason) => "server not responded");
}

export default function Login({ setToken }) {
  console.log("Login in " + setToken);

  const [username, setUserName] = useState();
  const [password, setPassword] = useState();

  const handleSubmit = async (e) => {
    e.preventDefault();
    const token = await loginUser(username, password);
    console.log("submit " + setToken);
    setToken(token);
  };

  return (
    <>
      <div className="LoginForm">
        <form onSubmit={handleSubmit}>
          <div className="Username">
            <span>Username</span>
            <input
              className="UsernameInput"
              type="text"
              onChange={(e) => setUserName(e.target.value)}
            />
          </div>
          <label className="">
            <span>Password</span>
            <input
              className="PasswordInput"
              type="password"
              onChange={(e) => setPassword(e.target.value)}
            />
          </label>{" "}
          <div className="Okreg">
            <button type="submit" className="Button1" name="login">
              OK
            </button>
            <Link to="/register">Регистрация</Link>
            <a className="Registration" href="">
              Регистрация
            </a>
          </div>
        </form>
      </div>
    </>
  );
}
