package cn.ws.leetcode.test001;

import java.util.Arrays;

/**
 * <p>
 *  两数之和
 * </p>
 *
 * @author shun
 * @date 2020-01-20 11:43
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] a = twoSum(nums,target);
        System.out.println(Arrays.toString(a));
    }
    public static int[] twoSum(int[] nums, int target) {
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
