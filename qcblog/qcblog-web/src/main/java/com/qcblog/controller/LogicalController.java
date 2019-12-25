package com.qcblog.controller;

import com.qcblog.pojo.Article;
import com.qcblog.pojo.Numbers;
import com.qcblog.pojo.Signinlog;
import com.qcblog.pojo.User;
import com.qcblog.service.ArticleService;
import com.qcblog.service.LogService;
import com.qcblog.service.NumbersService;
import com.qcblog.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
 *  主要功能控制层
 *  author: 起超
 */
@Controller
public class LogicalController {
    private final String PREFIX = "page/";
    private final String ERROR = "error/";
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
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }
    /**
     * 登出跳转逻辑
     * @return
     */
    @GetMapping("/signout")
    public String signout(HttpServletRequest request,HttpServletResponse response){
        //获得注销用户的信息
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            //设置为离线状态
            System.out.println("实时获取退出的用户："+auth.getName());
            String host = request.getHeader("host");
            User user = userService.findUserByName(auth.getName());
            user.setLastTime(new Date());
            user.setLastIp(host);
            userService.update(user);
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        Signinlog limitlog = logService.findLimitByName(auth.getName());
        limitlog.setUtime(new Date());
        limitlog.setIsDelete("0");
        logService.update(limitlog);
        return "index";
    }
    /**
     * 登录成功逻辑跳转
     * @return
     */
    @RequestMapping("/main")
    public String main(String name,HttpServletRequest request) {
        name = SecurityContextHolder.getContext().getAuthentication().getName();
        Signinlog signinlog = new Signinlog();
        User user = userService.findUserByName(name);
        user.setLastTime(new Date());
        String host = request.getHeader("host");
        signinlog.setLogip(host);
        signinlog.setIsDelete("0");
        signinlog.setLogstatus("1");
        signinlog.setLogtime(new Date());
        signinlog.setLogname(name);
        signinlog.setLogtype("平台用户");
        logService.insert(signinlog);
        userService.update(user);
        return "index";
    }
    /**
     * 获取用户信息
     * @return
     */
    @RequestMapping("/name")
    @ResponseBody
    public Map loginName(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Map map = new HashMap<>();
        map.put("signinName", name);
        return map;
    }

    @RequestMapping("/number")
    @ResponseBody
    public Map number(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findUserByName(name);
        Map map = new HashMap<>();
        Numbers numbers = new Numbers();
        if(name!="anonymousUser") {
            numbersService.updateNumber(numbers,user);
            Numbers queryNumber = numbersService.queryNumber(1);
            map.put("numbers", queryNumber.getWnumber());
            return map;
        }else{
            Numbers queryNumber = numbersService.queryNumber(1);
            map.put("numbers", queryNumber.getWnumber());
        }
        return map;
    }
    /**
     * 关于自己
     * @return
     */
    @GetMapping("/about")
    public String about() {
        return "about";
    }

    /*游戏开始*/
    @GetMapping("/play")
    public String play() {
        return "play";
    }
    @GetMapping("/play-cards")
    public String playcards() {
        return "play-cards";
    }
    @GetMapping("/play-frog")
    public String playfrog() {
        return "play-frog";
    }
    @GetMapping("/play-cube")
    public String playcube() {
        return "play-cube";
    }
    @GetMapping("/play-gobang")
    public String playgobang() {
        return "play-gobang";
    }
    /*游戏结束*/
    /**
     * 详情页
     * @return
     */
    @GetMapping("/detail")
    public String article_detail() {
        return "article_detail";
    }
    /**
     * 留言
     * @return
     */
    @GetMapping("/comment")
    public String comment() {
        return "comment";
    }
    /**
     * 文章页
     * @return
     */
    @GetMapping("/article")
    public String article() {
        return PREFIX+"article";
    }
    /**
     * 说说
     * @return
     */
    @GetMapping("/moodList")
    public String moodList() {
        return "moodList";
    }
    /**
     * 登陆页
     * @return
     */
    @GetMapping("/userlogin")
    public String loginPage(HttpServletRequest request) {
        return "login";
    }
    @GetMapping("/logIn")
    public String logInPage() {
        return "index";
    }

    /**
     * 文章详情页
     * 文章访问量控制层
     */
    @GetMapping("/articles")
    public String articles(@Param("atname")String atName) {
        Article articleServiceOne = articleService.findOne(atName);
        if(articleServiceOne!=null){
            articleService.upateArticles(articleServiceOne);
        }
        return PREFIX+"findArticle";
    }

    /**
     *
     * 失败页开始
     */
    @GetMapping("/error")
    public String errorPage(){
        return "error";
    }
    @GetMapping("/error-repetition")
    public String errorRepetition(){
        return ERROR+"error-repetition";
    }
    @GetMapping("/error-refailure")
    public String Refailure(){
        return ERROR+"error-refailure";
    }
    /*失败页结束*/

    /**
     * 注册功能
     * @param user
     * @return
     */
    @PostMapping("/insert")
    public String insertPage(User user){
        if(user.getUsername()!=null&&user.getUsername()!=""){
            User userByName = userService.findUserByName(user.getUsername());
            if(userByName == null){
                if(user.getPassword().equals(user.getRepassword())){
                    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                    String pass = bCryptPasswordEncoder.encode(user.getPassword());
                    user.setRepassword(pass);
                    user.setPassword(pass);
                    user.setLastTime(new Date());
                    user.setLimitCount(1);
                    user.setRole("USER");
                    user.setIsDelete("0");
                    user.setStatus("1");
                try{
                    userService.insert(user);
                    Thread.sleep(4000);
                    return "login";
                }catch (Exception e){
                    e.printStackTrace();
                 }
                }else{
                    try{
                        return "redirect:/error-refailure";
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }else{
                try{
                    return "redirect:/error-repetition";
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
        return "login";
    }

}
