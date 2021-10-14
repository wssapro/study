package cn.ws.jdk8.functionInterface;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: ${description}
 * @Author wangshun
 * @create: 2019-07-15 21:30
 */
public class ComparatorTest {
    public static void main(String[] args) {
        Integer a[] = {44,64,6,43,25};
        Arrays.sort(a,getComparator());
        System.out.println(Arrays.toString(a));
    }
    public static Comparator<Integer> getComparator(){
        return (a,b)->{
            return a-b;
        };
    }
}

