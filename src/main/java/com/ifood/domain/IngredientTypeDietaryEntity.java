package com.ifood.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "IngredientType_Dietary", schema = "dbo", catalog = "I_Food")
public class IngredientTypeDietaryEntity {
    private int id;
    private int ingredientTypeId;
    private int dietaryId;
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
    @Column(name = "IngredientTypeId")
    public int getIngredientTypeId() {
        return ingredientTypeId;
    }

    public void setIngredientTypeId(int ingredientTypeId) {
        this.ingredientTypeId = ingredientTypeId;
    }

    @Basic
    @Column(name = "DietaryId")
    public int getDietaryId() {
        return dietaryId;
    }

    public void setDietaryId(int dietaryId) {
        this.dietaryId = dietaryId;
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
        IngredientTypeDietaryEntity that = (IngredientTypeDietaryEntity) o;
        return id == that.id &&
                ingredientTypeId == that.ingredientTypeId &&
                dietaryId == that.dietaryId &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ingredientTypeId, dietaryId, description);
    }
}
