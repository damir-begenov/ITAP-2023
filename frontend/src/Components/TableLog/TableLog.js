import { Component } from "react";
import { Link } from 'react-router-dom'
import axios from 'axios';

import '../TableLog/TableLog.css'


export default class TableLog extends Component {
    state = {
        logs: [],
    }

    // componentDidMount() {
    //     axios.get(`http://localhost:9091/api/finpol/main/logs`)
    //       .then(res => {
    //         const logs = res.data;
    //         this.setState({ logs });
    //       })
    //   }

    render() {
        return (
            <table className="table">
                <thead >
                    <tr>
                    <th scope="col"><a className="sort">#</a></th>
                    <th scope="col"><a className="sort">Date</a></th>
                    <th scope="col"><a className="sort">Username</a></th>
                    <th scope="col"><a className="sort">Request Body</a></th>
                    <th scope="col"><a className="sort">LIMIT</a></th>
                    <th scope="col"><a className="sort">DEPTH</a></th>
                    <th scope="col"><a className="sort">RELATIONS</a></th>
                    <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    
                    {this.props.logs.map((log, index) => 
                        <tr className="row">
                            <td>{index+1}</td>
                            <td>{log.date}</td>
                            <td className="FIO"><Link className="rowInfo" to={`/schools`}>{log.username}</Link></td>
                            <td>{log.request_body}</td>
                            <td>{log.limit_}</td>
                            <td>{log.depth_}</td>
                            <td>{log.request_rels}</td>
                        </tr>
                    )}

                </tbody>
            </table>
        )
    }
}