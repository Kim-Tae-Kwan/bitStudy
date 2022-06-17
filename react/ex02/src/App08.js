import React, { useReducer } from "react";

function Li({num}){

    return <li>item{num}</li>;
}

let init = [<Li num={1}/>];

function reducer(state, action){
    const cnt = state.length;
    switch(action.type){
        case 'ADD' :
            return [...state, <Li num={cnt + 1}/>];
        case 'DELETE' :
            return state.filter(function(ele,idx){
                return cnt - 1 != idx;
            });
        default :
            return state;
    }

    
};

export default function App08(){
    const [lis, dispatch] = useReducer(reducer, init);

    return (
        <>
            <button onClick={()=>{dispatch({type:'ADD'})}}>add</button>
            <button onClick={()=>{dispatch({type:'DELETE'})}}>add</button>
            <ul>
                {lis.map((ele, idx) => ele)}
            </ul>
            
        </>
    );
};