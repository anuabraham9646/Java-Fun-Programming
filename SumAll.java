package com;

class SumAll {
	  public static void main(String[] args) {
	   int array[]={1,2,3,4,5,6} ;
	   int left[]= new int[6];
	   int right[]= new int[6];
	   int prod[]= new int[6];
	   left[0]=1;
	   right[5]=1;
	   for(int i=1;i<6;i++){
	     left[i]=array[i-1]*left[i-1];

	   }
	

	   for(int i=4;i>=0;i--){
	     right[i]=array[i+1]*right[i+1];
	     
	   }

	   for(int i=0;i<6;i++){
	     prod[i]=left[i]*right[i];
	   }
	   
	   for(int i=0;i<6;i++){
		   System.out.print(prod[i]+ " ");
	   }

	   }
	}
