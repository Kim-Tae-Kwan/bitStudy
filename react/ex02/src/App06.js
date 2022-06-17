import React, { useEffect, useState } from "react";

export default function App06(props){
    const [msg, setMsg] = useState("첫번째");
    const [msg2, setMsg2] = useState("두번째");

    useEffect(() => {
        console.log(msg);
    },[]);

    const btnHandler = () => {
        setMsg(msg + 1);
    };
    const btnHandler2 = () => {
        setMsg2(new String('이벤트 발생2'));
    };

    return(
        <div>
            <h1>{msg}</h1>
            <button onClick={btnHandler}>버튼</button>
            <button onClick={btnHandler2}>버튼2</button>
        </div>

    );
}