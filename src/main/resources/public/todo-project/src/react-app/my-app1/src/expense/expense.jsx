import React from 'react';
import './expense.css';
import Card from '../card/card';
import Date from '../date/date';

export default function Expense(props) {
    <Card className='expense-item'>
        <Date date={props.date} />
        <div className='expense-item__description'>
            <h2>{props.title}</h2>
            <div className='expense-item__price'>${props.amount}</div>
        </div>
    </Card>
}