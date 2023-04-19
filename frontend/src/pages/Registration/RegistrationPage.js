import React, {Component} from "react";
import ReactDOM from "react-dom";
import { Link } from 'react-router-dom'

import './RegistrationPage.css'
import { useForm } from "react-hook-form"

import RegisterForm from "../../Components/RegisterForm/RegisterForm";

export default class RegistrationPage extends Component {
    render() {
        return (
            <section>
                <div className="title">
                    <div>Регистрация</div>
                </div>

                <RegisterForm></RegisterForm>
            </section>
        )
    }
}