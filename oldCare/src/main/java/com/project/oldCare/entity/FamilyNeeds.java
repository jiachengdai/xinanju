package com.project.oldCare.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 家属需求
 * @TableName family_needs
 */
@TableName(value ="family_needs")
@Data
public class FamilyNeeds implements Serializable {
    /**
     * 家属需求ID
     */
    @TableId(type = IdType.AUTO)
    private Integer familyNeedsId;

    /**
     * 家属编号
     */
    private Integer familyNumber;

    /**
     * 姓名
     */
    private String fullName;

    /**
     * 标题
     */
    private String title;

    /**
     * 详情
     */
    private String details;

    /**
     * 提交时间
     */
    private Date submissionTime;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 审核状态
     */
    private String examineState;

    /**
     * 审核回复
     */
    private String examineReply;

    /**
     * 智能推荐
     */
    private Integer recommend;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        FamilyNeeds other = (FamilyNeeds) that;
        return (this.getFamilyNeedsId() == null ? other.getFamilyNeedsId() == null : this.getFamilyNeedsId().equals(other.getFamilyNeedsId()))
            && (this.getFamilyNumber() == null ? other.getFamilyNumber() == null : this.getFamilyNumber().equals(other.getFamilyNumber()))
            && (this.getFullName() == null ? other.getFullName() == null : this.getFullName().equals(other.getFullName()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getDetails() == null ? other.getDetails() == null : this.getDetails().equals(other.getDetails()))
            && (this.getSubmissionTime() == null ? other.getSubmissionTime() == null : this.getSubmissionTime().equals(other.getSubmissionTime()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getExamineState() == null ? other.getExamineState() == null : this.getExamineState().equals(other.getExamineState()))
            && (this.getExamineReply() == null ? other.getExamineReply() == null : this.getExamineReply().equals(other.getExamineReply()))
            && (this.getRecommend() == null ? other.getRecommend() == null : this.getRecommend().equals(other.getRecommend()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFamilyNeedsId() == null) ? 0 : getFamilyNeedsId().hashCode());
        result = prime * result + ((getFamilyNumber() == null) ? 0 : getFamilyNumber().hashCode());
        result = prime * result + ((getFullName() == null) ? 0 : getFullName().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getDetails() == null) ? 0 : getDetails().hashCode());
        result = prime * result + ((getSubmissionTime() == null) ? 0 : getSubmissionTime().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getExamineState() == null) ? 0 : getExamineState().hashCode());
        result = prime * result + ((getExamineReply() == null) ? 0 : getExamineReply().hashCode());
        result = prime * result + ((getRecommend() == null) ? 0 : getRecommend().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        String sb = getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", familyNeedsId=" + familyNeedsId +
                ", familyNumber=" + familyNumber +
                ", fullName=" + fullName +
                ", title=" + title +
                ", details=" + details +
                ", submissionTime=" + submissionTime +
                ", remarks=" + remarks +
                ", examineState=" + examineState +
                ", examineReply=" + examineReply +
                ", recommend=" + recommend +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", serialVersionUID=" + serialVersionUID +
                "]";
        return sb;
    }
}
