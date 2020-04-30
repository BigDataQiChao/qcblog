package com.qcblog.controller;

import com.qcblog.common.Result;
import com.qcblog.pojo.User;
import com.qcblog.service.UserLikeService;
import com.qcblog.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/User")
public class UserController {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());//日志级别
    private final String PREUSER = "user/";

    @Autowired
    private UserService userService;

    @Autowired
    private UserLikeService userLikeService;

    @RequestMapping("/signinInfo")
    @ResponseBody
    public Map map() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        User user = userService.findUserByName(name);
        Map map = new HashMap<>();
        try {
            if (user != null) {
                map.put("userCount", user.getLimitCount());
                map.put("userName", name);
                map.put("userEmail", user.getEmail());
                map.put("userIndus", user.getIndustry());
                map.put("userTelph", user.getTelephone());
                map.put("userStatus", user.getStatus());
                map.put("userImage", user.getImage());
                map.put("userSex", user.getSex());
                map.put("userTName", user.getTruename());
                map.put("userTime", sdf.format(new Date()));
                map.put("userViewNum", user.getViewCount());
                map.put("userId", user.getId());
                map.put("userCarticNum", user.getCarticnum());
                map.put("userIntro", user.getIntro());
                map.put("userEducation", user.getEducation());
                map.put("userSchName", user.getSchName());
                map.put("userWkCondition", user.getWkCondition());
                return map;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.warn("警告：当前处于未登录状态！");
        return map;
    }

    /**
     * 根据ID查询
     */
    @RequestMapping("/findOne")
    @ResponseBody
    public User findOne(Integer id) {
        return userService.selectUserById(id);
    }

    /**
     * 修改
     *
     * @param user
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody User user) {
        try {
            user.setUtime(new Date());
            userService.update(user);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 修改
     *
     * @param user
     * @return
     */
    @RequestMapping("/updateImage")
    @ResponseBody
    public Result updateImage(@RequestBody User user) {
        try {
            user.setUtime(new Date());
            userService.updateImage(user);
            return new Result(true, "更换头像成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "更换头像失败");
        }
    }

    /**
     * 修改密码
     */
    @RequestMapping("/updatePwd")
    @ResponseBody
    public Result updatePwd(@RequestBody User user) {
        User userByName = userService.findUserByName(user.getUsername());
        if (userByName != null) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String pass = bCryptPasswordEncoder.encode(user.getPassword());
            userByName.setPassword(pass);
            userByName.setRepassword(pass);
            try {
                userService.updatePwd(userByName);
                return new Result(true, "修改成功，请回到登录页！");
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false, "修改失败");
            }
        }
        return new Result(false, "修改失败，无此用户信息！");
    }

    /**
     * 查询文章详情作者信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/findOuthor")
    @ResponseBody
    public Map findArticleOneOuthor(@RequestBody Integer id) {
        Map map = new HashMap<>();
        try {
            if (id != null) {
                User outhor = userService.findArticleOneOuthor(id);
                Integer countLike = userLikeService.countByLikeArticle(id);
                Integer countAllLike = userLikeService.countByAllLikeArticle(outhor.getId());
                map.put("OuthorInfo", outhor);
                map.put("CountAllLike", countAllLike);
                map.put("CountLike", countLike);
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.warn("警告：当前处于未登录状态！暂时查询不到该文章的作者信息！");
        return null;
    }

}
