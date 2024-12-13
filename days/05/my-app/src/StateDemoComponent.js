import { useState } from "react";

const StateDemoComponent = () => {
    
    const [name, setName] = useState("oldname");
    const [age, setAge] = useState("oldage");

    const changeName = (input, ageInput) => {
        setName(input);
        setAge(ageInput)
    }
    return (
        <>
        <h2>{name} and {age}</h2>
        <button onClick={() => changeName("newnewname", 14)}>change name</button>
        </>
    );
}

export default StateDemoComponent;



/*

Write components to display comments associated with a post

ex: you have one post with 5 comments ---> need to use a prop to pass data

comments should be in an array and iterate them (use map function)


*/