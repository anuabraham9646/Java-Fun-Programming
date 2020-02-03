package com;

import java.util.HashMap;
import java.util.HashSet;

public class lengthOfLongestSubstring {

	public static void main(String[] args) {
		longestSubstring("abcbcad");

	}
	public static void longestSubstring(String s) {
		int count = 0,maxcount=0,starti=0;
		
		
		StringBuilder window= new StringBuilder();
		HashMap<Character,Integer> windowChar= new HashMap();
		for( int i =0;i<s.length();i++) {
			if(windowChar.containsKey(s.charAt(i))) {
				int j=windowChar.get(s.charAt(i));
				windowChar.clear();
				if(maxcount<count)
					maxcount=count;
				count=0;
				i=j;
			}
			else {
				
				count++;
				windowChar.put(s.charAt(i),i);
				if(i==s.length()-1)
				{
					if(maxcount<count)
						maxcount=count;
				}
				
			}
		}
		System.out.println(maxcount);
		
	}
}
