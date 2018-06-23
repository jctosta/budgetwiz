package com.budget.wiz.skip.app.repository;

import com.budget.wiz.skip.app.domain.object.BudgetTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends CrudRepository<BudgetTransaction, Long> {

    List<BudgetTransaction> findByCreateDateBetween(Date initial, Date endDate);

}
