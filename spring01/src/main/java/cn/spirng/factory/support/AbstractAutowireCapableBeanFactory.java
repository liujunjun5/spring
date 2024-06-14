package cn.spirng.factory.support;

import cn.spirng.BeansException;
import cn.spirng.factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException|IllegalAccessException e) {
            throw new BeansException("Failed to instantiate " + beanDefinition.getBeanClass(), e);
        }

        addSingleton(beanName, bean);
        return bean;
    }
}
