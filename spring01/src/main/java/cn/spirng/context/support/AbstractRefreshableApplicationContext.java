package cn.spirng.context.support;

import cn.spirng.beans.BeansException;
import cn.spirng.beans.factory.ConfigurableListableBeanFactory;
import cn.spirng.beans.factory.support.DefaultListableBeanFactory;
//获取了 DefaultListableBeanFactory 的实例化以及对资源配置的加载操作 loadBeanDefinitions(beanFactory)
// 在加载完成后即可完成对 spring.xml 配置文件中 Bean 对象的定义和注册
// 同时也包括实现了接口BeanFactoryPostProcessor、BeanPostProcessor 的配置 Bean 信息。
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException;

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
