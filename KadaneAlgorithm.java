package com;

public class KadaneAlgorithm {

	public static void main(String args[]) {
		
		
		int [] arr= new int[] {3,5,-9,1,3,-2,3,4,7,2,-9,6,3,1,-5,4};
		int maxSum= kadanesAlgorithm(arr);
		System.out.println(maxSum);
		
	}
	
	


	public static int kadanesAlgorithm(int[] array) {
	   

		int sum=0,  maxSum=0;
		for(int i=0;i<array.length;i++) {
			if(i==0) {
				sum= array[i];
				maxSum=sum;
			}
			else {
				sum= Math.max(sum+array[i], array[i]);
			}
			
			maxSum= sum>maxSum? sum: maxSum;
			
		}
	    return maxSum;
	  }
}