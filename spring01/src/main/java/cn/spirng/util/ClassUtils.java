package cn.spirng.util;

public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            // 尝试获取当前线程的上下文类加载器
            cl = Thread.currentThread().getContextClassLoader();
        }
        catch (Throwable ex) {
            // 如果获取线程上下文类加载器时发生异常，捕获异常并输出错误信息
            System.out.println(ex.getMessage());
            // 无法访问线程上下文类加载器 -> 退回到系统类加载器...
        }
        if (cl == null) {
            // 如果线程上下文类加载器为 null，则使用当前类的类加载器
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }

}