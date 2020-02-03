package com;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
public class KnapSackGreedy {

	public static void main(String[] args) {
		int [] profit= new int[] {60, 40, 100, 120};
		int [] weight= new int[] {10, 40, 20, 30};
		int total=50;
		knapSack(profit,weight,total);

	}
	public static void knapSack(int []profit, int[]weight, int total) {
		Item [] val= new Item[weight.length];
		for(int i =0 ;i < profit.length;i++) {
			val[i]= new Item(profit[i],weight[i],i);
			System.out.println(val[i].profitPerWeight);
		}
		Arrays.sort(val, new Comparator<Item>(){
			public int compare(Item i1, Item i2) {
				return i2.profitPerWeight.compareTo(i1.profitPerWeight);
			}
		});
		double maxProfit=0;
		for(Item i :val) {
			if(total > i.wt) {
				total-=i.wt;
				maxProfit+=i.profit;
			}
			else if(total >0 && total < i.wt) {
				maxProfit+=(total/i.wt)*i.profit;
				total=0;
			}
		}
		System.out.println(maxProfit);

		
		
	}
	
	public static class Item{
		double wt,profit,index;
		Double profitPerWeight;
		public Item(int profit,int weight,int index) {
			this.index= index;
			this.profit= profit;
			this.wt= weight;
			this.profitPerWeight= profit*1.0/weight;
		}
	}

}
