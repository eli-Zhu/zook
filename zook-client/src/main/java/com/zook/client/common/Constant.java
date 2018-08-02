package com.zook.client.common;

/**
 * 常量类
 * Created by Eli on 2018/7/25.
 */
public class Constant {
    /** 默认的超时时间*/
    public static final int DEFAULT_TIMEOUT = 3000; // ms
    /**连接zk的最多重试次数*/
    public static final int MAX_RETRY_TIMES = 3;
    /**默认字符编码*/
    public static final String UTF8 = "UTF-8";
    /** 分隔符*/
    public static final String BACK_SLASH = "/";
    /**默认根路径*/
    public static final String ROOT = "/defultRoot";
}
