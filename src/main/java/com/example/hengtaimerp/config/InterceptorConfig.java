package com.example.hengtaimerp.config;

import com.example.hengtaimerp.interceptor.JWTInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    //放行
    private String[] arp = {
            "user/api/login"



    };
    //拦截
    private String[] atr = {

            "/test"

    };
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns(atr)  //拦截路径
                .excludePathPatterns(arp); //放行路径
    }
}
