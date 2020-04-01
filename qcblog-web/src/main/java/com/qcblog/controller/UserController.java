package com.qcblog.controller;

import com.qcblog.common.Result;
import com.qcblog.pojo.User;
import com.qcblog.service.UserService;
import org.apache.ibatis.annotations.Param;
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
    private final String PREUSER = "user/";
    @Autowired
    private UserService userService;

    @RequestMapping("/signinInfo")
    @ResponseBody
    public Map map() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        User user = userService.findUserByName(name);
        Map map = new HashMap<>();
        if (user.getLimitCount() != null) {
            map.put("userCount", user.getLimitCount());
        }
        map.put("signinName", name);
        map.put("signinEmail", user.getEmail());
        map.put("signinIndus", user.getIndustry());
        map.put("signinTelph", user.getTelephone());
        map.put("signinStatus", user.getStatus());
        map.put("signinImage", user.getImage());
        map.put("signinSex", user.getSex());
        map.put("signinTame", user.getTruename());
        map.put("signinTime", sdf.format(new Date()));
        map.put("signinViewNum", user.getViewCount());
        map.put("signinId", user.getId());
        map.put("signinCarticNum", user.getCarticnum());
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
}
