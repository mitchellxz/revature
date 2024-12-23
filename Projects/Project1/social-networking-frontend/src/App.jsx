import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import { Routes, Route, BrowserRouter } from "react-router-dom";
import Home from "./Pages/Home";
import Login from "./Pages/Login";
import Register from "./Pages/Register";
import ProtectedRoutes from "./utils/ProtectedRoutes";
import ViewProfile from "./Components/Profile/ViewProfile";
import ViewEditProfile from "./Components/Profile/ViewEditProfile";
import NavbarComponent from "./Components/NavbarComponent";
import UserHomeView from "./Components/userHome/UserHomeView";
import CreatePost from "./Components/userHome/CreatePost";

function App() {
  const username = sessionStorage.getItem("username");

  return (
    <BrowserRouter>
      {username && <NavbarComponent username={username} />}
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route element={<ProtectedRoutes />}>
          <Route path="/user/home" element={<UserHomeView />} />
          <Route path="/profile/user/:username" element={<ViewProfile />} />
          <Route path="/profile/user/edit" element={<ViewEditProfile />} />
          <Route path="/profile/:username/upload" element={<CreatePost />} />
        </Route>
        <Route path="/register" element={<Register />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
