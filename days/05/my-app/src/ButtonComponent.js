import { useState } from "react";

const ButtonComponent = () => {
    const [clicks, setClicks] = useState(0);

    const onClickHandler = () => {
        setClicks(clicks + 1);
        alert(`Button clicked ${clicks} times!`)
    }
    
    return (
        <>
        <button onClick={onClickHandler}>A button</button>
        </>
    );

}

export default ButtonComponent;