import React from 'react';
import PropTypes from 'prop-types';

// import Control from 'react-bulma-components/lib/components/form/components/control';
// import Input from 'react-bulma-components/lib/components/form/components/input';
import Card from 'react-bulma-components/lib/components/card/card';
import Columns from 'react-bulma-components/lib/components/columns/columns';

const Budgets = props => {
    const displayBudget = (b) => {
        return (
            <Columns.Column desktop={{ size: 4 }} mobile={{ size: 12 }} tablet={{ size: 6 }} >
                <Card>
                    <Card.Header>
                        <Card.Header.Title>
                            {b.budgetName}
                        </Card.Header.Title>
                    </Card.Header>
                    <Card.Content>
                        <p>Valor Disponível: R$ {b.value}</p>
                    </Card.Content>
                </Card>
            </Columns.Column>
        )
    };
    const budgetList = props.user.budget.map(displayBudget)
    return (
        <div className="container">
            <h2 className="subtitle">My Budgets</h2>
            <Columns breakpoint="mobile">
                {props.user.budget > 0 ? budgetList : <p>No budgets available.</p>}    
            </Columns>
            <h2 className="subtitle">Create Budget</h2>
            <form onSubmit={props.createBudget}>
                <div className="field">
                    <label className="label">Name</label>
                    <div className="control">
                        <input className="input" type="text" name="name" />
                    </div>
                </div>
                <div className="field">
                    <label className="label">Description</label>
                    <div className="control">
                        <textarea className="textarea" name="description"></textarea>
                    </div>
                </div>
                <div className="field">
                    <label className="label">Value</label>
                    <div className="control">
                        <input className="input" type="number" name="value" />
                    </div>
                </div>
                <div className="field is-grouped">
                    <div className="control">
                        <button className="button is-link" type="submit">Create</button>
                    </div>
                    <div className="control">
                        <button className="button is-text">Cancel</button>
                    </div>
                </div>
            </form>
        </div>
    );
};

Budgets.propTypes = {
    
};

export default Budgets;