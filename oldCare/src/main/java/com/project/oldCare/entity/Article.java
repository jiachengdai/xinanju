package com.project.oldCare.entity;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;
import java.util.Objects;

public class Article {
    /**
    * 文章实体类
    * */

     private Integer articleId;
    @NotEmpty
     private String title;
     private String type;
    private Integer hits;
    private Integer praiseLen;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String source ;
    @URL
    private String url;
    private String tag;

    private String content;
    @URL
    private String img;

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", hits=" + hits +
                ", praiseLen=" + praiseLen +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", source='" + source + '\'' +
                ", url='" + url + '\'' +
                ", tag='" + tag + '\'' +
                ", content='" + content + '\'' +
                ", img='" + img + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleId, article.articleId) && Objects.equals(title, article.title) && Objects.equals(type, article.type) && Objects.equals(hits, article.hits) && Objects.equals(praiseLen, article.praiseLen) && Objects.equals(createTime, article.createTime) && Objects.equals(updateTime, article.updateTime) && Objects.equals(source, article.source) && Objects.equals(url, article.url) && Objects.equals(tag, article.tag) && Objects.equals(content, article.content) && Objects.equals(img, article.img) && Objects.equals(description, article.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleId, title, type, hits, praiseLen, createTime, updateTime, source, url, tag, content, img, description);
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getPraise_len() {
        return praiseLen;
    }

    public void setPraise_len(Integer praise_len) {
        this.praiseLen = praise_len;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

}
