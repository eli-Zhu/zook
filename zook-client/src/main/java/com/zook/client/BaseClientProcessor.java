package com.zook.client;

/**
 * 执行器
 * Created by Eli on 2018/7/25.
 */
public interface BaseClientProcessor extends BaseProcessor{
    /**
     * 注册资源
     * @param obj
     * @throws Exception
     */
    void registerResource(Object obj) throws Exception;
}
