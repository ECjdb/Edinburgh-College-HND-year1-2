package sortingassessmentpart2;

import java.text.DecimalFormat;
import java.util.Comparator;

//EC1524329
//Joel Degner-Budd
//11/12/2018

public class MergeSortComparator 
{
    //static variables
    
    static long startTime = 0;
    static long executionTime = 0;
    static int comparisons = 0;
    static int swaps = 0;
    static double seconds = 0;
    
    //****************************************************
    //****************************************************
    //*                 Merge Ascending                  *
    //****************************************************
    //****************************************************
    
    private static void mergeSortAscending(Comparator [ ] a, Comparator [ ] tmp,Comparator usaCity ,int left, int right)
    {
        if( left < right )
        {
            int center = (left + right) / 2;
            mergeSortAscending(a, tmp, usaCity, left, center);
            mergeSortAscending(a, tmp, usaCity, center + 1, right);
            mergeAscend(a, tmp,usaCity, left, center + 1, right);
        }
    }
    private static void mergeAscend(Comparator[ ] a, Comparator[ ] tmp,Comparator usaCity, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;
        while(left <= leftEnd && right <= rightEnd)
        {
            comparisons++;
            
            if(usaCity.compare(a[left],a[right]) <= 0)
            {
                tmp[k++] = a[left++];
            }

            else
            {
                tmp[k++] = a[right++];
            }
        }
        while(left <= leftEnd)
        {
            tmp[k++] = a[left++];
            swaps++;
        }
        while(right <= rightEnd)
        {
            tmp[k++] = a[right++];
            swaps++;
        }
        for(int i = 0; i < num; i++, rightEnd--)
        {
            a[rightEnd] = tmp[rightEnd];
            swaps++;
        }
    }

    public static void mergeSortAscending(Comparator[ ] a, Comparator usaCity)
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
        
        Comparator[] tmp = new Comparator[a.length];
        mergeSortAscending(a, tmp,usaCity, 0, a.length - 1);
        
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
    }//end MergeSortAscending *
    
    
    //****************************************************
    //****************************************************
    //*                 Merge Descending                 *
    //****************************************************
    //****************************************************
    private static void mergeSortDescending(Comparator [ ] a, Comparator [ ] tmp,Comparator usaCity ,int left, int right)
    {
        if( left < right )
        {
            int center = (left + right) / 2;
            mergeSortDescending(a, tmp, usaCity, left, center);
            mergeSortDescending(a, tmp, usaCity, center + 1, right);
            mergeDescend(a, tmp,usaCity, left, center + 1, right);
        }
    }
    private static void mergeDescend(Comparator[ ] a, Comparator[ ] tmp,Comparator usaCity, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;
        while(left <= leftEnd && right <= rightEnd)
        {
            comparisons++;
            
            if(usaCity.compare(a[left],a[right]) <= 0)
            {
                tmp[k++] = a[right++];
            }

            else
            {
                tmp[k++] = a[left++];
            }
        }
        while(left <= leftEnd)
        {
            tmp[k++] = a[left++];
            swaps++;
        }
        while(right <= rightEnd)
        {
            tmp[k++] = a[right++];
            swaps++;
        }
        for(int i = 0; i < num; i++, rightEnd--)
        {
            a[rightEnd] = tmp[rightEnd];
            swaps++;
        }
    }

    public static void mergeSortDescending(Comparator[ ] a,Comparator usaCity)
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
        
        Comparator[] tmp = new Comparator[a.length];
        mergeSortDescending(a, tmp,usaCity, 0, a.length - 1);
        
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
    }//end MergeSortDescending *
}//end MergeSortComparator class **