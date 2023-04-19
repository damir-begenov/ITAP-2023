import React, { useEffect, useState } from "react";
import './relationBlock.css'

import { components } from "react-select"
import { default as ReactSelect, StylesConfig } from "react-select";
import chroma from 'chroma-js';

import {relationsLevel1, relationsLevel2} from './../../data/relationsData.js'

const colourStyles = {
    control: (styles) => ({ ...styles, backgroundColor: 'rgba(255, 255, 255, 0.11)', border: 'none' }),
    option: (styles, { isDisabled, isFocused, isSelected }) => {
      return {
        ...styles,
        appearance: 'none',
        backgroundColor: isDisabled
          ? undefined
          : isSelected
          ? "#2D4231"
          : isFocused
          ? "#3a553f"
          : undefined,
        color: isDisabled
          ? '#ffffff'
          : 'isSelected'
          ? "#ffffff80"
            ? 'isFocused'
            : '#ffffff90'
          : "#2D4231",
        cursor: isDisabled ? 'not-allowed' : 'cursor',
  
        ':active': {
          ...styles[':active'],
          backgroundColor: !isDisabled
            ? isSelected
              ? "#ffffff"
              : "#223124"
            : undefined,
        },
      };
    },
    multiValue: (styles, { data }) => {
      const color = chroma("#2D4231");
      return {
        ...styles,
        backgroundColor: "#2D4231",
      };
    },
    multiValueLabel: (styles, { data }) => ({
      ...styles,
      color: "#ffffff80",
    }),
    multiValueRemove: (styles, { data }) => ({
      ...styles,
      color: "#223124",
      cursor: 'pointer',
      ':hover': {
        backgroundColor: "#223124",
        color: 'white',
      },
    }),
  };

const Option = (props) => {
    return (
        <>
        <div className={"relsOption"}>
            <components.Option {...props}>
                <input
                    type="checkbox"
                    checked={props.isSelected}
                    onChange={() => null}
                />{" "}
                <label>{props.label}</label>
            </components.Option>
      </div>
      </>
    );
};

const RelationBlock = (props) => {
    const [selectedOptions, setSelectedOptions] = useState([])

    const checkAdmin = () => {
        const userSession = JSON.parse(localStorage.getItem("user"))
        if (userSession && userSession.roles.includes('ROLE_ADMIN')) {
            return true;
        }
        return false;
    }

    useEffect(() => {
        if (document.getElementById("react-select-2-placeholder")) document.getElementById("react-select-2-placeholder").innerHTML = "Выберите связи"

        let rels = ""
        selectedOptions.forEach(el => {
            if (rels == "") rels = el.value
            else rels += "," + el.value
        });

        console.log(rels)
        props.setRels(rels)

    }, [selectedOptions])

    const handleChange = (selected) => {
        setSelectedOptions(selected)
    }

    const handleAllRels = () => {
        setSelectedOptions([...relationsLevel1, ...relationsLevel2])
    }

    const handleOptions = () => {
        return [...relationsLevel1, ...relationsLevel2]
    }

    return (
        <>
        <div className="relButton" onClick={handleAllRels}>Все связи</div>
        <span
            className="relsSelectBlock"
            data-toggle="popover"
            data-trigger="focus"
            data-content="Выберите связи"
        >
            <ReactSelect
                className="relsSelect"
                options={handleOptions()}
                isMulti
                closeMenuOnSelect={false}
                hideSelectedOptions={false}
                components={{
                    Option
                }}
                onChange={handleChange}
                allowSelectAll={true}
                isSearchable={false}
                value={selectedOptions}
                styles={colourStyles}
            />
        </span>
        </>
    )
} 

export default RelationBlock;