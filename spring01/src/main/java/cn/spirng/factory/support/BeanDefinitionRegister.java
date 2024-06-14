package cn.spirng.factory.support;

import cn.spirng.factory.config.BeanDefinition;

public interface BeanDefinitionRegister {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
