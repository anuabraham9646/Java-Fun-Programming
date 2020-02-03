package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigZagTraverse {

	public static void main(String[] args) {
	    List<List<Integer>> test = new ArrayList<List<Integer>>();
	    test.add(Arrays.asList(1,3,4,10));
	    /*test.add(Arrays.asList(2,5,9,11));
	    test.add(Arrays.asList(6,8,12,15));
	    test.add(Arrays.asList(7,13,14,16));*/
	    
	    /*for(int i=0;i<test.size();i++) {
	    	
	    	for(int j=0; j<test.get(i).size();j++) {
	    		System.out.print(test.get(i).get(j) + " ");
	    	}
	    	System.out.println(" ");
	    }*/
	    List<Integer> zigZag= zigzagTraverse(test);
	    
	    zigZag.forEach(System.out::println);

	}
	
	/*public static List<Integer> zigzagTraverse(List<List<Integer>> array) {

		List<Integer> zigZag = new ArrayList<>();
		int nums=0;
		for(int i=0 ;i < array.size();i++) {
			for(int j=0;j<array.get(i).size();j++) {
				nums++;
			}
			
		}
		int num=1;
		zigZag.add(array.get(0).get(0));
		 zigZag.forEach(System.out::print);
		 System.out.println("");
		num++;
		int i=0,j=0;
		while(num<=nums) {
			
			if (i < array.size()-1) {
				zigZag.add(array.get(++i).get(j));
				zigZag.forEach(System.out::print);
				System.out.println("");
				num++;
			}
			else {
				zigZag.add(array.get(i).get(++j));
				zigZag.forEach(System.out::print);
				System.out.println("");
				num++;
			}
			while( i >1 && j < array.get(i).size()-1) {
				zigZag.add(array.get(--i).get(++j));
				zigZag.forEach(System.out::print);
				 System.out.println("");
				num++;
			}
			if (j < array.get(i).size()-1) {
				zigZag.add(array.get(--i).get(++j));
				zigZag.forEach(System.out::print);
				System.out.println("");
				num++;
			}
			
			
			
			
			
			if (j< array.get(i).size()-1) {
				zigZag.add(array.get(i).get(++j));
				zigZag.forEach(System.out::print);
				System.out.println("");
				num++;
			}
			else {
				zigZag.add(array.get(++i).get(j));
				zigZag.forEach(System.out::print);
				System.out.println("");
				num++;
			}
			while( i < array.size()-1 && j > 1 ) {
				zigZag.add(array.get(++i).get(--j));
				zigZag.forEach(System.out::print);
				 System.out.println("");
				num++;
			}
			if (i < array.get(i).size()-1) {
				zigZag.add(array.get(++i).get(--j));
				zigZag.forEach(System.out::print);
				System.out.println("");
				num++;
			}
			
		}
		return zigZag;
		
	  }*/
	
	public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
		List<Integer> zigZag = new ArrayList<>();
		int nums=0;
		for(int i=0 ;i < array.size();i++) {
			for(int j=0;j<array.get(i).size();j++) {
				nums++;
			}
			
		}
		int num=0;
		if(nums==0)
			return new ArrayList<>();
		
		
		// if there are atleast 1 value
		else {
			
			int i=0,j=0;
			// adding 1st value
			zigZag.add(array.get(i).get(j));
			num++;
			while(num<nums) {
				boolean up= false;
				//traversing up
				while(i > 0 || j < array.get(i).size()-1) {
					
					
					
					
					//last row        // including last row and 1st column
					if(i == array.size()-1 && !up) {
						zigZag.add(array.get(i).get(++j));
						zigZag.forEach(System.out::print);
						 System.out.println("last row");
						 up= true;
						num++;
					}
					
					
					//1st column
					else if(j == 0 && !up) {
						zigZag.add(array.get(++i).get(j));
						zigZag.forEach(System.out::print);
						 System.out.println("1st column");
						 up= true;
						num++;
					}
					
					//traversing up
					else {
						zigZag.add(array.get(--i).get(++j));
						zigZag.forEach(System.out::print);
						 System.out.println("up");
						num++;
						
						if( (i== 0 || j==array.get(i).size()-1) && up )
							{up= false;
						break;}
					}
					
				}
				
				
				boolean down = false;
				//traversing down
				while(j >0 && i< array.size()-1) {
					//last column        // including 1st row and last column
					if(j == array.get(i).size()-1  && !down) {
						zigZag.add(array.get(++i).get(j));
						down=true;
						num++;
						zigZag.forEach(System.out::print);
						 System.out.println("up");
					}
					
					//1st row
					else if(i==0 && !down) {
						zigZag.add(array.get(i).get(++j));
						down = true;
						num++;
						zigZag.forEach(System.out::print);
						 System.out.println("up");
					}
					else {
						zigZag.add(array.get(++i).get(--j));
						num++;
						zigZag.forEach(System.out::print);
						 System.out.println("up");
						
						if( (j== 0 || i==array.size()-1) && down )
						{down= false;
					break;}
					}
					
				}
				
				
				
			}
			
			
			
		}
		
		
		
		
		
		
		
		return zigZag;
		
	}

}
