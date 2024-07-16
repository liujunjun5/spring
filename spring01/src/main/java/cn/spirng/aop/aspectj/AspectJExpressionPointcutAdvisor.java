package cn.spirng.aop.aspectj;

import cn.spirng.aop.Pointcut;
import cn.spirng.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

// 实现了PointcutAdvisor接口，把切面pointcut、拦截方法advice和具体的拦截表达式包装了
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    // 切面
    private AspectJExpressionPointcut pointcut;
    // 具体的拦截方法
    private Advice advice;
    // 表达式
    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Pointcut getPointcut() {
        if (pointcut == null) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }
}
