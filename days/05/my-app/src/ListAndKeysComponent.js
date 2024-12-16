import CommentDisplayComponent from "./CommentDisplayComponent";

import { useEffect, useState } from "react";


const ListAndKeysComponent = () => {

    const [comments, setComments] = useState([
        {"id": 1, "name": "test"},
        {"id": 2, "name": "test"},
    ])

    const handleDelete = (id) => {
        const newComment = comments.filter(comment => comment.id != id);
        setComments(newComment);
    }

    const [name, setName] = useState("old name");


    useEffect( () => {
        console.log("use effect called")
    }, [name])

    return (
        <>
        <h2>List and Keys</h2>
        <CommentDisplayComponent comments={comments} handleDelete={handleDelete} />
        <button onClick={() => setName("new name")}>Change Name</button>
        </>
    )

}

export default ListAndKeysComponent;