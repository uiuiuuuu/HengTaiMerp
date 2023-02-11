package com.example.hengtaimerp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName erp_bom
 */
@TableName(value ="erp_bom")
@Data
public class ErpBom implements Serializable {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * BOM组
     */
    private Integer bomSection;

    /**
     * 主件名称
     */
    private String masterPartName;

    /**
     * 主件编码
     */
    private String masterComponentCoding;

    /**
     * 主件规格型号
     */
    private String mainPartSpecificationsAndModels;

    /**
     * 主件预入仓库
     */
    private String masterPartsAreStored;

    /**
     * 主件生产车间
     */
    private String mainPartsProductionShop;

    /**
     * 主件单位
     */
    private String masterUnit;

    /**
     * 主件用量
     */
    private Integer volumeOfMainParts;

    /**
     * 子件编码
     */
    private String subpartCoding;

    /**
     * 子件物料名称
     */
    private String subpartMaterialName;

    /**
     * 子件规格型号
     */
    private String componentSpecificationsAndModels;

    /**
     * 子件预出仓库
     */
    private String subroutineExitWarehouse;

    /**
     * 子件单位
     */
    private String subunit;

    /**
     * 子件用量
     */
    private Integer componentDosage;

    /**
     * 制单人
     */
    private String documenter;

    /**
     * 制单时间
     */
    private Date documentMakingTime;

    /**
     * 修改人
     */
    private String modifier;

    /**
     * 修改时间
     */
    private Date modificationTime;

    /**
     * 审核人
     */
    private String auditor;

