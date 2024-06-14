import bean.UserService;
import cn.spirng.factory.BeanFactory;
import cn.spirng.factory.config.BeanDefinition;
import cn.spirng.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class test {
    @Test
    public void test_BeanFactory(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(new UserService().getClass());
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        UserService userService1 = (UserService) beanFactory.getBean("userService");
        userService1.queryUserInfo();

    }

}
