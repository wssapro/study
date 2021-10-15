package cn.ws.dataStructure.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author wangshun
 * @date 2019/3/23 23:35
 */
public class Quicksort {
    public static void sort(int[] arr, int start, int end){
        if (start < end) {
            int flat = arr[start];
            int low = start;
            int high = end;
            while (low < high) {
                while (low < high && arr[high] >= flat) {
                    high--;
                }
                arr[low] = arr[high];

                while (low < high && arr[low] <= flat) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = flat;
            if (start < low - 1) {
                sort(arr, start, low - 1);
            }
            if (low + 1 < end) {
                sort(arr, low + 1, end);
            }
        }
    }
    public static void print(int[] arr){
        System.out.println(Arrays.toString(arr));
    }
}