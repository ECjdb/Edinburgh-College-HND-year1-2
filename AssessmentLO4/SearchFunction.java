package sortingassessmentpart2;

import java.text.DecimalFormat;

//EC1524329
//Joel Degner-Budd
//11/12/2018

public class SearchFunction 
{
    public SearchFunction()
    {
    
    }
    
    //*****************************************************************
    //*                       String Search                           *
    //***************************************************************** 
    
    public String StringSearch(AmericanCities[] array, String findItem)
    {
        boolean itemFinder = false;
        long startTime = System.nanoTime();
        String str = "";
        
        System.out.print("\n********************************************");
        System.out.print("*********************************************\n\n"); 
        
        for(int x = 0; x<=array.length;x++)
        {    
            if(array[x].getCity().equalsIgnoreCase(findItem))
            {
                System.out.println("Item Found: "+array[x].getCity());
                System.out.println("Position: "+x);
                System.out.println("Object: "+array[x].toString());
                itemFinder = true;
                str = array[x].toString();
            }
            
            if(x == array.length-1)
            {
                if(itemFinder == true)
                {
                    System.out.println("All matching items found");
                    System.out.println("End of array");
                    
                    long executionTime = System.nanoTime() - startTime;
                    double seconds = (double)executionTime / 1_000_000_000.0;
                    System.out.println("Total Execution Time: " 
                                + new DecimalFormat
                    /* + */("#.############").format(seconds) + " Seconds");
        
                    System.out.print("************************"
                                + "********************");
                    System.out.print("************************"
                                + "*********************\n\n");
                    
                    return str;
                }
                else
                {
                    itemFinder = false;
                    
                    if(itemFinder == false)
                    {
                        System.out.println("End of array");
                        System.out.println("item doesnt exist\n");
                        
                        long executionTime = System.nanoTime() - startTime;
                        double seconds = (double)executionTime / 1_000_000_000.0;
                        System.out.println("Total Execution Time: " 
                                + new DecimalFormat
                        /* + */("#.############").format(seconds) + " Seconds");
        
                        System.out.print("************************"
                                + "********************");
                        System.out.print("************************"
                                + "*********************\n\n");
                        return str;
                    }
                }
            }
        }
        long executionTime = System.nanoTime() - startTime;
        double seconds = (double)executionTime / 1_000_000_000.0;
        System.out.println("Total Execution Time: " + new DecimalFormat
                        /* + */("#.############").format(seconds) + " Seconds");
        
        System.out.print("********************************************");
        System.out.print("*********************************************\n\n");
        
        return str;
    }//end StringSearch *
    
    //*****************************************************************
    //*                       popGrowth Search                        *
    //***************************************************************** 
    
    public String PopGrowthSearch(AmericanCities[] array, double itemFind)
    {
        boolean itemFinder = false;
        long startTime = System.nanoTime();
        String str = "";
        
        System.out.print("\n********************************************");
        System.out.print("*********************************************\n\n");
        
        for(int x = 0; x<=array.length;x++)
        {
            if(array[x].getPopGrowth() == itemFind)
            {
                System.out.println("Item Found: "+array[x].getPopGrowth());
                System.out.println("Position: "+x);
                System.out.println("Object: "+array[x]);
                itemFinder = true;
                str = array[x].toString();
            }
            if(x == array.length-1)
            {
                if(itemFinder == true)
                {
                    System.out.println("All matching items found");
                    System.out.println("End of array");
                    
                    return str;
                }
                else
                {
                    itemFinder = false;
                    
                    if(itemFinder == false)
                    {
                        System.out.println("End of array");
                        System.out.println("item doesnt exist\n");
                        return str;
                    }
                }
            }
        }//end for
        long executionTime = System.nanoTime() - startTime;
        double seconds = (double)executionTime / 1_000_000_000.0;
        System.out.println("Total Execution Time: " + new DecimalFormat
                        /* + */("#.############").format(seconds) + " Seconds");
        
        System.out.print("********************************************");
        System.out.print("*********************************************\n\n");
        
        return str;
    }//end popGrowthSearch *
    
    //*****************************************************************
    //*                     Population Search                         *
    //***************************************************************** 
    
    public String PopSearch(AmericanCities[] array, int itemFind)
    {  
        String str = ""; 
        boolean itemFinder = false;
        long startTime = System.nanoTime();
        AmericanCities[] usaArray = null;
        WriteFile wr = new WriteFile();
        
        System.out.print("\n********************************************");
        System.out.print("*********************************************\n\n");
        
        for(int x = 0; x<array.length;x++)
        {
            if(array[x].getPopulation() == itemFind)
            {
                System.out.println("Item Found: "+array[x].getPopulation());
                System.out.println("Position: "+x);
                System.out.println("Object: "+array[x]);
                itemFinder = true;
                str = array[x].toString();
            }
            if(x == array.length-1)
            {
                if(itemFinder == true)
                {
                    System.out.println("All matching items found");
                    System.out.println("End of array");
                    
                    return str;
                }
                else
                {
                    itemFinder = false;
                    if(itemFinder == false)
                    {
                        System.out.println("End of array");
                        System.out.println("item doesnt exist\n");
                        return str;
                    }
                }
            }
        }//end for
        
        long executionTime = System.nanoTime() - startTime;
        double seconds = (double)executionTime / 1_000_000_000.0;
        System.out.println("Total Execution Time: " + new DecimalFormat
                        /* + */("#.############").format(seconds) + " Seconds");
        
        System.out.print("********************************************");
        System.out.print("*********************************************\n\n");
        
        return str;
    }//end populationSearch *
}//end SearchFunction class **