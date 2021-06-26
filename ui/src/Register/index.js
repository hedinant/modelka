import "./register.css";
import "../alignment.css";
import {Link} from "react-router-dom";

export default function Register() {
    return (
        <div className="RegisterForm">
            <div className="register_table_back">
                <div className="reg_frame">
                    <div className="reg_items">
                        {/*<form onSubmit={handleSubmit}>*/}
                        <form>
                            <div className="Username">
                                <label className="Pass">
                                    <span>Логин</span>
                                    <input
                                        className="UsernameInput"
                                        type="text"
                                    />
                                </label>{" "}
                            </div>
                            <div className="Username">
                                <label className="Pass">
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
                                <button type="submit" className="Button2" name="login" ><span>OK</span> </button>
                                <div className="RestBack">
                                <p><Link className="Restore" to="/register">Восстановить пароль</Link>
                                    </p>
                                    <p><Link className="Back" to="/register">На главную</Link>
                                    </p>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            {/*<div className="Restback">*/}
            {/*<p><Link className="Restore" to="/register">Восстановить пароль</Link>*/}
            {/*</p>*/}
            {/*<p><Link className="Back" to="/register">На главную</Link>*/}
            {/*</p>*/}
            {/*</div>*/}
        </div>
    )

}
