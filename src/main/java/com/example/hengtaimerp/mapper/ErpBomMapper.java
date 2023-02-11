package com.example.hengtaimerp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.hengtaimerp.entity.ErpBom;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author Administrator
* @description 针对表【erp_bom】的数据库操作Mapper
* @createDate 2023-02-11 08:38:26
* @Entity com.example.hengtaimerp.entity.ErpBom
*/
@Repository
public interface ErpBomMapper extends BaseMapper<ErpBom> {


}




