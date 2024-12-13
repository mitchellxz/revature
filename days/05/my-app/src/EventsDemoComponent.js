const EventDemoComponent = () => {
    const handleClick = () => {
        console.log("hello event")
    }

    const handleClickAgain = (name) => {
        console.log("Hello event " + name)
    }

    return (
        <>
        <h2>Events Demo</h2>

        <button onClick={handleClick}>Click me</button>
        <button onClick={() => handleClickAgain("test")}>Click me again</button>
        </>
    )
}

export default EventDemoComponent;