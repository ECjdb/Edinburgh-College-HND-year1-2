package assessment.with.menu;

/**
 * @author Joel Degner-Budd
 * @author EC1524329
 * 6th of December 2017
 * version 1.0
 * Username Generator
 */

public class Stringmaker2 
{
    public Stringmaker2()
    //creates string object
    {
        System.out.println("Creating String Object");
    }
    
    public String getUserName(String firstName,String surName)
    //method to generate userName from strings firstName and surName 
    {
        String userName = "";
        userName = firstName.substring(0,1).concat(surName);
        //userName is generated  by taking the first name by joining or concatenating with the string surName
        
        return userName;
    } 

    public boolean validName(String nameStr)
    //method validName takes String "nameStr" and checks the conditions set to see if it is a valid string.
    {
        int limit1 = 65;   
        //ascii code for 'A'
        int limit2 = 90;   
        //ascii code for 'Z'
        int limit3 = 45;   
        //ascii code for '-'
        int limit4 = 32;   
        //ascii code for 'space' 
        String str2 = nameStr.toUpperCase();
       //string str2 equals nameStr.toUpperCase this takes the characters in str2 and assigns them uppercase ascii code number values.
        boolean valid = true;
        int previousNumber = 0; 
        //creates integer variable previousNumber with the value of (0)
        for(int k=0; k<str2.length(); k++)
        //for loop that continues until the value k is equal to the length of str2. 
        {
            char letter = str2.charAt(k);
            //The charAt() method returns the character at the specified index or position in a string. The index of the first character is 0, the second character is 1 ect.
            int number = (int)letter;
            // creates int "number" which is = to the int value of the char letter
            if(str2.length()< 2) 
            //string must be at least 2 characters long
            {
                return false;    
                // if string is too short returns false, loop starts again and will not proceed until condition is true. 
            }
            if (number == limit3 && previousNumber == limit3)
            //checks if character is a hyphen, and doesn't allow 2 hyphens in a row.
            {
                valid = false;
                break; 
            }
            if((number >=limit1 && number <=limit2) || number == limit3 && number != limit4)
            //if number is more than or equal to limit1 and less than or equal to limit2,or is limit3 and is not equal to limit4 then valid is true.   
            {                             
                valid = true;
                previousNumber = number; 
                //keeps track of number for next loop iteration, to check for 2 hypens in a row.
            }
            else 
            //no rules matched, so not a valid name
            {
                valid = false;
                break;
            }         
        }
        
    return valid;
   }   
 
}
