package com.jerry.yzgl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jerry.yzgl.yw.dao")
public class YzglApplication {

    public static void main(String[] args) {
        SpringApplication.run(YzglApplication.class, args);
    }

}
