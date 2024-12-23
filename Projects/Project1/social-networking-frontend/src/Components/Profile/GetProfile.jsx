import { useState, useEffect } from "react";
import axios from "axios";
import GetFollowingProfiles from "./GetFollowingProfiles";
import CardProfileComponent from "./CardProfileComponent";

function GetProfile({ username }) {
  const [profile, setProfile] = useState(null);

  useEffect(() => {
    async function getProfile() {
      try {
        const response = await axios.get(
          `http://localhost:8080/profile/user/${username}`
        );
        setProfile(response.data);

        console.log(response.data);
        sessionStorage.setItem("profile_id", response.data.id);
      } catch (error) {
        console.error("Error fetching profile: ", error);
      }
    }
    getProfile();
  }, [username]);

  if (!profile) {
    return <p>Loading profile...</p>;
  }

  return (
    <div>
      <CardProfileComponent
        name={profile.fullName}
        bio={profile.bio}
        location={profile.location}
      />
      <GetFollowingProfiles />
    </div>
  );
}

export default GetProfile;
