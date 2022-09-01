package com.example.TransactionService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_transaction")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="transactionId")
    private int transactionId;

    @Column(name="amount")
    private int amount;

    @Column(name="accountId")
    private int accountId;

    @Column(name="transactionName")
    private String transactionName;

    @Column(name="reversed")
    private int reversed;

    @Column(name="date")
    private String date;

    @Column(name="type")
    private int type;
}
