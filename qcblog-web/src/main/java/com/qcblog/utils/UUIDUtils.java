package com.qcblog.utils;

import java.util.UUID;

/**
 * UUID生成工具类
 *
 * @author 赵起超
 * @date 2018.10.18
 */
public class UUIDUtils {

    /**
     * 随机数
     *
     * @return 32位UUID
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}