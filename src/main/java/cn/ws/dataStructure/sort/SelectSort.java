package cn.ws.dataStructure.sort;

/**
 * 选择排序
 * @author wangshun
 * @date 2019/3/25 16:12
 */
public class SelectSort {
    public static void slesctSort(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            int select = i;
            for(int j=i;j<arr.length;j++){
                if(arr[select]>arr[j]){
                    select = j;
                }
            }
            if(select!=i){
                int temp = arr[select];
                arr[select] = arr[i];
                arr[i] =temp;
            }
        }
    }
}
