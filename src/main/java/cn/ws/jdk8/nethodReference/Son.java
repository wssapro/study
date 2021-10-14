package cn.ws.jdk8.nethodReference;

/**
 * @description: ${description}
 * @Author wangshun
 * @create: 2019-07-16 10:13
 */
public class Son extends Father {
    public Son(String name) {
        super(name);
    }
    @Override
    public void eat(){
        System.out.println("汉堡");
    }
    public void method(Human human){
        human.run();
    }
    public  void show(){
        method(super::eat);
        method(this::eat);
    }
    public static void main(String[] args) {
        String name = "a";
        new Son(name).show();
    }
}
