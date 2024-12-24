import axios from "axios";

async function followProfile(followedProfileId) {
    const profileId = sessionStorage.getItem("profile_id");
    const url = `http://localhost:8080/followers/${profileId}/follow/${followedProfileId}`
    const config = {"Content-Type": "application/json"};

    try {
        const response = await axios.post(url, null, config);
        console.log(response);
    } catch (error) {
        console.log("Error following: ", error);
    }
}

export default followProfile;