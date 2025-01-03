package cn.spirng.beans.factory.config;

import cn.spirng.beans.factory.HierarchicalBeanFactory;

//可获取 BeanPostProcessor、BeanClassLoader等的一个配置化接口
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
