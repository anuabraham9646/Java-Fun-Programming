package com;
import java.util.*;
public class sortedSquares {
	public static ArrayList<Integer> sortedSquare(int[] A) {
        int size=A.length;
        int i=0;
        while(i<size && A[i]<0) {
        	i++;
        }
        i--;
       	ArrayList<Integer>result= new ArrayList<>();
        int j=0;
        int total=size;
       // int minus=0;
        int plus=i+1;
        while(i>=-1 && plus<=size) {
        	if(i==-1&&plus==size) {
        		return result;
        	}
        	
        	if(plus==size) {
        		result.add(A[i]*A[i]);
        		i--;
        	}
        	else if(i==-1) {
        		result.add(A[plus]*A[plus]);
        		plus++;
        	}
        	else if(A[i]*A[i] < A[plus]*A[plus]) {
        		result.add(A[i]*A[i]);
        		i--;
        	}
        	else if(A[plus]*A[plus] < A[i]*A[i]) {
        		result.add(A[plus]*A[plus]);
        		plus++;
        	}
        	//System.out.println(result);
        	
        }
        //System.out.println(i);
       // return result;
		return result;
        
    }

	public static void main(String[] args) {
		int A[]= {-4,-1,0,3,10};
		System.out.println(sortedSquare(A));
		

	}

}
