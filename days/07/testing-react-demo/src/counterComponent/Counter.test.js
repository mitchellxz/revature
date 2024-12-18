import { fireEvent } from "@testing-library/react";
import Counter from "./Counter";
import { render } from "@testing-library/react";
import { screen } from "@testing-library/react";


describe('Testing the Counter Component', () => {

test('Testing the Increment Counter', () => {
    // render the component to test
    render(<Counter />)

    // select the elements you want to interact with
    const counter = screen.getByTestId("counter");
    const incrementBtn = screen.getByTestId("increment");

    // interact with the elements
    fireEvent.click(incrementBtn);

    // assert the expected result
    expect(counter).toHaveTextContent("1");
})

test('Testing the decrement Counter', () => {
    // render the component to test
    render(<Counter />)

    // select the elements you want to interact with
    const counter = screen.getByTestId("counter");
    const decrementBtn = screen.getByTestId("decrement");

    // interact with the elements
    fireEvent.click(decrementBtn);

    // assert the expected result
    expect(counter).toHaveTextContent("-1");
})
});