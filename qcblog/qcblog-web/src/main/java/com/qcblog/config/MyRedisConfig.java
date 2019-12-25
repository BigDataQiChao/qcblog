package com.qcblog.config;

import com.qcblog.pojo.Article;
import com.qcblog.pojo.Numbers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * Redis缓存、数据服务配置
 * @author 赵起超
 * @date 2018.11.06
 */
@Configuration
public class MyRedisConfig {

    /**
     * Redis模板配置
     *
     * @param redisConnectionFactory
     * @return
     * @throws UnknownHostException
     */
    @Bean
    public RedisTemplate<Object, Numbers> numbersRedisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Numbers> template = new RedisTemplate<Object, Numbers>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Numbers> serializer = new Jackson2JsonRedisSerializer<Numbers>(Numbers.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

    /**
     * 文章中调用Redis缓存
     *
     * @param redisConnectionFactory
     * @return
     * @throws UnknownHostException
     */
    @Bean("articleRedisTemplate")
    public RedisTemplate<Object, Article> articleRedisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Article> template = new RedisTemplate<Object, Article>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Article> serializer = new Jackson2JsonRedisSerializer<Article>(Article.class);
        template.setDefaultSerializer(serializer);
        return template;
    }
}
