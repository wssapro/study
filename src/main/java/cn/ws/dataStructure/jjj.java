package cn.ws.dataStructure;

/**
 * @author wangshun
 * @date 2019/3/30 14:25
 */
public class jjj {
    public static void main(String[] args) {
        int n =10;
        int sun = 0;
        for (int i = 2; i < n; i++) {
            if(n%i==0){
                sun+=i;
            }
        }
        System.out.println(sun);
    }
}

