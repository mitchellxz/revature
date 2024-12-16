import { useEffect, useState } from "react";
import axios from "axios";
import DisplayPosts from "../DisplayPosts";

const AxiosGetDemo = () => {
    
    const [posts, setPosts] = useState([]);

    useEffect( () => {
        //axios.get("https://jsonplaceholder.typicode.com/posts")
        axios.get("http://localhost:8000/posts")
        .then(response => {
            setPosts(response.data);
        })
    }, [])
    return (
        <>
        <h2>Axios Demo</h2>
        <DisplayPosts posts={posts}/>
        </>
    );
}

export default AxiosGetDemo;