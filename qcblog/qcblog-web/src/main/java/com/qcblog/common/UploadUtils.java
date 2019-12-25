package com.qcblog.common;

import java.io.File;

/**
 * 图片上传工具类
 *
 * @author 赵起超
 * @date 2019.07.15
 */
public class UploadUtils {
    public final static String IMG_PATH_PREFIX = "img/assets/"; //文件上传路径前缀

    /**
     * 获取图片上传路径
     *
     * @return
     */
    public static File getImgDirFile() {

        // 构建上传文件的存放 "文件夹" 路径
        //String fileDirPath = new String("qcblog-web/src/main/resources/static/" + IMG_PATH_PREFIX);
        String fileDirPath = new String("config/static/" + IMG_PATH_PREFIX);
        File fileDir = new File(fileDirPath);
        if (!fileDir.exists()) {
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        return fileDir;
    }
}
