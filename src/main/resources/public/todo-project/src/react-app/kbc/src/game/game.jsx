import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './game.css';
import Question from '../Question/question';
import Option from '../options/option';
export default function Game({ quiz }) {
    //console.log(quiz);
    const navigate = useNavigate();
    const [count, setCount] = useState(0);
    useEffect(() => {
        console.log('Count is now: ', count);
    }, [count]);
    const handleClick = (event) => {
        if (event === 'restart') {
            setCount(0);
        }
        if (count < 9) {
            setCount(count + 1);
        }
        else {
            navigate('/welcome');
        }
    };
    return (
        <div className="container mt-sm-5 my-1">
            <div className='ml-sm-5 pl-sm-5 pt-2 question-status'>{`Question ${count + 1}/10`}</div>
            <div className="question ml-sm-5 pl-sm-5 pt-2">
                <Question question={quiz[count].question}></Question>
                <div className='option'><Option options={quiz[count].options}></Option></div>
            </div>
            <div className="d-flex align-items-center pt-3 footer">
                <button className="btn btn-success1" onClick={handleClick}>Next</button>
            </div>
        </div>
    )
}