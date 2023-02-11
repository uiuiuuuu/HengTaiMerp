package com.example.hengtaimerp.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hengtaimerp.entity.ErpBom;
import com.example.hengtaimerp.mapper.ErpBomMapper;
import com.example.hengtaimerp.service.ErpBomService;
import com.example.hengtaimerp.vo.DataVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/bom")
public class EepBomController {


    @Autowired
    ErpBomService erpBomServices;
    @Autowired
    ErpBomVoMapper erpBomVoMapper;

    @Autowired
    ErpBomMapper erpBomMapper;

    /**
     * 上传BOM
     *
     * @param file        上传文件
     * @param httpRequest 请求头
     * @return
     * @throws IOException
     */
    @PostMapping("/import")
    public DataVo erpImport(@RequestParam("ExcelFile") MultipartFile file, HttpServletRequest httpRequest) throws IOException {
        return erpBomServices.iExcel(file,httpRequest);
    }

    /**
     * 下载BOM文件
     *
     * @param response 返回头
     * @param request  请求头
     */
    @RequestMapping("/download")
    public void myExport(HttpServletResponse response, HttpServletRequest request) {


        String str = "bom_section,master_part_name,master_component_coding,main_part_specifications_and_models,master_parts_are_stored,main_parts_production_shop,master_unit,volume_of_main_parts,subpart_coding,subpart_material_name,component_specifications_and_models,subroutine_exit_warehouse,subunit,component_dosage" ;

        try {
            String filenames = "上传模板下载";
            String userAgent = request.getHeader("User-Agent");
            if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
                filenames = URLEncoder.encode(filenames, "UTF-8");
            } else {
                filenames = new String(filenames.getBytes("UTF-8"), "ISO-8859-1");
            }
            response.setContentType("application/json.ms-excel");
            response.setCharacterEncoding("utf-8");
            response.addHeader("Content-Disposition", "filename=" + filenames + ".xlsx");

            // Step1：创建一个 QueryWrapper 对象
            QueryWrapper<ErpBom> queryWrapper = new QueryWrapper<>();

            // Step2： 构造查询条件
            queryWrapper
                    .select(str);

            // Step3：执行查询
            List<ErpBom> erpBom = erpBomMapper.selectList(queryWrapper);

            EasyExcel.write(response.getOutputStream(), ErpBom.class).sheet("sheet").doWrite(erpBom);

        } catch (Exception e) {

        }


    }

    /**
     * 查询BOM分页
     *
     * @param page  页码
     * @param limit 数量
     * @return
     */
    @GetMapping("/getBoms")
    public DataVo getBoms(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
        return erpBomServices.getBoms(page, limit);


    }

    /**
     * 添加BOM
     *
     * @param erpBom JSON 对象
     * @return Data  Code 0 通过
     */
    @PostMapping("/addBom")
    public DataVo addBom(@RequestBody ErpBom erpBom) {
        return erpBomServices.addBom(erpBom);
    }

    /**
     * 通过子件编码查找他下边的子健
     * @param subpartCoding  子件ID
     * @param page 页码
     * @param limit 数量
     * @return  code 0 成功
     */
    @GetMapping("/selBom")
    public DataVo selBom(@RequestParam("subpartCoding") String subpartCoding,@RequestParam("page") Integer page, @RequestParam("limit") Integer limit ) {
        return erpBomServices.selBom(subpartCoding,page,limit);
    }
}
