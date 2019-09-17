package elevatorlo2.pkg3;

//EC1524329
//Joel Degner-Budd
//27/03/2018

public class Door implements DoorInterface
{
    boolean closed;

    public Door()
    {
        //blank constructor
    }
    
    //opens the lift door
    @Override
    public void Open(boolean elevatorStopped) 
    {
        //if the elevator is stopped and the door is closed
        if(elevatorStopped == true && closed == true)
        {
            System.out.println("Opening elevator doors");
        }
    }
    
    //closes the lift door
    @Override
    public void Close(boolean elevatorStopped) 
    {
        //if the elevator has stopped and the doors are open
        if(elevatorStopped == true && closed == true)
        {
            System.out.println("Closing Elevator Doors");
        }
    }
    
    /*
    * Setters
    */
    
    public void setClosed(boolean closed) 
    {
        this.closed = closed;
    }
    
    
}
