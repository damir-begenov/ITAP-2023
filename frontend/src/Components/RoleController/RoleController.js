import { Component } from "react";
import { Link } from 'react-router-dom'
import axios from 'axios';

export default class RoleController extends Component {
    state = {
        level1: ['BUHGALTER','DETDOM_HIST','DFO_AFF_FIZ','DFO_AFF_UL','DIRECTOR_CUR','DIRECTOR_HIST','FOUNDER_CUR','FOUNDER_HIST','ESF_100','ESF_10and100','ESF_10and50','ESF_50and100','ESF_5and10','FPG','GOSZAKUP','IP_KX','NTR_FL','NTR_UL_FL','OPG','PDL','REG_ADDRESS','REG_ADDRESS_CUR','REG_ADDRESS_HIST','REG_ADDRESS_UL','SLUZHIL','SUDIM','UCHILSYA','WORKER_CUR','WORKER_HIST','ZAGS','ZAGS_FIO','ZAGS_IIN'],
        level2: [],
        level3: [],
    }


    render() {
        return(
            <div>
        <div className="level_1"> 
        Контроль уровнями доступа
        </div>
        Первый уровень доступа
        <div>
     
        </div>
        </div>
        )
    }
}