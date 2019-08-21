package projectholidays;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

//EC1524329
//Joel Degner-Budd
//27/03/2018

public class ProjectHolidays extends javax.swing.JFrame
{

    public static void main(String[] args) 
    {   
        Scanner sc  = new Scanner(System.in);
        String input = "";
        boolean runStart = true;
        HolidayPlanner hp = new HolidayPlanner();
        ArrayList holArrayList = new ArrayList();
        ReadFile rf = new ReadFile();
        Menu menu = new Menu();
        
        int uniqueId = 1;
            
        System.out.println("Welcome to Holiday Planner programme");
        while(runStart == true)
        {
            System.out.println("\nPlease select one of the following options:\n");
            System.out.println("Select '1' to add a new employee holiday record");
            System.out.println("Select '2' to make holiday request");
            System.out.println("Select '3' to load Holiday Planner");
            System.out.println("Select '4' to save Holiday Planner");
            System.out.println("Select '5' to clear Holiday Planner");
            System.out.println("Select '6' to end programme");
            
            input = sc.nextLine();
            
            if(input.equals("1"))
            {
                boolean createEmployee = true;
                
                while(createEmployee == true)
                {
                    System.out.println("\nPlease select one of the following "
                            + "options:\n");
                    System.out.println("Select '1' to add a new employee "
                            + "holiday record");
                    System.out.println("Select '2' to cancel and return to "
                            + "previous options");
                    
                    input = sc.nextLine();
                    if(input.equals("1"))
                    {
                        HolidayRecord holRecEntry = new HolidayRecord(uniqueId,28,0);
                        holArrayList.add(holRecEntry);
                        uniqueId++;
                        hp.setHolPlanner(holArrayList);
                        System.out.println("arraylist"+hp.getHolRecord());
                    }
                    else if(input.equals("2"))
                    {
                        PopUp.main(args);
                        try 
                        {
                            TimeUnit.SECONDS.sleep(1);
                            createEmployee = false;
                        } 
                        catch(InterruptedException ex) 
                        {
                            Logger.getLogger(ProjectHolidays.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else
                    {
                        System.out.println("An error has occured: "
                        + "please enter a valid option.");
                    }
                    
                    hp.setHolPlan(hp);
                }
            }
            else if(input.equals("2"))
            {
                boolean found = false;
                HolidayRecord tempHol = new HolidayRecord();
                System.out.println("Please enter employee id number");
                input = sc.nextLine();
                
                for(HolidayRecord holRec : hp.getHolRecord())
                {
                    if(holRec.getEmployeeId() == Integer.parseInt(input))
                    {
                        tempHol = holRec;
                        found = true;
                        break;
                    }
                    else
                    {
                        found = false;
                    }
                }
                
                if(found == false)
                {
                    System.out.println("employee cannot be found");
                }
                else if(found == true)
                {
                    int tempAllowance = tempHol.getAllowance();
                    System.out.println("Please enter requested amount of days");
                    input = sc.nextLine();
                
                    if(tempAllowance >= 0)
                    {
                        if(Integer.parseInt(input) > tempAllowance)
                        {
                            System.out.println("sorry, number of days requested is "
                                + "greater than days remaining");
                        }
                        else
                        {
                            tempAllowance = tempAllowance - Integer.parseInt(input);
                            tempHol.setAllowance(tempAllowance);
                            tempHol.setCount(Integer.parseInt(input));
                            System.out.println("You have requested: "+input+" days");
                            System.out.println("You have "+tempHol.getAllowance()
                                +" days remaining");
                            JOptionPane.showMessageDialog(menu, "Success");
                        }
                    }
                }
            }
            else if(input.equals("3"))
            {
                hp.setHolPlanner(holArrayList=rf.RF());
            }
            else if(input.equals("4"))
            {
                menu.setArrayList(hp.getHolRecord());
                menu.setVisible(true);
                hp.setHolPlanner(menu.getTestList());
                //Menu.main(args);
            }
            else if(input.equals("5"))
            {
                System.out.println("Clearing Holiday Planner!");
                ResetHolidays.main(args);
                hp.getHolRecord().clear();
                System.out.println("Holiday Planner contents:"+hp.getHolRecord()+"\n");
                for(int i = 0; i<holArrayList.size();i++)
                {
                    System.out.println(holArrayList.get(i));
                }
            }
            else if(input.equals("6"))
            {
                System.out.println("\nEnd of Programme: Goodbye\n");
                runStart = false;
                break;
            }
            else
            {
                System.out.println("An error has occured: "
                        + "please enter a valid option.");
            }
            
        }
        
    }
}//end Main