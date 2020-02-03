package com;

public class KnapSack {

	public static void main(String[] args) {
		int val[] = new int[]{60, 100, 120}; 
        int wt[] = new int[]{10, 20, 30}; 
        int  W = 50; 
        int n = val.length;
        System.out.println(knapSack(val,wt,W,n));
        System.out.println(dynamicKnapSack(val,wt,W,n));

	}

	private static int dynamicKnapSack(int[] val, int[] wt, int W, int n) {
		
		int memo[][]= new int[n+1][W+1];
		
		for(int i=0;i<=n;i++) {
			for(int w=0;w<=W;w++) {
				if(i==0 || w==0) {
					memo[i][w]=0;
				}
				
				else if(wt[i-1]<=w) {
					memo[i][w]= max(val[i-1]+memo[i-1][w-wt[i-1]], memo[i-1][w]);
				}
				else {
					memo[i][w]= memo[i-1][w];
				}
			}
		}
		return memo[n][W]; 
	}

	private static int knapSack(int[] val, int[] wt, int W, int n) {
		
		if(W ==0 || n==0)
			return 0;
		
		if(wt[n-1] > W)
			return knapSack(val, wt, W, n-1);
		
		else
			return max( val[n-1] + knapSack(val,wt,W-wt[n-1],n-1), 
					knapSack(val, wt, W, n-1) 
                    );
	}
	static int max(int a, int b) { return (a > b)? a : b; } 

}
