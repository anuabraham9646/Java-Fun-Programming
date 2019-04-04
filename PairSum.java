package com;

import java.util.HashSet;
import java.util.Set;

public class PairSum {
	public void sumPair(int[] array, int target) {
		HashSet<Integer> pair= new HashSet();
		for(int i=0;i<array.length;i++) {
			pair.add(array[i]);
		}
		for(int i=0;i<array.length;i++) {
			pair.add(array[i]);
			if(pair.contains(target-array[i])) {
				System.out.println(i);
				//System.out.println(pair.);
			}
		}
		
		
	}
	public static void main(String args[]) {
		int array[]= {2, 7, 11, 15};
		int target=9;
		PairSum ob= new PairSum();
		ob.sumPair(array,target);
	}

}
