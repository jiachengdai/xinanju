package com.project.oldCare.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 护工工资
 * @TableName salary_of_nursing_workers
 */
@TableName(value ="salary_of_nursing_workers")
@Data
public class SalaryOfNursingWorkers implements Serializable {
    /**
     * 护工工资ID
     */
    @TableId(type = IdType.AUTO)
    private Integer salaryOfNursingWorkersId;

    /**
     * 护工编号
     */
    private Integer nurseNo;

    /**
     * 姓名
     */
    private String fullName;

    /**
     * 月份
     */
    private String month;

    /**
     * 基本工资
     */
    private Integer basePay;

    /**
     * 奖金
     */
    private Integer bonus;

    /**
     * 补贴
     */
    private Integer subsidy;

    /**
     * 合计
     */
    private String total;

    /**
     * 备注
     */
    private String remarks;

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
        SalaryOfNursingWorkers other = (SalaryOfNursingWorkers) that;
        return (this.getSalaryOfNursingWorkersId() == null ? other.getSalaryOfNursingWorkersId() == null : this.getSalaryOfNursingWorkersId().equals(other.getSalaryOfNursingWorkersId()))
            && (this.getNurseNo() == null ? other.getNurseNo() == null : this.getNurseNo().equals(other.getNurseNo()))
            && (this.getFullName() == null ? other.getFullName() == null : this.getFullName().equals(other.getFullName()))
            && (this.getMonth() == null ? other.getMonth() == null : this.getMonth().equals(other.getMonth()))
            && (this.getBasePay() == null ? other.getBasePay() == null : this.getBasePay().equals(other.getBasePay()))
            && (this.getBonus() == null ? other.getBonus() == null : this.getBonus().equals(other.getBonus()))
            && (this.getSubsidy() == null ? other.getSubsidy() == null : this.getSubsidy().equals(other.getSubsidy()))
            && (this.getTotal() == null ? other.getTotal() == null : this.getTotal().equals(other.getTotal()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSalaryOfNursingWorkersId() == null) ? 0 : getSalaryOfNursingWorkersId().hashCode());
        result = prime * result + ((getNurseNo() == null) ? 0 : getNurseNo().hashCode());
        result = prime * result + ((getFullName() == null) ? 0 : getFullName().hashCode());
        result = prime * result + ((getMonth() == null) ? 0 : getMonth().hashCode());
        result = prime * result + ((getBasePay() == null) ? 0 : getBasePay().hashCode());
        result = prime * result + ((getBonus() == null) ? 0 : getBonus().hashCode());
        result = prime * result + ((getSubsidy() == null) ? 0 : getSubsidy().hashCode());
        result = prime * result + ((getTotal() == null) ? 0 : getTotal().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        String sb = getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", salaryOfNursingWorkersId=" + salaryOfNursingWorkersId +
                ", nurseNo=" + nurseNo +
                ", fullName=" + fullName +
                ", month=" + month +
                ", basePay=" + basePay +
                ", bonus=" + bonus +
                ", subsidy=" + subsidy +
                ", total=" + total +
                ", remarks=" + remarks +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", serialVersionUID=" + serialVersionUID +
                "]";
        return sb;
    }
}
