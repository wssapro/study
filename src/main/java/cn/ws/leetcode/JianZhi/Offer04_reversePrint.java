package cn.ws.leetcode.JianZhi;

/**
 * <p>
 *
 * </p>
 *
 * @author shun
 * @date 2020-06-24 15:57
 */
public class Offer04_reversePrint {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		int[] ints = reversePrint(null);
	}
	private static int[] reversePrint(ListNode head) {
		if(head==null){
			return new int[0];
		}
		ListNode root = head;
		int len = 1;
		while(root.next!=null){
			len++;
			root = root.next;
		}
		int[] result = new int[len];
		for (int i = len-1; i >=0; i--)
		{
			result[i] = head.val;
			head = head.next;
		}
		return  result;
	}
}

