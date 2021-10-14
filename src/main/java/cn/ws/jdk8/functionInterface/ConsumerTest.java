package cn.ws.jdk8.functionInterface;

import java.util.function.Consumer;

/**
 * @description: ${description}
 * @Author wangshun
 * @create: 2019-07-15 18:40
 */
public class ConsumerTest {

    public static void main(String[] args) {
//        Consumer<String> consumer = null;
//        consumer.accept("");
//        System.out.println(consumer);


        Consumer<String> printString = s -> System.out.println(s);
        printString.accept("helloWorld!");

        Consumer<String> pri1= s -> System.out.println(s);
        Consumer<String> pri2= s -> System.out.println(s);
        String aa="aaaa";
        pri1.accept(aa);
        pri2.accept(aa);
        pri2.andThen(pri1).accept(aa);
    }
}
