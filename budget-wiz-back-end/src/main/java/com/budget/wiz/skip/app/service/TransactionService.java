package com.budget.wiz.skip.app.service;

import com.budget.wiz.skip.app.domain.object.Budget;
import com.budget.wiz.skip.app.domain.object.BudgetTransaction;

import java.util.Date;
import java.util.List;

public interface TransactionService {


    Long newTrasaction(Budget budgetID, BudgetTransaction bt);

    void deleteTrasaction(Long btID);

    List<BudgetTransaction> getListOfTranscationByPeriod(Date initialDate, Date endDate);

}
