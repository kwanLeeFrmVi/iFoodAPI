package com.ifood.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SPRING_SESSION", schema = "dbo", catalog = "I_Food")
public class SpringSession {
    private String primaryId;
    private String sessionId;
    private long creationTime;
    private long lastAccessTime;
    private int maxInactiveInterval;
    private long expiryTime;
    private String principalName;

    @Id
    @Column(name = "PRIMARY_ID", nullable = false, length = 36)
    public String getPrimaryId() {
        return primaryId;
    }

    public void setPrimaryId(String primaryId) {
        this.primaryId = primaryId;
    }

    @Basic
    @Column(name = "SESSION_ID", nullable = false, length = 36)
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Basic
    @Column(name = "CREATION_TIME", nullable = false)
    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    @Basic
    @Column(name = "LAST_ACCESS_TIME", nullable = false)
    public long getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(long lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    @Basic
    @Column(name = "MAX_INACTIVE_INTERVAL", nullable = false)
    public int getMaxInactiveInterval() {
        return maxInactiveInterval;
    }

    public void setMaxInactiveInterval(int maxInactiveInterval) {
        this.maxInactiveInterval = maxInactiveInterval;
    }

    @Basic
    @Column(name = "EXPIRY_TIME", nullable = false)
    public long getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(long expiryTime) {
        this.expiryTime = expiryTime;
    }

    @Basic
    @Column(name = "PRINCIPAL_NAME", nullable = true, length = 100)
    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpringSession that = (SpringSession) o;
        return creationTime == that.creationTime &&
                lastAccessTime == that.lastAccessTime &&
                maxInactiveInterval == that.maxInactiveInterval &&
                expiryTime == that.expiryTime &&
                Objects.equals(primaryId, that.primaryId) &&
                Objects.equals(sessionId, that.sessionId) &&
                Objects.equals(principalName, that.principalName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primaryId, sessionId, creationTime, lastAccessTime, maxInactiveInterval, expiryTime, principalName);
    }
}
