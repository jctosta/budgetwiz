import React from 'react';
import PropTypes from 'prop-types';

const Profile = props => {
    return (
        <div className="container">
            <h1 className="title">@{props.user.userName} - Profile</h1>

            <form onSubmit={props.updateUser}>
                <div className="field">
                    <label className="label">Username</label>
                    <div className="control">
                        <input className="input" type="text" name="username" defaultValue={props.user.userName} />
                    </div>
                </div>
                <div className="field">
                    <label className="label">Email</label>
                    <div className="control">
                        <input className="input" type="mail" name="email" defaultValue={props.user.userEmail} />
                    </div>
                </div>

                
                <div className="field is-grouped">
                    <div className="control">
                        <button className="button is-link" type="submit">Update</button>
                    </div>
                    <div className="control">
                        <button className="button is-text">Cancel</button>
                    </div>
                </div>
            </form>
        </div>
    );
};

Profile.propTypes = {
    
};

export default Profile;