package com;

public class HighestPalindromeNew {

	public static void main(String[] args) {
		int highest= findPalindrome(423434,3);

	}
	private static int findPalindrome(int num, int keys) {
	
		System.out.println("The original number : "+num);
		StringBuilder value= new StringBuilder(String.valueOf(num));
		boolean isOdd= false;
		if(value.length()%2 != 0) {
			isOdd= true;
		}
		
		int i= 0 ;
		int comp= value.length()-1;
		int diff=0;
		while(comp-i >=0) {
			 
			if(value.charAt(i)!= value.charAt(comp))
			{
				diff++;
			}
			
			i++;
			comp = value.length()-1-i;
		}
		System.out.println("Number of differences : "+diff);
		System.out.println("Number of changes allowed : "+keys);
		 i= 0 ;
		 comp= value.length()-1;
		 
		 if(!isOdd) {
			 
		 }
		return diff;

	}

}
