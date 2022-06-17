import React from "react";

function App22({obj}){
    return (
        <>
            <h2>{obj.msg} {obj.msg2}</h2>
            <button onClick={()=>{console.log('클릭했음')}}>버튼</button>
        </>
    );
}

function App222(){
    return(
        <div>
            <h1>파라미터 전달</h1>
            <button onClick={(e)=>{console.log('환영합니다.',e.target)}}>클릭</button>
        </div>

    );
}

export default function App02({msg, msg2}){
    const msgs = {
        msg : "정말로",
        msg2 : "환영합니다."
    };
    return (
        <>
            <h1>환영합니다.</h1>
            <App222 obj={msgs}/>
        </>
    );
}