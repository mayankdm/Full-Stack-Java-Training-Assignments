import React from 'react';
import Footer from './Footer';
import AddTodo from '../containers/AddTodo';
import VisibleTodoList from '../containers/VisibleTodoList';

const App = () => (
    <div>
        <div className="app-card">
            <div className="app-container">
                <div><h4><b>Todo App</b></h4></div>
                <div className='cards'>
                    <div className="addtodo-card">
                        <div className="addtodo-container">
                            <AddTodo />
                        </div>
                    </div>
                    <div className="listtodo-card">
                        <div className="listtodo-container">
                            <VisibleTodoList />
                        </div>
                    </div>
                    <div className="listtodo-card">
                        <div className="listtodo-container">
                            <VisibleTodoList />
                        </div>
                    </div>
                    <div className="listtodo-card">
                        <div className="listtodo-container">
                            <VisibleTodoList />
                        </div>
                    </div>
                    <div className="listtodo-card">
                        <div className="listtodo-container">
                            <VisibleTodoList />
                        </div>
                    </div>
                </div>
                {/* <Footer /> */}
            </div>
        </div>
    </div>
);

export default App;