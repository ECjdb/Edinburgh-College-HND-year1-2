package projectholidays;

import java.util.ArrayList;
import java.util.Iterator;

//EC1524329
//Joel Degner-Budd
//27/03/2018

public class HolidayPlanner 
{
    private HolidayPlanner holPlan;
    private ArrayList<HolidayRecord> holPlanner = new ArrayList<>();

    public HolidayPlanner() 
    {
        
    }
    
    public HolidayPlanner getHolPlan()
    {
        return holPlan;
    }
    
    public void setHolPlan(HolidayPlanner holPlan)
    {
        this.holPlan = holPlan;
    }

    public ArrayList<HolidayRecord> getHolRecord() 
    {
        return holPlanner;
    }

    public void setHolPlanner(ArrayList<HolidayRecord> holPlanner) 
    {
        this.holPlanner = holPlanner;
    }
}
