package cn.ws.jdk8.nethodReference;

/**
 * @description: ${description}
 * @Author wangshun
 * @create: 2019-07-16 10:12
 */
public class Test {

    public static Father create(String name, humanConstrustor humanConstrustor){
        return humanConstrustor.getFather(name);
    }
    public static void main(String[] args) {
        create("灰太狼",name -> {
           return new Father(name);
        });
        create("小头爸爸",Father::new);
    }
}
