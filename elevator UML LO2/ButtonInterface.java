package elevatorlo2.pkg3;

//EC1524329
//Joel Degner-Budd
//27/03/2018

public abstract class ButtonInterface 
{    
    boolean lightOn = false;
    boolean buttonPushed = false;
    
    public abstract boolean SwitchTheLight(int passengerFloor);
}//end ButtonInterface