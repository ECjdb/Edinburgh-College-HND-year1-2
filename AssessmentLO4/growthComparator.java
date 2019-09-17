package sortingassessmentpart2;

import java.util.Comparator;

//EC1524329
//Joel Degner-Budd
//11/12/2018

public class growthComparator implements Comparator<AmericanCities>
{
    //blank constructor
    public growthComparator()
    {
    
    }

    //compare method for population growth
    @Override
    public int compare(AmericanCities usa1, AmericanCities usa2) 
    {
       if(usa1.getPopGrowth()*100<usa2.getPopGrowth()*100)
       {
           return -1;
       }
       else
       {
           if(usa1.getPopGrowth()*100>usa2.getPopGrowth()*100)
           {
               return 1;
           }
           else
           {
               return 0;
           }
       }
    }//end compare *
}//end growthComparator class **