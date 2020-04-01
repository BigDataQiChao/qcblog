package com.qcblog.service;

import com.qcblog.mapper.FlinkMapper;
import com.qcblog.pojo.Flink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlinkService {
    @Autowired
    private FlinkMapper flinkMapper;
    /**
     * 遍历所有链接
     *
     */
    public List<Flink> findAllList(){
        return flinkMapper.selectByExample(null);
    }
}
