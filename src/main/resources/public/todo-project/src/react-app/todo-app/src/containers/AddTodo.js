import React from 'react'
import { connect } from 'react-redux'
import { addTodo } from '../actions'

const AddTodo = ({ dispatch }) => {
    let name, description, status;
    function submitFormdata() {
        if (!name.value.trim()) {
            return
        }
        dispatch(addTodo(name.value))
        console.log(description, status)
        name.value = ''
    }
    return (
        <div>
            <h6><b>Add Todo</b></h6>
            <form onSubmit={e => {
                e.preventDefault();
                submitFormdata();
            }}>
                <input ref={node => name = node} placeholder='Name' type='text' />
                <input ref={node => description = node} placeholder='Description' type='text' />
                <b><input ref={node => status = node} placeholder='Status' type="checkbox" />
                <span className="checkmark"></span>Status</b>
                <button type="submit">
                    +
                </button>
            </form>
        </div>
    )
}

export default connect()(AddTodo)