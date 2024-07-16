package cn.spirng.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.spirng.beans.BeansException;
import cn.spirng.beans.PropertyValue;
import cn.spirng.beans.factory.config.BeanDefinition;
import cn.spirng.beans.factory.config.BeanReference;
import cn.spirng.beans.factory.support.AbstractBeanDefinitionReader;
import cn.spirng.beans.factory.support.BeanDefinitionRegistry;
import cn.spirng.context.annotation.ClassPathBeanDefinitionScanner;
import cn.spirng.core.io.Resource;
import cn.spirng.core.io.ResourceLoader;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            try (InputStream is = resource.getInputStream()) {
                doLoadBeanDefinitions(is);
            }
        } catch (IOException | ClassNotFoundException | DocumentException e) {
            throw new BeansException("IO Exception parsing XML document from" + resource + e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(String... locations) throws BeansException {
        for (String location : locations) {
            loadBeanDefinitions(location);
        }
    }

    protected void doLoadBeanDefinitions(InputStream is) throws ClassNotFoundException, DocumentException {
        SAXReader reader = new SAXReader();
        // 读取 XML 文件并解析成 Document 对象
        Document document = reader.read(is);
        Element root = document.getRootElement();

        // 检查是否存在 <component-scan> 标签
        Element componentScan = root.element("component-scan");
        if (componentScan != null) {
            // 获取 base-package 属性的值
            String scanPath = componentScan.attributeValue("base-package");
            if (StrUtil.isBlank(scanPath)) {
                throw new BeansException("The value of base-package attribute can not be empty or null");
            }
            // 调用 scanPackage 方法扫描指定的包
            scanPackage(scanPath);
        }

        List<Element> beanList = root.elements("bean");
        for (Element bean : beanList) {
            // 获取 Bean 定义的各个属性
            String id = bean.attributeValue("id");
            String name = bean.attributeValue("name");
            String className = bean.attributeValue("class");
            String initMethod = bean.attributeValue("init-method");
            String destroyMethodName = bean.attributeValue("destroy-method");
            String beanScope = bean.attributeValue("scope");

            // 根据 class 属性获取 Class 对象
            Class<?> clazz = Class.forName(className);
            // 确定 Bean 的名称,优先使用 id 属性,如果没有则使用 name 属性,如果都没有则使用类名的首字母小写
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            // 创建 BeanDefinition 对象并设置相关属性
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            beanDefinition.setInitMethodName(initMethod);
            beanDefinition.setDestroyMethodName(destroyMethodName);
            if (StrUtil.isNotEmpty(beanScope)) {
                beanDefinition.setScope(beanScope);
            }
            // 遍历 <property> 标签,解析属性值并添加到 BeanDefinition 中
            List<Element> propertyList = bean.elements("property");
            for (Element property : propertyList) {
                String attrName = property.attributeValue("name");
                String attrValue = property.attributeValue("value");
                String attrRef = property.attributeValue("ref");
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }

            // 检查 Bean 名称是否已经存在于注册表中,如果存在则抛出异常
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            // 将 BeanDefinition 注册到注册表中
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }

    private void scanPackage(String scanPath) {
        // 将包路径拆分成数组
        String[] basePackages = StrUtil.splitToArray(scanPath, ',');
        // 创建 ClassPathBeanDefinitionScanner 对象并扫描指定的包
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(getRegistry());
        scanner.doScan(basePackages);
    }

}
