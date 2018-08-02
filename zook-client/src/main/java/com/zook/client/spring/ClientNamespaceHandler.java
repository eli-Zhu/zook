package com.zook.client.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 自定义schema命名空间关联类
 * Created by Eli on 2018/7/26.
 */
public class ClientNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("client",new ClientDefinitionParser());
    }
}
