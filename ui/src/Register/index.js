import React from 'react';

//import { useForm } from "react-hook-form";
import ReactDOM from 'react-dom';
import { useState } from "react";
import { Link } from "react-router-dom";


/*
const useFormField = (initialValue: string = '') => {
    const [value, setValue] = React.useState(initialValue);
    const onChange = React.useCallback((e: React.ChangeEvent<HTMLInputElement>) => setValue(e.target.value), []);
    return { value, onChange };
};
*/
async function registerUser (username,password) {

    let response = await fetch ('http://localhost:3000/register',{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body:  JSON.stringify( {
            'userName': username,
            'password': password
            })
        });
    if (response != null) {
        console.log(response.toString);
    }


}




export default function Register() {

/*    const { register, handleSubmit, errors } = useForm(); // инициализация хука
    const onSubmit = (data) => {
        console.log(data);
    };
*/
   /* const { formFields, createChangeHandler } = useFormField({
        email: '',
        password: '',
    });

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
    //    api.login(formFields.email, formFields.password);
        alert (formFields.email);
    };*/
    const [username, setUserName] = useState();
    const [password, setPassword] = useState();

    const handleSubmit = async (e) => {
        e.preventDefault();
    //    const token = await loginUser(username, password);
        const resp = await registerUser (username,password);
        if (resp == "all ok") {
            console.log("registred " + username + "  " + password);
            alert ("User"+ username + "registred sucsesful");
        } else {
            console.log(resp);
            alert(resp);
        }
    }

    return (

        <>
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
                                <Link to="/login">Логин</Link>
                                {/*<a className="Registration" href="">*/}
                                {/*  Регистрация*/}
                                {/*</a>*/}
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </>
    );

}