package com.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.sys.dao")
@SpringBootApplication
public class SysOperAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysOperAuthApplication.class, args);
    }

}
