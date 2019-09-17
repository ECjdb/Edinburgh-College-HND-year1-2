package sortingassessmentpart2;

import java.util.Comparator;

//EC1524329
//Joel Degner-Budd
//11/12/2018

public class CityComparator implements Comparator<AmericanCities> 
{
    //blank constructor
    public CityComparator()
    {
    
    }//end CityComparator *
    
    //compares City names
    @Override
    public int compare(AmericanCities usa1, AmericanCities usa2) 
    {
        return usa1.getCity().compareTo(usa2.getCity());
    }//end compare *
}//end CityComparator class **