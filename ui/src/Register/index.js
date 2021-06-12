import {Link} from "react-router-dom";
import "./register.css";

export default function Register() {
    return (
        <div className="RegisterForm">
            <div className="register_table_back">
                <div className="reg_frame">
                    <div className="reg_items">
                        {/*<form onSubmit={handleSubmit}>*/}
                        <form>
                            <div className="Username">
                                <label className="Pass_reg">
                                    <span>Логин</span>
                                    <input
                                        className="UsernameInput"
                                        type="text"
                                    />
                                </label>{" "}
                            </div>
                            <div className="Username">
                                <label className="Pass_reg">
                                    <span>E-Mail</span>
                                    <input
                                        className="UsernameInput"
                                        type="text"
                                    />
                                </label>
                            </div>
                            <div>
                                <label className="Pass_reg">
                                    <span>Пароль</span>
                                    <input
                                        className="PasswordInput"
                                        type="password"
                                    />
                                </label>
                            </div>
                            <div>
                                <label className="Pass_reg">
                                    <span>Пароль (повтор)</span>
                                    <input
                                        className="PasswordInput"
                                        type="password"
                                    />
                                </label>
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
        </div>
    )

}
