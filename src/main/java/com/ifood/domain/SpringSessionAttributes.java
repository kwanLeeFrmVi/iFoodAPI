package com.ifood.domain;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "SPRING_SESSION_ATTRIBUTES", schema = "dbo", catalog = "I_Food")
@IdClass(SpringSessionAttributesPK.class)
public class SpringSessionAttributes {
    private String sessionPrimaryId;
    private String attributeName;
    private byte[] attributeBytes;

    @Id
    @Column(name = "SESSION_PRIMARY_ID", nullable = false, length = 36)
    public String getSessionPrimaryId() {
        return sessionPrimaryId;
    }

    public void setSessionPrimaryId(String sessionPrimaryId) {
        this.sessionPrimaryId = sessionPrimaryId;
    }

    @Id
    @Column(name = "ATTRIBUTE_NAME", nullable = false, length = 200)
    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    @Basic
    @Column(name = "ATTRIBUTE_BYTES", nullable = false)
    public byte[] getAttributeBytes() {
        return attributeBytes;
    }

    public void setAttributeBytes(byte[] attributeBytes) {
        this.attributeBytes = attributeBytes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpringSessionAttributes that = (SpringSessionAttributes) o;
        return Objects.equals(sessionPrimaryId, that.sessionPrimaryId) &&
                Objects.equals(attributeName, that.attributeName) &&
                Arrays.equals(attributeBytes, that.attributeBytes);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(sessionPrimaryId, attributeName);
        result = 31 * result + Arrays.hashCode(attributeBytes);
        return result;
    }
}
