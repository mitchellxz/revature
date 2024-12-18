import { useState } from "react";

const Counter = () => {
    const [counter, setCounter] = useState(0);

    const incrementCounter = () => {
        setCounter(counter + 1);
    }

    const decrementCounter = () => {
        setCounter(counter - 1);
    }
    return (
        <>
        <button data-testid="increment" onClick={incrementCounter}>Increment</button>
        <h3 data-testid="counter">{counter}</h3>
        <button data-testid="decrement" onClick={decrementCounter}>Decrement</button>
        </>
    );
}

export default Counter;