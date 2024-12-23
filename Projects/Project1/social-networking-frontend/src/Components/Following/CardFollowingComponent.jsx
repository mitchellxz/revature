import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/esm/Button";
import unfollowProfile from "./unfollowProfile";

function CardFollowingComponent({ followedProfiles }) {
  return (
    <Card style={{ width: "18rem" }}>
      <Card.Header>Following</Card.Header>
      <Card.Body>
        {followedProfiles?.map((profile) => (
          <div key={profile.id}>
            {profile.fullName}
            <Button
              onClick={() =>
                unfollowProfile(
                  // send profileid of followed user AND current user
                  profile.id,
                  sessionStorage.getItem("profile_id")
                )
              }
            >
              unfollow
            </Button>
          </div>
        ))}
      </Card.Body>
    </Card>
  );
}

export default CardFollowingComponent;
