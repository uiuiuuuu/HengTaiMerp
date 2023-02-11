package com.example.hengtaimerp.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hengtaimerp.entity.ErpBom;
import com.example.hengtaimerp.entity.User;
import com.example.hengtaimerp.listener.ExcelListener;
import com.example.hengtaimerp.mapper.UserMapper;
import com.example.hengtaimerp.service.ErpBomService;
import com.example.hengtaimerp.mapper.ErpBomMapper;
import com.example.hengtaimerp.utils.JwtUtils;
import com.example.hengtaimerp.utils.StrUtils;
import com.example.hengtaimerp.vo.DataVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Administrator
 * @description 针对表【erp_bom】的数据库操作Service实现
 * @createDate 2023-02-11 08:38:26
 */
@Service
@Slf4j
public class ErpBomServiceImpl extends ServiceImpl<ErpBomMapper, ErpBom>
        implements ErpBomService {

    @Autowired
    ErpBomMapper erpBomMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public DataVo getBoms(Integer page, Integer limit) {

        DataVo dataVo = new DataVo<>();

        IPage iPage = new Page(page, limit);
        //获取总条数
        dataVo.setCount(erpBomMapper.selectCount(null));

        IPage iPage1 = erpBomMapper.selectPage(iPage, null);
        dataVo.ok();
        dataVo.setMessage("获取信息成功");
        dataVo.setData(iPage1.getRecords());


        return dataVo;

    }

    @Override
    public DataVo addBom(ErpBom erpBom) {
        DataVo dataVo = new DataVo<>();
        ErpBom erpBom2 = erpBom;
        if (!StrUtils.IsNull(erpBom.getMasterComponentCoding())) {
            dataVo.error();
            dataVo.setMessage("主件编码不能为空");
            return dataVo;
        }
        if (!StrUtils.IsNull(erpBom.getVolumeOfMainParts())) {
            dataVo.error();
            dataVo.setMessage("主件用量不能为空，或不能为0");
            return dataVo;
        }
        if (!StrUtils.IsNull(erpBom.getSubpartCoding())) {
            dataVo.error();
            dataVo.setMessage("子件件编码不能为空");
            return dataVo;
        }
        if (!StrUtils.IsNull(erpBom.getComponentDosage())) {
            dataVo.error();
            dataVo.setMessage("子件用量不能为空，或不能为0");
            return dataVo;
        }
        if (!StrUtils.IsNull(erpBom.getMasterPartsAreStored())) {
            dataVo.error();
            dataVo.setMessage("主件预入仓库不能为空");
            return dataVo;
        }
        if (!StrUtils.IsNull(erpBom.getSubroutineExitWarehouse())) {
            dataVo.error();
            dataVo.setMessage("子件预出仓库不能为空");
            return dataVo;
        }
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("master_component_coding", erpBom.getMasterComponentCoding());
        ErpBom erpBom1 = erpBomMapper.selectOne(wrapper);

        if (StrUtils.IsNull(erpBom1)) {
            dataVo.error();
            dataVo.setMessage("主件编号已存在，请更改后添加");
            return dataVo;
        }

        int insert = erpBomMapper.insert(erpBom);

        if (insert <= 0) {
            dataVo.error();
            dataVo.setMessage("BOM添加失败请联系管理员检查");
            return dataVo;
        }
        dataVo.ok();
        dataVo.setMessage("新建成功");
        dataVo.setData(erpBom);


        return dataVo;
    }

    @Override
    public DataVo selBom(String subpartCoding, Integer page, Integer limit) {
        IPage<ErpBom> iPage = new Page<>(page, limit);
        DataVo dataVo = new DataVo<>();
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("master_component_coding", subpartCoding);
        IPage iPage1 = erpBomMapper.selectPage(iPage, wrapper);
        dataVo.ok();
        dataVo.setMessage("搜索成功");
        dataVo.setData(iPage1.getRecords());
        return dataVo;
    }

    @Override
    public DataVo iExcel(MultipartFile file, HttpServletRequest httpRequest) {
        DataVo dataVo = new DataVo();
        String authorization = httpRequest.getHeader("Authorization");
        DecodedJWT verify = JwtUtils.verify(authorization);
        Claim id = verify.getClaim("username");

        try {
            String fileName = file.getName();  //文件名

            InputStream inputStream = file.getInputStream(); //获取输入流
            ExcelListener listener = new ExcelListener();
            EasyExcelFactory.read(inputStream, ErpBom.class, listener).headRowNumber(2).build().readAll();
            List<Object> list = listener.getData();
            for (Object o : list) {
                ErpBom erpBom = (ErpBom) o;
                erpBom.setDocumenter(id.asString());
                Date date = new Date("yyyy/mm/dd");
                erpBom.setDocumentMakingTime(date);
                erpBomMapper.insert(erpBom);
            }
            dataVo.ok();
            dataVo.setMessage("上传成功");
            return dataVo;
        } catch (Exception e) {
            dataVo.error();
            dataVo.setMessage("上传失败");
            return dataVo;

        }

    }

    @Override
    public DataVo delBom(ErpBom erpBom) {
        DataVo dataVo = new DataVo();

        if (!StrUtils.IsNull(erpBom.getId())) {
            dataVo.error();
            dataVo.setMessage("数据不存在");
            return dataVo;

        }

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", erpBom.getId());

        ErpBom erpBom1 = erpBomMapper.selectOne(wrapper);

        if (Objects.isNull(erpBom1)) {
            dataVo.error();
            dataVo.setMessage("数据不存在");
            return dataVo;
        }
        if (erpBom1.getSubpartCoding() != "" || erpBom1.getSubpartCoding().equals(null)) {
            dataVo.error();
            dataVo.setMessage("BOM下有子件请删除下面子件再删除BOM");
            return dataVo;

        }

        int delete = erpBomMapper.delete(wrapper);
        if (delete <= 0) {
            dataVo.error();
            dataVo.setMessage("删除失败");
            return dataVo;
        }
        dataVo.ok();
        dataVo.setMessage("删除成功");
        return dataVo;


    }

    @Override
    public DataVo updateBom(ErpBom erpBom) {
        DataVo dataVo = new DataVo();


        QueryWrapper wrapper = new QueryWrapper<>();

        wrapper.eq("id", erpBom.getId());

        int update = erpBomMapper.update(erpBom, wrapper);
        if (update <= 0){
            dataVo.error();
            dataVo.setMessage("更新失败");
            return dataVo;

        }
        dataVo.ok();
        dataVo.setMessage("更新成功");
        dataVo.setData(erpBom);


            return dataVo;
    }


}




