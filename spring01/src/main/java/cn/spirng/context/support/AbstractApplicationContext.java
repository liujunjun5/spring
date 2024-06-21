package cn.spirng.context.support;

import cn.spirng.beans.BeansException;
import cn.spirng.beans.factory.ConfigurableListableBeanFactory;
import cn.spirng.beans.factory.config.BeanFactoryPostProcessor;
import cn.spirng.beans.factory.config.BeanPostProcessor;
import cn.spirng.beans.factory.support.ApplicationContextAwareProcessor;
import cn.spirng.context.ConfigurableApplicationContext;
import cn.spirng.core.io.DefaultResourceLoader;

import java.util.Map;

public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext  {
    @Override
    public void refresh() throws BeansException {
        //创建 BeanFactory 加载 BeanDefinition
        refreshBeanFactory();

        //获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        //添加 ApplicationContextAwareProcessor，让继承自 ApplicationContextAware 的 Bean 对象都能感知所属的 ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

        //在 Bean 实例化之前，执行BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);

        //BeanPostProcessor 需要提前与其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        //提前实例化 Bean 对象
        beanFactory.preInstantiateSingletons();
    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }

    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        return getBeanFactory().getBean(beanName);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return getBeanFactory().getBean(beanName, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        getBeanFactory().destroySingletons();
    }
}
