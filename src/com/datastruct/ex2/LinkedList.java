package com.datastruct.ex2;

public class LinkedList {
	public int len;
	public Node first;
	public Node last;
	
	public boolean isEmpty() {
		return this.len == 0;
	}
	public void insert(char newVal) {
		Node newNode = new Node(newVal);
		if(this.isEmpty()) {
			this.first = newNode;
			this.last = this.first;
		}
		else {
			this.last.next = newNode;
			this.last = newNode;
		}
		this.len++;
	}
	public class Node{
		public Node next;
		public char val;
		public Node(char val) {
			this.val = val;
			this.next = null;
		}
	}
	
	public static LinkedList generateListFromString(String str) {
		LinkedList list = new LinkedList();
		for(int i =0;i<str.length();i++) {
			char s = str.charAt(i);
			list.insert(s);
		}
		return list;
	}
	
	public boolean IS_WW() {
		Node step = this.first;
		Node doubleStep = this.first;
		/* I use doubleStep to get to the middle of the list,
		 * and if the list is odd, it will return false*/
		while(doubleStep!=null && doubleStep.next!=null) {
			step = step.next;
			if(doubleStep.next==null) {
				return false;
			}
			doubleStep = doubleStep.next.next;
		}
		/*the fact we are here means that the list is of even
		 * length, and if our list indexes are 1 to 2n,
		 * step is now at n+1, and we can commence the process
		 * of comparing both halfs of the list*/
		Node firstHalfTraverser = this.first;
		while(step!=null) {
			if(firstHalfTraverser.val!=step.val) {
				return false;
			}
			firstHalfTraverser = firstHalfTraverser.next;
			step = step.next;
		}
		/*If we got here, it means that all comparisons between
		 * the 2 halfs were true, thus we can return true*/
		return true;
	}
}
