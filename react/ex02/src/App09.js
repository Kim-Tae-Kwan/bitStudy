import React, { useEffect, useReducer, useState } from "react";

const reducer = (state, action) => {
    switch(action.type){
        case "PLUS" : return state + 1;
        case "MINUS" : return state - 1;
    }


    return state;
};

const Sub = (props) => {

    const[num, dispatch] = useReducer(reducer, 1);

    return(
        <>
            <div>{num}</div>
            <button onClick={()=>{dispatch({type: 'PLUS'})}} value="plus">+</button>
            <button onClick={()=>{dispatch({type: 'MINUS'})}} value="minus">-</button>
            <ul>
                <li>{props.msg}</li>
                <li>{props.cnt}</li>
            </ul>
        </>

    );
}



export default function App09(){
    const [num, setNum] = useState(0);
    const [num2, setNum2] = useState(0);
    useEffect(() => {
        console.log('e');
    },[num2]);



    const handler = (e) => {
        const type = e.target.value;
        console.log(type);
        switch(type){
            case 'plus': 
                setNum(num + 1);
                break;
            case 'minus' : 
                setNum(num - 1);
                break;
            
        }
    };

    return(
        <>
            <div>{num}</div>
            <div>{num2}</div>
            <button onClick={handler} value="plus">+</button>
            <button onClick={handler} value="minus">-</button>
            <div>--------------------------------------------</div>

            <Sub msg={'asdf'} cnt={1}/>
        </>
    );
};