    /**
     * 审核时间
     */
    private Date auditTime;

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
        ErpBom other = (ErpBom) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBomSection() == null ? other.getBomSection() == null : this.getBomSection().equals(other.getBomSection()))
            && (this.getMasterPartName() == null ? other.getMasterPartName() == null : this.getMasterPartName().equals(other.getMasterPartName()))
            && (this.getMasterComponentCoding() == null ? other.getMasterComponentCoding() == null : this.getMasterComponentCoding().equals(other.getMasterComponentCoding()))
            && (this.getMainPartSpecificationsAndModels() == null ? other.getMainPartSpecificationsAndModels() == null : this.getMainPartSpecificationsAndModels().equals(other.getMainPartSpecificationsAndModels()))
            && (this.getMasterPartsAreStored() == null ? other.getMasterPartsAreStored() == null : this.getMasterPartsAreStored().equals(other.getMasterPartsAreStored()))
            && (this.getMainPartsProductionShop() == null ? other.getMainPartsProductionShop() == null : this.getMainPartsProductionShop().equals(other.getMainPartsProductionShop()))
            && (this.getMasterUnit() == null ? other.getMasterUnit() == null : this.getMasterUnit().equals(other.getMasterUnit()))
            && (this.getVolumeOfMainParts() == null ? other.getVolumeOfMainParts() == null : this.getVolumeOfMainParts().equals(other.getVolumeOfMainParts()))
            && (this.getSubpartCoding() == null ? other.getSubpartCoding() == null : this.getSubpartCoding().equals(other.getSubpartCoding()))
            && (this.getSubpartMaterialName() == null ? other.getSubpartMaterialName() == null : this.getSubpartMaterialName().equals(other.getSubpartMaterialName()))
            && (this.getComponentSpecificationsAndModels() == null ? other.getComponentSpecificationsAndModels() == null : this.getComponentSpecificationsAndModels().equals(other.getComponentSpecificationsAndModels()))
            && (this.getSubroutineExitWarehouse() == null ? other.getSubroutineExitWarehouse() == null : this.getSubroutineExitWarehouse().equals(other.getSubroutineExitWarehouse()))
            && (this.getSubunit() == null ? other.getSubunit() == null : this.getSubunit().equals(other.getSubunit()))
            && (this.getComponentDosage() == null ? other.getComponentDosage() == null : this.getComponentDosage().equals(other.getComponentDosage()))
            && (this.getDocumenter() == null ? other.getDocumenter() == null : this.getDocumenter().equals(other.getDocumenter()))
            && (this.getDocumentMakingTime() == null ? other.getDocumentMakingTime() == null : this.getDocumentMakingTime().equals(other.getDocumentMakingTime()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()))
            && (this.getModificationTime() == null ? other.getModificationTime() == null : this.getModificationTime().equals(other.getModificationTime()))
            && (this.getAuditor() == null ? other.getAuditor() == null : this.getAuditor().equals(other.getAuditor()))
            && (this.getAuditTime() == null ? other.getAuditTime() == null : this.getAuditTime().equals(other.getAuditTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBomSection() == null) ? 0 : getBomSection().hashCode());
        result = prime * result + ((getMasterPartName() == null) ? 0 : getMasterPartName().hashCode());
        result = prime * result + ((getMasterComponentCoding() == null) ? 0 : getMasterComponentCoding().hashCode());
        result = prime * result + ((getMainPartSpecificationsAndModels() == null) ? 0 : getMainPartSpecificationsAndModels().hashCode());
        result = prime * result + ((getMasterPartsAreStored() == null) ? 0 : getMasterPartsAreStored().hashCode());
        result = prime * result + ((getMainPartsProductionShop() == null) ? 0 : getMainPartsProductionShop().hashCode());
        result = prime * result + ((getMasterUnit() == null) ? 0 : getMasterUnit().hashCode());
        result = prime * result + ((getVolumeOfMainParts() == null) ? 0 : getVolumeOfMainParts().hashCode());
        result = prime * result + ((getSubpartCoding() == null) ? 0 : getSubpartCoding().hashCode());
        result = prime * result + ((getSubpartMaterialName() == null) ? 0 : getSubpartMaterialName().hashCode());
        result = prime * result + ((getComponentSpecificationsAndModels() == null) ? 0 : getComponentSpecificationsAndModels().hashCode());
        result = prime * result + ((getSubroutineExitWarehouse() == null) ? 0 : getSubroutineExitWarehouse().hashCode());
        result = prime * result + ((getSubunit() == null) ? 0 : getSubunit().hashCode());
        result = prime * result + ((getComponentDosage() == null) ? 0 : getComponentDosage().hashCode());
        result = prime * result + ((getDocumenter() == null) ? 0 : getDocumenter().hashCode());
        result = prime * result + ((getDocumentMakingTime() == null) ? 0 : getDocumentMakingTime().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        result = prime * result + ((getModificationTime() == null) ? 0 : getModificationTime().hashCode());
        result = prime * result + ((getAuditor() == null) ? 0 : getAuditor().hashCode());
        result = prime * result + ((getAuditTime() == null) ? 0 : getAuditTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bomSection=").append(bomSection);
        sb.append(", masterPartName=").append(masterPartName);
        sb.append(", masterComponentCoding=").append(masterComponentCoding);
        sb.append(", mainPartSpecificationsAndModels=").append(mainPartSpecificationsAndModels);
        sb.append(", masterPartsAreStored=").append(masterPartsAreStored);
        sb.append(", mainPartsProductionShop=").append(mainPartsProductionShop);
        sb.append(", masterUnit=").append(masterUnit);
        sb.append(", volumeOfMainParts=").append(volumeOfMainParts);
        sb.append(", subpartCoding=").append(subpartCoding);
        sb.append(", subpartMaterialName=").append(subpartMaterialName);
        sb.append(", componentSpecificationsAndModels=").append(componentSpecificationsAndModels);
        sb.append(", subroutineExitWarehouse=").append(subroutineExitWarehouse);
        sb.append(", subunit=").append(subunit);
        sb.append(", componentDosage=").append(componentDosage);
        sb.append(", documenter=").append(documenter);
        sb.append(", documentMakingTime=").append(documentMakingTime);
        sb.append(", modifier=").append(modifier);
        sb.append(", modificationTime=").append(modificationTime);
        sb.append(", auditor=").append(auditor);
        sb.append(", auditTime=").append(auditTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}