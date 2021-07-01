import {useState} from "react";
import "./index.css";
import "../alignment.css";
import {Link} from "react-router-dom";

async function loginUser(username, password) {
    return fetch("http://localhost:3000/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({username, password}),
    })
        // .then((data) => "token" /*data.json()*/)
        // .catch((reason) => "server not responded");
}

export default function Login({setToken}) {
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
                <div className="login_table_back">
                    <div className="login_frame">
                        <div className="login_items">
                            <form onSubmit={handleSubmit}>
                                <label className="Pass">
                                    <span>Логин</span>
                                    <input
                                        className="UsernameInput"
                                        type="text"
                                        onChange={(e) => setUserName(e.target.value)}
                                    />

                                </label>
                                <label className="Pass">
                                    <span>Пароль</span>
                                    <input
                                        className="PasswordInput"
                                        type="password"
                                        onChange={(e) => setPassword(e.target.value)}
                                    />

                                </label>
                                <div className="Okreg">
                                    <button type="submit" className="Button1" name="login">
                                        <span> OK </span>
                                    </button>
                                    <p><Link className="Registration" to="/register">Регистрация</Link></p>
                                    {/*<a className="Registration" href="">*/}
                                    {/*  Регистрация*/}
                                    {/*</a>*/}

                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}
