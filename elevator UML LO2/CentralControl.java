package elevatorlo2.pkg3;

import java.util.Scanner;

//EC1524329
//Joel Degner-Budd
//27/03/2018

public class CentralControl implements CentralControlSystemInterface
{
    boolean selectedDirection;
    int currentFloor = 5;

    public CentralControl()
    {
        //blank constructor
    }
    
    @Override
    public boolean SelectDirection(int selectDir) 
    {
        //if the the int selectDir direction is less than
        //the currentFloor the lift was called from
        if(selectDir < currentFloor)
        {
            //move the lift down
            selectedDirection = false;
        }
        //else if the int selectDir is greater than
        //the currentFloor the lift was called from
        else if(selectDir > currentFloor)
        {
            //move the lift up
            selectedDirection = true;
        }
        
        if(selectedDirection == false)
        {
            System.out.println("System Call: move elevator down");
        }
        else if(selectedDirection == true)
        {
            System.out.println("System Call: move elevator up");
        }
        
        return selectedDirection;
    }

    @Override
    public void ControlCurrentFloor(boolean lightOn, int passengerFloor) 
    { 
        Elevator elevator = new Elevator();
        Door door = new Door();
        ExternalButton exButton = new ExternalButton();
        InternalButton inButton = new InternalButton();
        
        //if the button has been pressed
        if(lightOn == true)
        {
            //if the passenger floor is less than the lifts current floor
            if(passengerFloor < currentFloor)
            {
                System.out.println("Elevator is on upper level, floor:"
                        + "" +currentFloor);
                //set doors to close
                door.setClosed(true);
                //turn on the light
                door.Close(lightOn);
                //update status
                elevator.ChangeStatus(lightOn);
                //find direction for lift to move
                SelectDirection(passengerFloor);
                //sets the values for the lifts location and direction
                elevator.setCurrentFloor(currentFloor);
                elevator.setDirection(selectedDirection);
                //sets current floor to be equal to the passenger floor
                currentFloor = elevator.Move(passengerFloor);
                //door opens
                door.Open(lightOn);
                //set external button values to off
                exButton.setButtonPushed(false);
                exButton.setLightOn(false);
                //update light status 'off'
                lightOn = exButton.SwitchTheLight(passengerFloor);
                //check lift status
                elevator.ChangeStatus(lightOn);
            }
            //if the passenger floor is greater than the lifts current floor
            else
            {
                //same as above
                System.out.println("Elevator is on lower level, floor:"
                        + "" +currentFloor);
                SelectDirection(passengerFloor);
                door.setClosed(true);
                door.Close(lightOn);
                elevator.ChangeStatus(lightOn);
                SelectDirection(passengerFloor);
                elevator.setCurrentFloor(currentFloor);
                elevator.setDirection(selectedDirection);
                currentFloor = elevator.Move(passengerFloor);
                door.Open(lightOn);
                exButton.setButtonPushed(false);
                exButton.setLightOn(false);
                lightOn = exButton.SwitchTheLight(passengerFloor);
                elevator.ChangeStatus(lightOn);
            }
        }
        
        //once lift arrives, passenger enters
        //light is off, passenger and lift are on the same floor
        if(lightOn == false && passengerFloor == currentFloor)
        {
            selectedDirection = false;
            
            //if the passenger has not chosen a direction
            while(selectedDirection == false)
            {
                int input;
                //allows floor selection for passenger
                input = inButton.SelectFloor();
                
                //sets light and button pressed to true
                inButton.setLightOn(true);
                inButton.setButtonPushed(true);
                //light is now on
                lightOn = inButton.SwitchTheLight(input);
                //checks lift status
                elevator.ChangeStatus(lightOn);
                System.out.println("Moving to floor: "+input);
                //close the door
                door.Close(lightOn);
                //finds if the lift is to move up or down
                selectedDirection = SelectDirection(input);
                //sets the elevators direction
                elevator.setDirection(selectedDirection);
                //sets the current floor to the elevators current position
                currentFloor = elevator.Move(input);
                //passenger floor is the same as the lift/arrived at floor
                passengerFloor = currentFloor;
                //open door
                door.Open(lightOn);
                //set light values off
                inButton.setButtonPushed(false);
                inButton.setLightOn(false);
                //check light status
                lightOn = inButton.SwitchTheLight(passengerFloor);
                //check lift status
                elevator.ChangeStatus(lightOn);
                //resets lift
                selectedDirection = true;
            }//end while
        }//end if
    }//end ControlCurrentFloor
}//end Class Central Control