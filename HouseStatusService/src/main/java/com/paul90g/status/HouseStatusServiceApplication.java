package com.paul90g.status;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class HouseStatusServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseStatusServiceApplication.class, args);
    }

}
