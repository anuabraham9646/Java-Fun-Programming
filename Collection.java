package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Collection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int last= 'a';
		//System.out.println(last);
		List<String> name= new ArrayList<>();
		name.add("anu");
		name.add("chetan");
		ArrayList<String> name2 = new ArrayList<>();
		name2.add("himank");
		name2.addAll(0,name);
		//name2.clear();
		
		Iterator itr= name2.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		Stack<String> nn= new Stack<>();
		nn.push("hey");
		nn.push("hhjhj");
		nn.push("kjjhjhj");
		nn.pop();
		Iterator itr1= nn.iterator();
		while(itr1.hasNext()) {
			System.out.println(itr1.next());
		}
		
	}

}
