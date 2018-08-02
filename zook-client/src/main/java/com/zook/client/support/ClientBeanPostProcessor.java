package com.zook.client.support;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import com.zook.client.BaseClientProcessor;

/**
 *
 * Created by Eli on 2018/7/25.
 */
public class ClientBeanPostProcessor implements BeanPostProcessor {


    /**
     * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessBeforeInitialization(java.lang.Object, java.lang.String)
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    /**
     * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessAfterInitialization(java.lang.Object, java.lang.String)
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (BaseClientProcessor.class.isAssignableFrom(bean.getClass())) {
            BaseClientProcessor clientProcessor = BaseClientProcessor.class.cast(bean);
            clientProcessor.start();
        }
        return bean;
    }
}
