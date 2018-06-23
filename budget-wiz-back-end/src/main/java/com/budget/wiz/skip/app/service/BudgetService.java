package com.budget.wiz.skip.app.service;

import com.budget.wiz.skip.app.domain.object.Budget;
import com.budget.wiz.skip.app.domain.object.User;
import org.springframework.stereotype.Component;

import java.util.List;

public interface BudgetService {


    Budget createBudget(Budget budget);

    void updateBudgetValue(Budget budget);

    void deleteBudget(Long budget);

    Budget getBudgetByID(Long budgetID);


}
