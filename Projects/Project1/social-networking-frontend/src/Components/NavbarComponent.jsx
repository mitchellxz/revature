import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import Container from "react-bootstrap/Container";

function NavbarComponent({ username }) {
  return (
    <>
      <Navbar fixed="top" bg="dark" data-bs-theme="dark" className="navbar">
        <Container>
          <Navbar.Brand href="/user/home">Social Networking</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href={`/profile/user/${username}`}>Profile</Nav.Link>
            <Nav.Link href={`/profile/${username}/upload`}>Upload</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </>
  );
}

export default NavbarComponent;
