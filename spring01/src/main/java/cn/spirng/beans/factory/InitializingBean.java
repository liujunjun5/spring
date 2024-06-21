package cn.spirng.beans.factory;

public interface InitializingBean {
    //Bean处理了属性填充以后调用
    void afterPropertiesSet() throws Exception;
}
