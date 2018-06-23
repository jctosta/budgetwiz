package com.budget.wiz.skip.app.domain.object;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * This class is responsible to all the transcations information
 */
@Entity
@Table(
        name = "transaction",
        uniqueConstraints = @UniqueConstraint(name = "uc_transcation_id", columnNames = {"transcationID"})
)
public class BudgetTransaction {

    @Id
    @GeneratedValue
    private Long transcationID;

    @Column
    @NotNull(message =  "Transcation name can not be null")
    private String transactionName;

    private String desc;

    @Column
    @NotNull(message =  "Transcation Value can not be null")
    private Double value;

    @JsonIgnore
    private Timestamp createDate;

    @JsonIgnore
    private Timestamp lastUpdate;

    public Long getTranscationID() {
        return transcationID;
    }

    public void setTranscationID(Long transcationID) {
        this.transcationID = transcationID;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
