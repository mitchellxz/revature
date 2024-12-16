/*
1. write code to get an array of names from a given array of users
2. get back ONLY active users
(mapping users to get usernames)
*/

const users = [
    {
        id: 1,
        name: "jack",
        isActive: true,
        age:20
    },
    {
        id: 2,
        name: "john",
        isActive: true,
        age: 18
    },
    {
        id: 3,
        name: "mike",
        isActive: false,
        age: 30
    }
];

const names = users.filter(user => user.isActive).map( (user) => user.name);
console.log(names);


/*
What will be logged in the first example and second example? (null vs undefined)
*/

let var1;
console.log(var1);          // undefined
console.log(typeof var1);   // undefined

let var2 = null;
console.log(var2);          // null
console.log(typeof var2);   // object


/*
What will be console.logged here (hoisting)
*/

// Question 1
//console.log(foo);   // ReferenceError: foo is not defined
//foo = 1;


// Question 2
//console.log(foo)    // undefined - var bubbles to the top
//var foo = 2;

// Question 3
foo = 3
console.log(foo)      // 3 - var foo bubbles to the top, then foo is assigned 3
var foo;


/*
Write a function which gets an array and an element and returns an array with the element at the end
*/

const numbers = [1, 2]
const append = (array, element) => {
    return [...array, element]
}

const newNumbers = append(numbers, 3);
console.log(numbers);
console.log(newNumbers);


/*
Write a function which will concatenate 2 arrays
*/

const mergeArrays = (arr1, arr2) => {
    //return arr1.concat(...arr2);
    return [...arr1, ...arr2];
}

const arr1 = [4];
const arr2 = [5, 6];
const result = mergeArrays(arr1, arr2);
console.log(result);


/*
Check that a user with such name exists in an array of objects
*/

//const nameExists = (name, nameArray) => nameArray.some( (element) => element.name === name);

const nameExists = (name, nameArray) => {
    const element = nameArray.find(element => element.name === name);
    return Boolean(element);
}
console.log(nameExists("john", users));


/*
Remove all duplicates in the array
*/

const uniqueArray = arr => {
    return [...new Set(arr)];
}

const arrayWithDupes = [1, 1, 2, 2, 2, 3];

console.log(uniqueArray(arrayWithDupes));


/*
Sort the aray of numbers
*/

const arrayUnsorted = [3,2,1];
const arraySorted = arrayUnsorted.sort( (a, b) => a - b);
console.log(arraySorted);