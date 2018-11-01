package com.ifood.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "Dish", schema = "dbo", catalog = "I_Food")
public class DishEntity {
    private String id;
    private String authorId;
    private String name;
    private String description;
    private Timestamp createOn;
    private Double rate;
    private Boolean isActive;
    private Boolean isDelete;

    @Transient
    @Access(AccessType.PROPERTY)
    private List<CourseEntity> courses;
    @Transient
    private List<IngredientEntity> ingredients;
    @Transient
    private List<ReviewEntity> reviews;
    @Transient
    private List<DishEntity> relatedDishes;

    @Transient
    public List<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseEntity> courses) {
        this.courses = courses;
    }

    @Transient
    public List<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }

    @Transient
    public List<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviewes(List<ReviewEntity> reviews) {
        this.reviews = reviews;
    }

    @Transient
    public List<DishEntity> getRelatedDishes() {
        return relatedDishes;
    }

    public void setRelatedDishes(List<DishEntity> relatedDishes) {
        this.relatedDishes = relatedDishes;
    }

    @Id
    @GeneratedValue(generator = "dish-uuid")
    @GenericGenerator(name = "dish-uuid", strategy = "uuid2")
    @Column(name = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "AuthorId")
    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
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
    @Column(name = "Rate")
    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Basic
    @Column(name = "IsActive")
    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Basic
    @Column(name = "IsDelete")
    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishEntity that = (DishEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(authorId, that.authorId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(createOn, that.createOn) &&
                Objects.equals(rate, that.rate) &&
                Objects.equals(isActive, that.isActive) &&
                Objects.equals(isDelete, that.isDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorId, name, description, createOn, rate, isActive, isDelete);
    }
}
