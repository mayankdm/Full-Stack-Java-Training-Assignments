import { Link } from 'react-router-dom';
import './welcome.css';
export default function Welcome({ data }) {
    console.log(data);
    return (
        <>
            <div className='welcome'>{data.greeting}</div>
            <Link className='welcome-link' to={`/game`}>{data.link}</Link>
        </>
    )
}