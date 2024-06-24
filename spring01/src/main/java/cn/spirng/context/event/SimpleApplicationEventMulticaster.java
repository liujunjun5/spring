package cn.spirng.context.event;

import cn.spirng.beans.factory.BeanFactory;
import cn.spirng.context.ApplicationEvent;
import cn.spirng.context.ApplicationListener;

public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (ApplicationListener applicationListener : getApplicationListeners(event)) {
            applicationListener.onApplicationEvent(event);
        }
    }

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }
}
