package com.datastruct.ex2;

public class main {
	public static void main(String[] args) {
		String s1="amoszoharisawesomeamoszoharisawesome";//yes ww, not pali
		String s2 = "amoszoharisalmostawesome1amoszoharisalmostawesome";//not ww, not pali
		String s3 = "";//yes ww, yes pali
		String s4 = "A";//not ww, yes pali
		String s5 = "AA";//yes ww, yes pali
		String s6= "AB";//not ww, not pali
		String s7 = "ABA";//not ww, yes pali
		String s8 = "ABAB";//yes ww, not pali
		String s9 = "ababaababbababaaaababb";//not ww, not palindrom
		String s10 = "abbabbabbaaaaabbabbabba";//not ww, yes palindrom
		String s11 = "baabaaabbabbabbaabaaabbabbab";//yes ww, not pali
		String s12 = "abbabbaabbabba";//yes ww, yes pali
		String s13 = "amossoma";//not ww, yes pali
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
