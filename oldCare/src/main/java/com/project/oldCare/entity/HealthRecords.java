package com.project.oldCare.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 健康记录
 * @TableName health_records
 */
@TableName(value ="health_records")
@Data
public class HealthRecords implements Serializable {
    /**
     * 健康记录ID
     */
    @TableId(type = IdType.AUTO)
    private Integer healthRecordsId;

    /**
     * 护工编号
     */
    private String nurseNo;

    /**
     * 老人编号
     */
    private String seniorCitizenNumber;

    /**
     * 老人姓名
     */
    private String nameOfTheElderly;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 体重
     */
    private String weight;

    /**
     * 血压
     */
    private String bloodPressure;

    /**
     * 脉搏
     */
    private String pulse;

    /**
     * 体温
     */
    private String temperature;

    /**
     * 记录时间
     */
    private Date recordTime;

    /**
     * 健康状况
     */
    private String health;

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
        HealthRecords other = (HealthRecords) that;
        return (this.getHealthRecordsId() == null ? other.getHealthRecordsId() == null : this.getHealthRecordsId().equals(other.getHealthRecordsId()))
            && (this.getNurseNo() == null ? other.getNurseNo() == null : this.getNurseNo().equals(other.getNurseNo()))
            && (this.getSeniorCitizenNumber() == null ? other.getSeniorCitizenNumber() == null : this.getSeniorCitizenNumber().equals(other.getSeniorCitizenNumber()))
            && (this.getNameOfTheElderly() == null ? other.getNameOfTheElderly() == null : this.getNameOfTheElderly().equals(other.getNameOfTheElderly()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getBloodPressure() == null ? other.getBloodPressure() == null : this.getBloodPressure().equals(other.getBloodPressure()))
            && (this.getPulse() == null ? other.getPulse() == null : this.getPulse().equals(other.getPulse()))
            && (this.getTemperature() == null ? other.getTemperature() == null : this.getTemperature().equals(other.getTemperature()))
            && (this.getRecordTime() == null ? other.getRecordTime() == null : this.getRecordTime().equals(other.getRecordTime()))
            && (this.getHealth() == null ? other.getHealth() == null : this.getHealth().equals(other.getHealth()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHealthRecordsId() == null) ? 0 : getHealthRecordsId().hashCode());
        result = prime * result + ((getNurseNo() == null) ? 0 : getNurseNo().hashCode());
        result = prime * result + ((getSeniorCitizenNumber() == null) ? 0 : getSeniorCitizenNumber().hashCode());
        result = prime * result + ((getNameOfTheElderly() == null) ? 0 : getNameOfTheElderly().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getBloodPressure() == null) ? 0 : getBloodPressure().hashCode());
        result = prime * result + ((getPulse() == null) ? 0 : getPulse().hashCode());
        result = prime * result + ((getTemperature() == null) ? 0 : getTemperature().hashCode());
        result = prime * result + ((getRecordTime() == null) ? 0 : getRecordTime().hashCode());
        result = prime * result + ((getHealth() == null) ? 0 : getHealth().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        String sb = getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", healthRecordsId=" + healthRecordsId +
                ", nurseNo=" + nurseNo +
                ", seniorCitizenNumber=" + seniorCitizenNumber +
                ", nameOfTheElderly=" + nameOfTheElderly +
                ", age=" + age +
                ", weight=" + weight +
                ", bloodPressure=" + bloodPressure +
                ", pulse=" + pulse +
                ", temperature=" + temperature +
                ", recordTime=" + recordTime +
                ", health=" + health +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", serialVersionUID=" + serialVersionUID +
                "]";
        return sb;
    }
}
