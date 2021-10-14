package cn.ws.leetcode.JianZhi;

import java.util.HashSet;

/**
 * <p>
 *
 * </p>
 *
 * @author shun
 * @date 2020-06-24 11:02
 */
public class Offer01_findRepeatNumber
{

	public static void main(String[] args)
	{
		int a[] = new int[]{2, 3, 1, 0, 2, 5, 3};
		System.out.println(findRepeatNumber(a));
	}
	public static int findRepeatNumber(int[] nums) {
		HashSet<Integer> hashSet = new HashSet();
		for (int num : nums)
		{
			if (hashSet.contains(num))
			{
				return num;
			}
			else
			{
				hashSet.add(num);
			}
		}
		return 0;
	}
}
