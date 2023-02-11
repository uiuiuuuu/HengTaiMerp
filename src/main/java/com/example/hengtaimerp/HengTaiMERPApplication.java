package com.example.hengtaimerp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.hengtaimerp.mapper")
public class HengTaiMERPApplication {

    public static void main(String[] args) {
        SpringApplication.run(HengTaiMERPApplication.class, args);
    }

}
