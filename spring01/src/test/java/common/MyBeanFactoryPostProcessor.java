package common;


import cn.spirng.beans.BeansException;
import cn.spirng.beans.PropertyValue;
import cn.spirng.beans.PropertyValues;
import cn.spirng.beans.factory.ConfigurableListableBeanFactory;
import cn.spirng.beans.factory.config.BeanDefinition;
import cn.spirng.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
