function multiply(a, b) {
    if (typeof b !== 'undefined') {
        return a * b;
    }
    return a;
}
var multiplyValue = multiply(1);
console.log(multiplyValue);
multiplyValue = multiply(2, 2);
console.log(multiplyValue);
