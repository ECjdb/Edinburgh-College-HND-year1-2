package assessment.with.menu;

/**
 * @author Joel Degner-Budd
 * @author EC1524329
 * 6th of December 2017
 * version 1.0
 * Factorial calculator
 */

public class Factorial2 
{
 public Factorial2()
    {
     System.out.println("Creating Factorial Object");
    }
 
    public boolean validNumber(String valNumb)
    {
        String fct2 = valNumb.toUpperCase();
        //string fct2 equals valNumb.toUpperCase this takes the characters in fct2 and assigns them uppercase ascii code number values.
        int Numb1 = 48;
        //creates int Numb1 with a value of 48 ascii code for '0'.
        int Numb2 = 57;
        //creates int Numb2 with a value of 48 ascii code for '9'.
        for(int k=0; k<fct2.length(); k++)
        //loop through each character in the string, and check if it is between 0-9 (ie, a valid number)
        {
            char letter = fct2.charAt(k);
            //The charAt() method returns the character at the specified index or position in a string. The index of the first character is 0, the second character is 1 ect.
            int number = (int)letter;
            // creates int "number" which is equal to the int value of the char letter.
            if(number < Numb1 || number > Numb2)
            //if the int number is less than the ascii code value of Numb1 or more than the ascii code value of Numb2, value is false.     
            {
                return false; 
                //this character is not a valid number
            }

        }
        
        int userInput = Integer.parseInt(valNumb);
        //now that we know the string represents a valid number, we can convert it to an integer
        
        if (userInput < 0 || userInput > 20)
        // if iserInput is less and 0 or is more than 20 returns false.
        {
            return false;
        }
        return true;
        //we know at this point that all checks passed, so return true
    }

    public long getFactorial(int number)
    {
     long answer = 1; // stores a 64 bit number
    
    // the for loop takes integer input by user and mulitiplies it by k until k reaches the same value as the integer that was input by the user,
    // if the user put 5 in as an integer the loop will continue until k reaches the value of 5 and then stops.
    
        for(int k=1; k<=number; k++) 
        // k is the value of (1), while k is less than or equal to the number input by the user add (1) to the value of k.
        {
            answer = answer * k;     
            // answer is a variable held in memory, its value is currently (1), answer is multiplied by the value of k
            // which is (1), answers value becomes (1), k is incremented by (1) and is now (2), on second
            // passing answer(1) will be multiplied by k(2), answers value becomes (2), k is incremented by (1) becoming (3) ect.
        }
       return answer; 
       // returns answers value when the loop ends.
    }
    
    public String displayFactorial(int number)
    //Method used to display the answer from the getFactorial method        
    {
     String str = "";
        
        for (int f = number; f>=1; f--)
        //for loop takes variable the "number" input from the user and subtracts 1 if, it is more than or equal to the value of 1.    
        {
            if(f!=1)
            //if f is not equal to 1 prints str + 'f'+" * " for display purposes.    
            {
                str= str + f + " * ";
            }
            else
            //if f is equal to 1 then str+f+" = " is printed instead.    
            {
                str= str + f + " = ";
            }
        }
    str = str + this.getFactorial(number);
    return str;
    //returns the string str and the above print outs, str string is number.
    } 
  
}
