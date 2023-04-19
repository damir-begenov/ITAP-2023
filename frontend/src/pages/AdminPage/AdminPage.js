import React, { Component, useEffect, useState } from "react";
import axios from 'axios';

import './AdminPage.css'
import UsersTable from "../../Components/UsersTable/UsersTable";
import { useLocation, useNavigate } from "react-router-dom";

const baseURL = "http://192.168.30.24:9091/api/finpol/main"

const AdminPage = (props) => {
    const userSession = JSON.parse(localStorage.getItem("user"))
    const navigate = useNavigate()    

    const [users, setUsers] = useState(0)
    const [logs, setLogs] = useState(0)
    const [todayLogs, setTodayLogs] = useState(0)

    const location = useLocation()

    useEffect(() => {
        const a = !userSession.roles.includes("ADMIN") ? navigate('/') : ""

        axios.get(`${baseURL}/general`)
        .then(res => {
            setUsers(res.data.userNumber)
            setLogs(res.data.allLogsNum)
            setTodayLogs(res.data.todayRequests)
            // console.log(this.location)
        })
    })

    return (
        <section>
            <div className="countStats">
                <div className="lastQuery">
                    <div>Количество пользователей</div>
                    <div>{users}</div>
                </div>

                <div>
                    <div>Количество запросов</div>
                    <div>{logs}</div>
                </div>

                <div>
                    <div>Количество запросов за сегодня</div>
                    <div>{todayLogs}</div>
                </div>
            </div>
            <div>
                <UsersTable></UsersTable>
            </div>
            <div className="footer"></div>
        </section>
        
    );
}

export default AdminPage;