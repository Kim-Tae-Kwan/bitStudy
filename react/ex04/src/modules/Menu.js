import 'bootstrap/dist/css/bootstrap.min.css';
import { useContext, useEffect } from 'react';
import { Navbar, Nav, Container } from "react-bootstrap";
import { Link } from "react-router-dom";
import UserContext from './Store';

function Menu() {
    const user = useContext(UserContext);
    useEffect(()=>{
        
    });

    const logoutHandler = (e) => {
        e.preventDefault();
        user.dispatch({type : 'logout'})
    }

    return (
        <>
            <Navbar bg="primary" variant="dark">
                <Container>
                <Navbar.Brand as={Link} to="/">비트교육센터</Navbar.Brand>
                <Nav className="me-auto">
                    <ul className='navbar-nav'>
                        <li>
                            <Link to="/" className='nav-link'>Home</Link>
                        </li>
                        <li>
                            <Link to="/intro" className='nav-link'>Intro</Link>
                        </li>
                        <li>
                            <Link to="/dept" className='nav-link'>Dept</Link>
                        </li>
                        <li>
                            <Link to="/dept/add" className='nav-link'>Add</Link>
                        </li>
                        {user.state.result ?
                            <>
                            <li>
                                <Link to="/logout" className='nav-link' onClick={logoutHandler}>Logout</Link>
                            </li>
                            <p>{user.state.username}</p>
                            </>
                            :
                            <>
                            <li>
                                <Link to="/login" className='nav-link'>Login</Link>
                            </li>
                            <li>
                                <Link to="/join" className='nav-link'>join</Link>
                            </li>
                            </>
                        }
                    </ul>
                    
                </Nav>
                </Container>
            </Navbar>
        </>
    )
}

export default Menu