package com.coinisi.system.admin.component;

import com.coinisi.system.admin.service.impl.SysPermissionServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@AllArgsConstructor
@Slf4j
public class RedisOauthComponent implements CommandLineRunner {


    private SysPermissionServiceImpl service;
    @Override
    public void run(String... args) throws Exception {
     service.refreshPremission();
    }
}
