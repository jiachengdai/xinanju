package com.project.oldCare.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 药品管理
 * @TableName drug_management
 */
@TableName(value ="drug_management")
@Data
public class DrugManagement implements Serializable {
    /**
     * 药品管理ID
     */
    @TableId(type = IdType.AUTO)
    private Integer drugManagementId;

    /**
     * 药品编号
     */
    private String drugNo;

    /**
     * 药品名称
     */
    private String drugName;

    /**
     * 图片
     */
    private String picture;

    /**
     * 功效
     */
    private String effect;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 库存数量
     */
    private Integer inventoryQuantity;

    /**
     * 备注
     */
    private String remarks;

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
        DrugManagement other = (DrugManagement) that;
        return (this.getDrugManagementId() == null ? other.getDrugManagementId() == null : this.getDrugManagementId().equals(other.getDrugManagementId()))
            && (this.getDrugNo() == null ? other.getDrugNo() == null : this.getDrugNo().equals(other.getDrugNo()))
            && (this.getDrugName() == null ? other.getDrugName() == null : this.getDrugName().equals(other.getDrugName()))
            && (this.getPicture() == null ? other.getPicture() == null : this.getPicture().equals(other.getPicture()))
            && (this.getEffect() == null ? other.getEffect() == null : this.getEffect().equals(other.getEffect()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getInventoryQuantity() == null ? other.getInventoryQuantity() == null : this.getInventoryQuantity().equals(other.getInventoryQuantity()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getRecommend() == null ? other.getRecommend() == null : this.getRecommend().equals(other.getRecommend()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDrugManagementId() == null) ? 0 : getDrugManagementId().hashCode());
        result = prime * result + ((getDrugNo() == null) ? 0 : getDrugNo().hashCode());
        result = prime * result + ((getDrugName() == null) ? 0 : getDrugName().hashCode());
        result = prime * result + ((getPicture() == null) ? 0 : getPicture().hashCode());
        result = prime * result + ((getEffect() == null) ? 0 : getEffect().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getInventoryQuantity() == null) ? 0 : getInventoryQuantity().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
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
                ", drugManagementId=" + drugManagementId +
                ", drugNo=" + drugNo +
                ", drugName=" + drugName +
                ", picture=" + picture +
                ", effect=" + effect +
                ", price=" + price +
                ", inventoryQuantity=" + inventoryQuantity +
                ", remarks=" + remarks +
                ", recommend=" + recommend +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", serialVersionUID=" + serialVersionUID +
                "]";
        return sb;
    }
}
