import { useState } from 'react';
import './options.css';
export default function Option({ options }) {
    const [result, setResult] = useState(0);
    const handleClick = (e) => {
        if (e === options.answer) {
            setResult(result + 1);
        }
    };
    return (
        <table>
            <tbody>
                <tr>
                    <td><div className='option-key'>A</div><input className="btn btn-success" type="button" value={options.A} onClick={() => handleClick(options.A)}
                    /></td>
                    <td><div className='option-key'>C</div><input className="btn btn-success" type="button" value={options.C} onClick={() => handleClick(options.C)}
                    /></td>
                </tr>
                <tr>
                    <td><div className='option-key'>B</div><input className="btn btn-success" type="button" value={options.B} onClick={() => handleClick(options.B)}
                    /></td>
                    <td><div className='option-key'>D</div><input className="btn btn-success" type="button" value={options.D} onClick={() => handleClick(options.D)}
                    /></td>
                </tr>
            </tbody>
        </table>
    )
}