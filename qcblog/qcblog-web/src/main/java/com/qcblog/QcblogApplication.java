package com.qcblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import tk.mybatis.spring.annotation.MapperScan;


@ServletComponentScan
@MapperScan("com.qcblog.mapper")
@SpringBootApplication
public class QcblogApplication{

    public static void main(String[] args) {
        SpringApplication.run(QcblogApplication.class, args);
    }
}
