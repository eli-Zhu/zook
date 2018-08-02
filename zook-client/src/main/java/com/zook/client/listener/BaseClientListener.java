package com.zook.client.listener;

import com.zook.client.context.DefaultContext;

/**
 * 监听器
 * Created by Eli on 2018/7/25.
 */
public interface BaseClientListener {

    void onBeforeWatching(Object obj) throws Exception;

    void onAfterWatching(DefaultContext context, String path, byte[] content) throws Exception;
}
