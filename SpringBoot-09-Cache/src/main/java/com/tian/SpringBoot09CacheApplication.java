package com.tian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching//开启缓存
public class SpringBoot09CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot09CacheApplication.class, args);
    }

}
