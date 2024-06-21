package cn.spirng.beans.factory;
//实现该接口，可以感知到所属的 BeanName
public interface BeanNameAware extends Aware{
    void setBeanName(String beanName);
}
