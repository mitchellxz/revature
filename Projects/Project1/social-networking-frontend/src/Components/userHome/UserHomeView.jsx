import GetPosts from "./GetPosts";
import getProfileId from "../../utils/getProfileId";
import { useState, useEffect } from "react";

function UserHomeView() {
  const [profileId, setProfileId] = useState(null);

  useEffect(() => {
    async function fetchProfileId() {
      await getProfileId();
      const retrievedProfileId = sessionStorage.getItem("profile_id");
      setProfileId(retrievedProfileId);
    }
    fetchProfileId();
  }, []);
  return (
    <div>
      {profileId ? <GetPosts profileId={profileId} /> : <p>Loading posts...</p>}
    </div>
  );
}

export default UserHomeView;
