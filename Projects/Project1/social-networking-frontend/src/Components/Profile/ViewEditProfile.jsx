import ProfileForm from "./ProfileForm";
import Button from "react-bootstrap/Button";

function ViewEditProfile() {
  const username = sessionStorage.getItem("username");
  return (
    <div>
      <h1>Edit Profile</h1>
      <ProfileForm />
      <Button variant="primary" href={`/profile/user/${username}`}>
        Back to profile
      </Button>
    </div>
  );
}

export default ViewEditProfile;
