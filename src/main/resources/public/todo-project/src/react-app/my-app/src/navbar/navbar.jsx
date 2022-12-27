import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from 'react-router-dom';
// import NavDropdown from 'react-bootstrap/NavDropdown';
import './navbar.css';

export default function MyAppNavbar() {
    return (
        <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
            <Container>
                <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                <Navbar.Collapse id="responsive-navbar-nav">
                    <Nav className="me-auto">
                        {/* <Link to="home">Home</Link> */}
                        <Nav.Link className='nav-link' as={Link} to='/'>Home</Nav.Link>
                        <Nav.Link as={Link} to='/products'>Products</Nav.Link>
                    </Nav>
                    <Nav className='nav-rightmenu'>
                        <Nav.Link as={Link} to="login">Login</Nav.Link>
                        <Nav.Link as={Link} eventKey={2} to='/about'>
                            About
                        </Nav.Link>
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
}