package com.ifood.domain;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "CookBook_Dish", schema = "dbo", catalog = "I_Food")
public class CookBookDishEntity {
    private int id;
    private String  cookbookId;
    private DishEntity dishInCookbook;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="DishId")
    public DishEntity getDishInCookbook() {
        return dishInCookbook;
    }

    public void setDishInCookbook(DishEntity dishInCookbook) {
        this.dishInCookbook = dishInCookbook;
    }

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
    @Column(name = "CookbookId")
    public String getCookbookId() {
        return cookbookId;
    }

    public void setCookbookId(String cookbookId) {
        this.cookbookId = cookbookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CookBookDishEntity that = (CookBookDishEntity) o;
        return id == that.id &&
                cookbookId == that.cookbookId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cookbookId);
    }
}
