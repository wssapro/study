package cn.ws.jdk8.lambda;

/**
 * @description: ${description}
 * @Author wangshun
 * @create: 2019-07-15 18:08
 */
class myThread implements Runnable{
    public myThread() {
    }

    @Override
    public void run() {

    }
}

public class test {
    public static void main(String[] args) {
        new Thread(() -> System.out.println(Thread.currentThread().getName()+"启动了")).start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"启动了");
        }).start();
        myThread(()->{
            System.out.println(Thread.currentThread().getName()+"启动了");
        });
    }
    public static void myThread(Runnable runnable){
        new Thread(runnable).start();
    }
}



