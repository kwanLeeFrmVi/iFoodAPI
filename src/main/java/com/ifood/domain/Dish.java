package com.ifood.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Dish {
    private UUID id;
    private String name;
    private String description;
    private Boolean isActive;
    private Boolean isDelete;
    private UUID authorId;
    private Timestamp createOn;
    private Timestamp modifiedOn;
    private UUID modifiedBy;
    private Double rate;

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id", nullable = false, columnDefinition="uniqueidentifier")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    @Basic
    @Column(name = "AuthorId", nullable = false)
    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
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
    @Column(name = "ModifiedOn", nullable = true)
    public Timestamp getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Timestamp modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    @Basic
    @Column(name = "ModifiedBy", nullable = true)
    public UUID getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(UUID modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Basic
    @Column(name = "Rate", nullable = true, precision = 0)
    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Objects.equals(id, dish.id) &&
                Objects.equals(name, dish.name) &&
                Objects.equals(description, dish.description) &&
                Objects.equals(isActive, dish.isActive) &&
                Objects.equals(isDelete, dish.isDelete) &&
                Objects.equals(authorId, dish.authorId) &&
                Objects.equals(createOn, dish.createOn) &&
                Objects.equals(modifiedOn, dish.modifiedOn) &&
                Objects.equals(modifiedBy, dish.modifiedBy) &&
                Objects.equals(rate, dish.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, isActive, isDelete, authorId, createOn, modifiedOn, modifiedBy, rate);
    }
}
