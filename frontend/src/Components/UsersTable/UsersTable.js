import { Component } from "react";
import { Link } from 'react-router-dom'
import axios from 'axios';
import { TableRow } from "@mui/material";
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';

const baseURL = "http://192.168.30.24:9091/api/finpol/main"

export default class UsersTable extends Component {
    state = {
        value: "",
        users: [],
    }

    componentDidMount() {
        const userSession = JSON.parse(localStorage.getItem("user"))
        axios.defaults.headers.common['Authorization'] = 'Bearer ' + userSession.accessToken
        axios.get(`${baseURL}/getusers`)
            .then(res => {
            const users = res.data;
            this.setState({ users });
            // console.log(res.data)
        })
    }

    setActive(userEvent, selectEvent) {
        console.log(userEvent, selectEvent)
        // /admin/user/ban/{id}
        axios.post('${baseURL}/admin/user/ban/'+userEvent.id)
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    active(e) {
        if (e.active) {
            return (<TableCell align="right" className="finished">
                        <select onChange={event => this.setActive(e, event)}>
                            <option selected>Активен</option>
                            <option>Не Активен</option>
                        </select>
                    </TableCell>)
        } else {
            return (<TableCell align="right" className="unfinished">
                        <select onChange={event => this.setActive(e, event)}>
                            <option>Активен</option>
                            <option selected>Не Активен</option>
                        </select>
                    </TableCell>)
        }
    }

    search = async val => {
        axios
            .get(`${baseURL}/admin/users`, {params: {value: val}})
            .then(res => {
                const users = res.data;
                this.setState({ users });
            })
    }
    onChangeHandler = async e => {
        this.search(e.target.value)
        this.state.value = e.target.value
    }

    render() {
        return(
            <>
            <input value={this.state.value} onChange={e=> this.onChangeHandler(e)} type="text" className="searchUsers" placeholder="Поиск пользователей"></input>
                <TableContainer>
                        <Table className="table adminPanelTable uitable">
                            <TableHead>
                            <TableRow className="uitableHead">
                                <TableCell style={{ width: '5%' }}><a>#</a></TableCell>
                                <TableCell style={{ width: '20%' }}><a>Почта</a></TableCell>
                                <TableCell style={{ width: 100 }}><a>ФИО</a></TableCell>
                                <TableCell align="right"><a>Статус активности</a></TableCell>
                            </TableRow>
                            </TableHead>
                            <TableBody>
                            {this.state.users.map((row, index) => (
                                <TableRow hover>
                                    <TableCell><a>{index+1}</a></TableCell>
                                    <TableCell style={{ width: '20%' }}><Link className="rowInfo" to={{
                                        pathname:`/users/${row.username}`, 
                                        state: {user: row}
                                    }}>{row.username}</Link></TableCell>
                                    <TableCell><a>{row.email}</a></TableCell>
                                    {this.active(row)}
                                </TableRow>
                            ))}
                            </TableBody>
                        </Table>
                </TableContainer>
            </>
            )
    }
}