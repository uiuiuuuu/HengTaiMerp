package com.example.hengtaimerp.service;

import com.example.hengtaimerp.entity.ErpBom;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hengtaimerp.vo.DataVo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author Administrator
* @description 针对表【erp_bom】的数据库操作Service
* @createDate 2023-02-11 08:38:26
*/
public interface ErpBomService extends IService<ErpBom> {

    DataVo getBoms(Integer page ,Integer limit);

    DataVo addBom(ErpBom erpBom);

    DataVo selBom(String subpartCoding,Integer page,Integer limit);

    DataVo iExcel(MultipartFile file, HttpServletRequest httpRequest);


}
