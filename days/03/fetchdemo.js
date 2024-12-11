let fetchRes = fetch("https://jsonplaceholder.typicode.com/todos/1")

fetchRes.then(response => {
    response.json().then (
        data => {
            console.log(data)
        }
    )
}).catch(error => {
    console.log(error)
})