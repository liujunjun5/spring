package cn.spirng.beans.factory.support;

import cn.spirng.beans.BeansException;
import cn.spirng.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

//实例化策略接口
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException;
}
