package cn.spirng.beans.factory.support;

import cn.spirng.beans.BeansException;
import cn.spirng.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException {
        //通过beanDefinition获取Class信息
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (constructor != null) {
                return clazz.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            } else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}