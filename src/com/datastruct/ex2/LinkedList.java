/*name: amos zohar, id:311402812*/
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
		if(this.first!=null && this.first.next==null) {
			return false;//single char
		}
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
	public boolean IS_PALINDROM() {
		if(this.isEmpty()||this.len==1) {
			return true;
		}
		if(this.len==2) {
			return this.first.val == this.first.next.val;
		}
		int counter = 1;
		Node leftEnd = this.first;
		while(counter < this.len/2) {
			leftEnd = leftEnd.next;
			counter++;
		}
		/*If len is odd, skip middle element*/
		if(this.len%2==1) {
			leftEnd.next = leftEnd.next.next;
			this.len--;
		}
		Node rightStart = leftEnd.next;
		Node prev = null;
		Node curr = rightStart;
		while(curr!=null) {
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr=temp;
			if(curr==this.last) {
				leftEnd.next = curr;
				this.last = rightStart;
			}
		}
		int i =0;
		Node t1 = this.first;
		Node t2 = leftEnd.next;
		while(t1!=null&&t2!=null) {
			if(t1.val!=t2.val) {
				return false;
			}
			t1=t1.next;
			t2 = t2.next;
		}
		return true;
	}
	public static void main(String[] args) {
		String s1="amoszoharisawesomeamoszoharisawesome";//true,false
		String s2 = "amoszoharisalmostawesome1amoszoharisalmostawesome";//false,false
		String s3 = "";//true, true
		String s4 = "A";//false,true
		String s5 = "AA";//true,true
		String s6= "AB";//false,false
		String s7 = "ABA";//false,true
		String s8 = "ABAB";//true,false
		String s9 = "ababaababbababaaaababb";//false,false
		String s10 = "abbabbabbaaaaabbabbabba";//false,true
		String s11 = "baabaaabbabbabbaabaaabbabbab";//true,false
		String s12 = "abbabbaabbabba";//true,true
		String s13 = "amossoma";//false,true
		String[] stringArray = {s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13};
		for(int i =0;i<stringArray.length;i++) {
			LinkedList list = LinkedList.generateListFromString(stringArray[i]);
			System.out.print(i+1);
			System.out.print(" isWW : ");
			System.out.print(list.IS_WW());
			System.out.print(" , is palindrom: ");
			System.out.print(list.IS_PALINDROM());
			System.out.println();
		}
	}
}
