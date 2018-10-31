package com.ifood.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "Category_Dish", schema = "dbo", catalog = "I_Food")
public class CategoryDishEntity {
    private int id;
    private UUID categoryId;
    private UUID dishId;
    private String description;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CategoryId")
    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
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
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDishEntity that = (CategoryDishEntity) o;
        return id == that.id &&
                Objects.equals(categoryId, that.categoryId) &&
                Objects.equals(dishId, that.dishId) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryId, dishId, description);
    }
}
