import { useState } from "react";
import axios from "axios";

const AxiosPutDemo = () => {

    const [id, setId] = useState("");
    const [title, setTitle] = useState("");

    const updatePost = async (e) => {
        e.preventDefault();
        const url = `http://localhost:8000/posts/${id}`;
        const inputData = {title: title};
        const config = {'content-type': 'application/json'};

        try {
            const response = await axios.put(url, inputData, config);
            console.log(response.data);
            setTitle("");
        } catch (error) {
            console.error("Error: ", error);
        }
    }

    return (
        <>
        <h3>Axios Put Demo</h3>

        <form onSubmit={updatePost}>
            <b>enter id to modify: </b>
            <input
                type="text"
                value={id}
                onChange={(e) => setId(e.target.value)}
            />
            <br />
            <b>add title: </b>
            <input 
                type="text" 
                value={title} 
                onChange={(e) => setTitle(e.target.value)}
            />
            <br/>
            <button>modify title </button>
        </form>
        </>
    );
}

export default AxiosPutDemo;