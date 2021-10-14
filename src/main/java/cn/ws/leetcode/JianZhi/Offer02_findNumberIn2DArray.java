package cn.ws.leetcode.JianZhi;

/**
 * <p>
 *
 * </p>
 *
 * @author shun
 * @date 2020-06-24 14:28
 */
public class Offer02_findNumberIn2DArray
{
	public static void main(String[] args)
	{
		int a[][] = new int[5][5];
		int a1[] = new int[]{1, 2, 3, 4, 5};
		int a2[] = new int[]{6, 7, 8, 9, 10};
		int a3[] = new int[]{11, 12, 13, 14, 15};
		int a4[] = new int[]{16, 17, 18, 19, 20};
		int a5[] = new int[]{21, 22, 23, 24, 25};
		a[0] = a1;
		a[1] = a2;
		a[2] = a3;
		a[3] = a4;
		a[4] = a5;


		int aa[][]={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		aa= new int[][]{{-5}};
		aa= new int[][]{{}};
		System.out.println(findNumberIn2DArray2(aa, 15));
	}

	public static boolean findNumberIn2DArray2(int[][] matrix, int target)
	{
		int row = matrix.length - 1;
		int col = 0;
		while (row >= 0 && col < matrix[0].length) {
			if(target > matrix[row][col]){
				col++;
			}else if(target < matrix[row][col]){
				row--;
			}else{
				return true;
			}

		}
		return false;
	}

	public static boolean findNumberIn2DArray(int[][] matrix, int target)
	{
		if (matrix.length == 0 || matrix[0].length == 0)
		{
			return false;
		}
		int row = matrix.length / 2;
		int col = matrix[0].length / 2;

		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				if (matrix[i][j] == target)
				{
					return true;
				}
			}
		}
		return false;
	}

}

