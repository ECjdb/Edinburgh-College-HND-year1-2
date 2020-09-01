package task2.total.memory.and.average.file.size;

/**
Name: Joel Degner-Budd
Location: Sighthill - Edinburgh college
Date: 23rd February, 2018
Version: 1.0
Notes: n/a
 */

public class Task2TotalMemoryAndAverageFileSize 
{

    public static void main(String[] args) 
    {
         //this declares the variables and the array
        int totalValue = 0;
        int totalAverage = 0;
        int arr[]={121,256,201,789,943,981,867,456,763,741};
        
        for(int a=0; a<arr.length; a++)
        {
            //totalValue is equal to the current value + the current array index.
            totalValue = totalValue + arr[a];
        }
        //the totalAverage is equal to the totalValue divided by the size of the array, in this case 10.
        totalAverage = totalValue/10;
        
        //prints out totalValue and the totalAverage variables.
        System.out.println("The total memory size of all files is: "+totalValue+"\n"+"The Total average is: "+totalAverage);
    }
    
}
