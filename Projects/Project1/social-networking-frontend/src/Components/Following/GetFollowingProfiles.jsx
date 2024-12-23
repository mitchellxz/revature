import axios from "axios";
import { useEffect, useState } from "react";
import CardFollowingComponent from "./CardFollowingComponent";

function GetFollowingProfiles() {
  const profileId = sessionStorage.getItem("profile_id");
  const [followedProfiles, setFollowedProfiles] = useState([]);
  useEffect(() => {
    async function getFollowingProfiles() {
      try {
        const response = await axios.get(
          `http://localhost:8080/profile/following/${profileId}`
        );
        setFollowedProfiles(response.data);
      } catch (error) {
        console.error("Error fetching following profile: ", error);
      }
    }
    if (followedProfiles) {
      getFollowingProfiles();
    }
  }, []);

  return (
    <div>
      <CardFollowingComponent followedProfiles={followedProfiles} />
    </div>
  );
}

export default GetFollowingProfiles;
