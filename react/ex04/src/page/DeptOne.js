import axios from 'axios';
import { useEffect, useState } from "react";
import { Form, Container, Button } from "react-bootstrap";
import { useNavigate , useParams } from 'react-router-dom';

function DeptOne() {
  const apiRootUrl = 'http://localhost:8080/api/dept/';

  const [bean, setBean] = useState({});
  const [edit, setEdit] = useState(false);
  let navigate = useNavigate();

  let { deptno } = useParams();

  useEffect(() => {
    axios.get(apiRootUrl + deptno)
      .then(res => {
        setBean(res.data)
      })
      .catch(err => console.log(err))
  }, [])

  const editHandler = (e) => {
    e.preventDefault();
    setEdit(!edit);
    if(edit){
      axios.put(apiRootUrl + bean.deptno, bean)
        .then(res => {
          if(res.data.result) navigate("/dept")
          
        })
        .catch(err => console.log(err))
    }
  };

  const backHandler = () => navigate(-1);

  const inputHandler = (e) => {
    setBean({...bean, [e.target.name] : e.target.value})
  }
  
  const resetHandler = (e) => {

  }

  const deleteHandler = (e) => {
    axios.delete(apiRootUrl + bean.deptno)
      .then(res => {
        res.status === 200 ? navigate('/dept') : window.alert("삭제 실패");
      });
  }
  return (
    <Container>
      <h1>{edit ? '수정페이지' : '상세페이지'}</h1>
      <Form onSubmit={editHandler}>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>deptno</Form.Label>
          <Form.Control type="text" value={bean.deptno} name="deptno" readOnly = {true}/>
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>dname</Form.Label>
          <Form.Control type="text" 
                        value={bean.dname} 
                        name="dname" 
                        readOnly = {!edit} 
                        onChange = {inputHandler}
                        />
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>loc</Form.Label>
          <Form.Control type="text" 
                        value={bean.loc} 
                        name="loc" 
                        readOnly = {!edit} 
                        onChange = {inputHandler}
                        />
        </Form.Group>

        <Button variant="primary" type="submit">Update</Button>
        {edit 
          ? <Button variant="default" type="button" onClick={resetHandler}>Reset</Button>
          : <Button variant="danger" type="button" onClick={deleteHandler}>Delete</Button>
        }
        <Button variant="default" type="button" onClick={backHandler}>Back</Button>
      </Form>
    </Container>
  )
}

export default DeptOne