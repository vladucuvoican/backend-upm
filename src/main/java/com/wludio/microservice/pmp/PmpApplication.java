package com.wludio.microservice.pmp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class PmpApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmpApplication.class, args);
    }

}
