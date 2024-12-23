import { Outlet, Navigate } from "react-router-dom";

const ProtectedRoutes = () => {
  const user = sessionStorage.getItem("username");
  return user ? <Outlet /> : <Navigate to="/" />;
};

export default ProtectedRoutes;
