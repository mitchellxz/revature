import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";

function CardProfileComponent({ name, bio, location }) {
  return (
    <Card>
      <Card.Header>Profile Details</Card.Header>
      <Card.Body>
        <Card.Title>Name</Card.Title>
        <Card.Text>{name}</Card.Text>
        <Card.Title>Bio</Card.Title>
        <Card.Text>{bio}</Card.Text>
        <Card.Title>Location</Card.Title>
        <Card.Text>{location}</Card.Text>
        <Button variant="primary" href="/profile/user/edit">
          Edit Profile
        </Button>
      </Card.Body>
    </Card>
  );
}

export default CardProfileComponent;
