package cn.spirng.aop;

//定义匹配类，用于切点找到给定的接口和目标类
//定义类的过滤规则
public interface ClassFilter {
    boolean matches(Class<?> clazz);
}
