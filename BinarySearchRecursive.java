package com;

public class BinarySearchRecursive {

	public static void main(String[] args) {
		int [] arr= new int[] {1,9,11,15,40,66,100};
		int low=0,high= arr.length-1;
		int location= binarySearch(arr,11,low,high);
		System.out.println(location);

	}
	public static int binarySearch(int[] array, int target, int low, int high) {
		int mid= (low+high)/2;
		if(low==high) {
			if (array[low]==target)
				return low+1;
			else
				return -1;
		}
		else {
			if (array[mid] > target)
				return binarySearch(array, target, low, mid-1);
			
			else if (array[mid] == target)
				return mid + 1;
			else {
				return binarySearch(array, target, mid + 1, high);
			}
		}

		
	}
}
