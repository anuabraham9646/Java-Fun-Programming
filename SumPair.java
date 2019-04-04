package com;

import java.util.ArrayList;

public class SumPair {
	
	public static boolean pair(int array[],int sum) {
		System.out.println(array.length);
		int low= 0;
		int high= (array.length - 1);
		while(low<high) {
			if(array[low]+array[high]== sum)
				return true;
			else if(array[low]+array[high]< sum)
				low++;
			else
				high--;
			
		}
		return false;
	}
	public static boolean unsorted(int array[],int sum) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for(int i =0; i< array.length;i++) {
			if(al.contains(array[i])) {
				return true;
			}
			else {
				int val= sum-array[i];
				al.add(val);
			}
		}
		
		
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[]= {1,2,3,4,8,9};
		System.out.println(SumPair.pair(array,8));
		
		int array1[]= {1,1,6,4,8};
		System.out.println(SumPair.unsorted(array1,8));
		

	}

}
