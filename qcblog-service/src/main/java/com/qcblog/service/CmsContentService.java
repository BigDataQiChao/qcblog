package com.qcblog.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qcblog.common.PageResult;
import com.qcblog.mapper.CmsContentMapper;
import com.qcblog.pojo.CmsContent;
import com.qcblog.pojo.CmsContentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmsContentService {

    @Autowired
    private CmsContentMapper cmsContentMapper;

    public void insertCmsContent(CmsContent cmsContent){
        cmsContentMapper.insert(cmsContent);
    }

    public List<CmsContent> findCmsAll(){
        return cmsContentMapper.findCmsAll();
    }
    public PageResult findPage(CmsContent cmsContent, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        CmsContentExample example=new CmsContentExample();
        CmsContentExample.Criteria criteria = example.createCriteria();
        if(cmsContent!=null){
            if(cmsContent.getTitle()!=null && cmsContent.getTitle().length()>0){
                criteria.andTitleEqualTo(cmsContent.getTitle());
            }
            if(cmsContent.getStatus()!=null && cmsContent.getStatus().length()>0){
                criteria.andStatusEqualTo(cmsContent.getTitle());
            }
        }
        Page<CmsContent> page= (Page<CmsContent>)cmsContentMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }
    /**
     * 按分页查询
     */
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<CmsContent> page = (Page<CmsContent>) cmsContentMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }
    /**
     * 批量删除
     * @param ids
     */
    public void delete(Integer[] ids) {
        for(Integer id:ids){
            cmsContentMapper.deleteByPrimaryKey(id);
        }
    }

    public CmsContent findCmsOne(String id){
        return cmsContentMapper.findCmsOne(id);
    }

    public void updateCms(CmsContent cmsContent){
        cmsContentMapper.updateByPrimaryKey(cmsContent);
    }
}
