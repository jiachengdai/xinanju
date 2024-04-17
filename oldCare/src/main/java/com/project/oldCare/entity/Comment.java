package com.project.oldCare.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;
import java.util.Objects;

public class Comment {
    private Integer commentId;
    private Long userId;
    private Long replyToId;
    @NotEmpty
    private String content;
    private String nickname;
    private String avatar;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String sourceTable;
    private String sourceField;
    @NotNull
    private Integer sourceId;

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", userId=" + userId +
                ", replyToId=" + replyToId +
                ", content='" + content + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
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
        Comment comment = (Comment) o;
        return Objects.equals(commentId, comment.commentId) && Objects.equals(userId, comment.userId) && Objects.equals(replyToId, comment.replyToId) && Objects.equals(content, comment.content) && Objects.equals(nickname, comment.nickname) && Objects.equals(avatar, comment.avatar) && Objects.equals(createTime, comment.createTime) && Objects.equals(updateTime, comment.updateTime) && Objects.equals(sourceTable, comment.sourceTable) && Objects.equals(sourceField, comment.sourceField) && Objects.equals(sourceId, comment.sourceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, userId, replyToId, content, nickname, avatar, createTime, updateTime, sourceTable, sourceField, sourceId);
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getReplyToId() {
        return replyToId;
    }

    public void setReplyToId(Long replyToId) {
        this.replyToId = replyToId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
