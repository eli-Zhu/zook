package com.zook.client.listener.impl;

import com.sun.tools.javac.util.StringUtils;
import com.zook.client.annotation.DoAfterCall;
import com.zook.client.annotation.DoBeforeCall;
import com.zook.client.common.Constant;
import com.zook.client.context.DefaultContext;
import com.zook.client.listener.BaseClientListener;

import java.lang.reflect.Method;

/**
 * 默认监听器
 * Created by Eli on 2018/7/25.
 */
public class DefaultBaseClientListener implements BaseClientListener {
    /**
     * watch前的动作
     * @param obj
     * @throws Exception
     */
    @Override
    public void onBeforeWatching(Object obj) throws Exception{
        Class<? extends Object> clazz=obj.getClass();
        Method[] methods=clazz.getDeclaredMethods();
        for(Method method:methods){
            if(method.isAnnotationPresent(DoBeforeCall.class)){
                method.invoke(obj);
            }
        }
    }

    /**
     *watch后的动作
     * @param context
     * @param path
     * @param content
     * @throws Exception
     */
    @Override
    public void onAfterWatching(DefaultContext context, String path, byte[] content)throws Exception {
        Object obj=context.getMap().get(path);
        Class<? extends Object> clazz=obj.getClass();
        Method[] methods=clazz.getDeclaredMethods();
        for(Method method:methods){
            if(method.isAnnotationPresent(DoAfterCall.class)){
                method.invoke(obj,getkey(path),new String(content,Constant.UTF8));
            }
        }
    }
    /**
     * 获取属性名
     * @param path
     * @return
     */
    private String getkey(String path) {
        String[] split = path.split(Constant.BACK_SLASH);
        return split[split.length - 1];
    }
}
