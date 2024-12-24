import { useEffect, useState } from "react";
import CardFollowingComponent from "./CardFollowingComponent";
import followingProfiles from "./followingProfiles";

function GetFollowingProfiles() {
  const [followedProfiles, setFollowedProfiles] = useState([]);
  useEffect(() => {
    async function getFollowingProfiles() {
      try {
        const profiles = await followingProfiles();
        setFollowedProfiles(profiles || []);
      } catch (error) {
        console.error("Error fetching following profiles: ", error);
      }
    }
    getFollowingProfiles();
  }, []);

  return (
    <div>
      <CardFollowingComponent followedProfiles={followedProfiles} />
    </div>
  );
}

export default GetFollowingProfiles;
