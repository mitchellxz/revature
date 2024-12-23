import axios from "axios";
import { useEffect, useState } from "react";

function GetFollowerName({ followerId }) {
  const [followerName, setFollowerName] = useState("");
  useEffect(() => {
    async function getFollowerName() {
      try {
        const response = await axios.get(
          `http://localhost:8080/profile/following/mutual/${followerId}`
        );
        setFollowerName(response.data.fullName);
      } catch (error) {
        console.error("Error fetching profile: ", error);
      }
    }
    getFollowerName();
  }, [followerId]);
  return <>{followerName}</>;
}

export default GetFollowerName;
