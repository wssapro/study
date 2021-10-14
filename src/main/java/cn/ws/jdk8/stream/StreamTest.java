package cn.ws.jdk8.stream;

import java.util.stream.Stream;

/**
 * @description: ${description}
 * @Author wangshun
 * @create: 2019-07-15 22:43
 */
public class StreamTest {
    public static void main(String[] args) {
        //创建一个List集合,存储姓名
        /*List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");*/

        /*Predicate<String> pred = (str)-> str.length()==3;
        Consumer<String> con = str-> System.out.println(str);
        list.stream()
                .filter(pred)
                .forEach(con);
        Map<String, String> map = new HashMap<>();
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        map.keySet().forEach(a-> System.out.println(a));
        map.values().stream().forEach(a-> System.out.println(a));*/


        /*String[] array = { "张无忌", "张翠山", "张三丰", "张一元" };
        Stream<String> stream = Stream.of(array);
        Stream.of(array).forEach(a-> System.out.println(a));*/

        //map()方法
        // 对stream流进行转换
        //eg. String类型的转换为Integer类型
        Stream<String> original = Stream.of("10", "12", "18");
        Stream<Integer> result = original.map(str->Integer.parseInt(str));
        result.forEach(a-> System.out.print(a+","));
        System.out.println();
        //count()方法
        // 获取数量
        result = Stream.of(10, 12, 18);
        System.out.println(result.count());

        //limit()方法，
        // 截取stream流
        result = Stream.of(10, 12, 18).limit(2);
        result.forEach(a-> System.out.print(a+","));
        System.out.println();
        //skip()方法，
        // 跳过前几个
        result =  Stream.of(10, 12, 18).skip(2);
        result.forEach(a-> System.out.print(a+","));
        System.out.println();

        //concat()方法，合并两个stream流
        Stream<Integer> streamA = Stream.of(1,2);
        Stream<Integer> streamB = Stream.of(3,4);
        result = Stream.concat(streamA, streamB);
        result.forEach(a-> System.out.print(a+","));
    }
}