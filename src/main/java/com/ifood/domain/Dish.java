package com.ifood.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Dish {
    private UUID id;
    private UUID authorId;
    private String name;
    private String description;
    private Timestamp createOn;
    private Double rate;
    private Boolean isActive;
    private Boolean isDelete;

    @Id
    @Column(name = "Id", nullable = false)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Basic
    @Column(name = "AuthorId", nullable = false)
    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = 2147483647)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "CreateOn", nullable = true)
    public Timestamp getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Timestamp createOn) {
        this.createOn = createOn;
    }

    @Basic
    @Column(name = "Rate", nullable = true, precision = 0)
    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Basic
    @Column(name = "IsActive", nullable = true)
    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Basic
    @Column(name = "IsDelete", nullable = true)
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
        Dish dish = (Dish) o;
        return Objects.equals(id, dish.id) &&
                Objects.equals(authorId, dish.authorId) &&
                Objects.equals(name, dish.name) &&
                Objects.equals(description, dish.description) &&
                Objects.equals(createOn, dish.createOn) &&
                Objects.equals(rate, dish.rate) &&
                Objects.equals(isActive, dish.isActive) &&
                Objects.equals(isDelete, dish.isDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorId, name, description, createOn, rate, isActive, isDelete);
    }
}
