package cn.ws.dataStructure.heap;

import java.util.Arrays;

/**
 * @author wangshun
 * @date 2019/3/26 16:45
 */
public class MaxHeapTest {

    private static int arr[] = new int[]{12,23,32,21,45,56};
    public static void main(String[] args) {
        //heap();
        //heapSort();
        //heapifySort();

        MaxHeap maxHeap = new MaxHeap();
        maxHeap.heapSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    //插入
    public static void heap(){
        MaxHeap maxHeap = new MaxHeap();
        for (int i = 0; i < arr.length; i++) {
            maxHeap.insert(arr[i]);
        }
        while(!maxHeap.isEmpty()){
            System.out.print(maxHeap.extractMax()+" ");
        }
        System.out.println();

    }
    //每插入一个都生成最大数
    public static void heapSort(){
        MaxHeap maxHeap = new MaxHeap();
        for (int i = 0; i < arr.length; i++) {
            maxHeap.insert(arr[i]);
        }
        for (int i = arr.length-1; i >=0; i--) {
            arr[i] = maxHeap.extractMax();
        }
        System.out.println(Arrays.toString(arr));
    }
    //先写成一个树，再从最后一个不是叶子节点的节点判断
    public static void heapifySort(){
        MaxHeap maxHeap = new MaxHeap(arr);
        for (int i = arr.length-1; i >=0; i--) {
            System.out.print(maxHeap.extractMax());
        }

    }
}
