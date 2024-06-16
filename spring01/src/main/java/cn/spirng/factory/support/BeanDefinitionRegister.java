package cn.spirng.factory.support;

import cn.spirng.factory.factory.BeanDefinition;

public interface BeanDefinitionRegister {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
