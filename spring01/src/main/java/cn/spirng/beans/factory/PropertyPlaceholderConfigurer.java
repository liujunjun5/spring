package cn.spirng.beans.factory;

import cn.spirng.beans.BeansException;
import cn.spirng.beans.PropertyValue;
import cn.spirng.beans.PropertyValues;
import cn.spirng.beans.factory.config.BeanDefinition;
import cn.spirng.beans.factory.config.BeanFactoryPostProcessor;
import cn.spirng.core.io.DefaultResourceLoader;
import cn.spirng.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {
    public static final String DEFAULT_PLACEHOLDER_PREFIX = "${";
    public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";

    private String location;

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        try {
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());
            String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
            for (String beanName : beanDefinitionNames) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
                PropertyValues propertyValues = beanDefinition.getPropertyValues();
                for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                    // 获取属性值,如果不是 String 类型则跳过
                    Object value = propertyValue.getValue();
                    if (!(value instanceof String)) continue;
                    String strVal = (String) value;
                    StringBuilder buffer = new StringBuilder(strVal);
                    // 查找属性值中是否包含占位符
                    int start = strVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
                    int stop = strVal.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
                    if (start != -1 && stop != -1 && start < stop) {
                        // 提取占位符对应的属性键
                        String propKey = strVal.substring(start + 2, stop);
                        // 从 Properties 对象中获取对应的属性值
                        String propVal = properties.getProperty(propKey);
                        // 将占位符替换为属性值
                        buffer.replace(start, stop + 1, propVal);
                        // 更新 Bean 定义中的属性值
                        propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(), buffer.toString()));
                    }
                }
            }

        } catch (IOException e) {
            throw new BeansException("Could not load properties", e);
        }
    }
}
