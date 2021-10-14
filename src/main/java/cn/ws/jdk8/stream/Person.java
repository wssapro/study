package cn.ws.jdk8.stream;

/**
 * @description: ${description}
 * @Author wangshun
 * @create: 2019-07-16 00:58
 */
public class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Father{" +
                "name='" + name + '\'' +
                '}';
    }
}
