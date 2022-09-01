package com.example.TransactionService.repository;

import com.example.TransactionService.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount,Integer> {
    List<UserAccount> findAllByUserId(int user);
}

