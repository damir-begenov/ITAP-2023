import React, {Component, useEffect} from "react";
import ReactDOM from "react-dom";
import { Link, useNavigate } from 'react-router-dom'

import { useForm } from "react-hook-form"
import SignInForm from "../../Components/SignInForm/SignInForm";
import './SignInPage.css'

const SignInPage = () => {
    const userSession = JSON.parse(localStorage.getItem("user"))
    const navigate = useNavigate()

    useEffect(() => {
        const a = userSession ? navigate('/') : ""
    })

    return (
        <>
        <div className="signInBlock">
            {userSession ? navigate('/') : <></>}
            <div className="signInPageSection">
                
                <div className="title">
                    <div>iTap</div>
                </div>

                <SignInForm></SignInForm>

            </div>
        </div>
        </>
        )
}

export default SignInPage;