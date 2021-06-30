import React from "react";
import { useState } from "react";
import "./index.css";
import { Link } from "react-router-dom";
//import React from "react-in-jsx-scope";

async function loginUser(username, password) {

  let formData = new FormData();
  formData.append('username',username);
  formData.append('password', password);

 /* const response = await fetch("http://localhost:8080/login", {
    method: "POST",
    mode: "cors",
    referrer: "origin",
    headers: {
      "Content-Type": "multipart/form-data",
      "credentials" : `include`,
    },
    body: formData
  }).catch(err=>alert(`Error: ${err}`));

  console.log(response.ok);*/

 //Hedin want -  not working
  let response1;
  try {

    response1 = await fetch('http://localhost:8080/login', {
      method: 'POST',
      credentials: 'include',
      mode: "cors",
      body: new URLSearchParams({
        'username': username,
        'password': password,
      })
    });
  }
  catch (e) {
    console.error(`ErroR:  `, e);
  }
  try {
  let  js = await response1.json();
  console.log(js.toString());
  }
  catch (e) {
    alert(e);
  }

 //Test of username
  fetch("http://localhost:8080/username", {
    method: 'GET',
    credentials: 'include',
    mode: "cors",
  })
      .then((response) => response.json())
      .then((json) => {
        alert ("получили");
        console.log('Gotcha');
      }).catch((err) => {
    console.log(err);

  });

// Test of registr new user
 /* fetch("http://localhost:3000/register", {
    method: 'POST',
    credentials: 'include',
    mode: "cors",
    headers: { "Content-Type": "application/json" },
    body:  JSON.stringify( {
      'userName': username,
      'password': password,
    })
  })
      .then((response) => response.json())
      .then((json) => {
        alert ("получили");
        console.log('Gotcha');
      }).catch((err) => {
    console.log(err);

  });
*/

  return response1;
  /*  .then((data) => "token" /!*data.json()*!/)
    .catch((reason) => "server not responded");*/
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
    <div>
      <div className="LoginForm">
        <div className="login_table_back">
          <div className="login_items">
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
                {/*<a className="Registration" href="">*/}
                {/*  Регистрация*/}
                {/*</a>*/}
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}
