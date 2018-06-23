import React, { Component } from 'react';
import {
  BrowserRouter as Router,
  Route,
  Redirect,
} from 'react-router-dom';
import Header from './components/Header';
import Home from './components/Home';
import Help from './components/Help';
import About from './components/About';
import Transactions from './components/Transactions';
import Budgets from './components/Budgets';
import Login from './components/Login';
import Profile from './components/Profile';

import 'bulma/css/bulma.css';

class App extends Component {

  componentWillMount() {
    if (window.sessionStorage.userData) {
      this.setState({
        authenticated: true,
        user: JSON.parse(window.sessionStorage.getItem('userData')),
      });
    }
  }

  constructor(props) {
    super(props);
    this.state = {
      authenticated: false,
      user: null,
      alert: {
        type: '',
        message: '',
      },
    };
    this.authenticateUser = this.authenticateUser.bind(this);
    this.renderLogin = this.renderLogin.bind(this);
    this.renderProfile = this.renderProfile.bind(this);
    this.logoutUser = this.logoutUser.bind(this);
    this.updateUser = this.updateUser.bind(this);
    this.renderBudgets = this.renderBudgets.bind(this);
    this.createBudget = this.createBudget.bind(this);
  }

  authenticateUser(event) {
    event.preventDefault();
    
    const username = event.target['username'].value;

    fetch(`http://172.16.12.61:8080/v1/user/byUserName/${username}`)
      .then((response) => {
        return response.json();
      }).then((data) => {
        this.setState({
          authenticated: true,
          user: data,
          alert: {
            type: 'success',
            message: 'User authenticated.', 
          },
        });
        window.sessionStorage.setItem('userData', JSON.stringify(this.state.user));
      }).catch((error) => {
        this.setState({
          authenticated: false,
          alert: {
            type: 'error',
            message: 'Authentication Error, please check your information.', 
          },
        });
        console.error(error);
      });
  }

  updateUser(event) {
    event.preventDefault();

    const username = event.target['username'].value;
    const email = event.target['email'].value;

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    fetch('http://172.16.12.61:8080/v1/user/update', { 
      method: 'PUT', 
      body: JSON.stringify({
        userName: username,
        userEmail: email,
        userID: this.state.user.userID,
      }),
      headers,
    }).then(
      response => response.json()
    ).then((data) => {
      this.setState({
        user: data,
        alert: {
          type: 'success',
          message: 'User information updated.', 
        },
      });
    }).catch((error) => {
      this.setState({
        alert: {
          type: 'error',
          message: 'Can\'t update user. Check console for more information.', 
        },
      });
      console.error(error);
    });
  }

  logoutUser(event) {
    event.preventDefault();
    this.setState({
      authenticated: false,
      user: null,
    });
    window.sessionStorage.removeItem('userData');
  }

  createBudget(event) {
    
    event.preventDefault();
    
    const name = event.target['name'].value;
    const description = event.target['description'].value;
    const value = event.target['value'].value;

    const user = this.state.user;

    user.budget.push({
      budgetDesc: description,
      budgetName: name,
      value,
    });

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    fetch('http://172.16.12.61:8080/v1/budget/save', { 
      method: 'POST', 
      body: JSON.stringify(user),
      headers,
    }).then(
      response => response.json()
    ).then((data) => {
      this.setState({
        user: data,
      });
      window.sessionStorage.setItem('userData', JSON.stringify(this.state.user));
    }).catch((error) => {
      console.error(error);
    });

  }

  renderLogin() {
    if (this.state.authenticated) {
      return (<Redirect to="/profile" />);
    } else {
      return (<Login authenticateUser={this.authenticateUser} />);
    }
  }

  renderProfile() {
    if (this.state.authenticated) {
      return (<Profile user={this.state.user} updateUser={this.updateUser} />);
    } else {
      return (<Redirect to="/login" />);
    }
  }

  renderBudgets() {
    if (this.state.authenticated) {
      return (<Budgets user={this.state.user} createBudget={this.createBudget} />);
    } else {
      return (<Redirect to="/login"/>);
    }
  }

  render() {
    return (
      <Router>
        <section className="section">
          <Header authenticated={this.state.authenticated} logoutUser={this.logoutUser} />
          <div>{this.state.alert.message}</div>
          <Route exact path="/" component={Home} />
          <Route path="/login" render={this.renderLogin} />
          <Route path="/about" component={About} />
          <Route path="/help" component={Help} />
          <Route path="/transactions" component={Transactions} />
          <Route path="/budgets" component={this.renderBudgets} />
          <Route path="/profile" component={this.renderProfile} />
        </section> 
      </Router>
    );
  }
}

export default App;
