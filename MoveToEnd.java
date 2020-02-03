package com;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
public class MoveToEnd {
	
	
	public static void main(String args[]) {
		Integer [] arr= new Integer [] {2,1,2,2,2,3,4,2};
		List<Integer> l = Arrays.asList(arr);
		int x=2;
		List<Integer> l1=MoveToEnd.moveElementToEnd(l, x);
		l1.stream().forEach(System.out::print);
	}
	public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
		int start=0,last= array.size()-1;int temp;
		while(start<last) {
			//System.out.println(start);
			//System.out.println(last);
			if(array.get(last)==toMove) {
				last--;
			}
			else if(array.get(start)==toMove && array.get(last)!=toMove) {
				temp=array.get(last);
				array.set(last, toMove);
				//array.add(last, toMove);
				//array.add(last,toMove);
				array.set(start,temp);
				start++;last--;
			}
			else if(array.get(start)!=toMove)
				start++;
			
		}
		return array;
  }
}
