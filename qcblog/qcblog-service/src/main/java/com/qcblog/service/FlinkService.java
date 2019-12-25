package com.qcblog.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qcblog.common.PageResult;
import com.qcblog.mapper.FlinkMapper;
import com.qcblog.pojo.Flink;
import com.qcblog.pojo.FlinkExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlinkService {
    @Autowired
    private FlinkMapper flinkMapper;

    public List<Flink> findFlinks(){
        return flinkMapper.selectByExample(null);
    }
    public void add(Flink flink) {
        flinkMapper.insert(flink);
    }


    public void insert(Flink flink){
        flinkMapper.insert(flink);
    }
    public Flink findOne(String flname){
        return flinkMapper.findByName(flname);
    }

    /**
     * 修改
     */
    public void update(Flink flink){
        flinkMapper.updateByPrimaryKey(flink);
    }


    /**
     * 批量删除
     * @param ids
     */
    public void delete(Integer[] ids) {
        for(Integer id:ids){
            flinkMapper.deleteByPrimaryKey(id);
        }
    }
    /**
     * 单体删除
     * @param flink
     */
    public void deleteOne(Flink flink) {
        flinkMapper.deleteOne(flink);
    }
    /**
     * 通过ID 查询
     * @return
     */
    public Flink selectById(Integer id){
        return flinkMapper.selectByPrimaryKey(id);
    }

    public String countById(){
        return flinkMapper.countById();
    }

    public PageResult findPage(Flink flink, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        FlinkExample example=new FlinkExample();
        FlinkExample.Criteria criteria = example.createCriteria();
        if(flink!=null){
            if(flink.getFlname()!=null && flink.getFlname().length()>0){
                criteria.andFlnameLike("%"+flink.getFlname()+"%");
            }
            if(flink.getFlink()!=null && flink.getFlink().length()>0){
                criteria.andFlinkLike("%"+flink.getFlink()+"%");
            }

            if(flink.getFlstatus()!=null && flink.getFlstatus().length()>0){
                criteria.andFlstatusEqualTo(flink.getFlstatus());
            }
        }
        Page<Flink> page= (Page<Flink>)flinkMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 按分页查询
     */
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Flink> page = (Page<Flink>) flinkMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
