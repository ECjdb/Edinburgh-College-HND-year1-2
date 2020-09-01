package task3.create.user.name;
import java.util.Scanner;

/**
Name: Joel Degner-Budd
Location: Sighthill - Edinburgh college
Date: 23rd February, 2018
Version: 1.0
Notes: n/a
 */
public class Task3CreateUserName 
{

    public static void main(String[] args) 
    {
        Scanner userInput = new Scanner(System.in);
        String firstInitial[] = new String[20];
        String secondName[] = new String[20];
        String firstName;
        String lastName;
        boolean nameGen = true;
        
        while(nameGen == true)
        {
            firstName = userInput.next();
            firstInitial[0] = firstName;
            
            for(int a=0;a<firstInitial.length;a++)
            {
            
            }
            
            lastName = userInput.next();
            secondName[0] = lastName;
            
            for(int b=0;b<secondName.length;b++)
            {
            
            }
            
            System.out.println();
        }
    }
    
}
