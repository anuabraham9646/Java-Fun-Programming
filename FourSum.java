package com;

import java.util.*;
import java.util.stream.Collectors;

public class FourSum {

	public static void main(String[] args) {

		int [] arr= new int[] {7,6,4,-1,1,2};
		int target =16;
		
		List<Integer[]> result= fourNumberSum(arr, target);
		
		for(Integer[] pair : result) {
			for( Integer val : pair) {
				System.out.print(val+" ");
			}
			System.out.println(" ");
		}

	}
	
	
	public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
	    // Write your code here.
		
		//List<Integer> lis= Arrays.stream(array).boxed().sorted().collect(Collectors.toList());
		
		HashMap<Integer, List<Integer[]>> hash= new HashMap<>();
		List<Integer[]> result = new ArrayList<Integer[]>();
		for(int i=1;i< array.length-1;i++) {
			
			for(int j=i+1;j<array.length;j++) {
				int sum= array[i]+array[j];
				int diff= targetSum-sum;
				
				if(hash.containsKey(diff)) {
					for(Integer[] pair : hash.get(diff)) {
						Integer[] quad= new Integer[] {pair[0],pair[1],array[i],array[j]};
						result.add(quad);
					}
				}
				
				
			}
			
			for(int k=0;k<i;k++) {
				int key= array[i]+ array[k];
				Integer[] val= new Integer[] {array[i],array[k]};
				if(hash.containsKey(key)) {
					
					hash.get(key).add(val);
				}
				else {
					List<Integer[]> lis= new ArrayList<Integer[]>();
					lis.add(val);
					hash.put(key, lis);
				}
			}
			
			
			
		}
	    return result;
	  }

}
