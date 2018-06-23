import React from 'react';
import PropTypes from 'prop-types';

const Login = props => {
    return (
        <div className="container">
            <h1 className="title">Login</h1>
            <form onSubmit={props.authenticateUser}>
                <div className="field">
                    <label className="label">Username</label>
                    <div className="control">
                        <input className="input" type="text" name="username" />
                    </div>
                </div>

                {/* <div className="field">
                    <label className="label">Password</label>
                    <div className="control">
                        <input className="input" type="password" />
                    </div>
                </div> */}
                <div className="field is-grouped">
                    <div className="control">
                        <button className="button is-link" type="submit">Login</button>
                    </div>
                    <div className="control">
                        <button className="button is-text">Cancel</button>
                    </div>
                </div>
            </form>
        </div>
    );
};

Login.propTypes = {
    
};

export default Login;