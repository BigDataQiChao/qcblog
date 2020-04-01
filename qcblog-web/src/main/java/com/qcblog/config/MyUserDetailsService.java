package com.qcblog.config;

import com.qcblog.pojo.User;
import com.qcblog.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息Service
 *
 * @author 赵起超
 * @date 2018.10.18
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());//日志级别
    @Autowired
    UserService userService;//用户Service
    @Autowired
    HttpServletRequest request;//HTTP请求

    /**
     * 判断用户是否存在
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();
        User user = userService.findUserByName(username);
        if (user == null) {
            logger.info("用户信息填写错误!");
            throw new UsernameNotFoundException("用户信息不存在！");
        }else{
            //增加用户缓存
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("username", username);
            //角色
            authorities.add(new SimpleGrantedAuthority(user.getRole()));
            //权限（为了测试，硬编码，实际上应该从数据库中读取）
            authorities.add(new SimpleGrantedAuthority("普通用户"));
            logger.info(user.getUsername() + "角色权限为：" + authorities.toString());
            /*返回用户安全数据信息*/
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        }
    }
}
