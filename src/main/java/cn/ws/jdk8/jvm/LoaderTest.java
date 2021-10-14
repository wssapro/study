package cn.ws.jdk8.jvm;

/**
 * <p>
 *
 * </p>
 *
 * @author shun
 * @date 2020-05-14 16:17
 */
public class LoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader loader = Test2.class.getClassLoader();
        System.out.println(loader);
        //使用ClassLoader.loadClass()来加载类，不会执行初始化块
        Object o = loader.loadClass("com.jdk8.jvm.Test2").newInstance();
        System.out.println("-----------------------------");
        //使用Class.forName()来加载类，默认会执行初始化块
        Class.forName("com.jdk8.jvm.Test2");
        System.out.println("-----------------------------");
        //使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块
        Class.forName("com.jdk8.jvm.Test2", true, loader);
    }



    public void loader() throws ClassNotFoundException {
        Class.forName("com.jdk8.jvm.Test2", true, this.getClass().getClassLoader());
    }
}
