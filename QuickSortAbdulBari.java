package com;

public class QuickSortAbdulBari {
	
	public static void main(String[] args) {
		int [] arr= new int[] {15,12,1,18,55,0,6,7,12,6};
		int low=0,high= arr.length-1;
		int []solution = quickSort(arr,low,high);
		for(int i=0;i< solution.length;i++) {
			System.out.print(solution[i]+" ");
		}

	}
	public static int[] quickSort(int[]arr,int low, int high) {
		
		
		
		if (low <= high) {
			int pivot = arr[low];
			int partition = partitionPivot(arr, low, high, pivot);
			
			quickSort(arr, low, partition - 1);
			quickSort(arr, partition + 1, high);
		}
		return arr;
	}
	private static int partitionPivot(int[] arr, int low, int high, int pivot) {
		int i=low+1,j=high;
		while(i<=j) {
			
			if(arr[i]>pivot && arr[j]<pivot) {
				int temp= arr[i];
				arr[i]= arr[j];
				arr[j]=temp;
				i++;j--;
			}
			else if(arr[i]<=pivot)
				i++;
			else if(arr[j]>pivot)
				j--;
		}
		int temp=arr[j];
		arr[j]=pivot;
		arr[low]=temp;
		
		return j;
	}


}
