import './App.css';
import EventDemoComponent from './EventsDemoComponent';
import Hello from './Hello';
import PostComponent from './PostComponent';
import StateDemoComponent from './StateDemoComponent';

function App() {
  
  const comments = ["Comment one", "Comment two", "Comment three"];

  return (
    <div class="App">
      <h2>Hello React</h2>
      <Hello name="test" />
      <EventDemoComponent />
      <hr />
      <StateDemoComponent />
      <PostComponent comments={comments}/>
    </div>
  );
}

export default App;
