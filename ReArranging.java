package com;

public class ReArranging {

	public static void main(String[] args) {
		 String [] accepted= {"included","nincluded","nincluded","included","included","included","nincluded","included"};
		    int back= accepted.length-1;
		    boolean frontmis=false;
		    int front=0;
		    String temp="";
		    boolean backmis=false;
		    boolean bothmis=false;
		    for(int i =0 ;i<back;  i++){
		      //System.out.println(accepted[i]);
		      if(backmis){
		        i= front;
		        back--;
		        if(accepted[back].equalsIgnoreCase("included")){
		        	backmis=false;
		        }

		      }
		     else if(frontmis){
		        if(accepted[back].equalsIgnoreCase("included")){
		          i=front;
		          temp=accepted[back];
		          accepted[back]=accepted[i];
		          accepted[i]=temp;
		          frontmis=false;
		          backmis=false;
		          back--;
		        }
		        else{
		          backmis=true;
		          
		        }
		      }
		     
		     else if(accepted[i].equalsIgnoreCase("nincluded")){
		        frontmis=true;
		        front=i;
		      }
		    }

		  for (int i=0;i<accepted.length;i++){
		    System.out.println(accepted[i]);
		  }


	}

}
