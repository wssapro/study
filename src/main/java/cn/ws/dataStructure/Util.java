package cn.ws.dataStructure;

/**
 * @author wangshun
 * @date 2019/3/26 16:51
 */
public class Util {
    public static void arraysSwap(int arr[],int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static int[] arrayExpand (int arr[]){
        if(arr==null){
            return new int[1];
        }
        int a[] = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            a[i]=arr[i];
        }
        return a;
    }
    public static int[] arrayNarrow (int arr[]){
        int a[] = new int[arr.length-1];
        for (int i = 0; i < a.length; i++) {
            a[i]=arr[i];
        }
        return a;
    }
}
