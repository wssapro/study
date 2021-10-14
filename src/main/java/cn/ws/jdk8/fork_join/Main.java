package cn.ws.jdk8.fork_join;

import java.util.concurrent.ForkJoinPool;

/**
 * @description:
 * @Author wangshun
 * @create: 2019-12-17 18:35
 */
public class Main {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        SumRecursiveTask sumRecursiveTask = new SumRecursiveTask(1,10000);
        Long invoke = pool.invoke(sumRecursiveTask);
        System.out.println(invoke);
    }
}
