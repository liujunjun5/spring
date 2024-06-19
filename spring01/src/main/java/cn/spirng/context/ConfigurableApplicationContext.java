package cn.spirng.context;

import cn.spirng.beans.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext{
    //刷新容器
    void refresh() throws BeansException;
}
