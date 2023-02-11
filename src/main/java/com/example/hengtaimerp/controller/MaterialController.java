package com.example.hengtaimerp.controller;

import com.alibaba.excel.EasyExcel;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hengtaimerp.entity.ErpBom;
import com.example.hengtaimerp.entity.ErpMaterial;
import com.example.hengtaimerp.listener.ExcelListener;
import com.example.hengtaimerp.mapper.ErpMaterialMapper;
import com.example.hengtaimerp.utils.JwtUtils;
import com.example.hengtaimerp.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    ErpMaterialMapper erpMaterialMapper;

    /**
     * 物料上传
     * @param file 上传物料文件
     * @param httpServletRequest 验证
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public DataVo upload(@RequestParam("material") MultipartFile file, HttpServletRequest httpServletRequest) throws IOException {
        DataVo dataVo = new DataVo();
        String authorization = httpServletRequest.getHeader("Authorization");
        DecodedJWT verify = JwtUtils.verify(authorization);
        Claim username = verify.getClaim("username");

        try {
            String fileName = file.getName();
            InputStream inputStream = file.getInputStream();
            ExcelListener listener = new ExcelListener();

            EasyExcel.read(inputStream, ErpMaterial.class, listener)
                    .headRowNumber(1)
                    .build()
                    .readAll();

            List<Object> list = listener.getData();

            for (Object o : list) {
                ErpMaterial erpMaterial = (ErpMaterial) o;

                erpMaterial.setFounder(username.asString());
                Date date = new Date("yyyy/mm/dd");
                erpMaterial.setCreationTime(date);
                erpMaterial.setState("1");
                erpMaterialMapper.insert(erpMaterial);
            }
            dataVo.ok();
            dataVo.setMessage("上传成功");
            return dataVo;


        } catch (Exception e) {
            throw e;

        }


    }

    @GetMapping("/download")
    public void download(HttpServletResponse response, HttpServletRequest request){
        try {
            String filenames = "物料模板下载";
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
            QueryWrapper<ErpMaterial> queryWrapper = new QueryWrapper<>();

            // Step2： 构造查询条件
            queryWrapper
                    .select("*");

            // Step3：执行查询
            List<ErpMaterial> erpMaterials = erpMaterialMapper.selectList(queryWrapper);

            EasyExcel.write(response.getOutputStream(), ErpMaterial.class).sheet("sheet").doWrite(erpMaterials);

        } catch (Exception e) {

        }

    }


}
