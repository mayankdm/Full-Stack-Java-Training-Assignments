import React from "react";
import Expense from '../expense/expense';
import Card from '../card/card';
import './expenses.css';

export default function Expenses(props) {
    console.log(props);
    return (
        <Card className="expenses">
            <Expense
                title={props.items[0].title}
                amount={props.items[0].amount}
                date={props.items[0].date}
            />
            <Expense
                title={props.items[1].title}
                amount={props.items[1].amount}
                date={props.items[1].date}
            />
            <Expense
                title={props.items[2].title}
                amount={props.items[2].amount}
                date={props.items[2].date}
            />
            <Expense
                title={props.items[3].title}
                amount={props.items[3].amount}
                date={props.items[3].date}
            />
        </Card>
    );
}