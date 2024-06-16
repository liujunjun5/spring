package cn.spirng.beans.support;

import cn.spirng.beans.factory.BeanDefinition;

public interface BeanDefinitionRegister {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
