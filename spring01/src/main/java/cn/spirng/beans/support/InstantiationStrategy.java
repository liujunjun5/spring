package cn.spirng.beans.support;

import cn.spirng.BeansException;
import cn.spirng.beans.factory.BeanDefinition;

import java.lang.reflect.Constructor;

//实例化策略接口
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException;
}
