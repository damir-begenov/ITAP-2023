import React from "react";
import { useState } from "react";
import './approvementModal.css'

const ApprovementModalWindow = (props) => {
    const [approvement, setApprovement] = useState("app_0")

    const UgDelo = () => {
        return (
            <>
                <div className="modalItem">
                    <label>Введите номер (приказа) *</label>
                    <input type="text" name="orderNum" className="sendItem requiredItem" placeholder="11"
                        onChange={() => {
                            
                        }}/>
                </div>

                <div className="modalItem">
                    <label>Введите дату *</label>
                    <input type="date" name="orderDate" className="sendItem requiredItem" placeholder="01.01.23"
                        onChange={() => {
                        }}/>
                </div>

                <div className="modalItem">
                    <label>Введите статью УК РК *</label>
                    <input type="text" name="articleName" className="sendItem requiredItem" placeholder="11"
                        onChange={() => {
                        }}/>
                </div>
            </>
        )
    }
    const SledPoruchenie = () => {
        return (
            <>
                <div className="modalItem">
                    <label>Введите номер (приказа) *</label>
                    <input type="text" name="orderNum" className="sendItem requiredItem" placeholder="11"
                        onChange={() => {
                        }}/>
                </div>

                <div className="modalItem">
                    <label>Введите дату *</label>
                    <input type="text" name="orderDate" className="sendItem requiredItem" placeholder="01.01.23"
                        onChange={() => {
                        }}/>
                </div>

                <div className="modalItem">
                    <label>Введите номер уголовного дела *</label>
                    <input type="text" name="caseNum" className="sendItem requiredItem" placeholder="11"
                        onChange={() => {
                        }}/>
                </div>
            </>
        )
    }
    const PorProkurora = () => {
        return (
            <>
                <div className="modalItem">
                    <label>Введите номер (приказа) *</label>
                    <input type="text" name="orderNum" className="sendItem requiredItem" placeholder="11"
                        onChange={() => {
                        }}/>
                </div>

                <div className="modalItem">
                    <label>Введите дату *</label>
                    <input type="text" name="orderDate" className="sendItem requiredItem" placeholder="01.01.23"
                        onChange={() => {
                        }}/>
                </div>

                <div className="modalItem">
                    <label>Введите номер уголовного дела *</label>
                    <input type="text" name="caseNum" className="sendItem requiredItem" placeholder="11"
                        onChange={() => {
                        }}/>
                </div>

                <div className="modalItem">
                    <label>Проверка</label>
                    <input type="text" name="checkingName" className="sendItem" placeholder=""
                        onChange={() => {
                        }}/>
                </div>

                <div className="modalItem">
                    <label>Введите иные основания</label>
                    <input type="text" name="other" className="sendItem" placeholder=""
                        onChange={() => {
                        }}/>
                </div>
            </>
        )
    }
    const MejdPoruchenie = () => {
        return (
            <>
                <div className="modalItem">
                    <label>Введите номер (приказа) *</label>
                    <input type="text" name="orderNum" className="sendItem requiredItem" placeholder="11"
                        onChange={() => {
                        }}/>
                </div>

                <div className="modalItem">
                    <label>Введите дату *</label>
                    <input type="text" name="orderDate" className="sendItem requiredItem" placeholder="01.01.23"
                        onChange={() => {
                        }}/>
                </div>

                <div className="modalItem">
                    <label>Введите название организации *</label>
                    <input type="text" name="organName" className="sendItem requiredItem" placeholder="Финпол"
                        onChange={() => {
                        }}/>
                </div>
            </>
        )
    }
    const AfmPoruchenie = () => {
        return (
            <>
                <div className="modalItem">
                    <label>Введите номер (приказа) *</label>
                    <input type="text" name="orderNum" className="sendItem requiredItem" placeholder="11"
                        onChange={() => {
                        }}/>
                </div>

                <div className="modalItem">
                    <label>Введите дату *</label>
                    <input type="text" name="orderDate" className="sendItem requiredItem" placeholder="01.01.23"
                        onChange={() => {
                        }}/>
                </div>
            </>
        )
    }
    const PoruchenieRukovodstva = () => {
        return (
            <>
                <div className="modalItem">
                    <label>Введите номер (приказа) *</label>
                    <input type="text" name="orderNum" className="sendItem requiredItem" placeholder="11"
                        onChange={() => {
                        }}/>
                </div>

                <div className="modalItem">
                    <label>Введите дату *</label>
                    <input type="text" name="orderDate" className="sendItem requiredItem" placeholder="01.01.23"
                        onChange={() => {
                        }}/>
                </div>

                <div className="modalItem">
                    <label>Введите ФИО руководства *</label>
                    <input type="text" name="rukName" className="sendItem requiredItem" placeholder="Куанышбеков Мадияр Еркебуланулы"
                        onChange={() => {
                        }}/>
                </div>
            </>
        )
    }
    const MaterialOP = () => {
        return (
            <>
                <div className="modalItem">
                    <label>Введите название сферы *</label>
                    <input type="text" name="sphereName" className="sendItem requiredItem" placeholder=""
                        onChange={() => {
                        }}/>
                </div>
            </>
        )
    }
    const TematikaAnalRabot = () => {
        return (
            <>
                <div className="modalItem">
                    <label>Введите название тематики *</label>
                    <input type="text" name="tematikName" className="sendItem requiredItem" placeholder=""
                        onChange={() => {
                        }}/>
                </div>
            </>
        )
    }

    const validate = () => {
        let isValid = true

        const requiredElems = document.querySelectorAll('.requiredItem');
        requiredElems.forEach(elem => {
            if (elem.value.trim() === "") {
                isValid = false
            }

            if (elem.name == 'orderDate') {
                let len = elem.value.trim().length
                let ch1 = elem.value[2]
                let ch2 = elem.value[5]
                
                console.log(len, ch1, ch2)

                if (len < 8 && len > 10 && ch1 != '.' && ch1 != '-' && ch2 != '.' && ch2 != '-') isValid = false

            } else if (elem.name == 'orderNum' || elem.name == 'caseNum') {
                let v = elem.value.trim()
                if (isNaN(v) || isNaN(parseFloat(v))) isValid = false
            }
            
            console.log(elem.name, isValid)
        })

        return isValid
    }

    const showError = () => {
        alert(`Поля заполнены неправильно, либо пусты`)
    }

    const setApprovements = () => {
        const sendElems = document.querySelectorAll('.sendItem');
        let approvementss = {}

        sendElems.forEach(elem => {
            approvementss[elem.name] = elem.value
        })

        console.log(props.setApprovementObj, approvementss)

        props.setApprovementObj(approvementss)
    }

    return (
        <div className="modalBlock">
            <div className="modalWindow">

                <div className="title">Основание проверки</div>

                <div className="modalItems">
                    <div className="modalItem">
                        <label>Выберите основание</label>
                        <select name="approvement_type" className="sendItem" id='approvements' 
                            onChange={event => {
                                setApprovement(event.target.value);
                                setApprovements()
                            }}>
                            <option value="app_0">Основание проверки</option>
                            <option value="Уголовное дело / ЕРДР">Уголовное дело / ЕРДР</option>
                            <option value="Следственные поручения">Следственные поручения</option>
                            <option value="Поручения прокурора">Поручения прокурора</option>
                            <option value="Международные поручения">Международные поручения</option>
                            <option value="Поручения АФМ РК">Поручения АФМ РК</option>
                            <option value="Поручения вышестоящего руководства">Поручения вышестоящего руководства</option>
                            <option value="Материалы оперативных проверок">Материалы оперативных проверок</option>
                            <option value="Тематика аналитической работы">Тематика аналитической работы</option>
                        </select>
                    </div>
                    
                    {approvement == 'Уголовное дело / ЕРДР' ? <UgDelo></UgDelo> : ""}
                    {approvement == 'Следственные поручения' ? <SledPoruchenie></SledPoruchenie> : ""}
                    {approvement == 'Поручения прокурора' ? <PorProkurora></PorProkurora> : ""}
                    {approvement == 'Международные поручения' ? <MejdPoruchenie></MejdPoruchenie> : ""}
                    {approvement == 'Поручения АФМ РК' ? <AfmPoruchenie></AfmPoruchenie> : ""}
                    {approvement == 'Поручения вышестоящего руководства' ? <PoruchenieRukovodstva></PoruchenieRukovodstva> : ""}
                    {approvement == 'Материалы оперативных проверок' ? <MaterialOP></MaterialOP> : ""}
                    {approvement == 'Тематика аналитической работы' ? <TematikaAnalRabot></TematikaAnalRabot> : ""}

                    <div className="modalItem actionItems">
                        <input id="approvementCancel" onClick={ () => props.setModal(false) } type="button" value="Отмена"/>
                        <input id="approvementSend" disabled={approvement == 'app_0'} 
                            onClick={() => {

                                const sendElems = document.querySelectorAll('.sendItem');
                                let approvementss = {}

                                sendElems.forEach(elem => {
                                    approvementss[elem.name] = elem.value
                                })

                                props.setApprovementObj(approvementss)

                                if ( validate() ) {
                                    props.send(approvementss)
                                } else {
                                    showError()
                                }
                            }
                        } type="button" value="Отправить"/>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default ApprovementModalWindow;