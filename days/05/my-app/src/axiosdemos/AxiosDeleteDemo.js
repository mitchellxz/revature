import axios from "axios";
import { useState } from "react";

const AxiosDeleteDemo = () => {
    const [id, setId] = useState("");

    const deletePost = async (e) => {
        e.preventDefault();
        const url = `http://localhost:8000/posts/${id}`

        try {
            const response = await axios.delete(url);
            console.log(response.data);
            setId("");
        } catch (error) {
                console.error("Error: ", error);
        }

    }
    return (
        <>
        <h3>Axios Put Demo</h3>

        <form onSubmit={deletePost}>
            <b>enter id to delete: </b>
            <input
                type="text"
                value={id}
                onChange={(e) => setId(e.target.value)}
            />
            <button>delete id</button>
        </form>
        </>
    );
}

export default AxiosDeleteDemo;