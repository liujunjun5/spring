package cn.spirng.beans.factory;

import cn.spirng.beans.BeansException;

import java.util.Map;

public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;
    Object getBean(String beanName, Object... args) throws BeansException;
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
