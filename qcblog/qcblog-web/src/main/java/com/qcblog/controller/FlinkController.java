package com.qcblog.controller;

import com.qcblog.pojo.Flink;
import com.qcblog.service.FlinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Flink")
public class FlinkController {
    @Autowired
    private FlinkService flinkService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Flink> findFlinks(){
        return flinkService.findAllList();
    }
}
