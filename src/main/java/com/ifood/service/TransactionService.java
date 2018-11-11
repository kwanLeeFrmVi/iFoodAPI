package com.ifood.service;

import com.ifood.domain.*;
import com.ifood.repository.ShoppingListRepository;
import com.ifood.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.ifood.config.Constants.ERROR;

@Service
@Slf4j
public class TransactionService {
    @Autowired(required = true)
    private TransactionRepository transactionRepository;
    @Autowired(required = true)
    private ShoppingListRepository shoppingListRepository;

    public ResponseEntity<Object> createTransaction(String userId, TransactionEntity transaction, float totalPrice, List<ShoppingListEntity> shoppingLists) {
        ResponseEntity<Object> result = new ResponseEntity<>(ERROR, HttpStatus.BAD_REQUEST);
        try {
            transaction.setId(UUID.randomUUID().toString());
            transaction.setUserId(userId);
            transaction.setStatus(1);
            transaction.setTotalPrice((double) totalPrice);
            transaction.setCreatedOn(new Timestamp(System.currentTimeMillis()));

            transactionRepository.save(transaction);

            for (ShoppingListEntity shoppingList : shoppingLists){
                shoppingList.setTransactionId(transaction.getId());
                shoppingList.setStatus(1);
                shoppingListRepository.save(shoppingList);
            }

            result = new ResponseEntity<>(transaction, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        } finally {
            return result;
        }
    }
}
