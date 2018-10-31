package com.ifood.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "User_Dietary", schema = "dbo", catalog = "I_Food")
public class UserDietaryEntity {
    private int id;
    private UUID userId;
    private int dietaryId;
    private String description;
    private Timestamp createOn;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "UserId")
    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
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

    @Basic
    @Column(name = "CreateOn")
    public Timestamp getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Timestamp createOn) {
        this.createOn = createOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDietaryEntity that = (UserDietaryEntity) o;
        return id == that.id &&
                dietaryId == that.dietaryId &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(description, that.description) &&
                Objects.equals(createOn, that.createOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, dietaryId, description, createOn);
    }
}
