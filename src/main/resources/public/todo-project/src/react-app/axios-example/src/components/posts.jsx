import React, { useState, useEffect } from 'react'
import Axios from 'axios';
 import Table from 'react-bootstrap/Table';
//import { Modal, Button } from "react-bootstrap";
import { Link } from 'react-router-dom'
import '../utils/util.css';
const Posts = () => {
    const baseUrl = "http://localhost:3003/employees";
    const [postArr, setPostArr] = useState([]);
    const [isEditable, setIsEditable] = useState(false);
    const [currentRow, setIsCurrentRow] = useState(0);
    useEffect(() => {
        Axios.get(baseUrl).then((response) => {
            setPostArr(response.data);
        });
    }, []);
    const editRow = (e, id) => {
        setIsEditable(!isEditable);
        setIsCurrentRow(id);
        if (isEditable) {
            const htmlRegexG = /<(?:"[^"]*"['"]*|'[^']*'['"]*|[^'">])+>/g;
            const desc = e.target.parentElement.parentElement.children[1].innerText.replace(htmlRegexG, '');
            const name = e.target.parentElement.parentElement.children[0].innerText.replace(htmlRegexG, '');
            Axios.put(`${baseUrl}/${id}`, { name, desc }).then((response) => {
                console.log(response);
                Axios.get(baseUrl).then((response) => {
                    setPostArr(response.data);
                });
            }).catch((error) => {
                console.log(error);
            });
        }
    }
    const deleteRow = (id) => {
        Axios.delete(`${baseUrl}/${id}`)
            .then(() => {
                Axios.get(baseUrl).then((response) => {
                    console.log(response.data);
                    setPostArr(response.data);
                });
            })
    }
    // if (postArr.length === 0) return "<h1>There is No Data</h1>";
    return (
        <>
            <Table striped bordered hover variant="dark">
                <thead>
                    <tr className='table-header'><th colSpan="2"> All Post ({postArr.length})</th>
                        <th title='add item' className='tool-icons'>
                            <Link to='/add-posts'><i className="fa fa-plus-circle add-item" aria-hidden="true"></i></Link></th></tr>
                </thead>
                <tbody id='tableForm'>
                    {postArr.map((post) => <tr data-id={post.id} key={post.id}>
                        <td className='column-index' contentEditable={currentRow === post.id}>{post.name}</td>
                        <td className='column-title' contentEditable={currentRow === post.id}>{post.desc}</td>
                        <td className='column-icons' title='delete item'>
                            <i className="fa fa-eye action-icon view-icon" aria-hidden="true" onClick={(e) => deleteRow(post.id, e)}></i>
                            <i title='edit item' className={(isEditable && currentRow === post.id) ?
                                'fa fa-floppy-o action-icon edit-icon' : 'fa fa-pencil-square-o action-icon edit-icon'}
                                aria-hidden="true" onClick={(e) => editRow(e, post.id)}></i>
                            <i className="fa fa-trash-o action-icon delete-icon" aria-hidden="true" onClick={(e) => deleteRow(post.id, e)}></i>
                        </td>
                    </tr>)}
                </tbody>
            </Table>
            {/* <Modal show={this.state.isOpen} onHide={this.closeModal}>
                <Modal.Header closeButton>
                    <Modal.Title>Modal heading</Modal.Title>
                </Modal.Header>
                <Modal.Body>Woohoo, you're reading this text in a modal!</Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={this.closeModal}>
                        Close
                    </Button>
                </Modal.Footer>
            </Modal> */}
        </>
    )
}

export default Posts;