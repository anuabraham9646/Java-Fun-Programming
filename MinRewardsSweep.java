package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MinRewardsSweep {

	public static void main(String[] args) {
		int[] scores= new int[] {8,4,2,1,3,6,7,9,5};
		int minVal= minRewards(scores);
		System.out.println(minVal);

	}
	
	public static int minRewards(int[] scores) {
		//System.out.println("hhhh");
		int reward=0;
		int[] rewards = new int[scores.length];
		
		Arrays.fill(rewards, 1);
		int leftIdx=1;

		while(leftIdx<= scores.length-1) {
			if(scores[leftIdx] > scores[leftIdx-1]) {
				rewards[leftIdx]=rewards[leftIdx-1]+1;
				
			}
			leftIdx++;
		}
		
		//System.out.println("hhh");
		
		int rightIdx=scores.length-2;
		while(rightIdx >= 0) {
			if(scores[rightIdx] > scores[rightIdx+1]) {
				rewards[rightIdx]= Math.max(rewards[rightIdx],rewards[rightIdx+1]+1);
				
			}
			rightIdx--;
		}
		for(int i=0; i < rewards.length;i++)
			System.out.println(rewards[i]);
		
		return IntStream.of(rewards).sum();
	}

}
