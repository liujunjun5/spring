import bean.UserService;
import cn.spirng.beans.factory.config.BeanDefinition;
import cn.spirng.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class test {
    @Test
    public void test_BeanFactory(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService","LiuJun");
        userService.queryUserInfo();
        System.out.println(userService);

    }
}
