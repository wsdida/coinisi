package com.coinisi.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/com")
public class AController {
    @GetMapping
    public String te(){
        return "测试";
    }
}
