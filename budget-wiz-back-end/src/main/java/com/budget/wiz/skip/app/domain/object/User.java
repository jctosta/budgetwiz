package com.budget.wiz.skip.app.domain.object;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(
        name = "user",
        uniqueConstraints = @UniqueConstraint(name = "uc_user_id", columnNames = {"userID"})
)
public class User {

    @Id
    @GeneratedValue
    private Long userID;

    @Column
    @NotNull(message =  "User Name can not be null!")
    private String userName;

    @Column
    @NotNull(message =  "User Email can not be null!")
    private String userEmail;

    @OneToMany
    @Embedded
    private List<Budget> budget;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<Budget> getBudget() {
        return budget;
    }

    public void setBudget(List<Budget> budget) {
        this.budget = budget;
    }

}