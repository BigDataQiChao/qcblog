package com.qcblog.service;

import java.util.List;


import com.qcblog.common.PageResult;
import com.qcblog.mapper.AdminMapper;
import com.qcblog.pojo.Admin;
import com.qcblog.pojo.AdminExample;
import org.springframework.beans.factory.annotation.Autowired;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

/**
 * 管理员接口实现层
 * @author Administrator
 *
 */
@Service
public class AdminService {

	@Autowired
	private AdminMapper adminMapper;
	

	public Admin findOneByName(String adminName) {
		Admin admin = new Admin();
		admin.setAdminName(adminName);
		return adminMapper.selectOne(admin);
	}

	public void insert(Admin admin){
		adminMapper.insert(admin);
	}

	public List<Admin> findAll() {
		return adminMapper.selectByExample(null);
	}

	public void add(Admin admin) {
	      adminMapper.insert(admin);
	}

	
	public Admin findOne(String name) {
		return adminMapper.findByName(name);
	}
	/**
	 * 修改
	 */
	public void update(Admin admin){
		adminMapper.updateByPrimaryKey(admin);
	}

	
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			adminMapper.deleteByPrimaryKey(id);
		}		
	}

	public String countById(){
		return adminMapper.countById();
	}
	
	public PageResult findPage(Admin admin, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		AdminExample example=new AdminExample();
		AdminExample.Criteria criteria = example.createCriteria();
		if(admin!=null){			
						if(admin.getAdminName()!=null && admin.getAdminName().length()>0){
				criteria.andAdminNameLike("%"+admin.getAdminName()+"%");
			}
			if(admin.getAdminPassword()!=null && admin.getAdminPassword().length()>0){
				criteria.andAdminPasswordLike("%"+admin.getAdminPassword()+"%");
			}
		
			if(admin.getStatus()!=null && admin.getStatus().shortValue()>0){
				criteria.andStatusEqualTo(admin.getStatus());
			}
		}
		Page<Admin> page= (Page<Admin>)adminMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 按分页查询
	 */
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Admin> page=   (Page<Admin>) adminMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

}
