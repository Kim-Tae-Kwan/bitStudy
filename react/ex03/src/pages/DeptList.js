import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

export default function DeptList(props){
    const [arr, setArr] = useState([]);
    
    useEffect(() => {
        fetch('http://localhost:8080/api/dept')
        .then((res) => res.json())
        .then((json) => setArr(json))
        ;
    },[]);

    return(
        <>
            <h1>DeptList Page</h1>
            <ul className="list-group">
                { arr.map((ele, idx) => 
                    <li key={ele.deptno} className="list-group-item">{ele.dname} ({ele.deptno})</li>
                )}
            </ul>
            <Link to="/add" className="btn btn-primary btn-block">입력</Link>
        </>
    );
};