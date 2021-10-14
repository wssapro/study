package cn.ws.jdk8.functionInterface;

import java.util.function.Predicate;

/**
 * @description: ${description}
 * @Author wangshun
 * @create: 2019-07-15 20:43
 */
public class PredicateTest {
    public static void main(String[] args) {
        Predicate<Integer> pred = (i)-> {return i==2;};
        //等价于上一句
        pred = i-> i==2;
        System.out.println(pred.test(2));

        int i =6;
        /*boolean bool = check(i,(integer)->{
            return i==5;
        });*/
        //优化lambda
        //test方法
        boolean bool = check(i, a-> a==5);
        System.out.println("test方法结果为："+bool);
        //negate方法
        bool = checkNegate(i, a-> a==5);
        System.out.println("negate方法结果为："+bool);
        //and方法
        bool = checkAnd(i,a->a>5,a->a<10);
        System.out.println("and方法结果为："+bool);
        //or方法
        bool = checkOr(i,a->a>5,a->a<10);
        System.out.println("or方法结果为："+bool);

    }
    public static boolean  check(int i,Predicate<Integer> pre){
        return pre.test(i);
    }

    public static boolean  checkNegate(int i,Predicate<Integer> pre){
        return pre.negate().test(i);
    }
    public static boolean  checkAnd(int i,Predicate<Integer> pre,Predicate<Integer> other){
        return pre.and(other).test(i);
    }
    public static boolean  checkOr(int i,Predicate<Integer> pre,Predicate<Integer> other){
        return pre.or(other).test(i);
    }

}
