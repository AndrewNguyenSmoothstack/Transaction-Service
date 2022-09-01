package com.example.TransactionService.service;

import com.example.TransactionService.model.Transactions;
import com.example.TransactionService.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {
    @Autowired
    TransactionsRepository transactionsRepository;


    @Transactional
    public Boolean addTransaction(int accountId, Transactions newTransaction){
        Transactions a = new Transactions();

        if(newTransaction!=null)
        {
            a.setTransactionId(0);
            a.setAmount(newTransaction.getAmount());
            a.setTransactionName(newTransaction.getTransactionName());
            a.setDate(newTransaction.getDate());
            a.setAccountId(accountId);
            a.setReversed(0);
            a.setType(newTransaction.getType());
            transactionsRepository.save(a);
            return true;
        }
        return false;
    }

}
