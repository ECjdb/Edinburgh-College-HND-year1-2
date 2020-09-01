package sortingassessment;

import java.util.Comparator;

//EC1524329
//Joel Degner-Budd
//11/12/2018

public class BubbleSort 
{
    //these counters keep track of how many values will be stored in
    //memory during the algorithms execution. It is set to 1 to include
    //the variable itself.
    private static int intCounter = 2; // set to 2 to include total variable
    private static long longCounter = 1;
    private static double doubCounter = 1;
    private static int total = 0;
    
    //**********************************************
    //*              Bubble Ascending              *
    //**********************************************
    
    public static void intAscendBubbleSort(int[] array)
    {
        int maxInt;
        intCounter++;
        int index;
        intCounter++;
        int temp;
        intCounter++;
        long startTime = System.nanoTime(); 
        longCounter++;
        
        int swap = 0;
        intCounter++;
        int compare =0;
        intCounter++;
        
        intCounter++;//adds 1 to counter for value k
        for(int k = 0; k<array.length;k++)
        {
          intCounter++;//adds one for each element in the loop
        }
        
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
        longCounter++;
        double seconds = (double)executionTime / 1_000_000_000.0;
        doubCounter++;
        System.out.println("Total Execution Time: "+seconds+"s");
        System.out.println("\nBubble Sort");
        System.out.println("Comparisons: "+compare);
        System.out.println("Swaps: "+swap);
        System.out.println("Total Integers stored in memory: "+intCounter*4
                            +"bytes");
        System.out.println("Total Longs stored in memory: "+longCounter*8
                            +"bytes");
        System.out.println("Total Doubles stored in memory: "+doubCounter*8
                            +"bytes");
        total = intCounter*4;
        total = total+(int)longCounter*8;
        total = total+(int)doubCounter*8;
        System.out.println("Total memory usage is: "+total+"bytes\n");
        
        //resets values
        intCounter = 2;
        longCounter = 1;
        doubCounter = 1;
        total = 0;
    }//end intAscendBubbleSort *
    
    //**********************************************
    //*              Bubble Descending             *
    //**********************************************
    
    public static void intDescendBubbleSort(int[] array)
    {
        int maxInt;
        intCounter++;
        int index;
        intCounter++;
        int temp;
        intCounter++;
        long startTime = System.nanoTime();
        longCounter++;
        
        int swap = 0;
        intCounter++;
        int compare =0;
        intCounter++;
        
        intCounter++;//adds 1 to counter for value k
        for(int k = 0; k<array.length;k++)
        {
          intCounter++;//adds one for each element in the loop
        }
        
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
        longCounter++;
        double seconds = (double)executionTime / 1_000_000_000.0;
        doubCounter++;
        System.out.println("Total Execution Time: "+seconds+"s");
        System.out.println("\nBubble Sort");
        System.out.println("Comparisons: "+compare);
        System.out.println("Swaps: "+swap);
        System.out.println("Total Integers stored in memory: "+intCounter*4
                            +"bytes");
        System.out.println("Total Longs stored in memory: "+longCounter*8
                            +"bytes");
        System.out.println("Total Doubles stored in memory: "+doubCounter*8
                            +"bytes");
        total = intCounter*4;
        total = total+(int)longCounter*8;
        total = total+(int)doubCounter*8;
        System.out.println("Total memory usage is: "+total+"bytes\n");
        
        //resets values
        intCounter = 2;
        longCounter = 1;
        doubCounter = 1;
        total = 0;
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