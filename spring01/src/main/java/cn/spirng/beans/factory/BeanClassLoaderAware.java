package cn.spirng.beans.factory;
//实现该接口可以感知到所属的 ClassLoader
public interface BeanClassLoaderAware extends Aware{
    void setBeanClassLoader(ClassLoader classLoader);
}
