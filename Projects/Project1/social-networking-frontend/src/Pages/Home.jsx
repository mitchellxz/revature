import { useNavigate } from "react-router-dom";
import Button from "../Components/Button";
function Home() {
  const navigate = useNavigate();
  return (
    <>
      <h1>Welcome to the Social Networking Site</h1>

      <Button onClick={() => navigate("/login")}>Login</Button>
      <Button onClick={() => navigate("/register")}>Register</Button>
    </>
  );
}

export default Home;
