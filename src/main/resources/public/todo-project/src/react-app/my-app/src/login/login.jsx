import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Card from 'react-bootstrap/Card';
import { Link } from 'react-router-dom';
// import { useNavigate } from 'react-router-dom';
import './login.css';

export default function Login({ setUser }) {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');

  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!name || !email) return;
    setUser({ name: name, email: email });
    navigate('/dashboard');
  };
  return (
    <Card className='login-card'>
      <Card.Header className='login-card-header'>Login</Card.Header>
      <Card.Body className='login-card-body'>
        <Form onSubmit={handleSubmit}>
          <Form.Group className="mb-3" controlId="name">
            <Form.Label>Name</Form.Label>
            <Form.Control type='text'
              value={name}
              onChange={(e) => setName(e.target.value)} />
          </Form.Group>

          <Form.Group className="mb-3" controlId="email">
            <Form.Label>Password</Form.Label>
            <Form.Control type="email" placeholder="Email" value={email}
              onChange={(e) => setEmail(e.target.value)} />
          </Form.Group>
          {/* <Form.Group className="mb-3 remember-me" controlId="formBasicCheckbox">
            <Form.Check type="checkbox" id="rememberMe" value={rememberMe}
              onChange={(e) => setRememberMe(e.target.value)} />
            <Form.Label>Remember Me</Form.Label>
          </Form.Group> */}
          <Button className='login-submit-button' variant="primary" type="submit">
            Login Now
          </Button>
        </Form>
      </Card.Body>
      {/* <Card.Footer className="login-card-footer text-muted"><Link className='registration-link' to='register'>Register here</Link></Card.Footer> */}
    </Card>
  )
}