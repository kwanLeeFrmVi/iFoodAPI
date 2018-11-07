package com.ifood.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "Ingredient", schema = "dbo", catalog = "I_Food")
public class IngredientEntity {
    private String id;
    private Integer typeId;
    private String name;
    private String description;
    private String unitId;
    private Double pricePerUnit;
    private Boolean isDelete;

    @OneToMany(mappedBy = "dishIngredient")
    private List<DishIngredientEntity> dishIngredients;

    @OneToMany(mappedBy = "dishIngredient")
    public List<DishIngredientEntity> getDishIngredients() {
        return dishIngredients;
    }

    public void setDishIngredients(List<DishIngredientEntity> dishIngredients) {
        this.dishIngredients = dishIngredients;
    }

    @Transient
    private Double amount;

    @Transient
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setAmount(DishIngredientEntity dishIngredientEntity){
        this.amount = dishIngredientEntity.getAmount();
    }

    @Id
    @Column(name = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TypeId")
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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
    @Column(name = "UnitId")
    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "PricePerUnit")
    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
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
        IngredientEntity that = (IngredientEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(typeId, that.typeId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(unitId, that.unitId) &&
                Objects.equals(pricePerUnit, that.pricePerUnit) &&
                Objects.equals(isDelete, that.isDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeId, name, description, unitId, pricePerUnit, isDelete);
    }
}
