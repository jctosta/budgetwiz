package com.budget.wiz.skip.app.service.impl;

import com.budget.wiz.skip.app.domain.object.Budget;
import com.budget.wiz.skip.app.domain.object.BudgetTransaction;
import com.budget.wiz.skip.app.repository.TransactionRepository;
import com.budget.wiz.skip.app.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Component
public class TransactionServiceImpl implements TransactionService {


    private static final Logger LOG = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BudgetServiceImpl budgetService;

    @Override
    public Long newTrasaction(Budget budget, BudgetTransaction bt) {
        try{

            bt.setCreateDate(new Timestamp(System.currentTimeMillis()));
            bt.setLastUpdate(new Timestamp(System.currentTimeMillis()));

            List<BudgetTransaction> list = budget.getBudgetTransaction();
            list.add(bt);

            budget.setBudgetTransaction(list);
            budgetService.updateBudgetValue(budget);

        } catch (Exception ex){
            LOG.error("Error to save a new Transaction : " + bt.getTranscationID());
        }
        return bt.getTranscationID();
    }

    @Override
    @Transactional
    public void deleteTrasaction(Long btID) {
        transactionRepository.deleteById(btID);
    }

    @Override
    public List<BudgetTransaction> getListOfTranscationByPeriod(Date initialDate, Date endDate) {
        List<BudgetTransaction> list = transactionRepository
               .findByCreateDateBetween(initialDate, endDate);

        list.stream().sorted();

        return list;

    }

}
