package sortingassessmentpart2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;

//EC1524329
//Joel Degner-Budd
//11/12/2018

public class WriteFile
{
    
    //file writer
    public static void comparatorWrite(Comparator[]array,String str)
    {
        str = str + ".txt";
        File warehouseStorage = new File(str);
                  
        int counter = 0;
        try
        {
            FileWriter fw = new FileWriter(warehouseStorage);
            BufferedWriter bw = new BufferedWriter(fw);
                
            System.out.println("\nWriting Data to File...\n");
          
            for(int k=0;k<array.length;k++)
            {         
                counter++;
                System.out.println(array[k]);
                bw.write(array[k]+",");
                bw.write(System.lineSeparator());
            }
            bw.flush();
            bw.close();
            System.out.println("\nnew text file created.\n");
            System.out.println("Text File: "+str);
            System.out.println("Number of items on File: "+counter);
            System.out.println("End of Write\n\n");
        }
        catch(IOException e)
        {
            System.out.println("An error has occured");
        }
    }//end comparatorWrite *
    
    public static void comparatorWrite(String str, String object)
    {
        str = str + ".txt";
        File warehouseStorage = new File(str);
                 
        try
        {
            FileWriter fw = new FileWriter(warehouseStorage);
            BufferedWriter bw = new BufferedWriter(fw);
                
            System.out.println("\nWriting Data to File...\n");
            System.out.println(object);
            bw.write(object);
            bw.write(System.lineSeparator());
            
            bw.flush();
            bw.close();
            System.out.println("\nnew text file created.\n");
            System.out.println("Text File: "+str);
            System.out.println("Number of items on File: "+"1");
            System.out.println("End of Write\n\n");
        }
        catch(IOException e)
        {
            System.out.println("An error has occured");
        }
    }//end comparatorWrite *
}//end WriteFile class **