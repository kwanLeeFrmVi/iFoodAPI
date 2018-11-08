package com.ifood.domain;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "\"CookBook_Dish\"", schema = "dbo", catalog = "I_Food")
public class CookBookDishEntity {
    private int id;
    private String dishId;
    private int cookbookId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DishId")
    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    @Basic
    @Column(name = "CookbookId")
    public int getCookbookId() {
        return cookbookId;
    }

    public void setCookbookId(int cookbookId) {
        this.cookbookId = cookbookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CookBookDishEntity that = (CookBookDishEntity) o;
        return id == that.id &&
                cookbookId == that.cookbookId &&
                Objects.equals(dishId, that.dishId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dishId, cookbookId);
    }
}
