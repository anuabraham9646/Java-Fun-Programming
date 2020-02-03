package com;

import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array= {2,7,-1,11,66};
		findSum(array,10);

	}

	private static void findSum(int[] array, int target) {

		HashMap<Integer,Integer>hm= new HashMap<>();
		boolean found= false;
		for(int i =0;i<array.length;i++) {
			int compliment = target-array[i];
			if(hm.containsKey(compliment)) {
				System.out.println("The 2 indexes are"+i+" and "+hm.get(compliment));
				found= true;
			}
			else {
				hm.put(array[i], i);
			}
		}
		if (!found)
		System.out.println("Pairs not found");
		
	}

}
