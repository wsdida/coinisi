package com.coinisi.auth;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CoinisiAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoinisiAuthApplication.class);
    }
}
