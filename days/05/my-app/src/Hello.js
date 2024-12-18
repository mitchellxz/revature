import { useContext } from "react";
import MyContext from "./contextDemo/MyContext";

const Hello = (props) => {
    const theData = useContext(MyContext);
    return (
        <>
        <h2>Hello functional component</h2>
        <p>Hello world from hello component {props.name}</p>
        <h2>Data from context :::: {theData}</h2>
        </>
    )
}

export default Hello;