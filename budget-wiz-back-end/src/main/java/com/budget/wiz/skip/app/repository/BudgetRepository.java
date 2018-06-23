package com.budget.wiz.skip.app.repository;

import com.budget.wiz.skip.app.domain.object.Budget;
import org.springframework.data.repository.CrudRepository;

public interface BudgetRepository extends CrudRepository<Budget, Long> {


}
