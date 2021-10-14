package cn.ws.jdk8.method;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @description:
 * @Author wangshun
 * @create: 2019-12-17 16:11
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> newList = new ArrayList<>();
        // 使用并行的流往集合中添加数据
        IntStream.range(1,1000).parallel()
                .forEach(s -> {
                    newList.add(s);
                });
        System.out.println("newList = " + newList.size());

        Object o = new Object();
        List<Integer> newList2 = new ArrayList<>();
        // 使用并行的流往集合中添加数据
        IntStream.range(1,1000).parallel()
                .forEach(s -> {
                    synchronized (o){
                        newList2.add(s);
                    }
                });
        System.out.println("newList2 = " + newList2.size());

        Vector<Integer> vector = new Vector<>();
        IntStream.range(1,1000).parallel()
                .forEach(s -> {
                    vector.add(s);
                });
        System.out.println("newList2 = " + vector.size());


        List list = new ArrayList();
        List<Integer> synchronizedList = Collections.synchronizedList(list);
        // 使用并行的流往集合中添加数据
        IntStream.range(1,1000).parallel()
                .forEach(s -> {
                    synchronized (o){
                        synchronizedList.add(s);
                    }
                });
        System.out.println("newList2 = " + newList2.size());

        List<Integer> collect = IntStream.range(1, 1000).parallel()
                .boxed()
                .collect(Collectors.toList());
        System.out.println("collect = " + collect.size());

    }
}
