package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApartmentHunting {

	public static void main(String[] args) {

		List<Map<String,Boolean>> blocks = new ArrayList<Map<String,Boolean>>();
		blocks.add(0, new HashMap<String,Boolean>());
		blocks.get(0).put("gym", true);
		blocks.get(0).put("office", false);
		blocks.get(0).put("pool", false);
		blocks.get(0).put("school", true);
		blocks.get(0).put("store", false);
		
		blocks.add(1, new HashMap<String,Boolean>());
		blocks.get(1).put("gym", false);
		blocks.get(1).put("office", false);
		blocks.get(1).put("pool", false);
		blocks.get(1).put("school", false);
		blocks.get(1).put("store", false);
		
		blocks.add(2, new HashMap<String,Boolean>());
		blocks.get(2).put("gym", false);
		blocks.get(2).put("office", true);
		blocks.get(2).put("pool", false);
		blocks.get(2).put("school", true);
		blocks.get(2).put("store", false);
		
		blocks.add(3, new HashMap<String,Boolean>());
		blocks.get(3).put("gym", false);
		blocks.get(3).put("office", true);
		blocks.get(3).put("pool", false);
		blocks.get(3).put("school", false);
		blocks.get(3).put("store", false);
		
		blocks.add(4, new HashMap<String,Boolean>());
		blocks.get(4).put("gym", false);
		blocks.get(4).put("office", false);
		blocks.get(4).put("pool", false);
		blocks.get(4).put("school", false);
		blocks.get(4).put("store", true);
		
		blocks.add(5, new HashMap<String,Boolean>());
		blocks.get(5).put("gym", true);
		blocks.get(5).put("office", true);
		blocks.get(5).put("pool", false);
		blocks.get(5).put("school", false);
		blocks.get(5).put("store", false);
		
		blocks.add(6, new HashMap<String,Boolean>());
		blocks.get(6).put("gym", false);
		blocks.get(6).put("office", false);
		blocks.get(6).put("pool", true);
		blocks.get(6).put("school", false);
		blocks.get(6).put("store", false);
		
		blocks.add(7, new HashMap<String,Boolean>());
		blocks.get(7).put("gym", false);
		blocks.get(7).put("office", false);
		blocks.get(7).put("pool", false);
		blocks.get(7).put("school", false);
		blocks.get(7).put("store", false);
		
		blocks.add(8, new HashMap<String,Boolean>());
		blocks.get(8).put("gym", false);
		blocks.get(8).put("office", false);
		blocks.get(8).put("pool", false);
		blocks.get(8).put("school", false);
		blocks.get(8).put("store", false);

		blocks.add(9, new HashMap<String,Boolean>());
		blocks.get(9).put("gym", false);
		blocks.get(9).put("office", false);
		blocks.get(9).put("pool", false);
		blocks.get(9).put("school", true);
		blocks.get(9).put("store", false);
		
		blocks.add(10, new HashMap<String,Boolean>());
		blocks.get(10).put("gym", false);
		blocks.get(10).put("office", false);
		blocks.get(10).put("pool", true);
		blocks.get(10).put("school", false);
		blocks.get(10).put("store", false);
		
		String [] reqs= new String [] {"gym","pool","school","store"};
		int min = apartmentHunting(blocks, reqs);
		System.out.println(min);

	}
	
	 public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {

		 	int [][] minDistFromBlocks= new int [reqs.length][];
		 	for(int i=0; i< reqs.length;i++) {
		 		minDistFromBlocks[i]= findMinDistFromBlocks(blocks,reqs[i]);	 		
		 	}


		 	int blocknum=-1;
		 	int minBlocksValue=Integer.MAX_VALUE;
		 	for(int j=0;j< blocks.size();j++) {
		 		int max=-1;
		 		for(int i=0; i< reqs.length;i++) {


		 			if(minDistFromBlocks[i][j]> max)
		 				max= minDistFromBlocks[i][j];
		 		}
		 		if(max < minBlocksValue)
		 		{
		 			minBlocksValue=max;
		 			blocknum=j;
		 		}
		 			
		 	}
		 	
		    return blocknum;
		  }

	private static int[] findMinDistFromBlocks(List<Map<String, Boolean>> blocks, String req) {
		
		int [] minDistances= new int [blocks.size()];
		Arrays.fill(minDistances, Integer.MAX_VALUE);
		for(int i=0;i< blocks.size();i++) {
			
			if(blocks.get(i).get(req)) {
				minDistances[i]=0;
			}
			else {
				if(i== 0 || minDistances[i-1]==Integer.MAX_VALUE)
					continue;
				else
					minDistances[i]=minDistances[i-1]+1;
			}
			
		}
		
		for(int j=blocks.size() -2; j>=0 ;j--) {
			
			if(blocks.get(j).get(req)) {
				minDistances[j]=0;
			}
			else {
				
				minDistances[j]=Math.min((minDistances[j+1]+1), minDistances[j]);

			}
			
		}
		System.out.println(req);
		for(int i=0;i< blocks.size();i++) {
			System.out.print(minDistances[i]);
		}
		System.out.println("");
		return minDistances;
	}

}
