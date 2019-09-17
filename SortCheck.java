package sortingassessment;

//EC1524329
//Joel Degner-Budd
//11/12/2018

public class SortCheck 
{
    //**********************************************
    //*       Sorted Data Checker Ascending        *
    //**********************************************
    
    public static void ascendingArrChecker(int[]array)
    {
        boolean checker = true;
        
        for(int a = 1;a<array.length-1;a++)
        {
            if(array[a] > array[a+1])
            {
                System.out.println("Error has occured: numbers are not in"
                                                    + " the correct order");
                checker = false;
                
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
        }
    }//end ascendingArrChecker *
    
    //**********************************************
    //*       Sorted Data Checker Descending       *
    //**********************************************
    
    public static void descendingArrChecker(int[]array)
    {
        boolean checker = true;
        
        for(int a = array.length-2;a > 0;a--)
        {
            if(array[a] < array[a+1])
            {
                System.out.println("Error has occured: numbers are not in"
                                                    + " the correct order");
                checker = false;
                
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
                
                    if(checker==false)
                    {
                        break;
                    }
                }
            }
        }
        if(checker == true)
        {
            System.out.println("All numbers are in the "
                                    + "correct order:Descending\n");
        }
    }//end descendingArrChecker *
}//end SortCheck class **