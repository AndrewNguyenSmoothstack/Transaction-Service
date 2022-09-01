package com.example.TransactionService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "tbl_user_account")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserAccount {

    @Column(name="userId")
    private int userId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="accountId")
    private int accountId;
}
