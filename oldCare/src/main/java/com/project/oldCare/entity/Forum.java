package com.project.oldCare.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

import java.sql.Timestamp;
import java.util.Objects;

public class Forum {
    private Integer forumId;
    private Integer display;
@NotNull
    private Integer userId;
    private String nickname;

    private Integer praiseLen;

    private Integer hits;
@NotEmpty
    private String title;

    private String keywords;

    private String description;
@URL
    private String url;

    private String tag;
@URL
    private String img;

    private String content;

    private Timestamp createTime;

    private Timestamp updateTime;
@URL
    private String avatar;

    private String type;

    @Override
    public String toString() {
        return "Forum{" +
                "forumId=" + forumId +
                ", display=" + display +
                ", userId=" + userId +
                ", nickname='" + nickname + '\'' +
                ", praise_len=" + praiseLen +
                ", hits=" + hits +
                ", title='" + title + '\'' +
                ", keywords='" + keywords + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", tag='" + tag + '\'' +
                ", img='" + img + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", avatar='" + avatar + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forum forum = (Forum) o;
        return Objects.equals(forumId, forum.forumId) && Objects.equals(display, forum.display) && Objects.equals(userId, forum.userId) && Objects.equals(nickname, forum.nickname) && Objects.equals(praiseLen, forum.praiseLen) && Objects.equals(hits, forum.hits) && Objects.equals(title, forum.title) && Objects.equals(keywords, forum.keywords) && Objects.equals(description, forum.description) && Objects.equals(url, forum.url) && Objects.equals(tag, forum.tag) && Objects.equals(img, forum.img) && Objects.equals(content, forum.content) && Objects.equals(createTime, forum.createTime) && Objects.equals(updateTime, forum.updateTime) && Objects.equals(avatar, forum.avatar) && Objects.equals(type, forum.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(forumId, display, userId, nickname, praiseLen, hits, title, keywords, description, url, tag, img, content, createTime, updateTime, avatar, type);
    }

    public Integer getForumId() {
        return forumId;
    }

    public void setForumId(Integer forumId) {
        this.forumId = forumId;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getPraise_len() {
        return praiseLen;
    }

    public void setPraise_len(Integer praise_len) {
        this.praiseLen = praise_len;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
