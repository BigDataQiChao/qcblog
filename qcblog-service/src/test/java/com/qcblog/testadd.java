package com.qcblog;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public class testadd {
    @Test
    public void encoder(){
        String password = "liangjunhua";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String enPassword = encoder.encode(password);
        System.out.println(enPassword);
    }
}