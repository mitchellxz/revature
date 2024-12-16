import { useState } from "react";
import axios from "axios";

const AxiosPostDemo = () => {

    const [title, setTitle] = useState("");

    const createPost = async (e) => {
        e.preventDefault();
        const url = 'http://localhost:8000/posts';
        const inputData = {title: title};
        const config = {'content-type': 'application/json'};
            

        try {
            const response = await axios.post(url, inputData, config);
            console.log(response.data);
            setTitle("");
        } catch (error) {
                console.error("Error: ", error);
        }
    };

    return (
        <>
        <h3>Axios Post Demo</h3>
        <form onSubmit={createPost}>
                <input 
                    type="text" 
                    value={title} 
                    onChange={(e) => setTitle(e.target.value)}/>
                <button>Add a title</button>
            </form>
        </>
    );
    
}


export default AxiosPostDemo;