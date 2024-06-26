package bean;

import cn.spirng.beans.factory.BeanFactory;
import cn.spirng.context.ApplicationContext;

import java.util.Random;

public class UserService implements IUserService{
    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "111,222,333";
    }

    @Override
    public String register(String userName) {
        {
            try {
                Thread.sleep(new Random(1).nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "注册用户：" + userName + " success！";
        }
    }
}
