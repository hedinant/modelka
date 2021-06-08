import {Link} from "react-router-dom";
import "./register.css";

export default function Register() {
    return (
        <div className="RegisterForm">
            <div className="register_table_back">
                <div className="login_items">
            {/*<form onSubmit={handleSubmit}>*/}
            <form>
                <div className="Username">
                    <span>Логин</span>
                    <input
                        className="UsernameInput"
                        type="text"
                    />
                </div>
                <div> Пароль
                <input
                    className="PasswordInput"
                    type="password"
                />
                </div>
                <div> Повтор пароля
                <input
                    className="PasswordInput"
                    type="password"
                />
                </div>
                <div className="Username">
                    <span>Почта</span>
                    <input
                        className="UsernameInput"
                        type="text"
                    />
                </div>
                <div className="Okreg">
                    <button type="submit" className="Button1" name="login">
                        OK
                    </button>
                </div>
            </form>
        </div>
            </div>
        </div>
    )

}
