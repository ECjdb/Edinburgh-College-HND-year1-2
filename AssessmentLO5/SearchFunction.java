package AssessmentBinarySearch;

import java.text.DecimalFormat;

//EC1524329
//Joel Degner-Budd
//11/12/2018

public class SearchFunction 
{
    //blank constructor
    public SearchFunction()
    {
    
    }
    
    //*****************************************************************
    //*                     Linear Search Funciton                    *
    //***************************************************************** 
    
    public boolean LinearSearchFunction(int[] array, int num)
    {   
        int k = 0;
        int counter = 0;
        boolean found = false;
        
        long startTime = System.nanoTime(); 
        
        System.out.print("\n********************************************");
        System.out.print("*********************************************\n\n"); 
        
        for(int a = 0; a<array.length;a++)
        {
          counter++;
        }
        System.out.println("\nThe number of items on file is: "+ counter);
        counter = 0;
        
        System.out.println("\nSearching for item: "+num);
        for(int x = 0; x<array.length;x++)
        {
            counter ++;
            //finds first number
            if(array[x] == array[0])
            {
              System.out.println("The first number in the array is: "+array[x]);
            }
            //finds last number
            if(x == array.length-1)
            {
              System.out.println("The last number in the array is: "+array[x]);
            }
            //if item is found
            if(array[x] == num)
            {
              System.out.println("The number "+array[x]+" has been found");
              System.out.println("Number at position: "+counter+" \n");
              found = true;
            }
            //if item is not found
            else if(x == array.length-1 && found == false)
            {
              System.out.println("The number "+num+" does not exist in the array\n");
            }

        }
        //displays execution time
        long executionTime = System.nanoTime() - startTime;
        double seconds = (double)executionTime / 1_000_000_000.0;
        seconds = (double)executionTime/1_000_000_000.0;
        System.out.println("Total Execution Time: " + new DecimalFormat
                        /* + */("#.############").format(seconds) + " Seconds");
        System.out.println("End of Linear Search");
        System.out.println("*************************************"
                    + "****************************************************"); 
        if(found == true)
        {
          return true;
        }
        else
        {
          return false;
        }
        //RandomNumber(temp);
    }//end SearchFunction *
    
    //*****************************************************************
    //*                     Binary Search Funciton                    *
    //***************************************************************** 
    
    public int BinarySearchFunction(int[] array, int value)
    {
        int initialFirst = 0; //prevents out of bounds
        int initialLast = array.length-1; //prevents out of bounds
        int first;   // first array element
        int last;    // last array element
        int middle;  // mid point of the search
        int position; // position of search value
        int timesSearched=0; //tracks number of times item has been searched
        boolean found; // flag  indicates if data has been found
    
        found = false;
        position = -1;
        last  = array.length-1;
        first = 0;
        
        while(!found && first <= last) 
        {
            middle = (first+last)/2;
            timesSearched++;

            if(array[middle]==value)
            {
              found = true;
              position = middle;
              
              System.out.println("Item has been found: "+value);
              System.out.println("Items position is: "+position);
              System.out.println("Number of times item searched for: "
                                                            + ""+timesSearched);
              return position;
            }
            else
            {
              if(middle != initialFirst && middle !=initialLast)
              {
                System.out.println("Current position of middle: "+middle);
                System.out.println("middle array element is: "+array[middle]);
                System.out.println("right of middle array element is: "
                                                          + ""+array[middle+1]);
                System.out.println("left of middle array element is: "
                                                          + ""+array[middle-1]);
                System.out.println("first array element is: "+array[first]);
                System.out.println("second array element is: "+array[first+1]);
                System.out.println("last array element is: "+array[last]);
                System.out.println("second-last array element is: "+array[last-1]);
              }
              else if(middle == initialFirst || middle == initialLast)
              {
                first = middle;
                last = middle;
                System.out.println("Current position of middle: "+middle);
                System.out.println("middle array element is: "+array[middle]);
                System.out.println("first array element is: "+array[first]);
                System.out.println("last array element is: "+array[last]);
              }
              
              if(array[middle]>value)
              {
                last = middle - 1;  
                System.out.println("\nmiddle value larger than search value");
                System.out.println("moving to left side of array\n");
              } 
              else
              {
                first = middle + 1;  
                System.out.println("\nmiddle value smaller than search value");
                System.out.println("moving to right side of array\n");
              }
            }
        }
    
        if(found == false)
        {
          System.out.println("Number of times item searched for: "
                                                            + ""+timesSearched);
        }
        
    return position;
    
  }
}//end SearchFunction class ** 