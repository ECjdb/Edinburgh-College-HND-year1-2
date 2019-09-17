package sortingassessmentpart2;

import java.text.DecimalFormat;
import java.util.Comparator;

//EC1524329
//Joel Degner-Budd
//11/12/2018

public class BubbleSortComparator 
{
    //****************************************************
    //****************************************************
    //*                 Bubble Ascending                 *
    //****************************************************
    //****************************************************
    
    public static void BubbleSortAscending(Comparator[] array,Comparator name)  
    {
        int maxElement;
        int index;
        Comparator temp;
        
        long startTime = System.nanoTime(); 
        
        int swap = 0;
        int compare =0;
        
        System.out.println("\nExecuting Bubble Sort\n");
        System.out.println("Bubble Sort");
        System.out.println("*************************************"
                    + "****************************************************");
   
        for(maxElement =array.length-1;maxElement >=0; maxElement--)
        {
            for(index =0; index <= maxElement-1;index++)
            {
                compare++;
                
                if(name.compare((array[index]),(array[index+1]))>0)
                {
                    temp = array[index];
                    array[index]= array[index+1];
                    array[index+1]= temp;
                    swap++;
                }       
            } 
        }
        
        long executionTime = System.nanoTime() - startTime;
        double seconds = (double)executionTime / 1_000_000_000.0;
        System.out.println("Total Execution Time: " + new DecimalFormat
                        /* + */("#.############").format(seconds) + " Seconds");
        System.out.println("Total number of comparisons: "+compare);
        System.out.println("Total number of swaps: "+swap);
        System.out.println("End of Bubble Sort");
        System.out.println("*************************************"
                    + "****************************************************");
    }//end BubbleSortAscending *
    
    //****************************************************
    //****************************************************
    //*                 Bubble Descending                *
    //****************************************************
    //****************************************************
    
    public static void BubbleSortDescending(Comparator[] array,Comparator name)  
    {
        int maxElement;
        int index;
        Comparator temp;
        
        long startTime = System.nanoTime(); 
        
        int swap = 0;
        int compare =0;
        
        System.out.println("\nExecuting Bubble Sort\n");
        System.out.println("Bubble Sort");
        System.out.println("*************************************"
                    + "****************************************************");
   
        for(maxElement =array.length-1;maxElement >=0; maxElement--)
        {
            for(index =0; index <= maxElement-1;index++)
            {
                compare++;
                
                if(name.compare((array[index]),(array[index+1]))<0)
                {
                    temp = array[index];
                    array[index]= array[index+1];
                    array[index+1]= temp;
                    swap++;
                }       
            } 
        } 
        long executionTime = System.nanoTime() - startTime;
        double seconds = (double)executionTime / 1_000_000_000.0;
        System.out.println("Total Execution Time: " + new DecimalFormat
                        /* + */("#.############").format(seconds) + " Seconds");
        System.out.println("Total Execution Time: "+seconds+"s");
        System.out.println("Total number of comparisons: "+compare);
        System.out.println("Total number of swaps: "+swap);
        System.out.println("End of Bubble Sort");
        System.out.println("*************************************"
                    + "****************************************************");
    }//end BubbleSortDescending *
}//end BubbleSortComparator **
