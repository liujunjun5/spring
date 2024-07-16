package cn.spirng.aop;
//
public interface PointcutAdvisor extends Advisor{
    Pointcut getPointcut();
}
