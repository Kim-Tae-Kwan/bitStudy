import { Form, Container, Button } from "react-bootstrap";
import { useContext, useRef } from "react";
import UserContext from "../modules/Store";
import { useNavigate } from "react-router-dom";

function LoginPage() {
  const user = useContext(UserContext);
  const navigate = useNavigate();
  const inputId = useRef();
  const inputPw = useRef();

  const loginHandler = (e) => {
    e.preventDefault();
    user.dispatch({type : 'login', username : inputId.current.value})
    navigate('/');
  };
  return (
    <Container>
      <h1>Login page</h1>
      <Form onSubmit={loginHandler }>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>Email address</Form.Label>
          <Form.Control type="text" ref={inputId} placeholder="Enter email" />
        </Form.Group>

        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Label>Password</Form.Label>
          <Form.Control type="password" ref={inputPw} placeholder="Password" />
        </Form.Group>
        <Button variant="primary" type="submit">
          Submit
        </Button>
      </Form>
    </Container>
  )
}

export default LoginPage