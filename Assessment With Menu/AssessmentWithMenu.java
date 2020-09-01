package assessment.with.menu;

import java.util.Scanner; 
//imported utility java scanner, holds user input in memory and applies entered variable in methods when applicable.

/**
 * @author Joel Degner-Budd
 * @author EC1524329
 * 6th of December 2017
 * version 1.0
 * Menu program
 */

public class AssessmentWithMenu 
{

    public static void main(String[] args) 
    {
        
        Scanner sc = new Scanner(System.in);
        //creates new scanner variable called sc.
        String NumberStr2 = ""; 
        //creates string variable NumberStr2, string is empty.
        int number2 = 1; 
        //creates variable number 2 as an integer with the value of (1).
     
    
        System.out.println("\n\n*******  menu  *******\n");
        System.out.println("Option 1 : Username \n");
        System.out.println("Option 2 : Factorial Calculator \n");
        System.out.println("Option 3 : Quit \n");
        System.out.println("***********  menu  ***********\n");
        System.out.print("Please pick a number between 1 and 3 ");
        NumberStr2 = sc.nextLine();
        //prints menu.

        while(!NumberStr2.equals("3"))
        //program runs until until 3 has been entered to terminate it.
        {

            if(NumberStr2.equals("1"))
            //Enters Username program.
            {
                boolean valid = false;
                Stringmaker2 sm = new Stringmaker2();
                String userName;
                String firstName = "";
                String surName = "";
        
                while(valid == false)
                { 
                    System.out.println("Please Enter First Name ");
                    firstName = sc.nextLine();
                    //firstName is user input.
                    valid = sm.validName(firstName);
                    //takes firstName string input and runs it through the ValidName method using boolean valid to see if it is a valid string.
                    
                    if(valid == false)
                    {
                        System.out.println("Sorry invalid name try again");
                        //result if firsName string does not meet conditions.
                    }

                }
                
                valid = false; 
                //resets variable valid to false.
                
                while(valid == false)
                { 
                    System.out.println("Please Enter Surname ");
                    surName = sc.nextLine();
                    //surName is user input.
                    valid = sm.validName(surName);
                    //takes surName string input and runs it through the ValidName method using boolean valid to see if it is a valid string.
      
                    if(valid == false)
                    {
                        System.out.println("Sorry invalid name try again");
                        //result if surName string does not meet conditions.
                    }
                }
                  
                userName = sm.getUserName(firstName, surName);
                //calls getUserName method to generate username from valid firstName string and valid surName string.
                System.out.println("Your user name is "+userName);
                //prints out userName from getUserName method.
                
            }    
         
            else if(NumberStr2.equals("2"))
            //enters factorial program.
            {   
                boolean isNumb =false;
                Factorial2 fc =new Factorial2();
                String valNumb ="";
                int factorial = 1;
                int userInput;
                
                while(isNumb == false)
                {
                    System.out.println("Please enter a number between 1-20 ");
                    valNumb = sc.nextLine();
                    //valNumb is user input.
                    isNumb = fc.validNumber(valNumb);
                    //takes valNumb, calls validNumber method using boolean isNumb to check if valNumb is a valid number.
                    if(isNumb == false)
                    {
                        System.out.println("Invalid entry, please try again"); 
                        //result if valNumb string does not meet conditions. 
                    }  
                }    
                userInput = Integer.parseInt(valNumb);
                //integer userInput is equal to the integer converted string method "valNumb"
                System.out.println(fc.displayFactorial(userInput)); 
                //the userInput is passed into displayFactorial and the answer is printed on screen.
            }
        
            else if(NumberStr2.equals("3"))
            {
                System.out.println("Ending program");
            }
            else
            {
                System.out.println("");
                System.out.println("**************************************");
                System.out.println("");
                System.out.println("Invalid entry please try again");
                System.out.println("");
                System.out.println("**************************************");
            }
            
            System.out.println("\n\n*******  menu  *******\n");
            System.out.println("Option 1 : Username \n");
            System.out.println("Option 2 : Factorial Calculator \n");
            System.out.println("Option 3 : Quit \n");
            System.out.println("***********  menu  ***********\n");
            System.out.print("Please pick a number between 1 and 3 ");

            NumberStr2 = sc.nextLine();
        }
        System.out.println("\n\n ----- Goodbye !! ------\n\n");
        
    }
    
}

//end of program.
