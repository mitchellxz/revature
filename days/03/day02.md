DOM -- Document Object Model

querySelector()
querySelectorAll()

action --> event occurs --> event handler or eventlistener

#####

Web Tech
Request, Response (HTTP)

Request - Response Cycle

1. sends request to the server
2. the server receives the request
3. the server processes the request, typically using an application or program
4. the server returns a response
5. the client receives the response (data) and displays it

Client -- browser -- makes the request

callback
browser will display data (200, 404, 500)

####

Promise

1. Pending
2. Resolved
3. Rejected

var Promise = new Promise(resolve, rejected)
.then( () => {
do something when it is successful
})
.then ( () => {
do something when it is rejected
})

get(data)
will receive data
will not receive data
will get error

var promise = new promise(get(some type of data))
.then(data => {
console.log(data)
})
.then( () => {
console.log("no data found")
})
.catch ( () => {
console.log("There was an error fetching data")
})

    if(statuscode == 200) {
        display data
    }
    else if (statuscode == 404) {
        do something else
    }
    else if (...)

In order to make Async http request/response in JS

1. AJAX
2. Fetch API (uses or returns Promise)

async await
Async and await are syntactical sugars for Promises

Promise(resolve, reject)

async -- Async execution
await -- wait for the result of the execution of the method
Async and Await wraps the promises, Async and await result in a promise
