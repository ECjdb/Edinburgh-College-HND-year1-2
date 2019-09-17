package AssessmentBinarySearch;

//EC1524329
//Joel Degner-Budd
//11/12/2018

public class SortCheck 
{
    //**********************************************
    //*       Sorted Data Checker Ascending        *
    //**********************************************
    
    //blank constructor
    public SortCheck()
    {
    
    }
    
    public boolean LinearArrChecker(int[]array)
    {
        boolean checker = true;
        
        for(int a = 1;a<array.length-1;a++)
        {
            if(array[a] > array[a+1])
            {
                System.out.println("Numbers are not in"
                                                    + " Ascending order");
                checker = false;
                
                if(checker==false)
                {
                    return checker;
                }
            }
            else
            {
                if(array[a] > array[a+1] || array[a] < array[a-1])
                {
                    System.out.println("Numbers are not in"
                                                    + " Ascending order");       
                    checker = false;
                
                    if(checker==false)
                    {
                        return checker;
                    }
                }
            }
        }
        if(checker == true)
        {
            System.out.println("\nNumbers are in the "
                                + "correct order: Ascending\n\n");
            return checker;
        }
        
        return checker;
    }//end ascendingArrChecker *
}//end SortCheck class **