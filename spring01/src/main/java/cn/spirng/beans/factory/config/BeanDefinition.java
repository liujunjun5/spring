package cn.spirng.beans.factory.config;

import cn.spirng.beans.PropertyValues;

public class BeanDefinition {
    //存储的对象
    private Class beanClass;

    private PropertyValues propertyValues;

    private String initMethodName;

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    private String destroyMethodName;

    public BeanDefinition(Class beanClass) {
        this.propertyValues = new PropertyValues();
        this.beanClass = beanClass;
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.propertyValues = propertyValues!=null?propertyValues:new PropertyValues();
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public String getInitMethodName() {
        return initMethodName;
    }
}
