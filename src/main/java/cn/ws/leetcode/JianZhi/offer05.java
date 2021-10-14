package cn.ws.leetcode.JianZhi;

import java.util.ArrayList;

/**
 * <p>
 *
 * </p>
 *
 * @author shun
 * @date 2020-06-24 16:12
 */
public class offer05
{
	public static void main(String[] args)
	{
		buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder)
	{
		int rootValue = preorder[0];
		TreeNode root = new TreeNode(rootValue);
		return root;
	}
	public void buildOne(TreeNode root , int[] inorder){
		ArrayList<Integer> left = new ArrayList();
		ArrayList<Integer> right = new ArrayList();
		int index = 0;
		while(inorder[index] != root.val){
			left.add(inorder[index]);
			index++;
		}
		while (index!=inorder.length){
			right.add(inorder[index]);
			index++;
		}

		if(left.size()==1){
			root.left = new TreeNode(left.get(0));
		}
		else if(left.size()>1){
		}

		if(right.size()==1){
			root.right = new TreeNode(right.get(0));
		}
		else {

		}

	}
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

