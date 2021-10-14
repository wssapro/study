package cn.ws.jdk8.functionInterface;

import java.util.function.Function;

/**
 * @description: ${description}
 * @Author wangshun
 * @create: 2019-07-15 21:14
 */
public class FunctionTest {
    public static void main(String[] args) {
        Function<Integer,Double> fun = (i)->{return Double.valueOf(i);};
        Double D = fun.apply(5);
        System.out.println(D);

        //function方法的andThen使用
        String s = "1234";
        Function<String,Integer> fun1 = (i)->{
            return Integer.valueOf(i);
        };
        Function<Integer,String> fun2 = (i)->{
            i +=10;
            return i.toString();
        };
        String result = fun1.andThen(fun2).apply(s);
        System.out.println(result);
    }
}
