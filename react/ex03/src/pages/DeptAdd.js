
import {useNavigate} from 'react-router-dom'

export default function DeptAdd(props){
    const navigate = useNavigate();

    const insertSubmit = (e) => {
        e.preventDefault();

        const parameter = {};
        parameter.deptno = Number(e.target.deptno.value);
        parameter.dname = e.target.dname.value;
        parameter.loc = e.target.loc.value;

        fetch('http://localhost:8080/api/dept', {
            method : "POST",
            headers: {
                'Content-Type': 'application/json', // 'application/x-www-form-urlencoded'
            },
            body : JSON.stringify(parameter)
        })
        .then(res => res)
        .then(result => {
            console.log(props)
            navigate('/dept');
        });
    };

    return(
        <>
            <h1>DeptAdd Page</h1>
            <form onSubmit={insertSubmit}>
                <div className="form-group">
                    <label >
                    <input type="text" className="form-control" name="deptno" placeholder="deptno"/>
                    </label>
                </div>
                <div className="form-group">
                    <label >
                    <input type="text" className="form-control" name="dname" placeholder="dname"/>
                    </label>
                </div>
                <div className="form-group">
                    <label >
                    <input type="text" className="form-control" name="loc" placeholder="loc"/>
                    </label>
                </div>
                <div className="form-group">
                    <div className="col-sm-offset-2 col-sm-10">
                    <button type="submit" className="btn btn-default">Sign in</button>
                    </div>
                </div>
            </form>
        </>
    );
};