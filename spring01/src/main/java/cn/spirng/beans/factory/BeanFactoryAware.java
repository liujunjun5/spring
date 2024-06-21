package cn.spirng.beans.factory;

import cn.spirng.beans.BeansException;
//实现该接口可以感知到所属的 BeanFactory
public interface BeanFactoryAware extends Aware{
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
