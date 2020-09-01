package sortingassessment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//EC1524329
//Joel Degner-Budd
//11/12/2018

public class ReadFile 
{
    //blank constructor
    public ReadFile()
    {
    
    }
    
    //File Reader
    public int[]getNumArr(String fileName)
    {
        File myFile = new File(fileName);
        
        ArrayList<Integer>arrList = new ArrayList<>();
        
        int counter = 0;
        
        try 
        {
            FileReader rd = new FileReader(myFile);
            BufferedReader br = new BufferedReader(rd);
            
            String data = "";
            int number;
            
            while((data = br.readLine()) !=null)
            {
                StringTokenizer st = new StringTokenizer(data,",");
                
                while(st.hasMoreTokens())
                {
                    number = Integer.parseInt(st.nextToken().trim());
                    arrList.add(number);
                    counter++;
                }
            }
            br.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Error loading file");
        }
        
        Integer myArray[] = new Integer[arrList.size()];
        myArray = arrList.toArray(myArray);
        int loopCounter = 0;
        int[]result = new int[myArray.length];
        
        for(int k = 0; k<myArray.length;k++)
        {
            loopCounter++;
            result[k] = myArray[k];
           
            if(loopCounter <= 10)
            {
                System.out.print(result[k]+" ");
            }
            else
            {
                System.out.println(" \n");
                loopCounter = 0;
            }
        }
        System.out.println("\n\nnumber of items on file: "+counter+" \n");
        
        return result;
    }//end getNumArr   
    
    public void displayPartialArr(int[] array, String message) 
    {
        if(array != null)
        {
            for(int k = 0; k<array.length; k++)
            {
                System.out.print(array[k]+" "); 
            }
            System.out.print("\n********************************************");
            System.out.print("*********************************************\n\n"); 
        }
        else
        {
            System.out.println("An error has occured: Data is empty");
            System.out.print("\n********************************************");
            System.out.print("*********************************************\n\n"); 
        }
        System.out.println(message);
      
        System.out.print("********************************************");
        System.out.print("*********************************************\n\n");
   
    }//end displayNumArr *
    
    public void displayFullArr(int[] array, String message) 
    {
        System.out.println(message);
        
        int loopCounter = 0;
        
        if(array != null)
        {
            for(int k = 0; k<array.length; k++)
            {
              loopCounter++;  
                
              if(loopCounter <= 9)
              {
                System.out.print(array[k]+", ");
              }
              else
              {
                System.out.println(" \n");
                loopCounter = 0;
              }
            }
            System.out.print("\n********************************************");
            System.out.print("*********************************************\n\n"); 
        }
        else
        {
            System.out.println("An error has occured: Data is empty");
            System.out.print("\n********************************************");
            System.out.print("*********************************************\n\n"); 
        }
        System.out.print("********************************************");
        System.out.print("*********************************************\n\n");
  
    }//end displayNumArr *
}//end ReadFile class **