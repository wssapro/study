package cn.ws.jdk8.method;

/**
 * @description:
 * @Author wangshun
 * @create: 2019-12-17 16:50
 */
public class Student {
    private String name;
    private int age;
    private int socre;

    public Student(String name, int age, int socre) {
        this.name = name;
        this.age = age;
        this.socre = socre;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", socre=" + socre +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSocre() {
        return socre;
    }

    public void setSocre(int socre) {
        this.socre = socre;
    }
}
