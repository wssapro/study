package cn.ws.dataStructure.sort;
import java.util.Arrays;

/**
 * @author wangshun
 * @date 2019/3/25 16:13
 */
public class Test {
    public static void main(String[] args) {
        //长度为N的数组
        int arr[] = new int[]{5,8,1,4,6,9,2,3,7};
        System.out.println(Arrays.toString(arr));
        /**
         * 1.冒泡排序
         * 外循环遍历N-1次，内循环第一次N-1次，之后递减。与前一个作比较，
         */
        // BubbleSort.bubbleSort(arr);
        /**
         * 2.快速排序
         * 递归用法，先通过第一个数把数组分为小于它和大于它的两部门，
         * 在用递归以同样的方法处理这两部门，以及下去直到结束
         */
        Quicksort.sort(arr, 0,arr.length-1);
        /**
         * 3.插入排序
         * 始终认为前面是已经排好序的，寻找符合的位置插进去
         */
        // InsertSort.insertSort(arr);
        /**
         * 4.希尔排序
         * 快速版的插入排序，插入排序调整位置太多次，通过有规律的相隔比较进行插入
         * 最后进行一次插入排序，
         */
        //ShellSort.ShellSort(arr);
        /**
         * 5.选择排序
         * 第一次遍历N次，选择最小的与第一位交换
         * 之后依次第二小的放在第二位
         * 总比较次数n+(n-1)+(n-2)+...+1
         */
        //SelectSort.slesctSort(arr);
        /**
         * 6.归并排序
         * 递归思想，
         * 把原数组从中间分成两个数组，两个新数组一一对比，
         * 按从小到大的顺序写入一个和原数组一样大的临时数组，最后在写入原数组
         */
        //MergoSort.mergeSort(arr,0,arr.length-1);
        /**
         * 基数排序
         * 从个位数开始按0-9存到一个二维数组中，然后取出
         * 再按十位数组进行同样的操作
         * 依次进行，直到最高位
         */
        //RadixSort.radixSort(arr);
        /**
         * 基数排序之队列实现
         * 把上面的二维数组用队列的形式实现
         */
        // RadixQueueSort.radixQueueSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
