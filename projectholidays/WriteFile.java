/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectholidays;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author EC1524329
 */
public class WriteFile 
{
    public WriteFile()
    {
    
    }
    
    public void Write(List<?> genericArray, String fileName)
    {
        String fName = fileName+".txt";
        File myFile = new File(fName);
        
        int counter = 0;
        //pass in generic ArrayList
        try
        {
            FileWriter fw = new FileWriter(myFile);
            BufferedWriter bw = new BufferedWriter(fw);
                
            System.out.println("\nWriting Data to File...\n");
          
            for(int k=0;k<genericArray.size();k++)
            {         
                counter++;
                System.out.println(genericArray.get(k));
                bw.write(genericArray.get(k)+",");
                bw.write(System.lineSeparator());
            }
            bw.flush();
            bw.close();
            System.out.println("\nnew text file created.\n");
            System.out.println("Text File: "+fName);
            System.out.println("Number of items on File: "+counter);
            System.out.println("End of Write\n\n");
        }
        catch(Exception e)
        {
            System.out.println("An error has occured" + e);
        }     
    }
}
