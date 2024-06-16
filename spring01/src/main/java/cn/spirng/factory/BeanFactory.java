package cn.spirng.factory;

import cn.spirng.BeansException;

public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;
    Object getBean(String beanName, Object... args) throws BeansException;
}
