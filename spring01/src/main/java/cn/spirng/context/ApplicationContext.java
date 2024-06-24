package cn.spirng.context;

import cn.spirng.beans.factory.HierarchicalBeanFactory;
import cn.spirng.beans.factory.ListableBeanFactory;
import cn.spirng.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher  {
}
