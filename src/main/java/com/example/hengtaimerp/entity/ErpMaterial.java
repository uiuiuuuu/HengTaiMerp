package com.example.hengtaimerp.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Date;

import lombok.Data;

/**
 * @TableName erp_material
 */
@TableName(value = "erp_material")
@Data
@ExcelIgnoreUnannotated
public class ErpMaterial implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    @ExcelIgnore

    private Integer id;

    /**
     * 物料编码
     */
    @ColumnWidth(12)
    @ExcelProperty(value = "物料编码", index = 0)
    private String materialCode;

    /**
     * 物料名称
     */
    @ColumnWidth(12)
    @ExcelProperty(value = "物料名称", index = 1)
    private String materialName;

    /**
     * 规格型号
     */
    @ColumnWidth(12)
    @ExcelProperty(value = "规格型号", index = 2)
    private String specificationAndModel;

    /**
     * 图号
     */
    @ColumnWidth(12)
    @ExcelProperty(value = "图号", index = 3)
    private String drawingNumber;

    /**
     * 类别
     */
    @ColumnWidth(12)
    @ExcelProperty(value = "物料组", index = 4)
    private String category;

    /**
     * 仓库
     */
    @ColumnWidth(12)
    @ExcelProperty(value = "仓库", index = 5)
    private String warehouse;

    /**
     * 生产车间
     */
    @ColumnWidth(12)
    @ExcelProperty(value = "生产车间", index = 6)
    private String productionShop;

    /**
     * 常用单位
     */
    @ColumnWidth(12)
    @ExcelProperty(value = "常用单位", index = 7)
    private String commonUnit;

    /**
     * 基本单位
     */
    @ColumnWidth(12)
    @ExcelProperty(value = "基本单位", index = 8)
    private String basicUnit;

    /**
     * 库存上限
     */
    @ColumnWidth(12)
    @ExcelProperty(value = "库存上限", index = 9)
    private String inventoryCeiling;

    /**
     * 库存下限
     */
    @ColumnWidth(12)
    @ExcelProperty(value = "库存下限", index = 10)
    private String inventoryFloor;

    /**
     * 类型
     */
    @ColumnWidth(12)
    @ExcelProperty(value = "类型", index = 11)
    private String type;

    /**
     * 状态
     */
    @ExcelIgnore
    private String state;

    /**
     * 备注
     */
    @ColumnWidth(50)
    @ExcelProperty(value = "备注", index = 12)
    private String remarks;

    /**
     * 创建人
     */
    @ExcelIgnore
    private String founder;

    /**
     * 创建时间
     */
    @ExcelIgnore
    private Date creationTime;

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
        ErpMaterial other = (ErpMaterial) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getMaterialCode() == null ? other.getMaterialCode() == null : this.getMaterialCode().equals(other.getMaterialCode()))
                && (this.getMaterialName() == null ? other.getMaterialName() == null : this.getMaterialName().equals(other.getMaterialName()))
                && (this.getSpecificationAndModel() == null ? other.getSpecificationAndModel() == null : this.getSpecificationAndModel().equals(other.getSpecificationAndModel()))
                && (this.getDrawingNumber() == null ? other.getDrawingNumber() == null : this.getDrawingNumber().equals(other.getDrawingNumber()))
                && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
                && (this.getWarehouse() == null ? other.getWarehouse() == null : this.getWarehouse().equals(other.getWarehouse()))
                && (this.getProductionShop() == null ? other.getProductionShop() == null : this.getProductionShop().equals(other.getProductionShop()))
                && (this.getCommonUnit() == null ? other.getCommonUnit() == null : this.getCommonUnit().equals(other.getCommonUnit()))
                && (this.getBasicUnit() == null ? other.getBasicUnit() == null : this.getBasicUnit().equals(other.getBasicUnit()))
                && (this.getInventoryCeiling() == null ? other.getInventoryCeiling() == null : this.getInventoryCeiling().equals(other.getInventoryCeiling()))
                && (this.getInventoryFloor() == null ? other.getInventoryFloor() == null : this.getInventoryFloor().equals(other.getInventoryFloor()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
                && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
                && (this.getFounder() == null ? other.getFounder() == null : this.getFounder().equals(other.getFounder()))
                && (this.getCreationTime() == null ? other.getCreationTime() == null : this.getCreationTime().equals(other.getCreationTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMaterialCode() == null) ? 0 : getMaterialCode().hashCode());
        result = prime * result + ((getMaterialName() == null) ? 0 : getMaterialName().hashCode());
        result = prime * result + ((getSpecificationAndModel() == null) ? 0 : getSpecificationAndModel().hashCode());
        result = prime * result + ((getDrawingNumber() == null) ? 0 : getDrawingNumber().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
        result = prime * result + ((getWarehouse() == null) ? 0 : getWarehouse().hashCode());
        result = prime * result + ((getProductionShop() == null) ? 0 : getProductionShop().hashCode());
        result = prime * result + ((getCommonUnit() == null) ? 0 : getCommonUnit().hashCode());
        result = prime * result + ((getBasicUnit() == null) ? 0 : getBasicUnit().hashCode());
        result = prime * result + ((getInventoryCeiling() == null) ? 0 : getInventoryCeiling().hashCode());
        result = prime * result + ((getInventoryFloor() == null) ? 0 : getInventoryFloor().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getFounder() == null) ? 0 : getFounder().hashCode());
        result = prime * result + ((getCreationTime() == null) ? 0 : getCreationTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", materialCode=").append(materialCode);
        sb.append(", materialName=").append(materialName);
        sb.append(", specificationAndModel=").append(specificationAndModel);
        sb.append(", drawingNumber=").append(drawingNumber);
        sb.append(", category=").append(category);
        sb.append(", warehouse=").append(warehouse);
        sb.append(", productionShop=").append(productionShop);
        sb.append(", commonUnit=").append(commonUnit);
        sb.append(", basicUnit=").append(basicUnit);
        sb.append(", inventoryCeiling=").append(inventoryCeiling);
        sb.append(", inventoryFloor=").append(inventoryFloor);
        sb.append(", type=").append(type);
        sb.append(", state=").append(state);
        sb.append(", remarks=").append(remarks);
        sb.append(", founder=").append(founder);
        sb.append(", creationTime=").append(creationTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}