package cn.spirng.beans.factory.config;

import cn.spirng.beans.BeansException;

public interface BeanPostProcessor {
    //在 Bean 对象执行初始化方法之前，执行该方法
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;
    //在 Bean 对象执行初始化方法以后，执行该方法
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
