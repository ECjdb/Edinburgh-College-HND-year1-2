package sortingassessmentpart2;

//EC1524329
//Joel Degner-Budd
//11/12/2018

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class ReadFile 
{
    //blank constructor
    public ReadFile()
    {
    
    }
    
    //file reader method
    public AmericanCities[] getArray(String filename)
    {
        File myFile = new File(filename) ; 
        NumberFormat nf = new DecimalFormat("#0.00");
        ArrayList<AmericanCities> arrList = new ArrayList<>();
     
        try 
        {
            FileReader fr = new FileReader(myFile);  
            BufferedReader br = new BufferedReader(fr);
         
            String data="";
            int number;
         
            while((data = br.readLine())!= null)
            {
                StringTokenizer  st = new  StringTokenizer(data,",");
                AmericanCities usaC = new AmericanCities();
                while(st.hasMoreTokens())
                {
                    usaC.setCity(st.nextToken().trim());
                    usaC.setPopGrowth(Double.parseDouble(st.nextToken().trim()));
                    usaC.setLatitude(Double.parseDouble(st.nextToken().trim()));
                    usaC.setLongitude(Double.parseDouble(st.nextToken().trim()));
                    usaC.setPopulation(Integer.parseInt(st.nextToken().trim()));
                    usaC.setRank(Integer.parseInt(st.nextToken().trim()));
                    usaC.setState(st.nextToken().trim());  

                    arrList.add(usaC);
                }
            }
            br.close();
         } 
        catch (IOException e) 
        {
            System.out.println("Error loading file"); 
        }
        catch(NoSuchElementException e)
        {
            System.out.println("\nan error has occured: no such element");
        }
      
        // Use iterator to display contents of arrList
        System.out.print("\nOriginal contents of arrList: \n");
        System.out.print("\n============================================");
        System.out.print("=============================================\n");
        Iterator itr = arrList.iterator();
      
        System.out.println();
     
        while(itr.hasNext()) 
        {
            Object element = itr.next();
            System.out.print(element + " \n");
        }
        System.out.println();

        System.out.println("number of items on file is: "+arrList.size());
        AmericanCities myArray[] = new AmericanCities[arrList.size()];
        myArray = arrList.toArray(myArray);
      
        AmericanCities[] result = new AmericanCities[myArray.length];
        for (int k = 0; k < myArray.length; k++) 
        {
            result[k] = myArray[k];
        }

        return result;
    }//end file reader *

    //displays data
    public void displayArray(AmericanCities[] array, String message) 
    {
        System.out.println(message);
      
        System.out.print("********************************************");
        System.out.print("*********************************************\n\n");
        if(array != null)
        {
            for(int k = 0; k<array.length; k++)
            {
                System.out.print(array[k]+" \n"); 
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
    }//end display Array * 
    
    //displays data
    public void displaySorted(Comparator[] array, String message) 
    {
        System.out.println(message);
      
        System.out.print("********************************************");
        System.out.print("*********************************************\n\n");
        if(array != null)
        {
            for(int k = 0; k<array.length; k++)
            {
                System.out.print(array[k]+" \n"); 
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
    } //displaySorted *
}//end ReadFile class **