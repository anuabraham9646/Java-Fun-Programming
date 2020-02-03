package com;

public class SubarraySort1 {

	public static void main(String[] args) {
		int []arr= new int[] {1,2,4,7,10,11,7,12,6,7,16,18,19};
		int [] res= subarraySort(arr);
		for(int val : res)
			System.out.println(val);

	}
	
	public static int[] subarraySort(int[] array) {
		int minOutOfSort= Integer.MAX_VALUE;
		int maxOutOfSort= Integer.MIN_VALUE;
		
		for(int i=0;i<array.length;i++) {
			int num= array[i];
			if(isOutOfOrder(i,array,num)) {
				minOutOfSort= Math.min(minOutOfSort, num);
				maxOutOfSort=Math.max(maxOutOfSort, num);
			}
		}
		
		if(minOutOfSort == Integer.MAX_VALUE)
			return new int[] {-1,-1};
		
		int leftIndex=0;
		while(array[leftIndex]<=minOutOfSort)
			leftIndex++;
		
		int rightIndex=array.length-1;
		while(array[rightIndex] >= maxOutOfSort)
			rightIndex--;
		
		return new int[] {leftIndex,rightIndex};
	}

	private static boolean isOutOfOrder(int i, int[] array, int num) {
		
		if(i==0)
			return num > array[i+1];
		else if (i== array.length-1)
			return num < array[i-1];
			
		else {
			return num < array[i-1] || num > array[i+1];
		}
	}

}
