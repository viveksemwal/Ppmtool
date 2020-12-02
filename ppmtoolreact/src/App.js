import './App.css';
import Dashboard from './component/Dashboard';
import Navbar from './component/Header/Navbar';
import "bootstrap/dist/css/bootstrap.min.css"
import {BrowserRouter as Router, Route} from "react-router-dom"
import AddProjectForm from './component/Project/AddProjectForm';

function App() {
  return (
    <Router>
    <div className="App">
      <Navbar />
      
      <Route exact path="/dashboard" component={Dashboard} />
      <Route exact path="/addProjectForm" component={AddProjectForm} />
      
    </div>
    </Router>
  );
}

export default App;
