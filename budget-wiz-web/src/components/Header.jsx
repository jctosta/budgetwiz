import React from 'react';
import PropTypes from 'prop-types';
import { Navbar } from 'react-bulma-components';

import { Link } from 'react-router-dom';

const Header = props => {

    const normalMenu = (
        <Navbar.Menu>
            <Navbar.Container position="end">
                <Navbar.Item renderAs="span"><Link to="/about">About</Link></Navbar.Item>
                <Navbar.Item renderAs="span"><Link to="/help">Help</Link></Navbar.Item>
                <Navbar.Item renderAs="span"><Link to="/login">Login</Link></Navbar.Item>
            </Navbar.Container>
        </Navbar.Menu>
    );

    const loggedMenu = (
        <Navbar.Menu>
            <Navbar.Container position="end">
                {/* <Navbar.Item renderAs="span"><Link to="/transactions">Transactions</Link></Navbar.Item> */}
                <Navbar.Item renderAs="span"><Link to="/budgets">Budgets</Link></Navbar.Item>
                <Navbar.Item renderAs="span"><Link to="/profile">My Profile</Link></Navbar.Item>
                <Navbar.Item renderAs="a" onClick={props.logoutUser}>Logout</Navbar.Item>
            </Navbar.Container>
        </Navbar.Menu>
    );

    return (
        <Navbar fixed="top">
            <Navbar.Brand>
                <Navbar.Item renderAs="span"><Link to="/">BudgetWiz</Link></Navbar.Item>
                <Navbar.Burger/>
            </Navbar.Brand>
            { props.authenticated ? loggedMenu : normalMenu }
        </Navbar>
    );
};

Header.propTypes = {
    
};

export default Header;