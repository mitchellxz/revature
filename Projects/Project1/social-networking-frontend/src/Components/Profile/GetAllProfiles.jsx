import axios from "axios";
import { useEffect, useState } from "react";
import Button from "react-bootstrap/Button";
import followProfile from "../Following/followProfile.js";
import followingProfiles from "../Following/followingProfiles.js";

function GetAllProfiles() {
  const [profiles, setProfiles] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");
  const [followedProfileId, setFollowedProfileId] = useState(null);
  const [followedProfiles, setFollowedProfiles] = useState([]);

  useEffect(() => {
    async function getAllProfiles() {
      try {
        const response = await axios.get(`http://localhost:8080/profile/all`);
        setProfiles(response.data);
        console.log(response.data);
      } catch (error) {
        console.error("Error fetching profiles: ", error);
      }
    }
    getAllProfiles();
  }, []);

  const filteredProfiles = profiles.filter(
    (profile) =>
      profile.fullName &&
      profile.fullName.toLowerCase().includes(searchTerm.toLowerCase()) &&
      profile.id != sessionStorage.getItem("profile_id")
  );

  useEffect(() => {
    if (followedProfileId) {
      followProfile(followedProfileId);
    }
  }, [followedProfileId]);

  const handleFollowButtonClick = (e) => {
    e.preventDefault();
    setFollowedProfileId(e.target.value);
  };

  useEffect(() => {
    async function fetchFollowingProfiles() {
      try {
        const profiles = await followingProfiles();
        setFollowedProfiles(profiles);
        console.log(followedProfiles);
      } catch (error) {
        console.error("Error fetching followed profiles: ", error);
      }
    }
    fetchFollowingProfiles();
  }, []);

  return (
    <>
      <input
        type="text"
        placeholder="Search profiles..."
        value={searchTerm}
        onChange={(e) => setSearchTerm(e.target.value)}
      />
      {filteredProfiles.length > 0 ? (
        <ul>
          {filteredProfiles
            .filter((profile) => profile.fullName)
            .map((profile) => (
              <p key={profile.id}>
                {profile.fullName}
                {!followedProfiles.some(
                  (followedProfile) => followedProfile.id === profile.id
                ) && (
                  <Button
                    size="sm"
                    variant="dark"
                    onClick={handleFollowButtonClick}
                    value={profile.id}
                  >
                    Follow
                  </Button>
                )}
              </p>
            ))}
        </ul>
      ) : (
        <p>No profiles found.</p>
      )}
    </>
  );
}

export default GetAllProfiles;
