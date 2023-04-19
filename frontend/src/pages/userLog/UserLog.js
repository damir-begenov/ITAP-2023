import React, { Component } from "react";

import './UserLog.css'

const check = (props) => {

}

class UserLog extends Component {
    componentDidMount() {
        console.log("works")
    }

    render() {
        return (
          <section>
                <div className="userInfo">
                    <div>
                        <span>
                            DERZEET
                        </span>
                        :
                        <span>
                            USER
                        </span>
                    </div>
                    <div>
                        derzeet@proton.me
                    </div>
                </div>
                <div className="countStats">
                    <div className="lastQuery">
                        <div>Последний запрос</div>
                        <div>16:30</div>
                        <div>2014/02/01</div>
                    </div>

                    <div>
                        <div>Количество запросов</div>
                        <div>118</div>
                    </div>

                    <div>
                        <div>Количество запросов сегодня</div>
                        <div>0</div>
                    </div>
                </div>
            
          </section>
        );
    }
}

export default UserLog;