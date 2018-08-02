package com.zook.client.spring;

import com.zook.client.DefaultClientProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

/**
 * 自定义schema节点解析类
 * Created by Eli on 2018/7/26.
 */
public class ClientDefinitionParser extends AbstractSingleBeanDefinitionParser {
    private static final String ZK_CONNECT = "zkConnect";
    private static final String LISTENER = "listener";
    private static final String ROOT = "root";
    @Override
    protected Class<DefaultClientProcessor> getBeanClass(Element element) {
        return DefaultClientProcessor.class;
    }
    @Override
    protected String getBeanClassName(Element element) {
        return DefaultClientProcessor.class.getName();
    }
    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String zkconnect = element.getAttribute(ZK_CONNECT);
        String root = element.getAttribute(ROOT);

        // Listener
        Element listenerEle = DomUtils.getChildElementByTagName(element, LISTENER);
        if (listenerEle != null) {
            builder.addPropertyReference(LISTENER, listenerEle.getAttribute("ref"));
        }
        builder.addConstructorArgValue(zkconnect);
        builder.addConstructorArgValue(root);
    }
}
