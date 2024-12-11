const getTodos = async () => {
    const response = await fetch("https://jsonplaceholder.typicode.com/todos/1")
    const data = response.json();
    return data;
}

console.log(1)
console.log(2)
getTodos().then((data) => {
    console.log(data)
}).catch((error) => {
    console.log(error)
})

console.log(3)
console.log(4)