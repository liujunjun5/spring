package cn.spirng.beans.factory.config;

import cn.spirng.beans.BeansException;
import cn.spirng.beans.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {
    /*
    * 在所有 BeanDefinition 加载完以后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
    * */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
