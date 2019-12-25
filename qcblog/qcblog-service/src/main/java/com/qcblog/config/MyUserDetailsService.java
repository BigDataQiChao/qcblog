package com.qcblog.config;

import com.qcblog.pojo.Admin;
import com.qcblog.pojo.User;
import com.qcblog.service.AdminService;
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
    AdminService adminService;//用户Service
    @Autowired
    HttpServletRequest request;//HTTP请求

    /**
     * 判断用户是否存在
     *
     * @param adminname
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String adminname) throws UsernameNotFoundException {
        Admin admin = adminService.findOneByName(adminname);
        List<GrantedAuthority> authorities = new ArrayList<>();
            if (admin == null) {
                logger.info("管理员不存在!");
                throw new UsernameNotFoundException("管理员不存在!");
            }else{
                //增加用户缓存
                HttpSession session = request.getSession();
                session.setAttribute("user", admin);
                session.setAttribute("adminname", adminname);
                //角色
                if(admin.getIsSuperadmin()==1){
                    authorities.add(new SimpleGrantedAuthority("超级管理员"));
                }else{
                    authorities.add(new SimpleGrantedAuthority("普通管理员"));
                }
                //管理员状态
                if(admin.getStatus()==1) {
                    authorities.add(new SimpleGrantedAuthority("正常"));
                }else{
                    authorities.add(new SimpleGrantedAuthority("被注销"));
                }
                logger.info(admin.getAdminName() + "管理员状态：" + authorities.toString());
                return new org.springframework.security.core.userdetails.User(admin.getAdminName(), admin.getAdminPassword(), authorities);
            }
        /*返回用户安全数据信息*/
    }
}
