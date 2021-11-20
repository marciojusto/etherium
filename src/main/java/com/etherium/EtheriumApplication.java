package com.etherium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EtheriumApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtheriumApplication.class, args);
    }

}
