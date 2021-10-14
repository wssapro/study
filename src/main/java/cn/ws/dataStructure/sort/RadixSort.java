package cn.ws.dataStructure.sort;

/**
 * 基数排序
 * @author wangshun
 * @date 2019/3/25 18:47
 */
public class RadixSort {
    public static void radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(max<arr[i])
                max=arr[i];
        }
        int maxlength = (max+"").length();
        int temp[][]=new int[arr.length][10];
        int counts[] = new int[10];
        for (int i = 0 ,n = 1; i < maxlength; i++,n*=10) {
            for (int j = 0; j < arr.length; j++) {
                int a = arr[j]/n%10;
                temp[counts[a]][a]=arr[j];
                counts[a]++;
            }
            int index = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < counts[j]; k++) {
                    arr[index] = temp[k][j];
                    index++;
                }
                counts[j] = 0;
            }
        }
    }
}
