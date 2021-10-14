package cn.ws.jdk8.jvm;

/**
 * <p>
 *
 * </p>
 *
 * @author shun
 * @date 2020-05-14 15:10
 */
public class Test {
    public static void main(String[] args) throws Exception {

        String a = "abc";
        String b = "abc";
        String c= new String("abc");
        System.out.println(Addresser.addressOf("ab"));
        System.out.println(Addresser.addressOf("c"));
        System.out.println(Addresser.addressOf("abc"));
        System.out.println(Addresser.addressOf("ab"+"c"));
        System.out.println(Addresser.addressOf(a));
        System.out.println(Addresser.addressOf(b));
        System.out.println(Addresser.addressOf(c));

        Class<?> aClass = Class.forName("com.jdk8.jvm.Student");
        Student o = (Student) aClass.newInstance();
        o.setName("s");
        System.out.println(o.getName());

    }
}
