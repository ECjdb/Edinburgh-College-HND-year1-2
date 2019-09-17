package elevatorlo2.pkg3;

//EC1524329
//Joel Degner-Budd
//27/03/2018

public class Elevator implements ElevatorInterface 
{
    boolean direction;
    int currentFloor;
    boolean idle;
    
    public Elevator()
    {
        //blank constructor
    }
    
    //elevator movement
    @Override
    public int Move(int passengerFloor) 
    {
        //if direction is equal to false, the elevator is moving down
        if(direction == false)
        {
            for(int i = currentFloor; i >= passengerFloor;i--)
            {
                currentFloor = i;
                System.out.println("Elevator is on floor:"+currentFloor);
            }
        }
        //if direction is equal to true, the elevator is moving up
        else
        {
            for(int i = currentFloor; i <= passengerFloor;i++)
            {
                currentFloor = i;
                System.out.println("Elevator is on floor:"+currentFloor);
            }
        }
        
        //if the lift as at the same floor as the passenger
        if(currentFloor == passengerFloor)
        {
            //stop the lift
            Stop();
        }
        
        return currentFloor;
    }

    //stops lift and updates lift status
    @Override
    public void Stop() 
    {
        idle = true;
        System.out.println("Elevator has arrived");
    }
    
    //checks lift status/ busy or idle
    @Override
    public void ChangeStatus(boolean lightOn) 
    {
        //if the light is on then the lift is busy
        if(lightOn == true)
        {
            idle = false;
            System.out.println("Elevator is now busy");
        }
        //if the light is off the lift is idle
        else
        {
            idle = true;
            System.out.println("Elevator is currently idle");
        }
    }
    
    /*
    * Setters
    */
    
    public void setDirection(boolean direction) 
    {
        this.direction = direction;
    }

    public void setCurrentFloor(int currentFloor) 
    {
        this.currentFloor = currentFloor;
    }

    public void setIdle(boolean idle) 
    {
        this.idle = idle;
    }
    
    
}