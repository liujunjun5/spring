package cn.spirng.aop;

import java.lang.reflect.Method;

//方法匹配，找到匹配范围内匹配下的目标类和方法
//定义方法的匹配规则
public interface MethodMatcher {
    boolean matches(Method method, Class<?> targetClass);
}
