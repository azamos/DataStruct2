package com.datastruct.ex2;

public class main {
	public static void main(String[] args) {
		
		String s1="amoszoharisawesomeamoszoharisawesome";
		String s2 = "amoszoharisalmostawesome1amoszoharisalmostawesome";
		String s3 = "";
		String s4 = "A";
		String s5 = "AA";
		String s6= "AB";
		String s7 = "ABA";
		String s8 = "ABAB";
		String s9 = "ababaababbababaaaababb";
		String s10 = "abbabbabbaaaaabbabbabba";
		String s11 = "baabaaabbabbabbaabaaabbabbab";
		String s12 = "abbabbaabbabba";
		LinkedList list = LinkedList.generateListFromString(s12);
		System.out.println(list.IS_WW());
	}
}
