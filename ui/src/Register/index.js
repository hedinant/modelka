import { useState } from "react";
import { Link } from "react-router-dom";


export default function Register() {

    let out = new String;
const myInit = {
    metod: 'GET' ,
    credentials : "same-origin",
    mode: "no-cors",

        }
    fetch ("http://localhost:8080/username", myInit)
        .then(function (responce) {
        let answer = responce.text();
        out = "<div>"+answer+"</div>";
        return ("<div>"+answer+"</div>")
        })



 /*   const response = fetch("http://localhost:8080/username", {
        method: "GET",
        mode: "no-cors",

    });*/
/*
    return response.text();
*/

    return (out)

}