package sortingassessmentpart2;

import java.util.Comparator;

//EC1524329
//Joel Degner-Budd
//11/12/2018

public class popComparator implements Comparator<AmericanCities>
{
    //blank constructor
    public popComparator()
    {
    
    }
    
    //compare method for popualtion
    @Override
    public int compare(AmericanCities usa1, AmericanCities usa2) 
    {
        if(usa1.getPopulation()*100<usa2.getPopulation()*100)
        {
            return -1;
        }
        else
        {
            if(usa1.getPopulation()*100>usa2.getPopulation()*100)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
    }//end compare *
}//end popComparator class **