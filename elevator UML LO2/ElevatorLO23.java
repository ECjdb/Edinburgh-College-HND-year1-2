package elevatorlo2.pkg3;

import java.util.Scanner;

//EC1524329
//Joel Degner-Budd
//27/03/2018

public class ElevatorLO23 
{
    public static void main(String[] args) 
    {
        
        /*
         * Keeps programme running and makes initial external lift call
         */
        
        ExternalButton exButton = new ExternalButton();
        Elevator elevator = new Elevator();
        
        boolean runStart = true;
        boolean lightOn;
        Scanner sc = new Scanner(System.in);
        String input = "";
        int passengerFloor = 3;
        
        while(runStart == true)
        {
            System.out.println("\n\nPlease Select One of the "
                                                       + "Following Options: ");
            System.out.println("Select '1' to call elevator");
            System.out.println("Select '2' to exit programme");
            
            input = sc.nextLine();
            
            if(input.equals("1"))
            {
                exButton.setButtonPushed(true);
                exButton.setLightOn(true);
                lightOn = exButton.SwitchTheLight(passengerFloor); 
            }     
            else if(input.equals("2"))
            {
                runStart = false;
            }
            else
            {
                System.out.println("An error has occured, please try again");
            }
        }
        
        System.out.println("\nEnding programme - Goodbye!\n");
        
    }//end of Main
}//end of ElevatorLO2+3
