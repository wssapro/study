package cn.ws.jdk8.lambda;

/**
 * @description:
 * @Author wangshun
 * @create: 2019-12-05 14:18
 */
public class Main {
    public static void main(String[] args) {
        Swim swim1 = new Swim() {
            @Override
            public void swimming() {
                System.out.println("调用匿名内部类：游泳");
            }
        };
        swim1.swimming();
        Swim swim2 = () -> {
            System.out.println("调用lambda表达式：游泳");
        };
        swim2.swimming();

        Smoke smoke1 = new Smoke() {
            @Override
            public void smoking(String name) {
                System.out.println("调用匿名内部类："+name+"抽烟");
            }
        };
        smoke1.smoking("Tom");



        Smoke smoke2 = (name)->{
            System.out.println("调用lambda表达式："+name+"抽烟");
        };
        smoke2.smoking("Tom");


    }
}
