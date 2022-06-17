import React from "react";

function Li({item}){
    return(
        <li>{item}</li>
    );
}

export default (props) => {
    const arr = ['item1', 'item2', 'item3'];
    return (
        <>
            <h1>App03</h1>
            <ul>
                {arr.map((item)=><Li item={item}/>)}
            </ul>
        </>
    );
};