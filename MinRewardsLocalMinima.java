package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MinRewardsLocalMinima {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores= new int[] {8,4,2,1,3,6,7,9,5};
		int minVal= minRewards(scores);
		System.out.println(minVal);

	}
	
	public static int minRewards(int[] scores) {
	    int minScore= 0;
	    if(scores.length==1)
	    	return 1;
	    HashMap<Integer,Integer> scoreReward= new HashMap<>();
	    List<Integer> minSpots= new ArrayList<>();
	    
	    for(int score :scores) {
	    	scoreReward.put(score, -1);
	    }
	    
	    findMinSpots(scores,scoreReward,minSpots);
	    
	    
	    for(int minIdx : minSpots) {
	    	//System.out.println(minIdx);
	    	expandFromMin(scoreReward,minIdx,scores);
	    }
	    
	    for(Map.Entry<Integer, Integer> entry : scoreReward.entrySet()) {
	    	System.out.println(entry.getKey() + " : " +entry.getValue());
	    }
	    
	    for(Map.Entry<Integer, Integer> entry : scoreReward.entrySet()) {
	    	minScore+=entry.getValue();
	    }
	    
	    return minScore;
	  }

	private static void expandFromMin(HashMap<Integer, Integer> scoreReward, int minIdx, int[] scores) {

		int left =minIdx-1;
		while(left >=0 && scores[left]> scores[left+1]) {
			int rew= Math.max(scoreReward.get(scores[left]), (scoreReward.get(scores[left+1])+1));
			scoreReward.put(scores[left], rew);
			left--;
		}
		
		int right =minIdx+1;
		while(right <=scores.length-1 && scores[right]> scores[right-1]) {
			scoreReward.put(scores[right], scoreReward.get(scores[right-1])+1);
			right++;
		}
		
	}

	private static void findMinSpots(int[] scores, HashMap<Integer, Integer> scoreReward, List<Integer> minSpots) {

		for(int i=0;i<scores.length;i++) {
			int num= scores[i];
			if(i==0) {
				if(num < scores[i+1]) {
					scoreReward.put(num, 1);
					minSpots.add(i);
				}
			}
			else if(i==scores.length-1) {
				if(num<scores[i-1]) {
					scoreReward.put(num, 1);
					minSpots.add(i);
				}
			}
			else {
				if(num < scores[i+1] && num<scores[i-1]) {
					scoreReward.put(num, 1);
					minSpots.add(i);
				}
			}
		}
		
	}

}
