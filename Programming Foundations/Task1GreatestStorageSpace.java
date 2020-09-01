package task1.greatest.storage.space;

/**
Name: Joel Degner-Budd
Location: Sighthill - Edinburgh college
Date: 23rd February, 2018
Version: 1.0
Notes: n/a
 */
public class Task1GreatestStorageSpace 
{

    public static void main(String[] args) 
    {
    
        //this declares the variables and the array
        int maxValue = 0;
        int arr[]={121,256,201,789,943,981,867,456,763,741};
        
        // the repitition for the 10 array values
        for(int a=0; a<arr.length; a++)
        {
            //if maxValue is less than the current array index.
            if(maxValue < arr[a])
            {
                //maxValue becomes equal to the value of the array index.
                maxValue = arr[a];
            } 
        }
        //prints out the value held in variable maxValue.
        System.out.println("The largest memory size is: "+maxValue+"MB");
    }
    
}
