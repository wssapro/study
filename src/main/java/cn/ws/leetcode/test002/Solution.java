package cn.ws.leetcode.test002;

/**
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        ListNode listNode = addTwoNumbers(l1, l2);
        do{
            System.out.print(listNode.val+">");
            listNode = listNode.next;
        } while (listNode!=null);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root= new ListNode(0);
        ListNode pointer = root;
        boolean carry = false;
        while(l1!=null||l2!=null||carry){
            if(l1==null){
                l1 =  new ListNode(0);
            }
            if(l2==null){
                l2 =  new ListNode(0);
            }
            int sum = l1.val + l2.val;
            if(carry){
                sum++;
            }
            pointer.next = new ListNode(sum % 10);
            pointer = pointer.next;
            carry = sum > 9 ? true : false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return root.next;
    }
}
