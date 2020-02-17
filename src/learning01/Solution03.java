package learning01;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 */
class ListNode {
	int val;
	ListNode next;
	
	ListNode(int x) {
		val = x;
	}
}

public class Solution03 {
	
	// 递归法
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null){
			return l2;
		}
		if (l2 == null){
			return l1;
		}
		if (l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
	
	// 迭代法
	public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		ListNode res = new ListNode(-1);
		ListNode pre = res;
		while (l1 != null && l2 != null){
			if(l1.val < l2.val){
				pre.next = l1;
				l1 = l1.next;
			}else {
				pre.next = l2;
				l2 = l2.next;
			}
			pre = pre.next;
		}
		pre.next = l1 == null ? l2 : l1;
		return res.next;
	}
	
	public static void main(String[] args){
		// [-10,-9,-6,-4,1,9,9]
		ListNode l1 = new ListNode(-10);
		ListNode l2 = new ListNode(-9);
		ListNode l3 = new ListNode(-6);
		ListNode l4 = new ListNode(-4);
		ListNode l5 = new ListNode(1);
		ListNode l6 = new ListNode(9);
		ListNode l7 = new ListNode(9);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		
		//[-5,-3,0,7,8,8]
		ListNode l8 = new ListNode(-5);
		ListNode l9 = new ListNode(-3);
		ListNode l10 = new ListNode(0);
		ListNode l11 = new ListNode(7);
		ListNode l12 = new ListNode(8);
		ListNode l13 = new ListNode(8);
		l8.next=l9;
		l9.next=l10;
		l10.next=l11;
		l11.next=l12;
		l12.next=l13;
		
		ListNode newL = mergeTwoLists2(l1, l8);
		ListNode nextNode = newL;
		while (nextNode!=null){
			System.out.print(nextNode.val +"->");
			nextNode = nextNode.next;
		}
	}
}
