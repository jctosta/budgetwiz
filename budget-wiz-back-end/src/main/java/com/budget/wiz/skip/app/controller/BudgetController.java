package com.budget.wiz.skip.app.controller;

import com.budget.wiz.skip.app.domain.object.Budget;
import com.budget.wiz.skip.app.domain.object.User;
import com.budget.wiz.skip.app.service.impl.BudgetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin //I KNOW IS NOT A GOOD A IDEIA =)/ BUT is a good purpose !
@RestController
@RequestMapping("v1/budget")
public class BudgetController {

    @Autowired
    private BudgetServiceImpl budgetService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Budget createBudget(@Valid @RequestBody Budget Budget) {
        return budgetService.createBudget(Budget);
    }

    @PutMapping("/update")
    public void updateBudgetValue(@Valid @RequestBody Budget budget){
        budgetService.updateBudgetValue(budget);
    }

    @DeleteMapping("/delete")
    public void deleteBudget(Long budgetID) {
        budgetService.deleteBudget(budgetID);
    }


    @GetMapping("/byID")
    public Budget getBudgetByID(Long budgetID){
       return budgetService.getBudgetByID(budgetID);
    }


}


