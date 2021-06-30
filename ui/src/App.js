import "./App.css";
import Login from "./Login";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import Dashboard from "./Dashboard";
import Register from "./Register";
import { useState } from "react";

function App() {
  const [token, setToken] = useState();

  // console.log("token " + token)
  // if (!token) {
  //   console.log("Login " + setToken)
  //   return <Login setToken={setToken} />;
  // }

  function MainApp() {
    if (!token) {
      console.log("Login form app " + setToken)
      return <Login setToken={setToken} />;
    }
    return <Dashboard token={token} />
  }

  return (
    <div className="wrapper">
        <Switch>
          <Route path="/register">
            <Register />
          </Route>
          <Route path="/">
            <MainApp/>
          </Route>
        </Switch>
    </div>

    // <div className="App">
    //   <header className="App-header">
    //     <img src={logo} className="App-logo" alt="logo" />
    //     <p>
    //       Edit <code>src/App.js</code> and save to reload.
    //     </p>
    //     <a
    //       className="App-link"
    //       href="https://reactjs.org"
    //       target="_blank"
    //       rel="noopener noreferrer"
    //     >
    //       Learn React
    //     </a>
    //   </header>
    // </div>
  );
}

export default App;
