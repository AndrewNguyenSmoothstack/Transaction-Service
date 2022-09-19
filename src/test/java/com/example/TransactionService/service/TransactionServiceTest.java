package com.example.TransactionService.service;



import com.example.TransactionService.model.Transactions;
import com.example.TransactionService.repository.TransactionsRepository;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TransactionServiceTest {

    @Autowired
    TransactionService transactionService;

    @Autowired
    TransactionsRepository transactionsRepository;

    @Test
    public void testAddTransaction() {

        Transactions test = new Transactions(0,10,4,"test",0,"1997-05-13",0);
        Transactions a = transactionService.addTransaction(0,test);
        Optional<Transactions> actual = transactionsRepository.findById(Integer.valueOf(a.getTransactionId()));

        assertEquals(a.getDate(),actual.get().getDate());
        assertEquals("test",actual.get().getTransactionName());

    }
}