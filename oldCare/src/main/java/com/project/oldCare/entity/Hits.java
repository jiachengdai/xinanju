package com.project.oldCare.entity;

import java.sql.Timestamp;
import java.util.Objects;

public class Hits {

    private Integer praiseId;
    private Long userId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String sourceTable;
    private String sourceField;
    private Integer sourceId;

    @Override
    public String toString() {
        return "Hits{" +
                "praiseId=" + praiseId +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", sourceTable='" + sourceTable + '\'' +
                ", sourceField='" + sourceField + '\'' +
                ", sourceId=" + sourceId +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hits hits = (Hits) o;
        return Objects.equals(praiseId, hits.praiseId) && Objects.equals(userId, hits.userId) && Objects.equals(createTime, hits.createTime) && Objects.equals(updateTime, hits.updateTime) && Objects.equals(sourceTable, hits.sourceTable) && Objects.equals(sourceField, hits.sourceField) && Objects.equals(sourceId, hits.sourceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(praiseId, userId, createTime, updateTime, sourceTable, sourceField, sourceId);
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
}
