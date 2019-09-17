package AssessmentBinarySearch;

import java.text.DecimalFormat;

//EC1524329
//Joel Degner-Budd
//11/12/2018

public class MergeSort 
{   
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
        MergeSortAscending(a,temp,0,a.length-1);
        
        executionTime = System.nanoTime();
        executionTime = System.nanoTime() - startTime;
        seconds = (double)executionTime/1_000_000_000.0;
        System.out.println("Total Execution Time: " + new DecimalFormat
                        /* + */("#.############").format(seconds) + " Seconds");
        System.out.println("Total number of comparisons: "+comparisons);
        System.out.println("Total number of Swaps:"+swaps);
        System.out.println("End of Merge Sort");
        System.out.println("*************************************"
                    + "****************************************************"); 
    }
    
    private static void MergeAscending(int[] a,int[] temp,int left,int right,int rightEnd)
    {
        int leftEnd = right-1;
        int k = left;
        int num = rightEnd-left+1;
        
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
}
