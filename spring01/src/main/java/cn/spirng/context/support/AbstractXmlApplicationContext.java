package cn.spirng.context.support;

import cn.spirng.beans.BeansException;
import cn.spirng.beans.factory.config.AutowireCapableBeanFactory;
import cn.spirng.beans.factory.support.DefaultListableBeanFactory;
import cn.spirng.beans.factory.xml.XmlBeanDefinitionReader;
//处理了关于 XML 文件配置信息的操作
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext  {
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException {
        XmlBeanDefinitionReader beanDefinitionReader  = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (configLocations != null) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
