# TypeScript

- TS offers all of JavaScript's features, and an additional layer on top of these: TypeScript's type system.

> For example, JS provides language primitives like `string` and `number`, but it doesn't check that you've consistently assigned these. _TypeScript does._

- Your existing JS code is also TS code.

- The main benefit of TS is that it can highlight unexpected behavior in your code, decreasing the chances of a bug.

## Types by Inference

- TS knows the JS language and will generate types for you in many cases.

  > For example, when creating a variable and assigning it to a particular value, TS will use the value as its type.
  > `let helloWorld = "Hello World";` would be understood as `let helloWorld: string`

- By understanding how JS works, TS can build a type-system that accepts JS code but has types. This offers a type-system without needing to add extra characters to make explicit types in your code.

## Defining Types

- You can define a wide variety of design patterns in JS. However, some design patterns make it difficult for types to be inferred _automatically_. TS supports an extension of the JS language, which offers places for you to tell TS what the types should be.
  > For example, to create an object with an inferred type which includes `name: string` and `id: number`, you can write the following:
  ```const user = {
      name: "Hayes",
      id: 0,
     };
  ```
  > You can explicitly describe this object's shape using interface declaration:
  ```
  interface User {
    name: string;
    id: number;
  }
  ```
  > You can then declare that a JS object conforms to the shape of your new interface by using syntax like `: TypeName` after a varaible declaration:
  ```
  const user: User = {
    name: "Hayes",
    id: 0,
  };
  ```
- If you provide an object that doesn't match the interface you have provided, TS will warn you.

- Along with the set of primitive types already available in JS, TS offers a few more: any, unknown, never, void.
  > `any`: allow anything.
  > `unknown`: ensure someone using this type declares what the type is.
  > `never`: it's not possible that this type could happen.
  > `void`: a function which returns `undefined` or has no return value.

## Composing Types

- With TS, you can create complex types by combining simple ones. The two popular ways are unions and generics.

#### Unions

- With a union, you can declare that a type could be one of many types.
  > `type MyBool = true | false;` > `type WindowStates = "open" | "closed" | "minimized";`

#### Generics

- Generics provide variables to types. A common example is an array. An array without generics could contain anything. An array with generics can describe the values that the array contains.
  > `type StringArray = Array<string>;`

## Structural Type System

- One of TypeScript's core principles is that type checking focuses on the shape that values have.
- In a structural type system, if two objects have the same shape, they are considered to be of the same type.

## Everyday Types

### any

- TS has a special type, `any`, that you can use whenever you don't want a particular value to cause typechecking errors.
- when a value is of type `any`, you can access any properties of it, call it like a function, assign it to a value of any type, etc.

```
let obj: any = {x: 0};
obj.foo();
obj();
obj = "hello"
```

- The `any` type is useful when you don't want to write out a long type just to convince TS that a particular line of code is okay.

#### noimplicitAny

- When you don't specify a type, and TS can't infer it from context, the compiler will typically default to `any`.
- You usually want to avoid this because `any` isn't type-checked.

### Type Annotations on variables

- When you declare a variable using `const`, `var`, or `let`, you can optionally add a type annotation to explicitly specify the type of the variable:
  > `let myName: string = "Alice";

### Functions

- Functions are the primary means of passing data around in JS. TS allows you to specify the types of booth the input and output values of functions.

#### Parameter Type Annotations

```
function greet(name: string) {
    console.log("hello, " + name.toUpperCase() + "!!");
}
```

#### Return Type Annotations

```
function getFavoriteNumber(): number {
    return 26;
}
```

#### Functions which return promises

```
async function getFavoriteNumber(): Promise<number> {
    return 26;
}
```

### Working with Union Types

- TS will only allow an operation if it is valid for every member of the union.

### Type Aliases

- It's common to want to use the same type more than once and refer to it by a single name. a `type alias` is exactly that - a name for any type.

```
type Point = {
    x: number;
    y: number;
};

function printCoord(pt: Point) {
    console.log(pt.x);
    console.log(pt.y);
}

printCoord({x:100, y:100});
```

### Interfaces

- An interface declaration is another way to name an object type.

#### Differences between Type Aliases and Interfaces

- Almost all features of an `interface` are available in `type`.
- The key distinction is that a type cannot be re-opened to add new properties vs an interface which is always extendable.

### Type Assertions

- Sometimes you will have information about the type of a value that TS can't know about.
- For example, if you are using `document.getElementById`, TS only knows that this will return some kind of `HTMLElement`, but you might know that your page will always have an `HTMLCanvasElement` with a given ID.

  > You can use a type assertion to specify a more specific type: `const myCanvas = document.getElementById("main_canvas) as HTMLCanvasElement;`

- Because type assertions are removed at compile-time, there is no runtime checking associated with a type assertion. There won't be an exception or null generated if the type assertion is wrong.

## Object Types

### Intersection Types

- interfaces allowed us to build up new types from other types by extending them. TS provides another construct called `intersection types` that is mainly used to combine existing object types.
- An intersection type is defined using the & operator.

```
interface Colorful {
    color: string;
}
interface Circle {
    radius: number;
}

type ColorfulCircle = Colorful & Circle;
```

> Here, we've intersected Colorful and Circle to produce a new type that has ALL the members of Colorful and Circle.

### Interface Extension vs Intersection

- If interfaces are defined with the same name, TS will attempt to merge them if the properties are compatible. If they are not compatible, TS will raise an error.
- In the case of intersection types, properties with different types will be merged automatically. This may produce unexpected results.

## Type Manipulation

### Keyof Type Operator

- The `keyof` operator takes an object type and produces a string or numerical literal union of its keys. The following type `P` is the same as type `P = "x" | "y"`:

```
type Point = {x: number; y: number};
type P = keyof Point;
```

### Typeof Type Operator

- JS already has a `typeof` operator you can use in an expression context:
  > `console.log(typeof "hello world");`
- TS adds a `typeof` operator you can use in a type context to refer to the type of a variable or property:
  > ```
  > let s = "hello";
  > let n: typeof s;
  > ```
