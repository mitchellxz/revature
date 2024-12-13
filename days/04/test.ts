
function multiply(a: number, b?: number): number {
    if (typeof b !== 'undefined') {
        return a * b;
    }
    return a;
}

let multiplyValue = multiply(1);
console.log(multiplyValue);

multiplyValue = multiply(2,2);
console.log(multiplyValue);