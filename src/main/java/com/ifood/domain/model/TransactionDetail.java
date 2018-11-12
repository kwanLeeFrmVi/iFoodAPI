package com.ifood.domain.model;

import java.sql.Timestamp;

public class TransactionDetail {
    private String dishName;
    private String ingredientName;
    private String userName;
    private String status;

    public TransactionDetail() {
    }

    public TransactionDetail(String dishName, String ingredientName, String userName, String status) {
        this.dishName = dishName;
        this.ingredientName = ingredientName;
        this.userName = userName;
        this.status = status;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
