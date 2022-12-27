import { Outlet } from 'react-router-dom';
const Home = () => {
    return (
        <>
            <h2 id='product-heading'>products</h2>
            <Outlet />
        </>
    );
};
export default Home;