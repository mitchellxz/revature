# TypeScript study from slides

## Advanced Types

### TypeScript Intersection Types

- An intersection type creates a new type by combining multiple existing types.
- The new type has ALL the features of the existing types.
- To combine types, use the `&` operator:
  > `type typeAB = typeA & typeB;`

#### Type Order

- When you intersect types, the order of the type does not matter.

### TypeScript Type Guards

- Type Guards allow you to narrow down the type of a variable within a conditional block.

#### typeof

- Checks the type of a variable at runtime (eg. string, number, etc).
- Ensures type safety by validating primitive types before operations.

```
function isString(value: unknown): value is String {
    return typeof value === "string";
}

const value = "hello";
if (isString(value)) {
    console.log(value.toUpperCase());
}
```

#### instanceof

- Checks if an object is an instance of a specific class or constructor function.
- Helps ensure object compatibility with class-based types in object-oriented programming.

```
class Dog {
    bark() {
        console.log("Woof!");
    }
}

const pet = new Dog();
if (pet instanceof Dog) {
    pet.bark(); // safe to call Dog methods
}
```

#### in

- The in operator carries a safe check for the existence of a property on an object. You can also use it as a safe guard.
- Checks if an object has a specific property.
- Ensures existence of properties in union types or unknown objects.

#### User-defined Type Guards

- User-defined type guards allow you to define a type guard or help TS infer a type when you use a function.
- A user-defined type guard function is a function that simply returns arg is aType.

```
function isCustomer(partner: any): partner is Customer {
    return partner instanceof Customer;
}
```

> In this example, the isCustomer() is a user-defined type guard function.

### Type Casting

#### Type casting using the as keyword

#### Type casting using the <> operator

### Type Assertions
