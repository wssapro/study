package cn.ws.dataStructure.sort;

/**
 * 快速排序
 * @author wangshun
 * @date 2019/3/23 23:35
 */
public class Quicksort {
    public static void quickSort(int[] arr, int start, int end){
        if(start<end){
            int stard=arr[start];
            int low=start;
            int high=end;
            while(low<high){
                while(low<high & stard <=arr[high]){
                    high--;
                }
                arr[low] = arr[high];
                while(low<high & stard >=arr[low]){
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = stard;
            quickSort(arr, start,low-1);
            quickSort(arr, low+1,end);
        }
    }
}