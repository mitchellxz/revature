import axios from "axios";

async function postComment(messageText, postId) {
    const profileId = sessionStorage.getItem("profile_id");
    const url = `http://localhost:8080/message/${profileId}/${postId}/create`;
    const body = {messageText: messageText};
    const config = {"Content-Type": "application/json"};

    try {
        const response = await axios.post(url, body, config);
        console.log(response.data);
    } catch (error) {
        console.log("Error commenting: ", error);
    }

}

export default postComment;