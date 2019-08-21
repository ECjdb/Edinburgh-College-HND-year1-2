package projectholidays;

//EC1524329

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

//Joel Degner-Budd
//27/03/2018

public class ReadFile 
{
    public ReadFile()
    {
        
    }
    
    public ArrayList RF()
    {
        System.out.println("Reading Holiday Planner data...\n");
        File myFile = new File("holidays.txt");
        ArrayList hpArrayList = new ArrayList();
        
        String data ="";
     
        try
        {
            java.io.FileReader fr = new java.io.FileReader(myFile);  
            BufferedReader br = new BufferedReader(fr);          
            
            while( (data = br.readLine()) != null)
            {
                StringTokenizer st = new StringTokenizer(data ,",");

                while(st.hasMoreTokens())
                { 
                    int id;
                    int allowance;
                    int count;
                        
                    id = Integer.parseInt(st.nextToken().trim());
                    allowance = Integer.parseInt(st.nextToken().trim());
                    count = Integer.parseInt(st.nextToken().trim());
                        
                    HolidayRecord holRec = new HolidayRecord(id,allowance,count);
                    hpArrayList.add(holRec);
                }
            } 
            System.out.println(hpArrayList);
            br.close();
        }
        catch(IOException e) 
        {
            System.out.println("Error: File not found");  
        }
        
        return hpArrayList;
    }
    
    
}
