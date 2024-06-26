package cn.spirng.aop;

import cn.spirng.TargetSource;
import org.aopalliance.intercept.MethodInterceptor;

/*
* 把代理、拦截、匹配的各项属性包装到一个类中，方便在Proxy实现类使用
*/
public class AdvisedSupport {
    //被代理的目标对象
    private TargetSource targetSource;
    //方法拦截器
    private MethodInterceptor methodInterceptor;
    //方法匹配器（检查目标方法是否符合通知条件）
    private MethodMatcher methodMatcher;

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }
}
