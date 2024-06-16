package cn.spirng.beans.factory;
//定义一个获取单例对象的接口
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
