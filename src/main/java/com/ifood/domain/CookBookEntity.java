package com.ifood.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "CookBook", schema = "dbo", catalog = "I_Food")
public class CookBookEntity {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("description")
    private String description;
    @JsonProperty("createOn")
    private Timestamp createOn;
    @JsonProperty("isDelete")
    private Boolean isDelete;
    @JsonProperty("dishesInCookbook")
    @Transient
    private List<DishEntity> dishesInCookbook;
    private String imageLink;

    @Id
    @Column(name = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "UserId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
    @Column(name = "CreateOn")
    public Timestamp getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Timestamp createOn) {
        this.createOn = createOn;
    }

    @Basic
    @Column(name = "IsDelete")
    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    @Transient
    public List<DishEntity> getDishesInCookbook() {
        return dishesInCookbook;
    }

    public void setDishesInCookbook(List<DishEntity> dishesInCookbook) {
        for (DishEntity dish : dishesInCookbook){
            dish.setListDishInCookbook(null);
        }
        this.dishesInCookbook = dishesInCookbook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CookBookEntity that = (CookBookEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(description, that.description) &&
                Objects.equals(createOn, that.createOn) &&
                Objects.equals(isDelete, that.isDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userId, description, createOn, isDelete);
    }

    @Basic
    @Column(name = "ImageLink")
    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
