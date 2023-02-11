package com.example.hengtaimerp.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

@Data
public class ErpBomVo extends ErpBom{
    @ColumnWidth(15)
    @ExcelProperty(value = "BOM组", index = 0)
    private String bomSection;

    /**
     * 主件名称
     */
    @ColumnWidth(20)
    @ExcelProperty(value = "名称", index = 1)
    private String masterPartName;

    /**
     * 主件编码
     */
    @ColumnWidth(25)
    @ExcelProperty(value = "编码", index = 2)
    private String masterComponentCoding;

    /**
     * 主件规格型号
     */
    @ColumnWidth(15)
    @ExcelProperty(value = "规格型号", index = 3)
    private String mainPartSpecificationsAndModels;

    /**
     * 主件预入仓库
     */
    @ColumnWidth(15)
    @ExcelProperty(value = "预入仓库", index = 4)
    private String masterPartsAreStored;

    /**
     * 主件生产车间
     */
    @ColumnWidth(15)
    @ExcelProperty(value = "生产车间", index = 5)
    private String mainPartsProductionShop;

    /**
     * 主件单位
     */
    @ColumnWidth(20)
    @ExcelProperty(value = "计量单位", index = 6)
    private String masterUnit;

    /**
     * 主件用量
     */

    @ColumnWidth(30)
    @ExcelProperty(value = "用量", index = 7)
    private Integer volumeOfMainParts;

    /**
     * 子件编码
     */
    @ExcelProperty(value = {"子件","子件编码"}, index = 8)
    @ColumnWidth(15)
    private String subpartCoding;

    /**
     * 子件物料名称
     */
    @ExcelProperty(value = {"子件","子件名称"}, index = 9)
    @ColumnWidth(15)
    private String subpartMaterialName;

    /**
     * 子件规格型号
     */
    @ExcelProperty(value = {"子件","子件规格型号"}, index = 10)
    @ColumnWidth(15)
    private String componentSpecificationsAndModels;

    /**
     * 子件预出仓库
     */
    @ExcelProperty(value = {"子件","子件预出仓库"}, index = 11)
    @ColumnWidth(15)
    private String subroutineExitWarehouse;

    /**
     * 子件单位
     */
    @ExcelProperty(value = {"子件","子件单位"}, index = 12)
    @ColumnWidth(15)
    private String subunit;

    /**
     * 子件用量
     */
    @ExcelProperty(value = {"子件","子件用量"}, index = 13)
    @ColumnWidth(15)
    private Integer componentDosage;
}
