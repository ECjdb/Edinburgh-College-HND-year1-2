package sortingassessment;

//EC1524329
//Joel Degner-Budd
//11/12/2018

public class SearchFunction 
{
    public SearchFunction()
    {
    
    }
    
    public boolean SearchFunction(int[] array, int num)
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
            if(array[x] == num)
            {
              System.out.println("The number "+array[x]+" has been found");
              System.out.println("Number at position: "+counter+" \n");
              found = true;
            }
            else if(x == array.length-1 && found == false)
            {
              System.out.println("The number "+num+" does not exist in the array\n");
            }

        }
        
        long executionTime = System.nanoTime() - startTime;
        double seconds = (double)executionTime / 1_000_000_000.0;
        System.out.println("Total Execution Time: "+seconds+"s");
        
        System.out.print("********************************************");
        System.out.print("*********************************************\n\n");
        
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
}//end SearchFunction class ** 