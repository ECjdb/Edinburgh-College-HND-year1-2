package sortingassessment;

import java.text.DecimalFormat;

//EC1524329
//Joel Degner-Budd
//11/12/2018

public class SortCheck 
{
    private static int intCounter = 3; //set to 3 to include private variables
    private static long longCounter = 1;
    private static double doubCounter = 1;
    private static int boolCounter = 0;
    private static int total = 0;
    
    //**********************************************
    //*       Sorted Data Checker Ascending        *
    //**********************************************
    
    public static void ascendingArrChecker(int[]array)
    {
        boolean checker = true;
        boolCounter++;
        
        long startTime = System.nanoTime(); 
        longCounter++;
        
        intCounter++;//adds 1 to counter for value k
        for(int k = 0; k<array.length;k++)
        {
          intCounter++;//adds one for each element in the loop
        }
        
        for(int a = 1;a<array.length-1;a++)
        {
            if(array[a] > array[a+1])
            {
                System.out.println("Error has occured: numbers are not in"
                                                    + " the correct order");
                checker = false;

                long executionTime = System.nanoTime() - startTime;
                longCounter++;
                double seconds = (double)executionTime / 1_000_000_000.0;
                doubCounter++;
                System.out.println("Total Execution Time: " + new DecimalFormat
                        /* + */("#.############").format(seconds) + " Seconds");
                System.out.println("Total Integers stored in memory: "+intCounter*4
                    +"bytes");
                System.out.println("Total Longs stored in memory: "+longCounter*8
                    +"bytes");
                System.out.println("Total Doubles stored in memory: "+doubCounter*8
                    +"bytes");
                System.out.println("Total Booleans stored in memory: "+boolCounter*1
                    +"bytes");
                total = intCounter*4;
                total = total+(int)longCounter*8;
                total = total+(int)doubCounter*8;
                total = total+boolCounter*1;
                System.out.println("Total memory usage is: "+total+"bytes\n");
        
                //resets values
                intCounter = 3;
                longCounter = 1;
                doubCounter = 1;
                boolCounter=0;
                total = 0;

                if(checker==false)
                {
                    break;
                }
            }
            else
            {
                if(array[a] > array[a+1] || array[a] < array[a-1])
                {
                    System.out.println("Error has occured: numbers are not in"
                                                    + " the correct order");       
                    checker = false;

                    long executionTime = System.nanoTime() - startTime;
                    longCounter++;
                    double seconds = (double)executionTime / 1_000_000_000.0;
                    doubCounter++;
                    System.out.println("Total Execution Time: " + new DecimalFormat
                        /* + */("#.############").format(seconds) + " Seconds");
                    System.out.println("Total Integers stored in memory: "+intCounter*4
                        +"bytes");
                    System.out.println("Total Longs stored in memory: "+longCounter*8
                        +"bytes");
                    System.out.println("Total Doubles stored in memory: "+doubCounter*8
                        +"bytes");
                    System.out.println("Total Booleans stored in memory: "+boolCounter*1
                        +"bytes");
                    total = intCounter*4;
                    total = total+(int)longCounter*8;
                    total = total+(int)doubCounter*8;
                    total = total+boolCounter*1;
                    System.out.println("Total memory usage is: "+total+"bytes\n");
        
                    //resets values
                    intCounter = 3;
                    longCounter = 1;
                    doubCounter = 1;
                    boolCounter=0;
                    total = 0;
                
                    if(checker==false)
                    {
                        break;
                    }
                }
            }
        }
        if(checker == true)
        {
            System.out.println("\n\nAll numbers are in the "
                                + "correct order: Ascending\n");
            
            System.out.println("Total memory usage is: "+total+"bytes\n");
            long executionTime = System.nanoTime() - startTime;
            longCounter++;
            double seconds = (double)executionTime / 1_000_000_000.0;
            doubCounter++;
            System.out.println("Total Execution Time: " + new DecimalFormat
                        /* + */("#.############").format(seconds) + " Seconds");
            System.out.println("Total Integers stored in memory: "+intCounter*4
                +"bytes");
            System.out.println("Total Longs stored in memory: "+longCounter*8
                +"bytes");
            System.out.println("Total Doubles stored in memory: "+doubCounter*8
                +"bytes");
            System.out.println("Total Booleans stored in memory: "+boolCounter*1
                +"bytes");
            total = intCounter*4;
            total = total+(int)longCounter*8;
            total = total+(int)doubCounter*8;
            total = total+boolCounter*1;
            System.out.println("Total memory usage is: "+total+"bytes\n");
        
            //resets values
            intCounter = 3;
            longCounter = 1;
            doubCounter = 1;
            boolCounter=0;
            total = 0;
        }
    }//end ascendingArrChecker *
    
