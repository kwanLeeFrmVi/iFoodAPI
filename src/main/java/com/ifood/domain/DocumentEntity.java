package com.ifood.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Document", schema = "dbo", catalog = "I_Food")
public class DocumentEntity {
    private int id;
    private String objectId;
    private String source;
    private Boolean isDelete;

    @Id
    @Basic
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ObjectId")
    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    @Basic
    @Column(name = "Source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
        DocumentEntity that = (DocumentEntity) o;
        return id == that.id &&
                Objects.equals(objectId, that.objectId) &&
                Objects.equals(source, that.source) &&
                Objects.equals(isDelete, that.isDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, objectId, source, isDelete);
    }
}
