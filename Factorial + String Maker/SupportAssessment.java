package supportassessment;

import java.util.Scanner;



public class SupportAssessment 
{

    public static void main(String[] args) 
    {
      Scanner sc = new Scanner(System.in);
      String person;
      String numberStr = "";
      String numberStr2 = "";
      
      System.out.println("\n\n*******  menu  *******\n");
      System.out.println("Option 1 : Username \n");
      System.out.println("Option 2 : Factorial \n");
      System.out.println("Option 3 : Quit \n");
      System.out.println("*******  menu  *******\n");
      System.out.print("Please enter a number between 1 and 3 ");
      numberStr = sc.nextLine();
      
      while(!numberStr.equals("3") )
      {
        if(numberStr.equals("1"))
         {
           System.out.println("Run user name option"); 
           System.out.println("Please your name"); 
           person=sc.nextLine();
           StringMaker sm = new StringMaker();
           
           if(sm.validName(person) && sm.onespace(person))
            { 
              System.out.println("You user name is ");
              System.out.println(sm.getUserName(person));
            }
           else
            {
              System.out.println(person+" can not be converted to a user name"); 
            }
             
         }
        
        if(numberStr.equals("2"))
         {
           System.out.println("Run Factoral option"); 
           Factorial ft = new Factorial();
           
           int number = 1;
           System.out.println("Please enter a number ");
           numberStr2 = sc.nextLine();
           number=ft.CheckNumber(numberStr2);
           if(number==-1)
            {
             System.out.println("error not a number");   
            }
           else
           {
             System.out.println(ft.displayFactorial(number)); 
           }
         }
        
 
        System.out.println("\n\n*******  menu  *******\n");
        System.out.println("Option 1 : Username \n");
        System.out.println("Option 2 : Factorial \n");
        System.out.println("Option 3 : Quit \n");
        System.out.println("*******  menu  *******\n");
        System.out.print("Please enter a number between 1 and 3 ");
        numberStr = sc.nextLine();  
        
        
      }//end while
    
      
        System.out.println("\n\n ------ Goodbye !! ------\n\n");
      
    }
    
}
