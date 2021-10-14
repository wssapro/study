package cn.ws.dataStructure.sort;

/**
 * 冒泡排序
 * @author wangshun
 * @date 2019/3/23 23:35
 */
public class BubbleSort {
    public static void bubbleSort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
