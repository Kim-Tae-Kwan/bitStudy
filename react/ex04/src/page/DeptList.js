import axios from 'axios';
import {useEffect, useState} from 'react'
import { Card, Container, CardGroup} from "react-bootstrap";
import { Link } from "react-router-dom";

function DeptList() {
    const [arr, setArr] = useState([]);

    useEffect(() => {
        console.log('useEffect');

        axios.get('http://localhost:8080/api/dept')
            .then((res) => setArr(res.data))
            .catch(err => console.log(err))
    },[])


    return (
        <Container>
            <h1>List Page</h1>
            <CardGroup>
            {arr.map((bean, idx) =>
                <Card key={bean.deptno}>
                    <Card.Body>
                        <Card.Title>{bean.dname}</Card.Title>
                        <Card.Subtitle className="mb-2 text-muted">{bean.deptno}</Card.Subtitle>
                        <Card.Text>{bean.loc}</Card.Text>
                        <Card.Link as={Link} to={'/dept/' + bean.deptno}>detail</Card.Link>
                    </Card.Body>
                </Card>
            )}
            </CardGroup>
        </Container>
    )
}

export default DeptList