import Card from "react-bootstrap/Card";
import GetFollowerName from "../Following/GetFollowerName";

function CardMutualComponent({ followedProfiles }) {
  return (
    <Card style={{ width: "18rem" }}>
      <Card.Header>Mutuals</Card.Header>
      <Card.Body>
        {followedProfiles?.map((follower) => (
          <div key={follower.id}>
            {<GetFollowerName followerId={follower.id} />}
          </div>
        ))}
      </Card.Body>
    </Card>
  );
}

export default CardMutualComponent;
