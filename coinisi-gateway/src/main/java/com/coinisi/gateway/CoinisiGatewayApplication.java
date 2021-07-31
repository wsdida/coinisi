package com.coinisi.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
/*@ComponentScan("com.coinisi.gateway.config.swagger3")*/
public class CoinisiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoinisiGatewayApplication.class);
    }
}
