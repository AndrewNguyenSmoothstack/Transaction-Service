package com.example.TransactionService.repository;

import com.example.TransactionService.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions,Integer> {
    List<Transactions> findAllByAccountId(int a);

    @Override
    Optional<Transactions> findById(Integer integer);
}
