import React from 'react';
import PropTypes from 'prop-types';
import logo from '../logo.svg';

const Home = props => {
    return (
        <section className="hero">
            <div className="hero-body">
                <div className="container">
                <h1 className="title">
                    <img src={logo} alt="Logo"/>
                </h1>
                <h2 className="subtitle">
                    Your money best friend
                </h2>
                </div>
            </div>
        </section>
        // <div className="container">
        //     <img src={logo} alt="Logo"/>
        //     <p>Welcome to Budget Wiz, your money best friend!</p>
        // </div>
    );
};

Home.propTypes = {
    
};

export default Home;