package com.qcblog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 安全框架配置
 *
 * @author 赵起超
 * @date 2018.10.18
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    MyUserDetailsService myUserDetailsService;   //调用用户信息Service

    /**
     * 定制请求的授权规则
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**").permitAll()
                .antMatchers("/**").hasRole("USER");
        /*
        开启自动配置的登录功能,如果是自己的定制的登入页面，那么/userlogin 的get请求是来到登录页面
        /userlogin的post请求是处理认证登录，也就是loginPage中的URL的post请求是处理登录逻辑的。
        没登录的时候，访问会以get的方式访问loginpage的URL来到登录页面
         */
        http.formLogin().usernameParameter("username").passwordParameter("password").loginPage("/userlogin").successForwardUrl("/main").failureUrl("/error-refailure");
        http.exceptionHandling()//权限验证失败进入的页面（只对使用自定义拦截有效）
                .accessDeniedPage("/error");
        /*开启自动配置的注销功能，会访问/logout请求**/
        http.logout().logoutSuccessUrl("/"); //注销成功后，回到首页
        /*开启记住我功能（开启后，springboot会给浏览器发送一个cookies，以后访问网站都会带上这个cookies给springboot验证
        springboot会检查以前某一个用户的cookies的值是什么，如果找到了，这个用户就不用再次登录了
        注销时候springboot会发送命令给浏览器删除cookies）*/
        http.rememberMe().rememberMeParameter("remember-me");
        http.csrf().disable();
    }

    /**
     * 定义认证规则
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //使用自定义认证规则，并且使用BCrypt算法处理密码
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    /**
     * 配置需要跳过的资源
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        //Web层面的拦截，用来跳过的资源
        web.ignoring()
                .antMatchers("/static/**");
    }
}
