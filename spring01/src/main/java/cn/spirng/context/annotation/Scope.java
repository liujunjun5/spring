package cn.spirng.context.annotation;

import java.lang.annotation.*;

//可以用在类或接口名上和方法上
@Target({ElementType.TYPE, ElementType.METHOD})
//注解信息会保留在运行时，可以被反射API访问
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";

}
