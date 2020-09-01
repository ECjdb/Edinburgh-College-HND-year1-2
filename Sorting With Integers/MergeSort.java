package sortingassessment;

import java.text.DecimalFormat;

//EC1524329
//Joel Degner-Budd
//11/12/2018

public class MergeSort 
{   
    //these counters keep track of how many values will be stored in
    //memory during the algorithms execution. It is set to 1 to include
    //the variable itself.
    private static int intCounter = 4;
    private static long longCounter = 3;
    private static double doubCounter = 2;
    private static int total = 0;
    
    //**********************************************
    //*               Merge Ascending              *
    //**********************************************
    static long startTime = 0;
    static long executionTime = 0;
    static int comparisons = 0;
    static int swaps = 0;
    static double seconds = 0;
    
    private static void MergeSortAscending(int[] arr,int[] temp,int left,int right)
    {
        intCounter++;//adds 1 to counter for center variable
        if(left < right)
        {
            int center =(left+right)/2;
            
            MergeSortAscending(arr,temp,left,center);
            MergeSortAscending(arr,temp,center+1,right);
            MergeAscending(arr,temp,left,center+1,right);  
        }
    }
    
    public static void MergeSortAscending(int[] a)
    {
        intCounter++;//adds 1 to counter for value k
        for(int k = 0; k<a.length;k++)
        {
          intCounter++;//adds one for each element in the loop
        }
        
        executionTime = 0;
        comparisons = 0;
        swaps = 0;
        seconds = 0;
        
        startTime = System.nanoTime();       
        System.out.println("\nExecuting Merge Sort\n");
        System.out.println("Merge Sort");
        System.out.println("*************************************"
                    + "****************************************************");
    
        int[] temp = new int[a.length];
        intCounter++;
        MergeSortAscending(a,temp,0,a.length-1);
        
        executionTime = System.nanoTime();
        executionTime = System.nanoTime() - startTime;
        seconds = (double)executionTime/1_000_000_000.0;
        System.out.println("Total Execution Time: " + new DecimalFormat
                        /* + */("#.############").format(seconds) + " Seconds");
        System.out.println("Total number of comparisons: "+comparisons);
        System.out.println("Total number of Swaps:"+swaps);
        System.out.println("Total Integers stored in memory: "+intCounter*4
                            +"bytes");
        System.out.println("Total Longs stored in memory: "+longCounter*8
                            +"bytes");
        System.out.println("Total Doubles stored in memory: "+doubCounter*8
                            +"bytes");
        total = intCounter*4;
        total = total+(int)longCounter*8;
        total = total+(int)doubCounter*8;
        System.out.println("Total memory usage is: "+total+"bytes");
        System.out.println("End of Merge Sort");
        System.out.println("*************************************"
                    + "****************************************************"); 
        //resets values
        intCounter = 4;
        long longCounter = 3;
        doubCounter = 2;
        total = 0;
    }
    
    private static void MergeAscending(int[] a,int[] temp,int left,int right,int rightEnd)
    {
        int leftEnd = right-1;
        intCounter++;
        int k = left;
        intCounter++;
        int num = rightEnd-left+1;
        intCounter++;
        
        while(left <= leftEnd && right <= rightEnd)
        {
            comparisons++;
            
            if(a[left]-a[right] <= 0)
            {
                temp[k++] = a[left++];
            }
            else
            {
                temp[k++] = a[right++];
            }
        }
        while(left <= leftEnd)
        {
            temp[k++] = a[left++];
            swaps++;
        }
        while(right <= rightEnd)
        {
            temp[k++] = a[right++];
            swaps++;
        }
        for(int m = 0; m<num; m++ , rightEnd--)
        {
            a[rightEnd] = temp[rightEnd];
            swaps++;
        }
    }
    
    
    //**********************************************
    //*               Merge Descending             *
    //**********************************************
    private static void MergeSortDescending(int[] arr,int[] temp,int left,int right)
    {
        intCounter++;//adds 1 to counter for center variable
        if(left < right)
        {
            int center =(left+right)/2;
            
            MergeSortDescending(arr,temp,left,center);
            MergeSortDescending(arr,temp,center+1,right);
            MergeDescending(arr,temp,left,center+1,right);  
        }
    }
    
    public static void MergeSortDescending(int[] a)
    {
        
        intCounter++;//adds 1 to counter for value k
        for(int k = 0; k<a.length;k++)
        {
          intCounter++;//adds one for each element in the loop
        }
        
        executionTime = 0;
        comparisons = 0;
        swaps = 0;
        seconds = 0;
        
        startTime = System.nanoTime();       
        System.out.println("\nExecuting Merge Sort\n");
        System.out.println("Merge Sort");
        System.out.println("*************************************"
                    + "****************************************************");
        
        intCounter++;
        int[] temp = new int[a.length];
        
        MergeSortDescending(a,temp,0,a.length-1);
        
        executionTime = System.nanoTime();
        executionTime = System.nanoTime() - startTime;
        seconds = (double)executionTime/1_000_000_000.0;
        System.out.println("Total Execution Time: " + new DecimalFormat
                        /* + */("#.############").format(seconds) + " Seconds");
        System.out.println("Total number of comparisons: "+comparisons);
        System.out.println("Total number of Swaps:"+swaps);
        System.out.println("Total Integers stored in memory: "+intCounter*4
                            +"bytes");
        System.out.println("Total Longs stored in memory: "+longCounter*8
                            +"bytes");
        System.out.println("Total Doubles stored in memory: "+doubCounter*8
                            +"bytes");
        total = intCounter*4;
        total = total+(int)longCounter*8;
        total = total+(int)doubCounter*8;
        System.out.println("Total memory usage is: "+total+"bytes");
        System.out.println("End of Merge Sort");
        System.out.println("*************************************"
                    + "****************************************************");
        //resets values
        intCounter = 4;
        long longCounter = 3;
        doubCounter = 2;
        total = 0;
    }
    
    private static void MergeDescending(int[] a,int[] temp,int left,int right,int rightEnd)
    {
        int leftEnd = right-1;
        intCounter++;
        int k = left;
        intCounter++;
        int num = rightEnd-left+1;
        intCounter++;
        
        while(left <= leftEnd && right <= rightEnd)
        {
            comparisons++;
            
            if(a[left]-a[right] <= 0)
            {
                temp[k++] = a[right++];
            }
            else
            {
                temp[k++] = a[left++]; 
            }
        }
        while(left <= leftEnd)
        {
            temp[k++] = a[left++];
            swaps++;
        }
        while(right <= rightEnd)
        {
            temp[k++] = a[right++];
            swaps++;
        }
        for(int m = 0; m<num; m++ , rightEnd--)
        {
            a[rightEnd] = temp[rightEnd];
            swaps++;
        }
    }
}
