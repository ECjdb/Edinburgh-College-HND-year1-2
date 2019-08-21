/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectholidays;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author EC1524329
 */
public class HolidayRecord 
{
    private int employeeId;
    private int allowance;
    private int count;
    
    public HolidayRecord(int employeeId, int allowance, int count)
    {
        this.employeeId = employeeId;
        this.allowance = allowance;
        this.count = count;
    }
    
    public HolidayRecord()
    {
        this.employeeId = employeeId;
        this.allowance = allowance;
        this.count = count;
    }

    public int getEmployeeId() 
    {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) 
    {
        this.employeeId = employeeId;
    }

    public int getAllowance() 
    {
        return allowance;
    }

    public void setAllowance(int allowance) 
    {
        this.allowance = allowance;
    }

    public int getCount() 
    {
        return count;
    }

    public void setCount(int count) 
    {
        this.count = count;
    }

    @Override
    public String toString() 
    {
        return employeeId 
                + ","+ allowance 
                + "," + count;
    }
    
    public int RequestHoliday(ArrayList arrList)
    {
        Iterator<HolidayRecord> itr = arrList.iterator();
        
        HolidayRecord rec = itr.next();
        
        while(itr.hasNext())
        {
            rec.getEmployeeId();
        }
            
        return allowance;
    }
    
}
