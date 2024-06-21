package cn.spirng.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import cn.spirng.beans.BeansException;
import cn.spirng.beans.factory.DisposableBean;
import cn.spirng.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

//定义销毁方法适配器(接口和配置)
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;
    private final String beanName;
    private final String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getInitMethodName();
    }

    @Override
    public void destroy() throws Exception {
        // 实现接口 DisposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        //配置信息 destroy-method
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean) && "destroy".equals(this.destroyMethodName)) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (null == destroyMethod) {
                throw new BeansException("Could not find destroy method: " + destroyMethodName);
            }
            destroyMethod.invoke(bean);
        }
    }
}
