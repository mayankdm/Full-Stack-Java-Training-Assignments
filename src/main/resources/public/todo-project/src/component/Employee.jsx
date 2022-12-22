import React from "react";

export default function Employee(props) {
    let emp = props.src;
    return (
        <tr key={emp.id}>
            <td key={emp.id}>{emp.id}</td>
            <td key={emp.name}>{emp.name}</td>
            <td key={emp.department}>{emp.department}</td>
            <td key={emp.designation}>{emp.designation}</td>
        </tr>
    )
}