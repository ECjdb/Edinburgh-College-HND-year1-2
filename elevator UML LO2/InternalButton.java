package elevatorlo2.pkg3;

import java.util.Scanner;

//EC1524329
//Joel Degner-Budd
//27/03/2018

public class InternalButton extends ButtonInterface
{
    private boolean lightOn;
    private boolean buttonPushed;
    
    public InternalButton()
    {
        //blank constructor
    }
    //Passenger floor selection
    public int SelectFloor()
    {
        Scanner sc  = new Scanner(System.in);
        int input = 0;
        boolean valFloor = false;
        
        //while a valid floor choice 1,2,3,4,5 has not been selected
        while(valFloor == false)
        {
            System.out.println("\nPlease Select floor destination");
            System.out.println("1,2,3,4,5");
            
            input = sc.nextInt();
            //if the input is not between 1 and 5
            if(input < 1 || input > 5)
            {
                System.out.println("Invalid entry: please select a valid floor");
            }
            //else the value entered is valid
            else
            {
                System.out.println("You have selected floor "+input);
                valFloor = true;
            }
        }
        
        return input;
    }
    
    //switches the external light on or off
    @Override
    public boolean SwitchTheLight(int passengerFloor) 
    {
        //If the internal button has been pressed
        if(lightOn == true && buttonPushed == true)
        {
            System.out.println("\nThe button has been pressed, the light is on"
                    + " moving to floor "+passengerFloor);
        }
        else
        {
            System.out.println("The light is now off");
        }
        
        return lightOn;
    }

    /*
    * Setters
    */
    
    public void setLightOn(boolean lightOn) 
    {
        this.lightOn = lightOn;
    }

    public void setButtonPushed(boolean buttonPushed) 
    {
        this.buttonPushed = buttonPushed;
    }

}
