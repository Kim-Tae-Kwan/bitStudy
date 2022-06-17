import React, { useState } from "react";

export default function App04(){
    // const [msg, setMsg] = useState("입력");
    // const [msg2, setMsg2] = useState("입력");
    const [obj, setObj] = useState({id:'입력', pw : '입력'});
    const [chk, setChk] = useState(false);
    
    const formSubmit = (e) => {
        e.preventDefault();
        console.log(e.target.id.value, e.target.pw.value);
        e.target.id.value = '';
        e.target.pw.value = '';
    };

    const [firstName, setFirstName] = useState("kim");

    const handleChage = (e) => {
        console.log(e.target.value);
        setChk(!chk);
    };

    return(
        <>
            <h1>{obj.id}</h1>
            <h1>{obj.pw}</h1>
            <form onSubmit={formSubmit}>
                <label>
                    id : <input name="id"></input>
                </label>
                <label>
                    pw : <input name="pw"></input>
                </label>
                <input type="checkbox" onChange={handleChage} value={chk}/>
                <div>
                    <input type='submit' value='전달'></input>
                </div>
                <select value={firstName} onChange={handleChage}>
                    <option value="kim">kim</option>
                    <option value="seo">seo</option>
                    <option value="park">park</option>
                    <option value="lim">lim</option>
                </select>
            </form>
            
        </>

    );
}