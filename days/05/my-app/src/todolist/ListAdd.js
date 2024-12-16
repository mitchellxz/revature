import { useState } from "react";

const ListAdd = ({setList}) => {
    const [value, setValue] = useState("");

    const submitHandler = (e) => {
        e.preventDefault();
        console.log(value)
        setValue("");
        setList( (prevList) => {
            return [...prevList, value];
        })
    }

    return (
        <form onSubmit={submitHandler}>
                <input type="text" value={value} onChange={(e) => setValue(e.target.value)}/>
                <button>Add</button>
            </form>
    );
}

export default ListAdd;