package cn.ws.dataStructure.sort;

/**
 * 插入排序
 * @author wangshun
 * @date 2019/3/25 8:44
 */
public class InsertSort {
    public static void insertSort(int arr[]){
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]<arr[i-1]){
                int temp = arr[i];
                int j=i-1;
                for(;j>=0&&temp<arr[j];j--){
                    arr[j+1]=arr[j];
                }
                arr[j+1] =temp;
            }
        }
    }
}
