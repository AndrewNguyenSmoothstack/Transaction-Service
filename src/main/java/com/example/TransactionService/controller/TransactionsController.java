package com.example.TransactionService.controller;


import com.example.TransactionService.model.Transactions;
import com.example.TransactionService.model.UserAccount;
import com.example.TransactionService.repository.TransactionsRepository;
import com.example.TransactionService.repository.UserAccountRepository;
import com.example.TransactionService.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000/",allowedHeaders ="*")
@RestController
public class TransactionsController {
    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    TransactionService transactionService;


    @GetMapping("/useraccount/userId")
    @ResponseBody
    public ResponseEntity<List<UserAccount>> getUserAccounts(@RequestParam int userId){
        return new ResponseEntity<List<UserAccount>>(userAccountRepository.findAllByUserId(userId),HttpStatus.OK);
    }

    @GetMapping("/usertransactions/accountId")
    @ResponseBody
    public ResponseEntity<List<Transactions>> getAccountTransactions(@RequestParam int accountId){

        return new ResponseEntity<List<Transactions>>( transactionsRepository.findAllByAccountId(accountId),HttpStatus.OK);
    }

    @GetMapping("/transaction/id")
    @ResponseBody
    public ResponseEntity<Optional<Transactions>> getTransaction(@RequestParam int id){
        return new ResponseEntity<Optional<Transactions>>(transactionsRepository.findById(id),HttpStatus.OK);
    }


    @PostMapping("/transaction/add/{accountId}")
    public ResponseEntity<Boolean> addNewTransaction(@PathVariable("accountId") int accountId, @RequestBody Transactions newtran){
        Boolean added = transactionService.addTransaction(accountId,newtran);
        return new ResponseEntity<>(added, HttpStatus.CREATED);
    }




}
