package com.project.oldCare.entity;

import java.sql.Timestamp;
import java.util.Objects;

public class ForumType {


    private Integer typeId;

    private String name;

    private String description;

    private String url;

    private Integer fatherId;

    private String icon;

    private Timestamp createTime;

    private Timestamp updateTime;

    @Override
    public String toString() {
        return "ForumType{" +
                "typeId=" + typeId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", fatherId=" + fatherId +
                ", icon='" + icon + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForumType forumType = (ForumType) o;
        return Objects.equals(typeId, forumType.typeId) && Objects.equals(name, forumType.name) && Objects.equals(description, forumType.description) && Objects.equals(url, forumType.url) && Objects.equals(fatherId, forumType.fatherId) && Objects.equals(icon, forumType.icon) && Objects.equals(createTime, forumType.createTime) && Objects.equals(updateTime, forumType.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeId, name, description, url, fatherId, icon, createTime, updateTime);
    }
}
