const getSomething = () => {
    return new Promise((resolve, reject) => {
        //resolve("some data");
        reject("some error");
    })
}

getSomething().then(data => {
    console.log(data)
})
.catch(error => {
    console.log(error)
})