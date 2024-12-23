/*
    This function is used to get the profile id of the user.   
*/

import axios from "axios";

async function getProfileId() {
    const username = sessionStorage.getItem("username");
    try {
        const response = await axios.get(
            `http://localhost:8080/profile/user/${username}`
        );
        sessionStorage.setItem("profile_id", response.data.id);
    } catch (error) {
        console.error("Error fetching profile: ", error);
    }

}

export default getProfileId;