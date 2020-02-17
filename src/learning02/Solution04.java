package learning02;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
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


public class Solution04 {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		while (l1 != null){
			list1.add(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			list2.add(l2.val);
			l2 = l2.next;
		}
		int diff = list1.size()-list2.size();
		if (list1.size() > list2.size()){
			for(int i=0; i<diff; i++){
				list2.add(0);
			}
		}
		if (list1.size() < list2.size()){
			for(int i=0; i<-diff;i++){
				list1.add(0);
			}
		}
		int boundary = list1.size();
		for(int i=0; i<boundary; i++){
			Integer temp = list2.get(i)+list1.get(i);
			if(temp>=10){
				if(i==list1.size()-1){
					list1.add(1);
				}else{
					list1.set(i+1,list1.get(i+1)+1);
				}
				list1.set(i, temp%10);
			}else{
				list1.set(i, temp);
			}
		}
		
		ListNode p= new ListNode(-1);
		ListNode res = p;
		for(int i=0; i <list1.size(); i++){
			ListNode listNode = new ListNode(list1.get(i));
			p.next = listNode;
			p = p.next;
		}
		
		return res.next;
	}
	
	public static void main(String[] args){
		ListNode listNode1 = new ListNode(9);
		ListNode listNode2 = new ListNode(1);
		ListNode listNode3 = new ListNode(6);
		listNode1.next=listNode2;
		listNode2.next=listNode3;
		ListNode listNode = new ListNode(1);
		ListNode l = addTwoNumbers(listNode, listNode1);
		while (l != null){
			System.out.print(l.val+". ");
			l = l.next;
		}
	}
}
