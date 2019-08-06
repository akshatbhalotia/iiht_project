package com.comprtr;

import java.util.Comparator;
import java.util.TreeSet;

public class SetComparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<String> tss =new TreeSet<String>(new MyComp());
		tss.add("a");
		tss.add("aaa");
		tss.add("aa");
		tss.add("aaaaaa");
		tss.add("aaaaa");
		
		System.out.println(tss);
	}

}

class MyComp implements Comparator<String>
{
	public int compare(String str1,String str2)
	{
		return str1.length()-str2.length();
		
	}
}
