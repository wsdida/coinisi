package com.coinisi.system.admin.config;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Slf4j
public class GlobalInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {


        String signs = request.getHeader("signs");
        if(StrUtil.isNotBlank(signs)){
            String key = (String) redisTemplate.opsForValue().get("random");
            if(!StrUtil.isBlank(key) && signs.equals(key)){
                return true;
            }
        }
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
       writer.write("失败");
        return false;
    }
}

