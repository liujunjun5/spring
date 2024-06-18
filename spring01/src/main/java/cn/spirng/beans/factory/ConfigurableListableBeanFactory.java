package cn.spirng.beans.factory;

import cn.spirng.beans.BeansException;
import cn.spirng.beans.factory.config.AutowireCapableBeanFactory;
import cn.spirng.beans.factory.config.BeanDefinition;
import cn.spirng.beans.factory.config.ConfigurableBeanFactory;
//提供分析和修改Bean以及预先实例化的操作接口
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
