package sortingassessmentpart2;

import java.util.Comparator;

//EC1524329
//Joel Degner-Budd
//11/12/2018

public class SortChecker 
{
    public static boolean AscendingChecker(Comparator[] array, Comparator name)
    {
        boolean checker = true;
        
        for(int x = 0; x<array.length-1;x++)
        {
            if(name.compare(array[x], array[x+1])>0)
            {
                checker = false;
                System.out.println("\nInformation is not in Ascending order");
                return checker;
            }
        }
        System.out.println("\nInformation is in the correct order: Ascending\n");
        return checker;
    }//end AscendingChecker *
    
    public static boolean DescendingChecker(Comparator[] array, Comparator name)
    {
        boolean checker = true;
        
        for(int x = 0; x<array.length-1;x++)
        {
            if(name.compare(array[x], array[x+1])<0)
            {
                checker = false;
                System.out.println("\nInformation is not in Descending order");
                return checker;
            }
        }
        System.out.println("\nInformation is in the correct order: Descending\n");
        return checker;
    }//end DescendingChecker *
}//end SortChecker class **