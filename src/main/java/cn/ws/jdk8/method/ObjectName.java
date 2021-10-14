package cn.ws.jdk8.method;

import java.util.stream.Stream;

/**
 * @description:
 * @Author wangshun
 * @create: 2019-12-17 13:40
 */
public class ObjectName {
    public static void main(String[] args) {
        int totalAge = Stream.of(
                new Person("刘德华", 58),
                new Person("张学友", 56),
                new Person("郭富城", 54),
                new Person("黎明", 52)
        ).map((p) -> p.getAge())
                .reduce(0, (x, y) -> x + y);
        System.out.println("totalAge = " + totalAge);
        // 找出最大年龄
        int maxAge = Stream.of(
                new Person("刘德华", 58),
                new Person("张学友", 56),
                new Person("郭富城", 54),
                new Person("黎明", 52))
                .map((p) -> p.getAge())
                .reduce(0, (x, y) -> x > y ? x : y);
        System.out.println("maxAge = " + maxAge);
    }
}