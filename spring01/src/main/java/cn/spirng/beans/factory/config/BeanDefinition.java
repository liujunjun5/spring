package cn.spirng.beans.factory.config;

import cn.spirng.beans.PropertyValues;

public class BeanDefinition {
    //存储的对象
    private Class beanClass;

    private PropertyValues propertyValues;

    String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;

    String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;

    private String initMethodName;

    private String destroyMethodName;

    private boolean singleton = true;

    private boolean prototype = false;

    private String scope = SCOPE_SINGLETON;

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }

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

    public boolean isSingleton() {
        return singleton;
    }

    public boolean isPrototype() {
        return prototype;
    }

}
