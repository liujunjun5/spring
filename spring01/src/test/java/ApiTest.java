import bean.UserDao;
import bean.UserService;
import cn.hutool.core.io.IoUtil;
import cn.spirng.beans.PropertyValue;
import cn.spirng.beans.factory.config.BeanDefinition;
import cn.spirng.beans.factory.config.BeanReference;
import cn.spirng.beans.factory.support.DefaultListableBeanFactory;
import cn.spirng.beans.PropertyValues;
import cn.spirng.beans.factory.xml.XmlBeanDefinitionReader;
import cn.spirng.context.support.ClassPathXmlApplicationContext;
import cn.spirng.core.io.DefaultResourceLoader;
import cn.spirng.core.io.Resource;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ApiTest {
    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
}

