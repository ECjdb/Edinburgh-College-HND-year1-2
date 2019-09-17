package elevatorlo2.pkg3;

//EC1524329
//Joel Degner-Budd
//27/03/2018

public interface CentralControlSystemInterface 
{
    public boolean SelectDirection(int selectDir);
    public void ControlCurrentFloor(boolean lightOn, int passengerFloor);
}//end CentralControlSystemInterface 
