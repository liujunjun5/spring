package cn.spirng.beans.factory;

import cn.spirng.beans.BeansException;
import cn.spirng.context.ApplicationContext;
//实现该接口可以感知到所属的 ApplicationContext
public interface ApplicationContextAware extends Aware{
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
