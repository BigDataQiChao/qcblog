package com.qcblog.common;

/**
 * 文件名称工具类
 *
 * @author 赵起超
 * @date 2019.07.15
 */
public class FileNameUtils {

    /**
     * 获取文件后缀
     *
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成新的文件名
     *
     * @param fileOriginName 源文件名
     * @return
     */
    public static String getFileName(String fileOriginName) {
        return UUIDUtils.getUUID() + FileNameUtils.getSuffix(fileOriginName);
    }

}
