package com.ldn.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
/**
 *可以缓存
 */
@EnableCaching
public class SMApplication {

    public static void main(String[] args) {
        SpringApplication.run(SMApplication.class, args);
    }
}
