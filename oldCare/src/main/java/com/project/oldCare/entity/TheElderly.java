package com.project.oldCare.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 老人
 * @TableName the_elderly
 */
@TableName(value ="the_elderly")
@Data
public class TheElderly implements Serializable {
    /**
     * 老人ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 老人编号
     */
    private String seniorCitizenNumber;

    /**
     * 姓名
     */
    private String fullName;

    /**
     * 性别
     */
    private String gender;

    /**
     * 家属id
     */
    private Integer familyMembersId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     *
     */
    private Integer bedId;

    /**
     * 失能评级
     */
    private Integer disDegree;

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
        TheElderly other = (TheElderly) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSeniorCitizenNumber() == null ? other.getSeniorCitizenNumber() == null : this.getSeniorCitizenNumber().equals(other.getSeniorCitizenNumber()))
            && (this.getFullName() == null ? other.getFullName() == null : this.getFullName().equals(other.getFullName()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getFamilyMembersId() == null ? other.getFamilyMembersId() == null : this.getFamilyMembersId().equals(other.getFamilyMembersId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()))
            && (this.getBedId() == null ? other.getBedId() == null : this.getBedId().equals(other.getBedId()))
            && (this.getDisDegree() == null ? other.getDisDegree() == null : this.getDisDegree().equals(other.getDisDegree()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSeniorCitizenNumber() == null) ? 0 : getSeniorCitizenNumber().hashCode());
        result = prime * result + ((getFullName() == null) ? 0 : getFullName().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getFamilyMembersId() == null) ? 0 : getFamilyMembersId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getBedId() == null) ? 0 : getBedId().hashCode());
        result = prime * result + ((getDisDegree() == null) ? 0 : getDisDegree().hashCode());
        return result;
    }

    @Override
    public String toString() {
        String sb = getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", id=" + id +
                ", seniorCitizenNumber=" + seniorCitizenNumber +
                ", fullName=" + fullName +
                ", gender=" + gender +
                ", familyMembersId=" + familyMembersId +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", phoneNumber=" + phoneNumber +
                ", bedId=" + bedId +
                ", disDegree=" + disDegree +
                ", serialVersionUID=" + serialVersionUID +
                "]";
        return sb;
    }
}
