package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LargestRange {

	public static void main(String[] args) {
		int []arr= new int[] {8,4,2,10,3,6,7,9,1};
		int [] res= largestRange(arr);
		for(int val : res)
			System.out.println(val);
	}
	
	public static int[] largestRange(int[] array) {
		
		
		if(array.length==1)
			return new int[] {array[0],array[0]};
		HashMap<Integer, Boolean> number =new HashMap<>();
		List<Integer> lis= new ArrayList<>();
		int [] range= new int[2];
		int largest= 0;
		for(int i=0;i<array.length;i++) {
			int num= array[i];
			if(!number.containsKey(num)) {
				number.put(num, false);
			}
		}
		for(int i=0; i<array.length;i++) {
			
			if (!number.get(array[1])) {
				int leftIndex, rightIndex;
				leftIndex = array[i] - 1;
				rightIndex = array[i] + 1;
				int currentLength = 1;
				number.put(array[i], true);
				while (number.containsKey(leftIndex)) {
					number.put(leftIndex, true);
					currentLength++;
					leftIndex--;
				}
				while (number.containsKey(rightIndex)) {
					number.put(rightIndex, true);
					currentLength++;
					rightIndex++;
				}
				if (currentLength > largest) {
					largest=currentLength;
					range[0] = leftIndex + 1;
					range[1] = rightIndex - 1;
				} 
			}
				
		}
		return range;
		
	}



}
