package cn.ws.dataStructure.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * @author wangshun
 * @date 2019/3/25 10:18
 */
public class ShellSort {
    public static void ShellSort(int arr[]){
        //先根据步数，每隔几个进行对比
        for(int d=arr.length/2;d>0;d/=2){
            //根据步数d的值，从第d个开始遍历所有数。
            for(int i=d;i<arr.length;i++){
                //根据d来进行比较，相隔几个比较一次。
                for(int j=i; j>=d; j-=d){
                    if(arr[j]<arr[j-d]){
                        int temp = arr[j];
                        arr[j] = arr[j-d];
                        arr[j-d] = temp;
                    }
                }
            }
            System.out.println("d为"+d+"时候排序后的结果："+Arrays.toString(arr));
        }
    }
}
