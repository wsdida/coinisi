package com.coinisi.gateway.filter;

import cn.hutool.core.util.StrUtil;
import com.coinisi.common.core.constant.UserConstant;
import com.coinisi.common.core.util.JsonUtils;
import com.nimbusds.jose.JWSObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.server.reactive.ServerHttpRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


import java.text.ParseException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 将登录用户的JWT转化成用户信息的全局过滤器
 */
@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {


    @Autowired
    private RedisTemplate redisTemplate;
    private static Logger LOGGER = LoggerFactory.getLogger(AuthGlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (StrUtil.isEmpty(token)) {
            return chain.filter(exchange);
        }
        try {

            //从token中解析用户信息并设置到Header中去
            String realToken = token.replace("Bearer ", "");
            JWSObject jwsObject = JWSObject.parse(realToken);
            String userStr = jwsObject.getPayload().toString();
            LOGGER.info("AuthGlobalFilter.filter() user:{}",userStr);
            redisTemplate.opsForHash().putAll(UserConstant.USER_INFO, JsonUtils.stringToMap(userStr));
            double random = Math.random();
            redisTemplate.opsForValue().set("random",random,3, TimeUnit.SECONDS);
            ServerHttpRequest request = exchange.getRequest().mutate().header("user", userStr).header("signs",String.valueOf(random)).build();
            exchange = exchange.mutate().request(request).build();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }


}
