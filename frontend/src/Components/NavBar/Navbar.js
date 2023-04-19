import { Component, useEffect } from "react";
import { Link } from 'react-router-dom'
import React from "react";
import { useForm } from "react-hook-form";
import { Route, Routes, useNavigate } from 'react-router-dom';
import './NavBar.css'

import authService from "../../services/auth.service";

const Navbar = () => {
    const userSession = JSON.parse(localStorage.getItem("user"))
    const navigate = useNavigate()    

    const logoutHandler = () => {
        authService.logout();
        // navigate('/login');
    }

    useEffect(() => {
        const a = !userSession ? navigate('/login') : ""
    })

    const toAdmin = () => {
        navigate('/admin')
    }
    const toLogin = () => {
        navigate('/login')
    }

    return (
        <>
        <div className="nav-back">
            <nav className="NavbarItems">
                <h1 className="logo"><Link to='/'>ITap</Link></h1>
                <div>
                    {console.log(userSession.roles.includes("ADMIN"))}
                    {
                        userSession && 
                        userSession.roles.includes("ADMIN")
                        ?  (
                            <>
                            <div className="admin"><a onClick={() => toAdmin()}>Админ панель</a></div>
                            <div className="admin"><Link to="/registration">Регистрация</Link></div>
                            </>
                        ) : ("")
                    }
                   
                    <ul className="nav-menu">
                    {userSession ? 
                        <>
                            {/* <style>
                                
                            </style> */}
                            <li>
                                <a className={"nav-email"}>
                                    <span>{userSession.email}</span>
                                </a>
                            </li>
                            <li><Link className={"nav-links"} to={"/login"} onClick={logoutHandler}>Выйти</Link></li>
                        </> 
                        :
                        <>
                            {/* <li><a className={"nav-links"} href={"http://localhost:3000/registration"}>SIGN UP</a></li> */}
                            {/* <li><a className={"nav-links"} href={"http://localhost:3000/login"}>LOG IN</a></li> */}
                        </>
                    }
                </ul>
                </div>
                
            </nav>
        </div>
        </>
    )
}

export default Navbar