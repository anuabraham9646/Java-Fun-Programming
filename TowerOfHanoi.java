package com;

public class TowerOfHanoi {

	public static void main(String[] args) {
		tower(6,'s','m','f');

	}

	private static void tower(int item, char start, char aux, char destination) {
		
		if(item==1) {
			System.out.println("moving plate 1 from "+start+" to "+destination);
			return;
		}
			
		tower(item-1,start,destination,aux);
		System.out.println("moving rod "+item+" from "+start+" to "+destination);
		tower(item-1,aux,start,destination);
	}

}
