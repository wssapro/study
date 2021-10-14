package cn.ws.jdk8.functionInterface;

import java.util.function.Supplier;

/**
 * @description: ${description}
 * @Author wangshun
 * @create: 2019-07-15 18:31
 */
public class SupplierText {
    public static void main(String[] args) {
        int a = 1,b = 2;
        int result = getMax(()->{
            return a>b?a:b;
        });
        System.out.println(result);
    }
    public static int getMax(Supplier<Integer> sup){
        return sup.get();
    }
}
