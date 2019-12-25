package com.qcblog.controller;

import java.text.SimpleDateFormat;
import java.util.*;


import com.qcblog.common.IpUtil;
import com.qcblog.common.PageResult;
import com.qcblog.common.RandomTest;
import com.qcblog.common.Result;
import com.qcblog.pojo.Admin;
import com.qcblog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * 管理员控制层
 * @author 赵起超
 * @date 2019.10.11
 */
@Controller
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/findAll")
	public List<Admin> findAll() {
		System.out.println(adminService.findAll());
			return adminService.findAll();
	}
	/**
	 * 通过name查询实体
	 * @param name
	 * @return
	 */
	@RequestMapping("/findOne")
	@ResponseBody
	public Admin findOne(String name){
		return adminService.findOneByName(name);
	}

	/**
	 * 新增普通管理员
	 *
	 * @param admin
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Result add(@RequestBody Admin admin) {
		if (admin.getAdminName() != null && admin.getAdminName() != "") {
			Admin articleByName = adminService.findOne(admin.getAdminName());
			if (articleByName != null) {
				admin.setAdminName(admin.getAdminName());
				try {
					adminService.insert(admin);
					return new Result(true, "修改成功");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return new Result(false, "修改的内容不存在！！！");
		} else {
			return new Result(false, "出现null漏洞！！！");
		}
	}
	/**
	 * 随机码
	 * @return
	 */
	@RequestMapping("/randomCode")
	public Result randomCode() {
		System.out.println("--------随机码开始--------");
		RandomTest random = new RandomTest();
		String verifyCode = random.verifyCode();
		System.out.println(verifyCode);
		System.out.println("--------随机码结束--------");
		return new Result (true,"随机码："+verifyCode);
		}
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public PageResult findPage(int page, int rows){
		return adminService.findPage(page, rows);
	}
	/**
	 * 修改
	 * @param admin
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Result update(@RequestBody Admin admin){
		try {
			adminService.update(admin);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	@RequestMapping("/delete")
	@ResponseBody
	public Result delete(Integer[] ids) {
		try {
			adminService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	@RequestMapping("/search")
	@ResponseBody
	public PageResult search(@RequestBody Admin admin, int page, int rows  ){
		return adminService.findPage(admin, page, rows);		
	}
	/*@RequestMapping( value= "getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片  
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容  
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        RandomCode randomCode = new RandomCode();
        try {
            randomCode.getRandcode(request, response);//输出验证码图片方法  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	    @RequestMapping(value = "checkVerify")
	    @ResponseBody
	    public String checkVerify(String inputStr, HttpSession session){
	        //从session中获取随机数
	        String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
	        if(random.equals(inputStr)){
	            return "TURE";//验证码正确
	        }else{
	            return "FALSE";//验证码错误
	        }
	    } */
}
