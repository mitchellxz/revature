let authors = fetch("https://jsonplaceholder.typicode.com/users")
const authorMap = {};

authors.then(response => {
    response.json().then (
        data => {
            data.forEach(user => {
                authorMap[user.email] = user.name;
            });

            Object.entries(authorMap).forEach(([email, name]) =>{
                let h3Name = document.createElement("h3")
                let pEmail = document.createElement("p")
                let br = document.createElement("br");

                h3Name.innerText = name;
                pEmail.innerText = email;

                document.body.appendChild(h3Name);
                document.body.appendChild(pEmail)
                document.body.appendChild(br);

            })
            console.log(authorMap);
        }
    )
}).catch((error) => {
    console.log(error);
})

