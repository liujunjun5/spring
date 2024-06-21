package cn.spirng.beans.factory.support;

import cn.spirng.beans.BeansException;
import cn.spirng.beans.factory.ApplicationContextAware;
import cn.spirng.beans.factory.config.BeanPostProcessor;
import cn.spirng.context.ApplicationContext;

//包装处理器
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
