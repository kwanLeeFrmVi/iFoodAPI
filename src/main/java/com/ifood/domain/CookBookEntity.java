package com.ifood.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "CookBook", schema = "dbo", catalog = "I_Food")
public class CookBookEntity {
    private int id;
    private UUID userId;
    private String description;
    private Timestamp createOn;
    private Boolean isDelete;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CookBookEntity that = (CookBookEntity) o;
        return id == that.id &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(description, that.description) &&
                Objects.equals(createOn, that.createOn) &&
                Objects.equals(isDelete, that.isDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, description, createOn, isDelete);
    }
}
