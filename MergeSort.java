package com;

public class MergeSort {

	public static void main(String[] args) {
		int [] arr= new int[] {15,12,1,18,55,0,44,7,6,6};
		int low=0,high= arr.length-1;
		int []solution = mergeSort(arr,low,high);
		System.out.println("");
		for(int i=0;i< solution.length;i++) {
			System.out.print(solution[i]+" ");
		}

	}
	public static int[] mergeSort(int[] arr, int low, int high) {
		
		int mid= (low+high)/2;
		if(low < high) {
			System.out.println("1st merge "+low+" "+high);
			
			mergeSort(arr,low,mid);
			
			System.out.println("2st merge "+low+" "+high);
			mergeSort(arr,mid+1,high);
			merge(arr,low,mid,high);
		}
		
		return arr;
		
	}
	private static void merge(int[] arr, int low, int mid, int high) {
		//System.out.println(low);
		//System.out.println(high);
		//System.out.println(" ");
		System.out.println("inside merge "+low+" "+high);
		int [] sort= new int[high-low+1];
		int i=low,j=mid+1,k=0;
		while(i<=mid && j<=high) {
			if(arr[i]<=arr[j]) {
				sort[k]=arr[i];
				k++;
				i++;
			}
			else if(arr[i]>arr[j]) {
				sort[k]=arr[j];
				k++;
				j++;
			}
		}
		while(i<=mid) {
			sort[k]=arr[i];
			i++;
			k++;
		}
		while(j<=high) {
			sort[k]=arr[j];
			j++;
			k++;
		}
		for(int l=0;l<k;l++)
			arr[low+l]=sort[l];
		
		for(int p=0;p< sort.length;p++) {
			System.out.print(sort[p]+" ");
		}
		
	}

}
