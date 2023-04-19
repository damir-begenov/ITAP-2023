import {useState, Component } from "react";
import { useParams } from "react-router-dom";
import axios from 'axios';

import './userDetails.css'

import Alert from '@mui/material/Alert';

import Box from '@mui/material/Box';
import Collapse from '@mui/material/Collapse';
import IconButton from '@mui/material/IconButton';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Typography from '@mui/material/Typography';
import Paper from '@mui/material/Paper';
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
import KeyboardArrowUpIcon from '@mui/icons-material/KeyboardArrowUp';

const baseURL = "http://192.168.30.24:9091/api/finpol/main"

function withParams(Component) {
    return props => <Component {...props} username={useParams()} />;
}

class UserDetails extends Component {
    state = {
        user: {},
        date: "", 
        allRequsetNum: 0,
        todayRequsetNum: 0,
        logs: [],
        role: "",
        newRole: 0,
        id: 0
    }
    
    componentDidMount = () => {
        axios.get(`${baseURL}/getuserdetails`, {params: {username: this.props.username.username}})
            .then(res => {
                const result = res.data
                console.log(res.data)
                let user = res.data.user
                let role = res.data.role
                let date = res.data.date
                this.setState({user: user, role: role, date: date, allRequsetNum: result.allRequsetNum, todayRequsetNum: result.todayRequsetNum, logs: result.logs})
            })
    }

    promote = async (e) =>  {
        const userSession = JSON.parse(localStorage.getItem("user"))

        axios.defaults.headers.common['Authorization'] = 'Bearer ' + userSession.accessToken
        axios.get(`${baseURL}/changeUserRole`, 
            { params: { 
                user: e, 
                role: this.state.newRole
            }})
            .then(
                res => {
                    if (res.status == 200) {
                        let alert = document.getElementById('alertofChange')
                        alert.style.display = 'block'
                    }
                }
                // window.location.reload(false)
            )
    }

    rels = (e) => {
        console.log(e)

    }
    search = async val => {
        // console.log(this.state.user.id)
        axios
            .get(`${baseURL}/admin/searchuserlogs`, {params: {value: val, username: this.state.user.username}})
            .then(res => {
                const logs = res.data;
                this.setState({ logs });
            })
    }

    onChangeHandler = async e => {
        this.search(e.target.value)
        this.state.value = e.target.value
    }

    setNumbers = () => {
        if (this.state.date==null) {
            
                return(
                    <div>Нет даты</div> 
                )
        } else {
            return <>
        <div>{this.state.date.slice(11, 19)}</div>
        <div>{this.state.date.slice(0, 10)}</div></>
        }
    }


