package com.qcblog.controller;

import com.qcblog.common.PageResult;
import com.qcblog.common.Result;
import com.qcblog.pojo.User;
import com.qcblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 平台用户控制层
 * @author 赵起超
 * @Date 2019.10.23
 */
@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAll() {
        return userService.findAll();
    }
    /**
     * 通過name查詢实体
     * @param name
     * @return
     */
    @RequestMapping("/findOne")
    @ResponseBody
    public User findOne(String name){
        return userService.findOne(name);
    }

    /**
     * 新增普通管理员
     *
     * @param user
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Result add(@RequestBody User user) {
        if (user.getUsername() != null && user.getUsername() != "") {
            User articleByName = userService.findOne(user.getUsername());
            if (articleByName != null) {
                user.setUsername(user.getUsername());
                try {
                    userService.insert(user);
                    return new Result(true, "新增成功");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return new Result(false, "新增的内容不存在！！！");
        } else {
            return new Result(false, "出现null漏洞！！！");
        }
    }

    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findPage")
    @ResponseBody
    public PageResult findPage(int page, int rows){
        return userService.findPage(page, rows);
    }
    /**
     * 修改
     * @param user
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody User user){
        try {
            if (user.getPassword().equals(user.getRepassword())){
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                String encode = bCryptPasswordEncoder.encode(user.getPassword());
                user.setPassword(encode);
                user.setRepassword(encode);
            }
            user.setUpdateTime(new Date());
            userService.update(user);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Result deleteUser(Integer[] ids) {
        try {
            userService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
    /**
     * 单体删除
     * @param id
     * @return
     */
    @RequestMapping("/deleteOne")
    @ResponseBody
    public Result deleteUserOne(Integer id) {
        try {
            User user = userService.selectById(id);
            user.setIsDelete("1");
            userService.deleteOne(user);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
    /**
     * 用户禁用
     * @param name
     * @return
     */
    @RequestMapping("/forbiddenOne")
    @ResponseBody
    public Result forbiddenUserOne(String name) {
        try {
            User user = userService.findOne(name);
            user.setStatus("0");
            user.setUpdateTime(new Date());
            userService.updateForbidden(user);
            return new Result(true, "禁用成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "禁用失败");
        }
    }
    /**
     * 用户禁用
     * @param name
     * @return
     */
    @RequestMapping("/enabledOne")
    @ResponseBody
    public Result enabledUserOne(String name) {
        try {
            User user = userService.findOne(name);
            user.setStatus("1");
            user.setUpdateTime(new Date());
            userService.updateForbidden(user);
            return new Result(true, "启用成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "启用失败");
        }
    }
    @RequestMapping("/search")
    @ResponseBody
    public PageResult search(@RequestBody User user, int page, int rows  ){
        return userService.findPage(user, page, rows);
    }
    @RequestMapping("/count")
    @ResponseBody
    public Map countById(){
        String countUser = userService.countById();
        Map map = new HashMap<>();
        map.put("countUser", countUser);
        return map;
    }
}
