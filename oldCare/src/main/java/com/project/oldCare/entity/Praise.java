package com.project.oldCare.entity;

import java.sql.Timestamp;
import java.util.Objects;

public class Praise {
    private Integer praiseId;
    private Long userId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String sourceTable;
    private String sourceField;
    private Integer sourceId;

    private Integer status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Praise praise = (Praise) o;
        return Objects.equals(praiseId, praise.praiseId) && Objects.equals(userId, praise.userId) && Objects.equals(createTime, praise.createTime) && Objects.equals(updateTime, praise.updateTime) && Objects.equals(sourceTable, praise.sourceTable) && Objects.equals(sourceField, praise.sourceField) && Objects.equals(sourceId, praise.sourceId) && Objects.equals(status, praise.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(praiseId, userId, createTime, updateTime, sourceTable, sourceField, sourceId, status);
    }

    @Override
    public String toString() {
        return "Praise{" +
                "praiseId=" + praiseId +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", sourceTable='" + sourceTable + '\'' +
                ", sourceField='" + sourceField + '\'' +
                ", sourceId=" + sourceId +
                ", status=" + status +
                '}';
    }

    public Integer getPraiseId() {
        return praiseId;
    }

    public void setPraiseId(Integer praiseId) {
        this.praiseId = praiseId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getSourceTable() {
        return sourceTable;
    }

    public void setSourceTable(String sourceTable) {
        this.sourceTable = sourceTable;
    }

    public String getSourceField() {
        return sourceField;
    }

    public void setSourceField(String sourceField) {
        this.sourceField = sourceField;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
