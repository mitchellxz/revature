#### Why Study JavaScript?

- JavaScript is used to program the behavior of web pages.

#### <script> Tag

- In HTML, JS code is inserted inside the <script> tag.
- Scripts can be placed in the <body> or <head> section of an HTML page.
- Scripts can also be placed in external files.
  > External scripts are practical when the same code is used in many _different_ web pages
  > To use an external script, put the name of the script file in the `src` attribute of a <script> tag.
  > External scripts _CANNOT_ contain <script> tags.

#### JS Functions and Events

- A JS function is a block of JS code.
  > for example, a function can be called when an event occurs (like when a user clicks a buttton)

#### External JS Advantages

- placing scripts in external files has some advantages:
  1. It separates HTML and code
  2. It makes HTML and JS easier to read and maintain
  3. Cached JS files can speed up page loads

#### JS Display Possibilities

- JS can display data in different ways:

1. Writing into an HTML element, using `innerHTML`
2. Writing into the HTML output, using `docment.write()`
3. Writing into an alert box, using `window.alert()`
4. Writing into the browser console, using `console.log()`
