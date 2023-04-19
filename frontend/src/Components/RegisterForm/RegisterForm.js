import React from "react";
import { useForm } from "react-hook-form";
import { Link } from "react-router-dom";
import { Route, Routes, useNavigate } from 'react-router-dom';

import './RegisterForm.css'

import authService from "../../services/auth.service";

const RegisterForm = () => {
    const navigate = useNavigate();

    const {
        register,
        handleSubmit,
        watch,
        formState: { errors }
    } = useForm({
        defaultValues: {
            username: "",
            email: "",
            level: "",
            password: "",
            password_conf: "",
            fio: "",
        }
    });
    const handleRegistration = (data) => {
        console.log(data);
        authService.register(
            data.username,
            data.email,
            data.fio,
            data.password,
            data.level
        ).then(
            response => {
                console.log(response)
                navigate('/login', { replace: true });
            },
            error => {
                console.log(error)
            }
        );
    }
    const handleErrors = (errors) => {
        console.log(errors)
    }

    const registerOptions = {
        username: {
            required: "Username is required",
            minLength: {
                value: 1,
                message: "Minimum length is 1"
            }
        },
        email: {
            required: "Email is required",
            validate: (val) => {
                if (val.length < 1) {
                    return "Email is invalid"
                }
            }
        },
        fio: {
            required: "ФИО обязательна",
            validate: (val) => {
                if (val.length < 4) {
                    return "Не менее 4 символов в ФИО"
                }
            }
        },
        level: {
            required: "Level is required. Please choose уровень доступа"
        },
        password: {
            required: "Password is required",
            minLength: {
                value: 1,
                message: "Password must have at least 1 characters"
            }
        },
        password_conf: {
            required: "Password confirmation is required",
            validate: (val) => {
                if(watch('password') != val) {
                    return "Your passwords do not match"
                }
            },
        }
    };

    return (
        <div>
            <form name="registrationForm" onSubmit={handleSubmit(handleRegistration, handleErrors)}>

                <div className="inputs">
                    <div className="firstLine">
                        <div>
                            <label >ФИО</label>
                            <input
                                type="text"
                                {...register("username", registerOptions.username)}
                                id="username" placeholder="Введите ФИО"
                            />
                        </div>

                        <div>
                            <label >Уровень доступа</label>
                            <div className="level">
                                <select {...register("level", registerOptions.level)} id='level'>
                                    <option value="" disabled selected>Выбрать уровень доступа</option>
                                    <option value="admin">Admin</option>
                                    <option value="vip">Vip</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                </select>
                            </div>

                        </div>
                    </div>

                    <div className="secondLine">


                        <div>
                            <label >Почта</label>
                            <input
                                type="text"
                                {...register("email", registerOptions.email)}
                                id="email" placeholder="Введите почту"
                            />
                        </div>
                    </div>

                    <div className="secondLine">
                        <div>
                            <label>Пароль</label>
                            <input type="password" {...register("password", registerOptions.password)} id="password" placeholder="Введите пароль"/>
                        </div>
                    </div>

                    <div className="thirdLine">
                        <div>
                            <label >Подтверждение пароля</label>
                            <input type="password" {...register("password_conf", registerOptions.password_conf)} id="password-conf" placeholder="Подтвердите пароль"/>
                        </div>
                    </div>
                </div>

                <div className="actions">
                    {/* <Link to='/login'><a>Войти в аккаунт</a></Link> */}
                    <input id="clear" type="button" value="Очистить"/>
                    <input id="register" type="submit" value="Зарегистрировать"/>
                </div>

                {
                    Object.keys(errors).length != 0 ?
                    <div className="errorsBlock">
                        <div className="title">Invalid Registration</div>
                        <div className="errors">
                            {errors.username ? <span>{errors.username?.message}</span> : ""}
                            {errors.email ? <span>{errors.email?.message}</span> : ""}
                            {errors.fio ? <span>{errors.fio?.message}</span> : ""}
                            {errors.level ? <span>{errors.level?.message}</span> : ""}
                            {errors.password ? <span>{errors.password?.message}</span>: ""}
                            {errors.password_conf ? <span>{errors.password_conf?.message}</span> : ""}
                        </div>
                    </div> 
                    : ""
                }
            </form>
        </div>
    );
};

export default RegisterForm;