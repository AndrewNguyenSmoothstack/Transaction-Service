package com.example.TransactionService.service;

import com.example.TransactionService.model.Transactions;
import com.example.TransactionService.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
public class TransactionService {
    @Autowired
    TransactionsRepository transactionsRepository;


    @Transactional
    public Transactions addTransaction(int accountId, Transactions newTransaction){

        //check if loyalty points need to be added
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = "http://localhost:8086/service/checkServices?accountId=" + String.valueOf(newTransaction.getAccountId());
        ResponseEntity<Boolean> x = restTemplate.getForEntity(endpoint, Boolean.class);

        //add loyalty points
        if(Boolean.parseBoolean(x.toString())){
            endpoint = "http://localhost:8086/service/addPoints";
            HttpEntity<Transactions> httpEntity = new HttpEntity<>(newTransaction, headers);
            restTemplate.put(endpoint,httpEntity,Boolean.class);
        }


        transactionsRepository.save(newTransaction);
        return newTransaction;
    }

}
