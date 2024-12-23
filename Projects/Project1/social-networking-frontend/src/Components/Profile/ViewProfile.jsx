import GetProfile from "./GetProfile";

// also need to change fullName to name and bio to larger text box

function ViewProfile() {
  const username = sessionStorage.getItem("username");
  return (
    <div>
      <GetProfile username={username} />
    </div>
  );
}

export default ViewProfile;
