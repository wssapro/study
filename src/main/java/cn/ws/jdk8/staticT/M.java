package cn.ws.jdk8.staticT;

/**
 * <p>
 *
 * </p>
 *
 * @author shun
 * @date 2020-06-09 16:52
 */
public class M {
    public static void main(String[] args) {
        A a1 = new A();
        System.out.println(a1.getI());
        a1.setI();


        A a2 = new A();
        System.out.println(a2.getI());
    }
}
