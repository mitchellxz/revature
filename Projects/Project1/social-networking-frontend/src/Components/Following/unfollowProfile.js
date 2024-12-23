import axios from "axios";

async function unfollowProfile(profileToUnfollow, profileId) {
    try {
        const response = await axios.delete(
            `http://localhost:8080/followers/${profileId}/unfollow/${profileToUnfollow}`
        );
        console.log(response);
        alert("Succesfully unfollowed.")
        return true;
    } catch (error) {
        console.log("Error unfollowing profile: ", error);
        return false;
    }
}

export default unfollowProfile;