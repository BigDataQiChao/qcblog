package com.qcblog.controller;

import com.qcblog.common.Result;
import com.qcblog.pojo.Article;
import com.qcblog.pojo.Numbers;
import com.qcblog.pojo.Signinlog;
import com.qcblog.pojo.User;
import com.qcblog.service.ArticleService;
import com.qcblog.service.LogService;
import com.qcblog.service.NumbersService;
import com.qcblog.service.UserService;
import org.slf4j.LoggerFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能逻辑跳转控制层
 * author: 起超
 */
@Controller
public class LogicalController {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());//日志级别
    private final String ERROR = "error/";
    private final String PREFIX = "page/";
    private final String DETAILS = "particulars/";
    private final String PREUSER = "user/";
    private final String SUPPORT = "support/";
    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;
    @Autowired
    private NumbersService numbersService;
    @Autowired
    private LogService logService;

    /**
     * 欢迎页
     *
     * @return
     */
    @GetMapping("/")
    public String index() {
        return PREUSER + "index";
    }

    /**
     * 登出跳转逻辑
     *
     * @return
     */
    @GetMapping("/signout")
    public String signout(HttpServletRequest request, HttpServletResponse response) {
        //获得注销用户的信息
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            //设置为离线状态
            System.out.println("实时获取退出的用户：" + auth.getName());
            String host = request.getHeader("host");
            User user = userService.findUserByName(auth.getName());
            user.setLastTime(new Date());
            user.setLastIp(host);
            userService.update(user);
            new SecurityContextLogoutHandler().logout(request, response, auth);
            logger.info("获取退出用户信息成功，信息如→{}", user.toString());
        } else {
            logger.info("获取退出时用户为空!");
        }
        if (auth.getName() != null) {
            Signinlog limitlog = logService.findLimitByName(auth.getName());
            limitlog.setUtime(new Date());
            limitlog.setIsDelete("0");
            logService.update(limitlog);
            logger.info("更新日志成功，信息如→{}", limitlog.toString());
        }
        return "redirect:/";
    }

    /**
     * 登录成功逻辑跳转
     *
     * @return
     */
    @RequestMapping("/main")
    public String main(String name, HttpServletRequest request) {
        name = SecurityContextHolder.getContext().getAuthentication().getName();
        Signinlog signinlog = new Signinlog();
        int countUserId = userService.countByArticleUserId(name);
        User user = userService.findUserByName(name);
        System.out.println("获取实时登录用户:" + user.getUsername());
        user.setLastTime(new Date());
        String host = request.getHeader("host");
        signinlog.setLogip(host);
        signinlog.setIsDelete("0");
        signinlog.setLogstatus("1");
        signinlog.setLogtime(new Date());
        signinlog.setLogname(name);
        signinlog.setLogtype("平台用户");
        try {
            logService.insert(signinlog);
            userService.update(user);
            userService.updateCarticnum(countUserId, name);
            logger.info("获取用户信息成功，信息如→{}", user.toString());
        } catch (Exception e) {
            logger.error("/main方法体异常，原因如→{}",e.getMessage());
             e.printStackTrace();
        }
        return "redirect:/";
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @RequestMapping("/name")
    @ResponseBody
    public Map loginName() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Map map = new HashMap<>();
        map.put("signinName", name);
        return map;
    }

    @RequestMapping("/number")
    @ResponseBody
    public Map number() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findUserByName(name);
        Map map = new HashMap<>();
        Numbers numbers = new Numbers();
        if (name != "anonymousUser") {
            numbersService.updateNumber(numbers, user);
            Numbers queryNumber = numbersService.queryNumber(1);
            map.put("numbers", queryNumber.getWnumber());
            return map;
        } else {
            Numbers queryNumber = numbersService.queryNumber(1);
            map.put("numbers", queryNumber.getWnumber());
        }
        return map;
    }

    /**
     * 关于自己
     *
     * @return
     */
    @GetMapping("/about")
    public String about() {
        return PREUSER + "about";
    }

    /*游戏开始*/
    @GetMapping("/play")
    public String play() {
        return PREUSER + "play";
    }

    @GetMapping("/play-cards")
    public String playcards() {
        return PREUSER + "play-cards";
    }

    @GetMapping("/play-frog")
    public String playfrog() {
        return PREUSER + "play-frog";
    }

    @GetMapping("/play-cube")
    public String playcube() {
        return PREUSER + "play-cube";
    }

    @GetMapping("/play-gobang")
    public String playgobang() {
        return PREUSER + "play-gobang";
    }
    /*游戏结束*/

    /**
     * 去修改个人资料
     */
    @GetMapping("/updateUser")
    public String updateUser() {
        return PREUSER + "developer_edit";
    }

    /**
     * 详情页
     *
     * @return
     */
    @GetMapping("/detail")
    public String article_detail() {
        return DETAILS + "article_detail";
    }

    /**
     * 留言
     *
     * @return
     */
    @GetMapping("/comment")
    public String comment() {
        return PREUSER + "comment";
    }

    /**
     * 专题
     *
     * @return
     */
    @GetMapping("/learn")
    public String learn() {
        return PREUSER + "learn";
    }

    /**
     * 文章页
     *
     * @return
     */
    @GetMapping("/article")
    public String article() {
        return DETAILS + "article";
    }

    /**
     * 新增文章
     */
    @GetMapping("/addArticle")
    public String addArticle() {
        return PREUSER + "add-article";
    }

    /**
     * 说说
     *
     * @return
     */
    @GetMapping("/moodList")
    public String moodList() {
        return PREUSER + "moodList";
    }

    /**
     * 登陆页
     *
     * @return
     */
    @GetMapping("/userlogin")
    public String loginPage(HttpServletRequest request) {
        return "login";
    }

    /**
     * 注册页
     *
     * @return
     */
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * 平台协议
     *
     * @return
     */
    @GetMapping("/protocol")
    public String protocol() {
        return SUPPORT + "protocol";
    }

    /**
     * 文档中心
     *
     * @return
     */
    @GetMapping("/pldoc")
    public String pldoc() {
        return SUPPORT + "pldoc";
    }

    /**
     * 个人中心
     *
     * @return
     */
    @GetMapping("/personal")
    public String personal() {
        return PREUSER + "developer";
    }

    /**
     * 平台介绍
     *
     * @return
     */
    @GetMapping("/recommend")
    public String recommend() {
        return SUPPORT + "recommend";
    }

    /**
     * 首页
     *
     * @return
     */
    @GetMapping("/logIn")
    public String logInPage() {
        return PREUSER + "index";
    }

    /**
     * 文章详情页
     * 文章访问量控制层
     */
    @GetMapping("/articles")
    public String articles(@Param("atname") String atname) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Article articleServiceOne = articleService.findOne(atname);
        User user = userService.findUserByName(name);
        if (user != null) {
            userService.addViewCount(user);
        }
        if (articleServiceOne != null) {
            articleService.upateArticles(articleServiceOne);
        }
        return DETAILS + "findArticle";
    }

    /**
     * 失败页开始
     */
    @GetMapping("/error")
    public String errorPage() {
        return ERROR + "error";
    }

    @GetMapping("/error-repetition")
    public String errorRepetition() {
        return ERROR + "error-repetition";
    }

    @GetMapping("/error-refailure")
    public String Refailure() {
        return ERROR + "error-refailure";
    }
    /*失败页结束*/

    /**
     * 注册功能
     *
     * @param user
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Result insertPage(@RequestBody User user) {
        if (user.getUsername() != null && user.getUsername() != "") {
            User userByName = userService.findUserByName(user.getUsername());
            if (userByName == null) {
                if (user.getPassword().equals(user.getRepassword())) {
                    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                    String pass = bCryptPasswordEncoder.encode(user.getPassword());
                    user.setRepassword(pass);
                    user.setPassword(pass);
                }
                user.setEmail(user.getEmail());
                user.setTelephone(user.getTelephone());
                user.setLimitCount(1);
                user.setLastTime(new Date());
                user.setRole("USER");
                user.setIsDelete("0");
                user.setStatus("1");
                try {
                    userService.insert(user);
                    Thread.sleep(4000);
                    return new Result(true, "恭喜您，注册成功！");
                } catch (Exception e) {
                    e.printStackTrace();
                    return new Result(true, "注册出现异常！");
                }
            } else {
                try {
                    return new Result(true, "该用户名已被注册！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return new Result(true, "注册失败，请重试！");
    }

    /**
     * 去修改密码
     */
    @GetMapping("/toUpdatePwd")
    public String toUpdatePwd() {
        return "forgetpwd";
    }

    /**
     * 获取当前IP
     */
    @RequestMapping("/getIp")
    @ResponseBody
    public Map getIp(HttpServletRequest request) {
        Map map = new HashMap<>();
        String referer = request.getHeader("referer");
        map.put("signinReferer", referer);
        return map;
    }

    /**
     * 核验成功页面
     *
     * @return
     */
    @GetMapping("/check")
    public String check() {
        return "check_over";
    }
}
