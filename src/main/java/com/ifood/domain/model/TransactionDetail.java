package com.ifood.domain.model;

import java.sql.Timestamp;

public class TransactionDetail {
    private String dishName;
    private String ingredientName;
    private String userName;
    private String amount;
    private String unit;
    private String pricePerUnit;
    private String dishImage;

    public TransactionDetail() {
    }

    public TransactionDetail(String dishName, String ingredientName, String userName, String amount, String unit, String pricePerUnit, String dishImage) {
        this.dishName = dishName;
        this.ingredientName = ingredientName;
        this.userName = userName;
        this.amount = amount;
        this.unit = unit;
        this.pricePerUnit = pricePerUnit;
        this.dishImage = dishImage;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDishImage() {
        return dishImage;
    }

    public void setDishImage(String dishImage) {
        this.dishImage = dishImage;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(String pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}
