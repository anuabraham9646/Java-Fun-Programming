package com;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequenceGreedy {
	int index,profit,deadline;
	
	public JobSequenceGreedy(int index, int profit,int deadline) {
		this.index= index;
		this.deadline= deadline;
		this.profit= profit;
	}
	public static void main(String[] args) {
		int[] profit = new int[] {1,5,20,15,10};
		int[] deadline = new int[] {3,3,2,2,1};
		findMaxProfit(profit,deadline);

	}
	public static void findMaxProfit(int[] profit, int[] deadline) {
		JobSequenceGreedy[] sequence= new JobSequenceGreedy[profit.length];
		for(int i=0;i< profit.length;i++) 
			sequence[i]= new JobSequenceGreedy(i+1,profit[i],deadline[i]);
		
		Arrays.sort(sequence, new Comparator<JobSequenceGreedy>() {
			public int compare(JobSequenceGreedy j1, JobSequenceGreedy j2) {
				if(j1.profit==j2.profit)
					return 0;
				else if(j1.profit>j2.profit)
					return -1;
				else
					return 1;
				
			}
		});
		
		
		int maxDeadline=-1;
		for(int i=0;i< profit.length;i++) {
			if(sequence[i].deadline>= maxDeadline)
				maxDeadline=sequence[i].deadline;
		}
		int [] jobSequence= new int [maxDeadline];
		for(int i =0 ;i < maxDeadline;i++) {
			jobSequence[i]=-1;
		}
		int lastEmpty= maxDeadline-1;
		int maxProfit=0;
		for(JobSequenceGreedy js: sequence) {
			int curDeadline= js.deadline;
			for(int loc= curDeadline-1; loc>=0;loc--) {
				if(jobSequence[loc]==-1)
				{
					jobSequence[loc]=js.index;
					maxProfit+=js.profit;
					break;
				}
					
			}
			
		}
		System.out.println(maxProfit);
		for(int i=0; i< jobSequence.length;i++)
			System.out.print("job " +jobSequence[i]+ " ");
			

	}

}