    render() {
        return(
            <>
            <div className="userDetailsBlock">
                <div>
                    <div className="userFirstBlock">

                    <div className="userInfo">
                        <div>
                            <span>
                                {this.state.user.username} 
                            </span>
                            :
                            <span>
                                {this.state.role}
                            </span>
                        </div>
                        <div>
                            {this.state.user.email}
                        </div>
                    </div>
                    <select name="roles" id='connectionsUserDetails' onChange={event=> {
                        let final;
                        if (event.target.value == "vip") {
                            final = 2
                        } else if (event.target.value == "1") {
                            final = 3
                        } else if (event.target.value == "2") {
                            final = 4
                        } else if (event.target.value == "3") {
                            final = 5
                        } 
                        this.setState({newRole: final})}
                        }>
                        <option>Уровень доступа</option>
                        <option value="vip">ВИП</option>
                        <option value="1">1 уровень</option>
                        <option value="2">2 уровень</option>
                        <option value="3">3 уровень</option>
                    </select>
                    <button className="changeRole" onClick={e => this.promote(this.state.user.id)} >Изменить</button>
                    </div>
                    <div id="alertofChange" style={{display: 'none'}}>
                    <Alert severity="success" style={{backgroundColor: '#17191C'}}>
                        Уровень доступа пользователя изменен успешно! Перезагрузите страницу для того чтобы обновить данные
                    </Alert>
                    </div>
                    
                    <div className="countStatsUser">
                        <div className="lastQuery">
                            <div>Последний запрос</div>
                            {this.setNumbers()}
                        </div>

                        <div>
                            <div>Количество запросов</div>
                            <div>{this.state.allRequsetNum}</div>
                        </div>

                        <div>
                            <div>Количество запросов сегодня</div>
                            <div>{this.state.todayRequsetNum}</div>
                        </div>
                    </div>
                    <div>
                    <input value={this.state.value} onChange={e=> this.onChangeHandler(e)} type="text" className="searchUsers" placeholder="Поиск по запросам"></input>
                    <TableContainer>
                        <Table aria-label="collapsible table" className="uitable">
                            <TableHead>
                            <TableRow className="uitableHead">
                                <TableCell style={{ width: '5%' }} align="left"><a>#</a></TableCell>
                                <TableCell style={{ width: '20%' }} align="left"><a>Дата и время</a></TableCell>
                                <TableCell style={{ width: '60%' }} align="left"><a>Запрос</a></TableCell>
                                <TableCell></TableCell>
                            </TableRow>
                            </TableHead>
                            <TableBody>
                            { this.state.logs.length>0 ? this.state.logs.map((row, index) => (
                                <Row row={row} index={index} />
                            )): <TableCell  className="zeroResult" align="center" colSpan={4} style={{borderBottom: 'hidden'}}><a>Нет данных</a></TableCell>}
                            </TableBody>
                        </Table>
                    </TableContainer>
                        
                        {/* <TableContainer className="uitable">
                            <Table className="uitable">
                                <TableHead>
                                    <TableRow>
                                        <TableCell><a>#</a></TableCell>
                                        <TableCell><a>Дата</a></TableCell>
                                        <TableCell><a>Запрос</a></TableCell>
                                        <TableCell><a>Дополнительно</a></TableCell>
                                    </TableRow>
                                </TableHead>
                                <TableBody>
                                    {this.state.logs.map((log, index) => (  
                                        <TableRow className="uitablerow">
                                            <TableCell><a>{index+1}</a></TableCell>
                                            <TableCell><a>{log.date.slice(0, 10)} {log.date.slice(11, 19)}</a></TableCell>
                                            <TableCell><a>{log.obwii}</a></TableCell>
                                            <TableCell><a>Расскрыть</a></TableCell>
                                        </TableRow>
                                    ))}
                                </TableBody>
                            </Table>
                        </TableContainer> */}
                    </div>
                </div>

            </div>
            <div className="footer"></div>
            </>
        )
    }
}
function Row(props) {
    const { row } = props;
    const [open, setOpen] = useState(false);
  
    return (
      <>
        <TableRow hover className="uitablerow">
            <TableCell><a>{props.index + 1}</a></TableCell>
          <TableCell style={{ width: '20%' }} align="left"><a>
            {row.date.slice(0, 10)} {row.date.slice(11, 19)}
            </a></TableCell>
          <TableCell style={{ width: '60%' }} align="left"><a>{row.obwii}</a></TableCell>
          <TableCell ><a>{row.fat}</a></TableCell>
          <TableCell ><a>{row.carbs}</a></TableCell>
          <TableCell>
            <IconButton
              aria-label="expand row"
              size="small"
              onClick={() => setOpen(!open)}
            >
              {open ? <KeyboardArrowUpIcon style={{ fill: '#ffffff' }}/> : <KeyboardArrowDownIcon style={{ fill: '#ffffff' }}/>}
            </IconButton>
          </TableCell>
        </TableRow>
        <TableRow>
          <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={6}>
            <Collapse in={open} timeout="auto" unmountOnExit>
              <Box sx={{ margin: 1 }}>
                <Typography variant="h6" gutterBottom component="div">
                <a>Информация о запросе</a>
                </Typography>
                <Table size="small" aria-label="purchases">
                  <TableHead>
                    <TableRow>
                      <TableCell style={{ width: '20%' }} align="left"><a>Основание запроса</a></TableCell>
                      <TableCell style={{ width: '80%' }} align="left"><a>{row.approvement_data ? row.approvement_data: "Нет данных"}</a></TableCell>
                    </TableRow>
                    <TableRow>
                      <TableCell style={{ width: '20%' }} align="left"><a>Объекты запроса</a></TableCell>
                      <TableCell style={{ width: '80%' }} align="left"><a>{row.request_body.join(',')}</a></TableCell>
                    </TableRow>
                    <TableRow>
                      <TableCell style={{ width: '20%' }} align="left"><a>Лимит</a></TableCell>
                      <TableCell style={{ width: '80%' }} align="left"><a>{row.limit_ ? row.limit_: "Лимит не установлен"}</a></TableCell>
                    </TableRow>
                    <TableRow style={{borderBottom: 'hidden'}}>
                      <TableCell style={{ width: '20%' }} align="left"><a>Уровень</a></TableCell>
                      <TableCell style={{ width: '80%' }} align="left"><a>{row.depth_ ? row.depth_: "Уровень не установлен"}</a></TableCell>
                    </TableRow>
                    {/* <TableRow style={{borderBottom: 'hidden'}}>
                      <TableCell style={{ width: '20%' }} align="left"><a>Связи</a></TableCell>
                      <TableCell style={{ width: '80%' }} align="left"><a>{row.request_rels.length>0 ? row.request_rels.join(','): "Связи не установлены"}</a></TableCell>
                    </TableRow> */}
                  </TableHead>
                </Table>
              </Box>
            </Collapse>
          </TableCell>
        </TableRow>
      </>
    );
  }


export default withParams(UserDetails);
