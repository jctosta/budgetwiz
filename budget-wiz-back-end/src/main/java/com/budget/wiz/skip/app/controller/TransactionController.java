package com.budget.wiz.skip.app.controller;


import com.budget.wiz.skip.app.domain.object.Budget;
import com.budget.wiz.skip.app.domain.object.BudgetTransaction;
import com.budget.wiz.skip.app.service.impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@CrossOrigin //I KNOW IS NOT A GOOD A IDEIA =)/ BUT is a good purpose !
@RestController
@RequestMapping("v1/transaction")
public class TransactionController {


    @Autowired
    private TransactionServiceImpl transactionService;


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Long  createNewTransaction(@Valid @RequestBody Budget budget, BudgetTransaction budgetTransaction) {
        return transactionService.newTrasaction(budget,budgetTransaction);
    }

    @DeleteMapping("/delete")
    public void deleteTransactino(Long transactionID) {
        transactionService.deleteTrasaction(transactionID);
    }

    @GetMapping("/findByDates")
    public List<BudgetTransaction> getListOfTransctionByDate(@Valid @RequestBody Date initDate, Date endDate){
        return transactionService.getListOfTranscationByPeriod(initDate, endDate);
    }

}
