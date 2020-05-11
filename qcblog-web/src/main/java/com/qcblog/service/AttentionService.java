package com.qcblog.service;

import com.qcblog.mapper.AttentionMapper;
import com.qcblog.pojo.Attention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttentionService {

    @Autowired
    private AttentionMapper attentionMapper;

    public List<Attention> checkIsAttention(Integer focusId, Integer focusedId){
        return attentionMapper.checkIsAttention(focusId,focusedId);
    }

    public void insertAttention(Attention attention){
        attentionMapper.insert(attention);
    }

    public void deleAttention(Integer focusId, Integer focusedId){
        attentionMapper.deleAttention(focusId, focusedId);
    }
}