    //**********************************************
    //*       Sorted Data Checker Descending       *
    //**********************************************
    
    public static void descendingArrChecker(int[]array)
    {
        boolean checker = true;
        boolCounter++;
        
        long startTime = System.nanoTime(); 
        longCounter++;
        
        intCounter++;//adds 1 to counter for value k
        for(int k = 0; k<array.length;k++)
        {
          intCounter++;//adds one for each element in the loop
        }
        
        for(int a = 1;a<array.length-1;a++)
        {
            if(array[a] < array[a+1])
            {
                System.out.println("Error has occured: numbers are not in"
                                                    + " the correct order");
                checker = false;

                long executionTime = System.nanoTime() - startTime;
                longCounter++;
                double seconds = (double)executionTime / 1_000_000_000.0;
                doubCounter++;
                System.out.println("Total Execution Time: " + new DecimalFormat
                        /* + */("#.############").format(seconds) + " Seconds");
                System.out.println("Total Integers stored in memory: "+intCounter*4
                    +"bytes");
                System.out.println("Total Longs stored in memory: "+longCounter*8
                    +"bytes");
                System.out.println("Total Doubles stored in memory: "+doubCounter*8
                    +"bytes");
                System.out.println("Total Booleans stored in memory: "+boolCounter*1
                    +"bytes");
                total = intCounter*4;
                total = total+(int)longCounter*8;
                total = total+(int)doubCounter*8;
                total = total+boolCounter*1;
                System.out.println("Total memory usage is: "+total+"bytes\n");
        
                //resets values
                intCounter = 3;
                longCounter = 1;
                doubCounter = 1;
                boolCounter=0;
                total = 0;

                if(checker==false)
                {
                    break;
                }
            }
            else
            {
                if(array[a] < array[a+1] || array[a] > array[a-1])
                {
                    System.out.println("Error has occured: numbers are not in"
                                                    + " the correct order");       
                    checker = false;

                    long executionTime = System.nanoTime() - startTime;
                    longCounter++;
                    double seconds = (double)executionTime / 1_000_000_000.0;
                    doubCounter++;
                    System.out.println("Total Execution Time: " + new DecimalFormat
                        /* + */("#.############").format(seconds) + " Seconds");
                    System.out.println("Total Integers stored in memory: "+intCounter*4
                        +"bytes");
                    System.out.println("Total Longs stored in memory: "+longCounter*8
                        +"bytes");
                    System.out.println("Total Doubles stored in memory: "+doubCounter*8
                        +"bytes");
                    System.out.println("Total Booleans stored in memory: "+boolCounter*1
                        +"bytes");
                    total = intCounter*4;
                    total = total+(int)longCounter*8;
                    total = total+(int)doubCounter*8;
                    total = total+boolCounter*1;
                    System.out.println("Total memory usage is: "+total+"bytes\n");
        
                    //resets values
                    intCounter = 3;
                    longCounter = 1;
                    doubCounter = 1;
                    boolCounter=0;
                    total = 0;
                
                    if(checker==false)
                    {
                        break;
                    }
                }
            }
        }
        if(checker == true)
        {
            System.out.println("\n\nAll numbers are in the "
                                + "correct order: Descending\n");
            
            System.out.println("Total memory usage is: "+total+"bytes\n");
            long executionTime = System.nanoTime() - startTime;
            longCounter++;
            double seconds = (double)executionTime / 1_000_000_000.0;
            doubCounter++;
            System.out.println("Total Execution Time: " + new DecimalFormat
                        /* + */("#.############").format(seconds) + " Seconds");
            System.out.println("Total Integers stored in memory: "+intCounter*4
                +"bytes");
            System.out.println("Total Longs stored in memory: "+longCounter*8
                +"bytes");
            System.out.println("Total Doubles stored in memory: "+doubCounter*8
                +"bytes");
            System.out.println("Total Booleans stored in memory: "+boolCounter*1
                +"bytes");
            total = intCounter*4;
            total = total+(int)longCounter*8;
            total = total+(int)doubCounter*8;
            total = total+boolCounter*1;
            System.out.println("Total memory usage is: "+total+"bytes\n");
        
            //resets values
            intCounter = 3;
            longCounter = 1;
            doubCounter = 1;
            boolCounter=0;
            total = 0;
        }
    }//end descendingArrChecker *
}//end SortCheck class **