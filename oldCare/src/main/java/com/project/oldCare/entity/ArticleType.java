package com.project.oldCare.entity;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import java.sql.Timestamp;
import java.util.Objects;

public class ArticleType {
    private Integer typeId;


    private Integer display;
@NotEmpty
    private String name;

    private Integer fatherId;


    private String description;

@URL
    private String icon;

@URL
    private String url;


    private Timestamp createTime;


    private Timestamp updateTime;

    @Override
    public String toString() {
        return "ArticleType{" +
                "typeId=" + typeId +
                ", display=" + display +
                ", name='" + name + '\'' +
                ", fatherId=" + fatherId +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                ", url='" + url + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleType that = (ArticleType) o;
        return Objects.equals(typeId, that.typeId) && Objects.equals(display, that.display) && Objects.equals(name, that.name) && Objects.equals(fatherId, that.fatherId) && Objects.equals(description, that.description) && Objects.equals(icon, that.icon) && Objects.equals(url, that.url) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeId, display, name, fatherId, description, icon, url, createTime, updateTime);
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
