package com.example.hengtaimerp.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

@Configuration
public class MulterFile {
    /**  
     * 文件上传配置  
     * @return  
     */  
    @Bean  
    public MultipartConfigElement multipartConfigElement() {  
        MultipartConfigFactory factory = new MultipartConfigFactory();  
        //文件最大
        DataSize dataSize = DataSize.ofMegabytes(100);
        factory.setMaxFileSize(dataSize); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(dataSize);
        return factory.createMultipartConfig();  
    }
}