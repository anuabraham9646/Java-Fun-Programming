package com;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;


public class MaxHeap {
	int capacity = 10;
	int size=0;
	int [] item = new int[capacity];
	
	private int getLeftChildIndex(int parent) {return (2*parent +1);}
	private int getRightChildIndex(int parent) {return (2*parent + 2);}
	private int getParentIndex(int child) {return (child-1)/2;}
	
	private boolean hasLeftChild(int parent) {return getLeftChildIndex(parent)<size;}
	private boolean hasRightChild(int parent) {return getRightChildIndex(parent)<size;}
	private boolean hasParent(int child) {return getParentIndex(child)>=0;}
	
	private int getLeftChild(int parent) {return item[getLeftChildIndex(parent)];}
	private int getRightChild(int parent) {return item[getRightChildIndex(parent)];}
	private int getParent(int child) {return item[getParentIndex(child)];}
	
	private void swap(int one, int two) {
		int temp= item[one];
		item[one]= item[two];
		item[two]=temp;
	}
	private void ensureCapacity() {
		if (size==capacity) {
			item= Arrays.copyOf(item, capacity*2);
		}
	}
	public int peek() {
		if(size==0)
			return -1;
		
		else
			return item[0];
	}
	public int poll() {
		if(size==0)
			return -1;
		
		else {
			int max= item[0];
			item[0]= item[size-1];
			size--;
			heapifyDown();
			System.out.println(max);
			return max;
		}
	}
	public void add(int value) {
		if(size == capacity)
			ensureCapacity();
		
		item[size]=value;
		size++;
		heapifyUp();
	}
	
	public void heapifyUp() {
		boolean inOrder= false;
		int startIndex= size-1;
		
		
		while(!inOrder) {
			if(!hasParent(startIndex))
				break;
			else {
				int parentIndex= getParentIndex(startIndex);
				if(item[startIndex]> item[parentIndex]) {
					swap(startIndex,parentIndex);
					startIndex=parentIndex;
				}
				else {
					inOrder= true;
				}
			}
		}
	}
	public void heapifyDown() {
		boolean inOrder= false;
		int startElt= item[0];
		int left,right;
		int largestIndex=-1;
		int startIndex=0;
		while(!inOrder) {
			if(!hasLeftChild(startIndex))
				break; 
			
			else if(hasRightChild(startIndex) && hasLeftChild(startIndex)) {
				right= getRightChildIndex(startIndex);
				left = getLeftChildIndex(startIndex);
				largestIndex= (item[right]> item[left]) ? right : left;
			}
			else if(hasLeftChild(startIndex))
				largestIndex= getLeftChildIndex(startIndex);
			
			
			if(item[startIndex] > item[largestIndex]) {
				inOrder= true;
			}
			else {
				swap(largestIndex,startIndex);
				startIndex=largestIndex;
			}
			
			
			
		}
		
	}
	public ArrayList<Integer> dfs(){
		ArrayList<Integer> result = new ArrayList();
		Stack<Integer> dfs= new Stack();
		if(size==0) {
			result.add(Integer.MIN_VALUE);
			return result;
		}
		else {
			int current= item[0],index=0;
			
			dfs.push(index);
			while(!dfs.isEmpty()) {
				index=dfs.pop();
				result.add(item[index]);
				if(hasRightChild(index))
					dfs.push(getRightChildIndex(index)); 
				
				if(hasLeftChild(index)) {
					dfs.push(getLeftChildIndex(index));
				}
				
				
			}
		}
			
		
		
		return result;
	}
	public ArrayList<Integer> bfs(){
		//System.out.println("kkk");
		ArrayList<Integer> result  = new ArrayList();
		Queue<Integer> bfs= new LinkedList();
		if(size==0) {
			result.add(Integer.MIN_VALUE);
			return result;
		}
		else {
			int current= item[0],index=0;
			bfs.add(index);
			while(!bfs.isEmpty()) {
				index=bfs.poll();
				result.add(item[index]);
				if(hasLeftChild(index)) {
					bfs.add(getLeftChildIndex(index));
				}
				if(hasRightChild(index))
					bfs.add(getRightChildIndex(index));
			}
		}
		return result;
		
	}
	
	
	public static void main(String[] args) {
		MaxHeap h= new MaxHeap();
		h.add(10);
		
		h.add(11);
		
		h.add(12);
		
		h.add(25);
		
		h.add(55);
		//System.out.println(h.size);
		
		for(int i=0; i< h.size;i++) {
			System.out.println(h.item[i]);
		}
		
		System.out.println("BFS");
		ArrayList<Integer> result= h.bfs();
		for(int i=0; i< result.size();i++) {
			System.out.print(result.get(i)+ " ");
		}
		
		System.out.println("\nDFS");
		result= h.dfs();
		for(int i=0; i< result.size();i++) {
			System.out.print(result.get(i)+ " ");
		}


	}

}
