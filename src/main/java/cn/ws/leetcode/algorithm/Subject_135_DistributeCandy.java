package cn.ws.leetcode.algorithm;

/**
 * 分发糖果
 *
 * @author shun
 * @date 2020-12-24 21:11
 */
public class Subject_135_DistributeCandy {

	public static void main(String[] args) {
		int[] list = {1, 2, 2};
		//int[] list = {1,3,2,2,1};
		//int[] list = {1,2,87,87,87,2,1};
		//int[] list = {1,2,3,5,4,3,2,1,4,3,2,1};
		System.out.println(candy(list));
	}

	public static int candy(int[] ratings) {
		int[] result = new int[ratings.length];
		int index = 0;
		result[0] = 1;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] == ratings[i - 1]) {
				index = i;
				result[i] = 1;
			}
			else if (ratings[i] > ratings[i - 1]) {
				index=i;
				result[i] = result[i - 1] + 1;
			}
			else {
				result[i] = 1;
				int end = i;
				while (end > index && result[end - 1] <= result[end]) {
					result[end - 1]++;
					end--;
				}
			}
		}
		int num = 0;
		for (int value : result) {
			num += value;
		}
		return num;
	}
}
