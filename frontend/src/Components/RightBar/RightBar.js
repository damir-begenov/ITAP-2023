import React, {Component, useEffect, useState} from "react";
import ReactDOM from "react-dom";

import RelationBlock from "../Relation/RelationBlock";
import './RightBar.css'

const RightBar = (props) => {
  const [showRels, setShowRelss] = useState("")
  const [openLimit, setOpenLimit] = useState(10)
  const [showNodeInfo, setShowNodeInfo] = useState(false)
  const [showNodeAddInfo, setShowNodeAddInfo] = useState(false)

  

  useEffect(() => {
    props.setOpenLimit(openLimit)
    props.setShowRels(showRels)
  }, [openLimit, showRels])

  const setShowRels = (rels) => {
    setShowRelss(rels);
  }

  const shortOpen = (id) => {
    props.shortOpen(id)
  }

  const shortHide = () => {
    props.shortHide()
  }

  return (
    <div className='rightBar'>
      <div className="infoBlock" id="infoBlock">
        <div>

          <div className="infoBlockTitle">Информация {props.isOnSelectNode || props.isOnSelectEdge ? "о объекте" : ""}</div>
          <div className="nodeImg"
              style={{display: props.showImage 
              ? "flex" : "none"}}>
          </div>
            <div className="nodeInfo" id="nodeInfo" 
                style={{display: props.isOnSelectNode 
                  || props.isOnSelectEdge 
                ? "flex" : "none"}}>
              <div className="nodeInfoTitle" 
                  onClick={() => {
                    setShowNodeInfo(!showNodeInfo)
                    document.querySelector('#nodeInfoInner').style.display = showNodeInfo ? "flex" : "none"
                  }}>
                <div>Общие сведения</div>
                <i></i>
              </div>
              <div className="nodeInfoInner" id="nodeInfoInner">

              </div>
            </div> 

            <div className="nodeInfo" id="nodeAddInfo" style={{display: props.isOnSelectNode ? "flex" : "none"}}>
              <div className="nodeInfoTitle" 
                  onClick={() => {
                    setShowNodeAddInfo(!showNodeAddInfo)
                    document.querySelector('#nodeAddInfoInner').style.display = showNodeAddInfo ? "flex" : "none"
                  }}>
                <div>Дополнительные сведения</div>
                <i></i>
              </div>
              <div className="nodeInfoInner nodeAddInfoInner" id="nodeAddInfoInner">

              </div>
            </div> 

            <div className="nodeInfo" id="nodeAddInfo" style={{display: props.isOnSelectNode && props.showSudInfo ? "flex" : "none"}}>
              <div className="nodeInfoTitle" 
                  onClick={() => {
                    setShowNodeAddInfo(!showNodeAddInfo)
                    document.querySelector('#nodeSudInfoInner').style.display = showNodeAddInfo ? "flex" : "none"
                  }}>
                <div>Риски</div>
                <i></i>
              </div>
              <div className="nodeInfoInner nodeSudInfoInner" id="nodeSudInfoInner">

              </div>
            </div> 
        </div> 
      </div>

      <div className={"openHideBlock"} style={{display: props.isOnSelectNode ? "flex" : "none"}}>
        <div className="actionBlock" style={{display: props.isOnSelectNode ? "block" : "none"}}>
            <input className="showhide" type="button" visible="false" value="Расскрыть" onClick={() => {
              let id = Object.keys(props.Network.selectionHandler.selectionObj.nodes)[0]
              shortOpen(id)
            }}/>
            <input className="showhide" type="button" visible="false" value="Скрыть" onClick={shortHide}/>
        </div>

        <div>
          <div className="limitInputBlock">
            <label>Лимит</label>
            <input name="openLimit" className={"openLimit"} value={openLimit} onChange={event => {
              setOpenLimit(event.target.value)
            }}/>
          </div>
        </div>

        <div className="showRelsBlockRight" >
          <div>            
            <RelationBlock setRels={setShowRels}></RelationBlock>
          </div>
        </div>
      </div>
    </div>
  );
}

export default RightBar;