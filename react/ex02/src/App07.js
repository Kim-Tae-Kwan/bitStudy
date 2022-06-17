import React, { createContext, useContext, useState } from "react";

let UserContext;

export default function App07(){
    console.log('App07');

    UserContext = createContext();

    const [msg1, setMsg1] = useState('abcd');

    const app07 = {msg : msg1, setMsg : setMsg1}

    return (
        <UserContext.Provider value={app07}>
            <div><App77 setMsg1={setMsg1}/></div>
        </UserContext.Provider>
    );
}

function App77(){
    console.log('App77');
    return <div><App777 /></div>;
}

function App777(){

    console.log('App777');

    const app07 = useContext(UserContext);

    const [msg2, setMsg2] = useState(app07.msg);

    const btnHandler = () => {
        app07.setMsg('test');
    }

    const btnHandler2 = () => {
        app07.setMsg2('test2')
    }

    return (
        <div>
            <div>{app07.msg}</div>
            <button onClick={btnHandler}>버튼</button>
            <button onClick={btnHandler2}>버튼2</button>
        </div>
    );
}
