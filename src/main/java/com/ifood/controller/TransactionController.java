package com.ifood.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.ifood.domain.ShoppingListEntity;
import com.ifood.domain.TransactionEntity;
import com.ifood.domain.UserEntity;
import com.ifood.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired(required = true)
    TransactionService transactionService;

    @PutMapping("")
    public ResponseEntity<Object> createTransaction (@RequestBody Map<String, String> json){
        TransactionEntity transaction = new Gson().fromJson(json.get("transaction"), TransactionEntity.class);
        List<ShoppingListEntity> shoppingLists = new Gson().fromJson(json.get("shoppingLists"),  new TypeToken<List<ShoppingListEntity>>(){}.getType());
        return transactionService.createTransaction(json.get("userId"), transaction, Float.parseFloat(json.get("totalPrice")), shoppingLists);
    }

    @GetMapping("/getByUserId")
    public ResponseEntity<Object> getTransactionByUserId (@RequestParam String userId){
        return transactionService.getTransactionByUserId(userId);
    }
}
