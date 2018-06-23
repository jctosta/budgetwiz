package com.budget.wiz.skip.app.domain.object;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(
        name = "budget",
        uniqueConstraints = @UniqueConstraint(name = "uc_budget_id", columnNames = {"budgetID"})
)
public class Budget {


    @Id
    @GeneratedValue
    private Long budgetID;

    @Column(nullable = false)
    @NotNull(message =  "Bugdet name can not be null!!")
    private String budgetName;

    private String budgetDesc;

    @Column
    @NotNull(message =  "Budget Value can not be null")
    private Double value;

    @OneToMany
    @Embedded
    private List<BudgetTransaction> budgetTransaction;

    public Long getBudgetID() {
        return budgetID;
    }

    public void setBudgetID(Long budgetID) {
        this.budgetID = budgetID;
    }

    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    public String getBudgetDesc() {
        return budgetDesc;
    }

    public void setBudgetDesc(String budgetDesc) {
        this.budgetDesc = budgetDesc;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public List<BudgetTransaction> getBudgetTransaction() {
        return budgetTransaction;
    }

    public void setBudgetTransaction(List<BudgetTransaction> budgetTransaction) {
        this.budgetTransaction = budgetTransaction;
    }
}
