package com.budget.wiz.skip.app.service.impl;

import com.budget.wiz.skip.app.domain.object.Budget;
import com.budget.wiz.skip.app.domain.object.User;
import com.budget.wiz.skip.app.repository.BudgetRepository;
import com.budget.wiz.skip.app.service.BudgetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Component
public class BudgetServiceImpl  implements BudgetService {


    private static final Logger LOG = LoggerFactory.getLogger(BudgetServiceImpl.class);

    @Autowired
    private BudgetRepository budgetRepository;


    @Override
    public Budget createBudget(Budget budget) {
       try {
            budgetRepository.save(budget);
       } catch(Exception ex) {
           LOG.error("Error to save the new User");
       }
       return budget;
    }

    @Override
    @Transactional
    public void updateBudgetValue(Budget budget) {
        Budget b = checkCarById(budget.getBudgetID());
        b.setValue(budget.getValue());
        if(budget.getBudgetTransaction() != null)
           b.setBudgetTransaction(budget.getBudgetTransaction());

    }

    @Override
    public void deleteBudget(Long budgetID) {
        budgetRepository.deleteById(budgetID);
    }

    @Override
    public Budget getBudgetByID(Long budgetID) {
        return checkCarById(budgetID);
    }

        private Budget checkCarById(Long budgetID) throws EntityNotFoundException {
            return budgetRepository.findById(budgetID)
                    .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + budgetID));
        }
}
