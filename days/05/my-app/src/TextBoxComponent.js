import {useState} from "react";

const TextBoxComponent = () => {
    const [text, setText] = useState("Some text");

    const handleOnChange = (event) => {
        setText(event.target.value);        
    }
    return (
        <label>
            <h3>{text}</h3>
            <input value ={text} onChange={handleOnChange} />
        </label>
    )
}

export default TextBoxComponent;