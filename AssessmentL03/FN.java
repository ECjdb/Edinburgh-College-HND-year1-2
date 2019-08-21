package golfplayersapp;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

//EC1524329
//Joel Degner-Budd
//15/11/2018

public class FN 
{
    public FN()
    {
        
    }
    
    //============================================================
    //================= Calculates Total Points ==================
    //============================================================
    public double totalPoints(Map<String,GolfPlayer> gpMap)
    {
        NumberFormat nf = new DecimalFormat("#0.00");
        
        double max = 0;
        for(GolfPlayer x : gpMap.values())
        {
            max += x.getTotalPts();
        }
        System.out.println(nf.format(max));
        
        return max;
    }
    
    //============================================================
    //================ Calculates Greatest Value =================
    //============================================================
    public void greatestValue(double value1, double value2)
    {
        NumberFormat nf = new DecimalFormat("#0.00");
        
        if(value1 > value2)
        {
            System.out.println("Max has "+(nf.format(value1 -value2))+" more points");
        }
        else
        {
            System.out.println("Max has "+(nf.format(value2 - value1))+" more points");
        }
    }
    //============================================================
    //================ Calculates most Americans =================
    //============================================================
    public int mostAmericans(Map<String,GolfPlayer> gpMap)
    {
        int counter =0;
        for(GolfPlayer x : gpMap.values())
        {
            if(x.getCountry().equals("USA"))
            {
                System.out.println("USA player = "+x);
                counter++;
            }
        }      
        System.out.println("There are "+counter+" in this map");
        
        return counter;
    }
    //============================================================
    //=================== Converts Map to Set ====================
    //============================================================
    public Set<GolfPlayer>mapToSet(Map<String,GolfPlayer> gpMap)
    {
        Set<GolfPlayer> gpSet = new LinkedHashSet<>();
        
        for(GolfPlayer x : gpMap.values())
        {
            gpSet.add(x);
        }
        System.out.println(gpSet);
        
        return gpSet;
    }
}    
