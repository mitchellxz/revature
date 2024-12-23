import Card from "react-bootstrap/Card";

function CardFollowingComponent({ followedProfiles }) {
  return (
    <Card style={{ width: "18rem" }}>
      <Card.Header>Following</Card.Header>
      <Card.Body>
        {followedProfiles?.map((profile) => (
          <div key={profile.id}>{profile.fullName}</div>
        ))}
      </Card.Body>
    </Card>
  );
}

export default CardFollowingComponent;
