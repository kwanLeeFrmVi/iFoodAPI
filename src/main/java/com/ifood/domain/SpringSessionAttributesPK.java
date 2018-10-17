package com.ifood.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SpringSessionAttributesPK implements Serializable {
    private String sessionPrimaryId;
    private String attributeName;

    @Column(name = "SESSION_PRIMARY_ID", nullable = false, length = 36)
    @Id
    public String getSessionPrimaryId() {
        return sessionPrimaryId;
    }

    public void setSessionPrimaryId(String sessionPrimaryId) {
        this.sessionPrimaryId = sessionPrimaryId;
    }

    @Column(name = "ATTRIBUTE_NAME", nullable = false, length = 200)
    @Id
    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpringSessionAttributesPK that = (SpringSessionAttributesPK) o;
        return Objects.equals(sessionPrimaryId, that.sessionPrimaryId) &&
                Objects.equals(attributeName, that.attributeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionPrimaryId, attributeName);
    }
}
