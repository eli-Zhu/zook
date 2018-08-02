package com.zook.client.context;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 角色处理类
 * Created by Eli on 2018/7/25.
 */
public class DefaultContext {
    /**事件id*/
    private String eventId;
    /***事件名称*/
    private String eventName;
    /**本地缓存*/
    private ConcurrentHashMap<String,Object> map=new ConcurrentHashMap<String,Object>();

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public ConcurrentHashMap<String, Object> getMap() {
        return map;
    }

    public void setMap(ConcurrentHashMap<String, Object> map) {
        this.map = map;
    }
}
