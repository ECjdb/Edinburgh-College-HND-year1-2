package sortingassessment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//EC1524329
//Joel Degner-Budd
//11/12/2018

public class WriteFile 
{
    //blank constructor
    public WriteFile()
    {
        
    }
    
    public static void intWrite(int[]array,String str)
    {
        str = str + ".txt";
        File warehouseStorage = new File(str);
        String value = "";
                  
        try
        {
            FileWriter fw = new FileWriter(warehouseStorage);
            BufferedWriter bw = new BufferedWriter(fw);
                
            System.out.println("\nWriting Data to File...");
          
            for(int k=0;k<array.length;k++)
            {
              bw.write(array[k]+",");
            }
            bw.flush();
            bw.close();
            System.out.println("\nnew text file created.\n");
            System.out.println("End of Write\n\n");
        }
        catch(IOException e)
        {
            System.out.println("An error has occured");
        }
    }//end intWrite *
}//end WriteFile class **
