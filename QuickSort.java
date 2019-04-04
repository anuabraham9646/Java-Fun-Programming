package com;

public class QuickSort{
    
    public void sort(int[] array, int left, int right){
        if(left <= right){
            int pivot = partition(array, left, right);
          //  System.out.println(pivot);
            sort(array,left, pivot-1);
            sort(array,pivot+1,right); 
            
        }
        else {
        	return;
        }
    }
    
    public int partition(int[] array, int left, int right){
        int pivot= array[left]
        ;int high=left;
        int low=left;
        for(int i=left;i<array.length;i++){
            if(array[i]<=pivot){
            
                if(low==high)
                {low++;
                high++;
                }
            else{
                int temp=array[low];
                array[low]=array[i];
                array[i]=temp;
                low++;
                high++;
              
            }
            }
            else{
                high++;
            }
            
        }
        int temp=array[left];
        array[left]=array[low-1];
        array[low-1]=temp;
      //  for (int i=0; i<array.length; ++i) 
         //   System.out.print(array[i]+" "); 
       // System.out.println(); 
        return low-1;
        
        
    }

    public static void main(String []args){
        int arr[] ={43,32,22,78,63,57,91,13};
        int n = arr.length;
        QuickSort ob = new QuickSort(); 
        ob.sort(arr, 0, n-1); 
        
        
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    }
}