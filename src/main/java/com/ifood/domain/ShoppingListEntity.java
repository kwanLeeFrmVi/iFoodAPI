package com.ifood.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "ShoppingList", schema = "dbo", catalog = "I_Food")
public class ShoppingListEntity {
    private int id;
    private UUID userId;
    private int transactionId;
    private UUID dishId;
    private UUID ingredientId;
    private String description;
    private Integer status;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "UserId")
    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "TransactionId")
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    @Basic
    @Column(name = "DishId")
    public UUID getDishId() {
        return dishId;
    }

    public void setDishId(UUID dishId) {
        this.dishId = dishId;
    }

    @Basic
    @Column(name = "IngredientId")
    public UUID getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(UUID ingredientId) {
        this.ingredientId = ingredientId;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingListEntity that = (ShoppingListEntity) o;
        return id == that.id &&
                transactionId == that.transactionId &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(dishId, that.dishId) &&
                Objects.equals(ingredientId, that.ingredientId) &&
                Objects.equals(description, that.description) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, transactionId, dishId, ingredientId, description, status);
    }
}
