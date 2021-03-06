package com.qcblog.controller;

import com.qcblog.common.FileUtils;
import com.qcblog.common.Result;
import com.qcblog.common.UploadUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;
@Controller
public class FileController {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());//日志级别
    private final ResourceLoader resourceLoader;
    @Autowired
    public FileController(ResourceLoader resourceLoader){
        this.resourceLoader =resourceLoader;
    }
    @Value("img/assets/")
    private String path;
    
    @PostMapping("/upload")
    @ResponseBody
    public Result upload(MultipartFile file, Map<String, Object> map) {

        // 要上传的目标文件存放路径
//        String localPath = "classpath:/assets/";
        // 上传成功或者失败的提示
        String msg = "";
//        String originalFilename = file.getOriginalFilename();//获取文件名
//		String extName=originalFilename.substring(originalFilename.lastIndexOf(".")+1);
        File fileDir = UploadUtils.getImgDirFile();
        String fileXD = System.getProperty("user.dir");
        System.out.println(fileXD + "/" + fileDir);
        String realPath = fileXD + "/" + fileDir;
        try {
            FileUtils.upload(file, realPath, file.getOriginalFilename());
            // 上传成功，给出页面提示
            msg = "上传成功！";
            System.out.println("上传成功：" + file.getOriginalFilename());
            String url = path + file.getOriginalFilename();
            return new Result(true, url);
        } catch (Exception e) {
            logger.error("/upload方法体异常，原因如→{}",e.getMessage());
            return new Result(false, "上传失败，请选择上传图片！");
        }
    }
}
