package golfplayersapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

//EC1524329
//Joel Degner-Budd
//31.10.2018

public class ReadData 
{
    
    public ReadData()
    {
        System.out.println("Reading in file data...");
    }
    
    //============================================================
    //================ Reads data from .txt file =================
    //============================================================
    
    public Map<String,GolfPlayer> ReadData(String currFile)
    {
        File myFile = new File(currFile);
        
        Map<String,GolfPlayer> gpMap = new LinkedHashMap<>();
        GolfPlayer gp;
        String data = "";
        
        System.out.println("\n*************** Start of read: "+currFile
                +" ***************");
        try
        {
            FileReader fr = new FileReader(currFile);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            
                while((data = br.readLine()) !=null )
                {
                    System.out.println("info: "+data);
                
                    StringTokenizer st = new StringTokenizer(data,",");
                
                    while(st.hasMoreTokens())
                    {
                        gp = new GolfPlayer(st.nextToken().trim()
                                ,(st.nextToken())
                                ,Integer.parseInt(st.nextToken().trim()) 
                                ,Double.parseDouble(st.nextToken())
                                ,(st.nextToken()) );
                        
                        String key;
                        key = gp.setKey();
                        gpMap.put(key, gp);
                    }
                }
            }  
        catch(IOException e)
        {
            System.out.println("\nan error has occured");
        }
        catch(NumberFormatException e)
        {
            System.out.println("\nFormat Error has occured");
        }
        catch(NoSuchElementException e)
        {
            System.out.println("\nan error has occured: No such element");
        }

        System.out.println("\nMap created...\n");
        System.out.println("*************** End of read: "+currFile
                +" ***************");
        return gpMap;
    }  
        
}