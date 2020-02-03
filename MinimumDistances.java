package com;
import java.util.Arrays;
public class MinimumDistances {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1= new int[] {-1,5,10,20,3};	//-1 3 5 10 20 28 136
		int[] array2= new int[] {26,134,135,15,17};		 //15 17 26 134 135
		int []solution= findMinimumDistance(array1,array2);
		for(int i=0; i < solution.length;i++)
			System.out.println(solution[i]);
	}

	private static int[] findMinimumDistance(int[] array1, int[] array2) {

		Arrays.sort(array1);
		Arrays.sort(array2);
		
		int ptr1 = 0, ptr2=0;
		int minDist= Integer.MAX_VALUE;
		int val1 = 0,val2 = 0,diff;
		while(ptr1<array1.length || ptr2<array2.length) {
		
			if(ptr1 ==array1.length || ptr2==array2.length)
				break;
			
			if(array1[ptr1] == array2[ptr2]) {
				return new int[] {array1[ptr1],array2[ptr2]};
			}
			
			diff=Math.abs(array1[ptr1] - array2[ptr2]);
			if(diff < minDist) {
				minDist=diff;
				val1= array1[ptr1];
				val2= array2[ptr2];
				
			}

			if (array1[ptr1] > array2[ptr2]){	
				ptr2++;
				
			}
			else if (array1[ptr1] < array2[ptr2]){
					ptr1++;
			}
		}
		return new int[] {val1,val2};
	}

}
