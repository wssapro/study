package cn.ws.jdk8.threadTest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class run {

	public static void main(String[] args) {
		int[] nums = new int[]{1,5,4,2,3,6};
		System.out.println(topKMax(nums, 5));	//输出：[2, 3, 4, 5, 6]
	}
	
	//寻找前k个最大的数--使用小顶堆
	public static List<Integer> topKMax(int[] nums, int k){
		//寻找前k个最小数，因此将小顶堆大小定义为k
		PriorityQueue<Integer> pq = new PriorityQueue<>(k);
		for(int i=0; i<nums.length; i++){
			if(i<k){
				pq.offer(nums[i]);	//前k个数，直接入堆
			}else if(nums[i]>pq.peek()){	//如果当前元素比堆顶元素大
				pq.poll();	//说明堆顶元素（堆中最小元素）一定不属于前k大的数，出堆
				pq.offer(nums[i]);	//当前元素有可能属于前k大，入堆
			}
		}
		
		List<Integer> ans = new ArrayList<>();
		while(!pq.isEmpty()){
			ans.add(pq.poll());
		}
		return ans;
	}
}
