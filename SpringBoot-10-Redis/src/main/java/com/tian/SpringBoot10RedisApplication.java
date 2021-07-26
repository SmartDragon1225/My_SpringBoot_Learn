package com.tian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringBoot10RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot10RedisApplication.class, args);
    }

}
