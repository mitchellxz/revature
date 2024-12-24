import axios from "axios";

async function followingProfiles() {
    const profileId = sessionStorage.getItem("profile_id");

    try {
        const response = await axios.get(
            `http://localhost:8080/profile/following/${profileId}`
        );
        
        return response.data;
    } catch (error) {
        console.error("Error fetching following profiles: ", error);
        return [];
    }
}

export default followingProfiles;