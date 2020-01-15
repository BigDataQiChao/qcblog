package com.qcblog.controller;

import com.qcblog.common.IpUtil;
import com.qcblog.pojo.Admin;
import com.qcblog.pojo.Signinlog;
import com.qcblog.pojo.Statistics;
import com.qcblog.service.AdminService;
import com.qcblog.service.LogService;
import com.qcblog.service.StatisticsService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 逻辑跳转控制层
 * @author 赵起超
 * @date 2019.10.11
 */
@Controller
public class LogicalController {
    //自定义静态前缀
    private final String PREFIX = "admin/";

    @Autowired
    private AdminService adminService;

    @Autowired
    private LogService logService;

    @RequestMapping("/signinName")
    @ResponseBody
    public Map map() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        List<GrantedAuthority> authorities = new ArrayList<>();
        Map map = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Admin admin = adminService.findOneByName(name);
        if(admin.getIsSuperadmin()==1){
            authorities.add(new SimpleGrantedAuthority("超级管理员"));
        }else{
            authorities.add(new SimpleGrantedAuthority("普通管理员"));
        }
        String numbers = adminService.countById();
        String nums = String.valueOf(admin.getUserId());
        Date date = new Date();
        map.put("signinName", name);
        map.put("signinTime", sdf.format(date));
        map.put("signinRole", authorities.toString());
        map.put("signinNums", nums);
        map.put("signinNumbers", numbers);
        return map;
    }

    @RequestMapping("/signinIp")
    @ResponseBody
    public Map getIp(HttpServletRequest request) {
        Map map = new HashMap<>();
        Enumeration e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String name = (String)e.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + " = " + value);
        }
        String cookie = request.getHeader("cookie");
        String osName = System.getProperty("os.name" );
        String host = request.getHeader("host");
        String language = request.getHeader("accept-language");
        String connection = request.getHeader("connection");
        String referer = request.getHeader("referer");
        map.put("signinIp", IpUtil.getIpAddr(request));
        map.put("signinOSName", osName);
        map.put("signinCookie", cookie);
        map.put("signinHost", host);
        map.put("signinLanguage", language);
        map.put("signinConnection", connection);
        map.put("signinReferer", referer);
        return map;
    }
    /**
     * 登录成功后跳转逻辑
     * @param name
     * @return
     */
    @RequestMapping("/index")
    public String index(String name,HttpServletRequest request){
        name = SecurityContextHolder.getContext().getAuthentication().getName();
        Signinlog signinlog = new Signinlog();
        Admin admin = adminService.findOneByName(name);
        admin.setSignintime(new Date());
        admin.setUserId(admin.getUserId()+1);
        String host = request.getHeader("host");
        signinlog.setLogip(host);
        signinlog.setIsDelete("0");
        signinlog.setLogstatus("1");
        signinlog.setLogtime(new Date());
        signinlog.setLogname(name);
        signinlog.setLogtype("管理员");
        logService.insert(signinlog);
        adminService.update(admin);
        return PREFIX+"index";
    }
    /**
     * 核验页面
     * @return
     */
    @GetMapping("/check")
    public String check(){
        return "check_over";
    }

    /**
     * 主页
     * @return
     */
    @GetMapping("/main")
    public String main(){
        return PREFIX+"index";
    }
    /**
     * SpringBoot自定义登录逻辑
     * @return
     */
    @GetMapping("/signin")
    public String userlogin(){
        return "login";
    }

    /**
     * 登录验证失败跳转逻辑
     * @return
     */
    @RequestMapping("/errorSignin")
    public String signinerror(String name,HttpServletRequest request){
        /*name = SecurityContextHolder.getContext().getAuthentication().getName();*/
        Signinlog signinlog = new Signinlog();
        String host = request.getHeader("host");
        signinlog.setLogip(host);
        signinlog.setIsDelete("0");
        signinlog.setLogstatus("0");
        signinlog.setLogtime(new Date());
        signinlog.setLogname(name);
        signinlog.setLogtype("管理员");
        logService.insert(signinlog);
        return "error-signin";
    }

    /**
     * 登出跳转逻辑
     * @return
     */
    @GetMapping("/signout")
    public String signout(HttpServletRequest request,HttpServletResponse response){
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        Signinlog signinlog = new Signinlog();
        if (auth != null){
            System.out.println("实时获取退出的用户："+auth.getName());
            Admin admin = adminService.findOneByName(auth.getName());
            admin.setSigouttime(new Date());
            adminService.update(admin);
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        Signinlog limitlog = logService.findLimitByName(auth.getName());
        limitlog.setUtime(new Date());
        limitlog.setIsDelete("0");
        logService.update(limitlog);
        return "login";
    }
    /**
     * 自定义add前缀跳转逻辑
     */
    /*------------开始----------------------*/
    @GetMapping("/addarticle")
    public String addarticle(){
        return PREFIX+"add-article";
    }
    @GetMapping("/addflink")
    public String addflink(){
        return PREFIX+"add-flink";
    }
    @GetMapping("/addnotice")
    public String addnotice(){
        return PREFIX+"add-notice";
    }
    /*------------结束----------------------*/

    /**
     * 文章管理跳转逻辑
     * @return
     */
    @GetMapping("/article")
    public String article(){
        return PREFIX+"article";
    }
    /**
     * 导航栏管理跳转逻辑
     * @return
     */
    @GetMapping("/category")
    public String category(){
        return PREFIX+"category";
    }

    /**
     * 个性说说管理跳转逻辑
     * @return
     */
    @GetMapping("/talk")
    public String comment(){
        return PREFIX+"talk";
    }
    /**
     * 友情链接管理跳转逻辑
     * @return
     */
    @GetMapping("/flink")
    public String flink(){
        return PREFIX+"flink";
    }
    /**
     * 修改文章跳转逻辑
     * @return
     */
    @GetMapping("/updatearticle")
    public String updatearticle(){
        return PREFIX+"update-article";
    }
    /**
     * 前端栏目跳转逻辑
     * @return
     */
    @GetMapping("/updatecategory")
    public String updatecategory(){
        return PREFIX+"update-category";
    }
    /**
     * 文章友情链接管理跳转逻辑
     * @return
     */
    @GetMapping("/updateflink")
    public String updateflink(){
        return PREFIX+"update-flink";
    }
    /**
     * 登录日志跳转逻辑
     * @return
     */
    @GetMapping("/loginlog")
    public String loginlog(){
        return PREFIX+"loginlog";
    }

    /**
     * 用户管理跳转逻辑
     * @return
     */
    @GetMapping("/manageuser")
    public String manageuser(){
        return PREFIX+"manage-user";
    }
    /**
     * 通知公告管理跳转逻辑
     * @return
     */
    @GetMapping("/notice")
    public String notice(){
        return PREFIX+"notice";
    }
    /**
     * 阅读权限设置跳转逻辑
     * @return
     */
    @GetMapping("/readset")
    public String readset(){
        return PREFIX+"readset";
    }
    /**
     * 常规配置跳转逻辑
     * @return
     */
    @GetMapping("/setings")
    public String setings(){
        return PREFIX+"setings";
    }


}
