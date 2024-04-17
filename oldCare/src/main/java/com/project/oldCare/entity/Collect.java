package com.project.oldCare.entity;

import java.sql.Timestamp;
import java.util.Objects;

public class Collect {
    private Integer collectId;
    private Integer userId;
    private String sourceTable;
    private String sourceField;
    private Integer sourceId;
    private String title;
    private String img;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Override
    public String toString() {
        return "Collect{" +
                "collectId=" + collectId +
                ", userId=" + userId +
                ", sourceTable='" + sourceTable + '\'' +
                ", sourceField='" + sourceField + '\'' +
                ", sourceId=" + sourceId +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collect collect = (Collect) o;
        return Objects.equals(collectId, collect.collectId) && Objects.equals(userId, collect.userId) && Objects.equals(sourceTable, collect.sourceTable) && Objects.equals(sourceField, collect.sourceField) && Objects.equals(sourceId, collect.sourceId) && Objects.equals(title, collect.title) && Objects.equals(img, collect.img) && Objects.equals(createTime, collect.createTime) && Objects.equals(updateTime, collect.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collectId, userId, sourceTable, sourceField, sourceId, title, img, createTime, updateTime);
    }

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
}
