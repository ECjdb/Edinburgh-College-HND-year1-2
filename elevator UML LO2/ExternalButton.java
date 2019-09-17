package elevatorlo2.pkg3;

//EC1524329
//Joel Degner-Budd
//27/03/2018

public class ExternalButton extends ButtonInterface
{
    private boolean lightOn;
    private boolean buttonPushed;
    
    public ExternalButton()
    {
        //blank constructor
    }

    //switches the external light on or off
    @Override
    public boolean SwitchTheLight(int passengerFloor) 
    {
        //creates central control as external button has been pressed
        CentralControl ctrlControl = new CentralControl();
        //If the button has been pressed
        if(lightOn == true && buttonPushed == true)
        {
            System.out.println("\nThe button has been pressed, the light is on");
            System.out.println("Elevator Call made for floor: "+passengerFloor);
            //call central control and pass the lightOn and passenger floor
            ctrlControl.ControlCurrentFloor(lightOn, passengerFloor);
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
