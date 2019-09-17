package elevatorlo2.pkg3;

//EC1524329
//Joel Degner-Budd
//27/03/2018

public interface ElevatorInterface 
{
    public int Move(int passengerFloor);
    public void Stop();
    public void ChangeStatus(boolean lightOn);
}
