package cn.spirng.factory.factory;

public class BeanDefinition {
    //存储的对象
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }
}
