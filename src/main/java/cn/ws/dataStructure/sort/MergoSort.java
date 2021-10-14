package cn.ws.dataStructure.sort;

/**
 * 归并排序
 * @author wangshun
 * @date 2019/3/25 17:29
 */
public class MergoSort {

    public static void mergeSort(int arr[],int low,int high){
        int middle = (low+high)/2;
        if(low<high){
            mergeSort(arr, low, middle);
            mergeSort(arr, middle+1, high);
            merge(arr,low,middle,high);
        }
    }
    public static void merge(int arr[],int low,int middle,int high) {
        //存储归并后的临时数组
        int temp[] = new int [high-low+1];
        //用于记录第一个数组中需要遍历的下标
        int i = low;
        //用于记录第二个数组中需要遍历的下标
        int j = middle+1;
        //用于记录临时数组中的下标
        int index = 0;
        while(i<=middle && j<=high){
            if(arr[i]<=arr[j]){
                temp[index]=arr[i];
                i++;
            }else{
                temp[index]=arr[j];
                j++;
            }
            index++;
        }
        //处理多余的数据
        while(j<=high){
            temp[index]=arr[j];
            index++;
            j++;
        }
        while(i<=middle){
            temp[index]=arr[i];
            index++;
            i++;
        }
        //把临时数组中数据存到原数组
        for(int k=0;k<temp.length;k++){
            arr[k+low]=temp[k];
        }
    }
}
