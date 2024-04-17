package com.project.oldCare.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 老人需求
 * @TableName needs_of_the_elderly
 */
@TableName(value ="needs_of_the_elderly")
@Data
public class NeedsOfTheElderly implements Serializable {
    /**
     * 老人需求ID
     */
    @TableId(type = IdType.AUTO)
    private Integer needsOfTheElderlyId;

    /**
     * 老人编号
     */
    private Integer seniorCitizenNumber;

    /**
     * 姓名
     */
    private String fullName;

    /**
     * 需求id
     */
    private Integer needId;

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
        NeedsOfTheElderly other = (NeedsOfTheElderly) that;
        return (this.getNeedsOfTheElderlyId() == null ? other.getNeedsOfTheElderlyId() == null : this.getNeedsOfTheElderlyId().equals(other.getNeedsOfTheElderlyId()))
            && (this.getSeniorCitizenNumber() == null ? other.getSeniorCitizenNumber() == null : this.getSeniorCitizenNumber().equals(other.getSeniorCitizenNumber()))
            && (this.getFullName() == null ? other.getFullName() == null : this.getFullName().equals(other.getFullName()))
            && (this.getNeedId() == null ? other.getNeedId() == null : this.getNeedId().equals(other.getNeedId()))
            && (this.getDetails() == null ? other.getDetails() == null : this.getDetails().equals(other.getDetails()))
            && (this.getSubmissionTime() == null ? other.getSubmissionTime() == null : this.getSubmissionTime().equals(other.getSubmissionTime()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getExamineState() == null ? other.getExamineState() == null : this.getExamineState().equals(other.getExamineState()))
            && (this.getExamineReply() == null ? other.getExamineReply() == null : this.getExamineReply().equals(other.getExamineReply()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNeedsOfTheElderlyId() == null) ? 0 : getNeedsOfTheElderlyId().hashCode());
        result = prime * result + ((getSeniorCitizenNumber() == null) ? 0 : getSeniorCitizenNumber().hashCode());
        result = prime * result + ((getFullName() == null) ? 0 : getFullName().hashCode());
        result = prime * result + ((getNeedId() == null) ? 0 : getNeedId().hashCode());
        result = prime * result + ((getDetails() == null) ? 0 : getDetails().hashCode());
        result = prime * result + ((getSubmissionTime() == null) ? 0 : getSubmissionTime().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getExamineState() == null) ? 0 : getExamineState().hashCode());
        result = prime * result + ((getExamineReply() == null) ? 0 : getExamineReply().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        String sb = getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", needsOfTheElderlyId=" + needsOfTheElderlyId +
                ", seniorCitizenNumber=" + seniorCitizenNumber +
                ", fullName=" + fullName +
                ", needId=" + needId +
                ", details=" + details +
                ", submissionTime=" + submissionTime +
                ", remarks=" + remarks +
                ", examineState=" + examineState +
                ", examineReply=" + examineReply +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", serialVersionUID=" + serialVersionUID +
                "]";
        return sb;
    }
}
