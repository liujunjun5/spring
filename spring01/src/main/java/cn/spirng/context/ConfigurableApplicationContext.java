package cn.spirng.context;

import cn.spirng.beans.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext{
    //刷新容器
    void refresh() throws BeansException;
    //注册虚拟机钩子的方法
    void registerShutdownHook();
    //手动执行关闭的方法
    void close();
}
