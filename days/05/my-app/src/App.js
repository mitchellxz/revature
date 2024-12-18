import './App.css';
import AxiosGetDemo from './axiosdemos/AxiosGetDemo';
import EventDemoComponent from './EventsDemoComponent';
import Hello from './Hello';
import StateDemoComponent from './StateDemoComponent';
import {BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Navbar from './Navbar';
import ToDoList from './todolist/ToDoList';
import AxiosPostDemo from './axiosdemos/AxiosPostDemo';
import AxiosPutDemo from './axiosdemos/AxiosPutDemo';
import AxiosPatchDemo from './axiosdemos/AxiosPatchDemo';
import AxiosDeleteDemo from './axiosdemos/AxiosDeleteDemo';
import TextBoxComponent from './TextBoxComponent';
import ButtonComponent from './ButtonComponent';
import MyContext from './contextDemo/MyContext';


function App() {
  
  const comments = ["Comment one", "Comment two", "Comment three"];
  const sharedData = 'shared data';

  return (
    <MyContext.Provider value={sharedData}>
   <Router>
    <div className="app">
      <Navbar />
    </div>
    <Routes>
      <Route path='/hello' element={<Hello />} />
      <Route path='/sdc' element={<StateDemoComponent />} />
      <Route path='/edc' element={<EventDemoComponent />} />
      <Route path='/getposts' element={<AxiosGetDemo />} />
      <Route path='/createpost' element={<AxiosPostDemo />} />
      <Route path='/updatepost' element={<AxiosPutDemo />} />
      <Route path='/patchpost' element={<AxiosPatchDemo />} />
      <Route path='/deletepost' element={<AxiosDeleteDemo />} />
    </Routes>
    <ButtonComponent />
    <br/> <hr />
    <TextBoxComponent />
    <br />
   </Router>
   </MyContext.Provider>

  );
}

export default App;
