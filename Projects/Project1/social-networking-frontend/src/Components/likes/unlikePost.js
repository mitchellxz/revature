import axios from "axios";

async function unlikePost(postId) {
    const profileId = sessionStorage.getItem("profile_id");
    const url = `http://localhost:8080/likes/${postId}/${profileId}`;
    const config = {
        headers: 
        {
            "Content-Type": "text/plain;charset=UTF-8",

        },
    };
    try {
        const response = await axios.delete(url,null,config);
        console.log(response);
    } catch (error) {
        console.log("Error liking post: ", error);
    }
}

export default unlikePost;