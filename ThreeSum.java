package com;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {

	public static void main(String[] args) {
		int [] array= new int[] {12,3,1,2,-6,5,-8,6};
		ArrayList<Integer[]> solution= new ArrayList();
		solution=findThreeSum(array,0);
		for(int i=0 ;i <solution.size();i++) {
			for(int j= 0 ;j<solution.get(i).length;j++) {
				System.out.println(solution.get(i)[j]);
			}
			System.out.println(" ");
		}

	}

	private static ArrayList<Integer[]> findThreeSum(int[] array, int targetSum) {
		
		Arrays.sort(array);
		ArrayList<Integer[]> solution= new ArrayList();
		boolean found= false;
		for(int i=0;i<array.length; i++) {
			int currentNum= array[i];
			int left= i+1;
			int right= array.length-1;
			while(left < right) {
				if (currentNum+array[left]+array[right]==targetSum){
					found= true;
					Integer[] arr= new Integer[] {currentNum,array[left],array[right]};
					solution.add(arr);
					left++;
					right--;
					
				}
				else if(currentNum+array[left]+array[right]>targetSum) {
					right--;
				}
				else if (currentNum+array[left]+array[right]<targetSum) {
					left ++;
				}
			}
		}
		return solution;
	}

}
