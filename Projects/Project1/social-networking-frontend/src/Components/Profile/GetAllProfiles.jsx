import axios from "axios";
import { useEffect, useState } from "react";

function GetAllProfiles() {
  const [profiles, setProfiles] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");

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
      profile.fullName.toLowerCase().includes(searchTerm.toLowerCase())
  );
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
              <p key={profile.id}>{profile.fullName}</p>
            ))}
        </ul>
      ) : (
        <p>No profiles found.</p>
      )}
    </>
  );
}

export default GetAllProfiles;
