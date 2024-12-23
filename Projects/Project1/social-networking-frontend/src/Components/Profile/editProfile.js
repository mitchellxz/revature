import axios from "axios";

async function editProfile( name, bio, location ) {
      const profileId = sessionStorage.getItem("profile_id");
      const url = `http://localhost:8080/profile/${profileId}/edit`;
      const body = { fullName: name, bio: bio, location: location };
      const config = { "Content-Type": "application/json" };

      try {
        const response = await axios.patch(url, body, config);
        console.log(response.data);
      } catch (error) {
        console.error("Error editing profile: ", error);
      }
    }

export default editProfile;
