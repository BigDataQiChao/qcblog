package com.qcblog;

import com.qcblog.mapper.ArticleMapper;
import com.qcblog.mapper.NumbersMapper;
import com.qcblog.pojo.Article;
import com.qcblog.pojo.Numbers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class TestEncoder {
    @Autowired
    private ArticleMapper articleMapper;
    @Test
    public void encoder(){
        String password = "qichao";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String enPassword = encoder.encode(password);
        System.out.println(enPassword);
    }
    @Test
    public void findAllList(){
        System.out.println(articleMapper.selectByExample(null));
    }
}
