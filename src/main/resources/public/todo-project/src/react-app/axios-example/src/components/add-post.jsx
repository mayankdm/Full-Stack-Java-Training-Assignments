import React, { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Axios from 'axios';
import '../utils/util.css';

const AddPost = () => {
    const baseUrl = "http://localhost:3003/employees";
    const [name, setName] = useState('');
    const [desc, setDesc] = useState('');
    const submitHandler = (event) => {
        event.preventDefault();
    }
    const addPostHandler = () => {
        Axios.post(baseUrl, { name, desc }).then((response) => {
            setName("");
            setDesc("");
        }).catch((error) => {
            console.log(error);
        });
    }
    return (
        <Form className='add-item-form' onSubmit={submitHandler}>
            <Form.Group className="mb-3" controlId="title">
                <Form.Label>Title</Form.Label>
                <Form.Control type="text" placeholder="Title" onChange={(event) => setName(event.target.value)} />
            </Form.Group>
            <Form.Group className="mb-3" controlId="description">
                <Form.Label>Description</Form.Label>
                <Form.Control type="text" placeholder="Description" onChange={(event) => setDesc(event.target.value)} />
            </Form.Group>
            <Button variant="primary" type="submit" onClick={addPostHandler}>
                Submit
            </Button>
        </Form>
    )
};

export default AddPost