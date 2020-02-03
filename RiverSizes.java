package com;

import java.util.ArrayList;
import java.util.Stack;

public class RiverSizes {

	public static void main(String[] args) {
		int topography[][]= {{1,0,1,1,0},{1,1,1,0,0},{0,0,1,0,1},{1,1,1,1,1},{1,0,1,1,0}};
		ArrayList<Integer> sizes= new ArrayList();
		sizes= getRiverSize(topography);
		
		for(int i=0;i< sizes.size();i++) {
			//System.out.println(sizes.get(i));
		}
		
		

	}
	/*	1	0	1	1	0
		1	1	1	0	0
		0	0	1	0	1
		1	1	1	1	1
		1	0	1	1	0	*/

	private static ArrayList<Integer> getRiverSize(int[][] topography) {
		
		boolean [][] visitedNode= new boolean[topography.length][topography[0].length];
		ArrayList<Integer> riverSize= new ArrayList();
		int size;
		for(int i=0;i< topography.length;i++) {
			for(int j=0;j<topography[i].length;j++) {
				if(visitedNode[i][j])
					continue;
				else if(topography[i][j]==0)
					continue;
				else {
					size=traverseNode(i,j,visitedNode,topography);
					if (size>0)
					{
						System.out.println("river starting at "+i+","+j+" length ="+size);
						riverSize.add(size);
						}
				}
			}
		}

		return riverSize;
		
	}

	private static int traverseNode(int row, int column, boolean[][] visitedNode, int[][] topography) {
		Stack<Integer> currentNode= new Stack();
		
		int size=0;
		ArrayList<Integer> neighbours= new ArrayList();
		currentNode.push(row);
		currentNode.push(column);
		while(!currentNode.isEmpty()) {
			int j=currentNode.pop();
			int i=currentNode.pop();
			
			if(visitedNode[i][j])
				continue;
			visitedNode[i][j]=true;
			if(topography[i][j]==0)
				continue;
			size++;
			neighbours=nodesNeighbour(i,j,topography,visitedNode);
			for(int k =0;k<neighbours.size();k++) {
				
				currentNode.push(neighbours.get(k));

		}
		}
		return size;
		
	}

	private static ArrayList<Integer> nodesNeighbour(int i, int j, int[][] topography, boolean[][] visitedNode) {
		
		ArrayList<Integer> neighbours= new ArrayList();
		if(i>0 && !visitedNode[i-1][j]) {
			neighbours.add(i-1);
			neighbours.add(j);
			
			
		}
		if(j>0 && !visitedNode[i][j-1]) {
			
			neighbours.add(i);
			neighbours.add(j-1);
			
		}
		if(i<topography.length-1 && !visitedNode[i+1][j]) {
			neighbours.add(i+1);
			neighbours.add(j);
			
		}
		if(j<topography[0].length-1 && !visitedNode[i][j+1]) {
			neighbours.add(i);
			neighbours.add(j+1);
			
		}
		
		return neighbours;
	}

}
