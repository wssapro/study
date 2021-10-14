package cn.ws.dataStructure.heap;


import cn.ws.dataStructure.Util;

/**
 * @author wangshun
 * @date 2019/3/26 16:42
 */
public class MaxHeap {
    private int data[];
    private int count;
    public MaxHeap() {
        data= new int[1];
        count = 0;
    }
    public MaxHeap(int arr[]){
        data = new int[arr.length+1];
        count = arr.length;
        for (int i = 0; i < arr.length; i++) {
            data[i+1] = arr[i];
        }
        for (int i = arr.length/2; i >=1 ; i--) {
            shiftDown(i);
        }
    }
    public void insert(int item){
        data = Util.arrayExpand(data);
        data[count+1] = item;
        count++;
        shiftUp( count );
    }
    private void shiftUp(int k){
        while(k>1 && data[k/2] < data[k]){
            Util.arraysSwap(data,k/2 , k);
            k/=2;
        }
    }
    public int extractMax(){
        int ret = 0;
        if(count>0){
            ret = data[1];
            Util.arraysSwap(data,1,count);
            count--;
            shiftDown(1);
            data = Util.arrayNarrow(data);
        }
        return ret;
    }
    private void shiftDown(int k){
        while(2*k <= count){
            int j = 2*k;
            if(2*k+1<=count && data[2*k]<data[2*k+1]){
                j=2*k+1;
            }
            if(data[k]>=data[j]){
                break;
            }
            Util.arraysSwap(data,j,k);
            k=j;
        }
    }
    public void heapSort(int arr[],int n){
        for(int i=(n-1)/2 ; i>=0 ; i--){
            shiftDown(arr,n,i);
        }
        for (int i = n-1; i > 0; i--) {
            Util.arraysSwap(arr,0,i);
            shiftDown(arr,i,0);
        }
    }
    private void shiftDown(int arr[],int n,int k){
        while(2*k+1 < n){
            int j = 2*k+1;
            if(2*k+2< n && arr[2*k+1]<arr[2*k+2]){
                j=2*k+2;
            }
            if(arr[k]>=arr[j]){
                break;
            }
            Util.arraysSwap(arr,j,k);
            k=j;
        }
    }
    public int[] getData() {
        return data;
    }
    public int size(){
        return count;
    }
    public boolean isEmpty(){
        return count==0;
    }
}
