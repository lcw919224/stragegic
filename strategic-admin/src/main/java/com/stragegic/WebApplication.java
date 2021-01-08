package com.stragegic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.stragegic.service")
@SpringBootApplication
public class WebApplication {
    public static void main(String[] args) {
       SpringApplication.run(WebApplication.class, args);
    }
}
