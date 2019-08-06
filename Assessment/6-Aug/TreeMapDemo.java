package com.tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
public class TreeMapDemo {
public static void main(String[] args) {
		
		//Map is used to store key:value pairs
		//HashMap doesn't follow any order, hence there is no guarantee for the order
		//Tree Map stores elements in ascending order of keys
		TreeMap tm1 = new TreeMap();
		tm1.put("akshat","Cognizant");		
		tm1.put("subham", "tcs");
		tm1.put("sonal", "wipro");
		tm1.put("sweta", "pwc");
		tm1.put("sunil", "itc");
		
		Set <Map.Entry<String,String>> s= tm1.entrySet();
		Iterator <Map.Entry<String,String>> itr1 = s.iterator();
		while(itr1.hasNext())
		{
			Map.Entry<String,String> me = itr1.next();
			System.out.println("Key: "+me.getKey()+"    "+"value: "+me.getValue());
		}
		
		return;
}
}
