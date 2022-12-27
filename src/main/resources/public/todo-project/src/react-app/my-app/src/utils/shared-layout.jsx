import {Outlet } from 'react-router-dom';
import MyAppNavbar from '../navbar/navbar';
const Home = () => {
  return (
    <>
      <MyAppNavbar />
      <Outlet />
    </>
  );
};
export default Home;