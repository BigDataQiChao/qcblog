package com.qcblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.qcblog.mapper")
@SpringBootApplication
public class QcblogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(QcblogServiceApplication.class, args);
    }
}

