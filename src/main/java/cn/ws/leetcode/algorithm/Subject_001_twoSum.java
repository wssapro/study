package cn.ws.leetcode.algorithm;

/**
 * @author shun
 * @date 2020-12-25 14:44
 */
public class Subject_001_twoSum {

	public static void main(String[] args) {

	}
	public int[] twoSum(int[] nums, int target) {
		int [] a = new int[2];
		for(int i=0;i<nums.length;i++){
			for(int j =i+1;j<nums.length;j++){
				if(nums[i]+nums[j]==target){
					a[0]=i;
					a[1]=j;
				}
			}
		}
		return a;
	}
}
