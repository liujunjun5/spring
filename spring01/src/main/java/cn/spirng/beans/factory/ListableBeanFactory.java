package cn.spirng.beans.factory;

import cn.spirng.beans.BeansException;

import java.util.Map;

//一个扩展 Bean 工厂接口的接口,新增加了 getBeansOfType、getBeanDefinitionNames() 方法
public interface ListableBeanFactory extends BeanFactory{
    /**
     * 按照类型返回 Bean 实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * Return the names of all beans defined in this registry.
     *
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();
}
