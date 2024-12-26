import axios from "axios";

 async function postCreatePost(content) {
    const profileId = sessionStorage.getItem("profile_id");
    const url = `http://localhost:8080/post/${profileId}/create`;
    const body = {content: content};
    const config = { "Content-Type": "application/json" };

    try {
        const response = await axios.post(url, body, config);
        console.log(response);
    } catch (error) {
        console.error("Error creating post: ", error);
    }
}

export default postCreatePost;