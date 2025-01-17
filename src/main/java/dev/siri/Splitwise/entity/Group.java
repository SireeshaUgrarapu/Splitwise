package dev.siri.Splitwise.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name ="SPLITWISE_GROUP")
public class Group extends BaseModel {
    private String name;
    @ManyToOne
    private User createdBy;
    private LocalDateTime creationDate;
    private double totalAmountSpent;
    @ManyToMany
    private List<User> members;
    @OneToMany
    private List<Expense> expenses;
    @OneToMany
    private List<SettlementTransaction> settlementTransactions;
//    private String name;
//    private User createdBy;
//    private LocalDateTime creationDate;
//    private double totalAmountSpent;
//    private List<User> members;
//    private List<Expense> expenses;
//    private List<SettlementTransaction> settlementTransactions;
    /*
     group    user
     1         1
      m          1
     */

}
