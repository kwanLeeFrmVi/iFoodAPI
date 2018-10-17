package com.ifood.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "IngredientType_Dietary", schema = "dbo", catalog = "I_Food")
public class IngredientTypeDietary {
    private int id;
    private int ingredientTypeId;
    private int dietaryId;
    private Boolean isActive;
    private Boolean isDelete;
    private Timestamp createOn;
    private Timestamp modifiedOn;
    private String description;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "IngredientTypeId", nullable = false)
    public int getIngredientTypeId() {
        return ingredientTypeId;
    }

    public void setIngredientTypeId(int ingredientTypeId) {
        this.ingredientTypeId = ingredientTypeId;
    }

    @Basic
    @Column(name = "DietaryId", nullable = false)
    public int getDietaryId() {
        return dietaryId;
    }

    public void setDietaryId(int dietaryId) {
        this.dietaryId = dietaryId;
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
    @Column(name = "Description", nullable = true, length = 2147483647)
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
        IngredientTypeDietary that = (IngredientTypeDietary) o;
        return id == that.id &&
                ingredientTypeId == that.ingredientTypeId &&
                dietaryId == that.dietaryId &&
                Objects.equals(isActive, that.isActive) &&
                Objects.equals(isDelete, that.isDelete) &&
                Objects.equals(createOn, that.createOn) &&
                Objects.equals(modifiedOn, that.modifiedOn) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ingredientTypeId, dietaryId, isActive, isDelete, createOn, modifiedOn, description);
    }
}
