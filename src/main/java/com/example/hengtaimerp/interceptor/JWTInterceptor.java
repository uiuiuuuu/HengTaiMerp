package com.example.hengtaimerp.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.hengtaimerp.utils.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT验证拦截器
 */
public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, Object> map = new HashMap<>();
        //令牌建议是放在请求头中，获取请求头中令牌
        String token = request.getHeader("Authorization");
        if (token == null) {
            map.put("msg", "验证失败");
            map.put("code", 0);
            map.put("state", false);//设置状态
            //将map转化成json，response使用的是Jackson
            String json = new ObjectMapper().writeValueAsString(map);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().print(json);
            return false;
        }
        try {
            JwtUtils.verify(token);//验证令牌
            return true;//放行请求
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            map.put("msg", "验证无效");
            map.put("code", 5);
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            map.put("msg", "令牌已过期,请重新登录");
            map.put("code", 3);
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            map.put("msg", "验证算法不一致");
            map.put("code", 1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "令牌失效");
            map.put("code", 5);
        }
        map.put("state", false);//设置状态
        //将map转化成json，response使用的是Jackson
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(json);
        return false;
    }
}
