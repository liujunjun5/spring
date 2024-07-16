package cn.spirng.context.annotation;

import cn.hutool.core.util.ClassUtil;
import cn.spirng.beans.factory.config.BeanDefinition;
import cn.spirng.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

public class ClassPathScanningCandidateComponentProvider {
    //扫描到所有@Component注解的Bean对象
    public Set<BeanDefinition> findCandidateComponents(final String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
