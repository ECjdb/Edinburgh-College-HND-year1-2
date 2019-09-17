package sortingassessment;

import java.util.Comparator;

//EC1524329
//Joel Degner-Budd
//11/12/2018

public class BubbleSort 
{
    //**********************************************
    //*              Bubble Ascending              *
    //**********************************************
    
    public static void intAscendBubbleSort(int[] array)
    {
        int maxInt;
        int index;
        int temp;
        long startTime = System.nanoTime(); 
        
        int swap = 0;
        int compare =0;
        
        for(maxInt = array.length-1; maxInt >= 0;maxInt--)
        {
            for(index = 0; index <= maxInt-1; index++)
            {
                compare++;
                
                if(array[index] > array[index+1])
                {
                    temp = array[index];
                    array[index]=array[index+1];
                    array[index+1]=temp;
                    swap++;
                }
            }
        }
        long executionTime = System.nanoTime() - startTime;
        double seconds = (double)executionTime / 1_000_000_000.0;
        System.out.println("Total Execution Time: "+seconds+"s");
        System.out.println("\nBubble Sort");
        System.out.println("Comparisons: "+compare);
        System.out.println("Swaps: "+swap);
    }//end intAscendBubbleSort *
    
    //**********************************************
    //*              Bubble Descending             *
    //**********************************************
    
    public static void intDescendBubbleSort(int[] array)
    {
        int maxInt;
        int index;
        int temp;
        long startTime = System.nanoTime(); 
        
        int swap = 0;
        int compare =0;
        
        for(maxInt = array.length-1; maxInt >= 0;maxInt--)
        {
            for(index = 0; index <= maxInt-1; index++)
            {
                compare++;
                
                if(array[index] < array[index+1])
                {
                    temp = array[index];
                    array[index]=array[index+1];
                    array[index+1]=temp;
                    swap++;
                }
            }
        }
              
        long executionTime = System.nanoTime() - startTime;
        double seconds = (double)executionTime / 1_000_000_000.0;
        System.out.println("Total Execution Time: "+seconds+"s");
        System.out.println("\nBubble Sort");
        System.out.println("Comparisons: "+compare);
        System.out.println("Swaps: "+swap);
    }//end intDescendBubbleSort *
    
    public static void comparatorBubbleSort(Comparator[] array,Comparator name)  
    {
        int maxElement;
        int index;
        Comparator temp;

        for(maxElement =array.length-1;maxElement >=0; maxElement--)
        {
            for(index =0; index <= maxElement-1;index++)
            {
                if(name.compare((array[index]),(array[index+1]))>0)
                {
                    temp = array[index];
                    array[index]= array[index+1];
                    array[index+1]= temp;
                }       
            } 
        }  
    }//end comparatorBubbleSort *
}//end BubbleSort class **