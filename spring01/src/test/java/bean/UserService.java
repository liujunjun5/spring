package bean;

public class UserService {

    private String uId;
    private UserDao userDao;
    private String name;

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.queryUserName(uId));
    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                '}';
    }

    public UserService(String name) {
        this.name = name;
    }

    public UserService(){}
}
