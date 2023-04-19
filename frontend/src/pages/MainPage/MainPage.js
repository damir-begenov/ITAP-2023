import React, {Component} from "react";
import ReactDOM from "react-dom";
import { Link } from 'react-router-dom'

import './MainPage.css'

export default class MainPage extends Component {
    userSession = JSON.parse(localStorage.getItem("user"))

    render() {
        return (
            
            <header>
                <div className="bgImage"></div>
                <div className="container">
                    <div className="comName">
                        <div>NEXUS</div>
                        <div>SERVICE</div>
                    </div>
                    <div className="actionBtn">
                        {this.userSession 
                            ? <Link to='/searchtool'><div className="tryBtn"><a>TRY</a></div></Link>
                            : <Link to='/login'><div className="tryBtn"><a>TRY</a></div></Link>
                        }
                    </div>
                </div>
            </header>
        )
    }
}