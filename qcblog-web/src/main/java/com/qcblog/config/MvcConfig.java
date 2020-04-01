package com.qcblog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 资源映射配置
 *
 * @author 赵起超
 * @date 2019.08.18
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    /**
     * 增加虚拟映射路径
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //String path_win = System.getProperty("user.dir")+"\\qcblog-web\\src\\main\\resources\\static\\img\\assets\\";
        String path_win = System.getProperty("user.dir") + "/config/static/img/assets/";
        String path_un = System.getProperty("user.dir") + "/config/static/img/assets/";
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            registry.addResourceHandler("/img/assets/**").
                    addResourceLocations("file:" + path_win);
        } else {//linux和mac系统
            registry.addResourceHandler("/img/assets/**").
                    addResourceLocations("file:" + path_un);
        }
    }
}

