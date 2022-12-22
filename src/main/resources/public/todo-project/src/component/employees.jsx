import React from 'react'
import './employees.css'
import Employee from './Employee'

export default function Employees(props) {
    return (
        <div>
            <p>Employee Table</p>
            <table>
                <tbody>
                    {props.data.map((emp) => <Employee src={emp} />)}
                </tbody>
            </table>
        </div>
    )
}