package cn.ws.jdk8.nethodReference;

/**
 * @description: ${description}
 * @Author wangshun
 * @create: 2019-07-16 10:12
 */
public class Father{
    private String name;
    public void eat(){
        System.out.println("大米");
    }
    public Father(String name) {
        this.name = name;
    }
}
