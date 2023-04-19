import React from "react";
import { useForm } from "react-hook-form";
import { Link } from "react-router-dom";
import { useNavigate } from 'react-router-dom';

import './SignInForm.css'

import authService from "../../services/auth.service";

const SignInForm = () => {
    const navigate = useNavigate();

    const { 
        register, 
        handleSubmit, 
        watch,
        formState: { errors } 
    } = useForm({
        defaultValues: {
            username: "",
            password: ""
        }
    });
    const handleLogin = (data) => {
        console.log(data);
        authService.login(
            data.username,
            data.password
        ).then(
            response => {
                console.log(response)
                navigate('/');
            },
            error => {
                console.log(error)
            }
        );
    }
    const handleErrors = (errors) => {
        console.log(errors)
    }

    const loginOptions = {
        username: { 
            required: "Username is required", 
            minLength: {
                value: 1,
                message: "Minimum length is 1"
            }
        },
        password: {
            required: "Password is required",
            minLength: {
                value: 1,
                message: "Password must have at least 1 characters"
            }
        }
    };

    return (
        <div>
            <form name="loginForm" onSubmit={handleSubmit(handleLogin, handleErrors)}>

                <div className="inputs">
                    <div className="">
                        <div>
                            <label >Логин</label>
                            <input 
                                type="text" 
                                {...register("username", loginOptions.username)} 
                                id="username" placeholder="Введите логин" 
                            />
                        </div>
                    </div>

                    <div className="secondLine">
                        <div>
                            <label>Пароль</label>
                            <input type="password" {...register("password", loginOptions.password)} id="password" placeholder="Введите пароль"/>
                        </div>
                    </div>

                </div>

                <div className="actions">
                    {/* <Link to='/registration'><a>Нет аккаунта</a></Link> */}
                    <input id="clear" type="button" value="Очистить"/>
                    <input id="register" type="submit" value="Войти"/>
                </div>

                {
                    Object.keys(errors).length != 0 ?
                    <div className="errorsBlock">
                        <div className="title">Invalid Sign in</div>
                        <div className="errors">
                            {errors.username ? <span>{errors.username?.message}</span> : ""}
                            {errors.password ? <span>{errors.password?.message}</span>: ""}
                        </div>
                    </div> 
                    : ""
                }
            </form>
        </div>
    );
};

export default SignInForm;