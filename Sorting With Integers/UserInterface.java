package sortingassessment;

import java.util.ArrayList;
import java.util.Scanner;



public class UserInterface 
{
    //*****************************************************************
    //*                     Private Varibles                          *
    //***************************************************************** 

    private ReadFile rf = new ReadFile();
    private Scanner sc = new Scanner(System.in);
    private String input = "";
    private int[] array;
    private int[] searchArr = new int[50];
    
    //*****************************************************************
    //*                     Read UserInterface                        *
    //***************************************************************** 
    
    public void ReadInterface(boolean runStart)
    {        
      while(runStart == true)
      {
        System.out.println("Please select one of the following options:\n");
        System.out.println("Select '1' to read 'Data1Assess.txt'");
        System.out.println("Select '2' to read 'Data2Assess.txt'");
        System.out.println("Select '3' to Quit");
        input = sc.nextLine();
            
        switch(input)
        {
          case "1": //reads in first file
          {                   
            array = rf.getNumArr("Data1Assess.txt");
                   
            if(array.length <1) //if there is no data or damaged
            {
              System.out.println("\nProgramme cannot continue due to"
                  + " damaged data.");
              System.out.println("Please try again with a different"
                  + " data file.\n");
              break;
            }
            else //go to next part of User Interface.
            {
              SortingInterface(runStart,array);
              break;
            }
          }//end case '1' Read Interface
          
          case "2": //reads in second file
          {
            array = rf.getNumArr("Data2Assess.txt");
                   
            if(array.length<1) //if there is no data or damaged
            {
              System.out.println("\nProgramme cannot continue due to"
                  + " damaged data.");
              System.out.println("Please try again with a different"
                  + " data file.\n");
              break;
            }
            else //go to next part of User Interface.
            {
              SortingInterface(runStart,array);
              break;
            }   
          }//end case '2' ReadInterface
          
          case "3":
          {
            runStart = false;
            runStart = quitProgramme(runStart);
            break;
          }//end case '3' ReadInterface
          
          default: //prompts user with invalid message if entry is not valid
          {
            System.out.println("Invalid entry: please select a valid"
                + " entry when prompted");
          }//end default ReadInterface
        }//end Switch
      }//end While
    }//end ReadInterface *
    
    //*****************************************************************
    //*                     Sorting UserInterface                     *
    //***************************************************************** 
    
    public boolean SortingInterface(boolean runStart, int[] array)
    {
      while(runStart == true) //selects sort type
      {
        System.out.println("Please select one of the following options:\n");
        System.out.println("Select '1' for BubbleSort");
        System.out.println("Select '2' for MergeSort");
        System.out.println("Select '3' to check, find and write data");
        System.out.println("Select '4' to return to read files");
        input = sc.nextLine();
            
        switch(input)
        {
          case "1": //selects bubble sort ascending or descending
          {
            System.out.println("Please select BubbleSort Ascending"
                + " or Descending");
            System.out.println("Select '1' for Ascending");
            System.out.println("Select '2' for Descending");
            input = sc.nextLine();
                    
            if(input.equalsIgnoreCase("1")) //bubble sort ascending
            {
              BubbleSort.intAscendBubbleSort(array);
              
              System.out.println("Select Sorted array view: ");
              System.out.println("Select '1' for partial view");
              System.out.println("Select '2' for full view");
              
              input = sc.nextLine();
              if(input.equalsIgnoreCase("1"))//displays patial view
              {
                rf.displayPartialArr(array, "Partial: Bubble Ascending");
              }
              else if(input.equalsIgnoreCase("2"))//displays full view
              {
                rf.displayFullArr(array, "Full: Bubble Ascending");
              }
              else
              {
                System.out.println("Invalid entry: please select a valid"
                    + " entry when prompted");
              }
              break;
            }//end if '1' case '1'
            else if(input.equalsIgnoreCase("2"))//bubble sort descending
            {
              BubbleSort.intDescendBubbleSort(array);
              
              System.out.println("Select Sorted array view: ");
              System.out.println("Select '1' for partial view");
              System.out.println("Select '2' for full view");
              
              input = sc.nextLine();
              if(input.equalsIgnoreCase("1"))//displays partial view
              {
                rf.displayPartialArr(array, "Partial: Bubble Descending");
              }
              else if(input.equalsIgnoreCase("2"))//displays full view
              {
                rf.displayFullArr(array, "Full: Bubble Descending");
              }
              else
              {
                System.out.println("Invalid entry: please select a valid"
                    + " entry when prompted");
              }
              break;
            }//end outer if '2'           
            else //prompts user with invalid message if entry is not valid
            {
              System.out.println("Invalid entry: please select a valid"
                + " entry when prompted");
            }//end else
          }//end case 1 bubblesort of SortingInterface
          
          case "2"://selects mergesort ascending or descending
          {
            System.out.println("Please select MergeSort Ascending"
                + " or Descending");
            System.out.println("Select '1' for Ascending");
            System.out.println("Select '2' for Descending");
            input = sc.nextLine();
                    
            if(input.equalsIgnoreCase("1"))//merge sort ascending
            {
              MergeSort.MergeSortAscending(array);
              
              System.out.println("Select Sorted array view: ");
              System.out.println("Select '1' for partial view");
              System.out.println("Select '2' for full view");
              
              input = sc.nextLine();
              if(input.equalsIgnoreCase("1"))
              {
                rf.displayPartialArr(array, "Partial: Merge Ascending");
              }
              else if(input.equalsIgnoreCase("2"))
              {
                rf.displayFullArr(array, "Full: Merge Ascending");
              }
              else
              {
                System.out.println("Invalid entry: please select a valid"
                    + " entry when prompted");
              }
              break;
            }//end outer if '1' mergeAscend
            else if(input.equalsIgnoreCase("2"))//merge sort descending
            {
              MergeSort.MergeSortDescending(array);
              
              System.out.println("Select Sorted array view: ");
              System.out.println("Select '1' for partial view");
              System.out.println("Select '2' for full view");
              
              input = sc.nextLine();
              if(input.equalsIgnoreCase("1"))
              {
                rf.displayPartialArr(array, "Partial: Merge Descending");
              }
              else if(input.equalsIgnoreCase("2"))
              {
                rf.displayFullArr(array, "Full: Merge Descending");
              }
              else
              {
                System.out.println("Invalid entry: please select a valid"
                    + " entry when prompted");
              }
              break;
            }//end outer if '2' mergeDescend
            else //prompts user with invalid message if entry is not valid
            {
              System.out.println("Invalid entry: please select a valid"
                + " entry when prompted");
            }//end outer else mergeAscend
          }//end case '2' mergesort SortingInterface
          
          case "3": //moves to utility interface: data check, search, write
          {
            UtilityInterface(runStart);
            break;
          }//end case '3' SortingInterface
          
          case "4": //goes back to 'ReadInterface'
          {
            runStart = false;
            break;
          }//end case '4' SortingInterface
          
          default://prompts user with invalid message if entry is not valid
          {
            System.out.println("Invalid entry: please select a valid"
                + " entry when prompted");
          }//end default SortingInterface
        }//end Switch
      }//end While
        return runStart;
    }//end SortingInterface *
    
    //*****************************************************************
    //*               check , find , write UserInterface              *
    //***************************************************************** 
    
    public boolean UtilityInterface(boolean runStart)
    {
      while(runStart == true)
      {
        System.out.println("Please select one of the following options");
        System.out.println("Select '1' to check data is sorted");
        System.out.println("Select '2' to find a specific piece of data");
        System.out.println("Select '3' to write data to file");
        System.out.println("Select '4' to return to sorting");
          
        input = sc.nextLine();
          
        switch(input)
        {
            case"1": //checks data is sorted correctly
            {
              System.out.println("Select option to check how data is sorted");
              System.out.println("Select '1' check sorted ascending");
              System.out.println("Select '2' check sorted descending");
                
              input = sc.nextLine();
              //checks integer data ascending
              if(input.equalsIgnoreCase("1"))
              {
                SortCheck.ascendingArrChecker(array);
                break;
              }//end inner if '1' case'1'
              //checks integer data descending 
              else if(input.equalsIgnoreCase("2"))
              {
                SortCheck.descendingArrChecker(array);
                break;
              }//end inner if '2' case'1'
              else
              {
                System.out.println("Invalid entry: please select a valid"
                    + " entry when prompted");
              }//end else
              break;
            }//end case '1' datachecker UtilityInterface
            
            case"2": //finds specific item in sorted data
            {
              SearchFunction sf = new SearchFunction();
              int numFind = 0;
              int k = 0;
              boolean itemFinder = true;
              boolean found = false;
              while(itemFinder == true)
              {
                System.out.println("Please enter a number to find: ");
                if(sc.hasNextInt())
                {
                  numFind = sc.nextInt();
                  found = sf.SearchFunction(array, numFind);
                  if(found == true)
                  {
                    searchArr[k] = numFind;
                    k++;
                  }
                  itemFinder = false;
                  sc.nextLine();
                }
                else
                {
                  System.out.println("Invalid Entry: Please enter a number");
                  sc.nextLine();
                }
                
                while(itemFinder == false)
                {
                  System.out.println("Please Select an option to continue");
                  System.out.println("Select '1' to find another item");
                  System.out.println("Select '2' to write found items to file");
                  
                  input = sc.nextLine();
                  if(input.equalsIgnoreCase("1"))
                  {
                    itemFinder = true;
                  }
                  else if(input.equalsIgnoreCase("2"))
                  {
                    String name = "";
                    System.out.println("What would you like to name"
                        + " your file?");
                    name = sc.nextLine();
                    WriteFile.intWrite(searchArr, name);
                    break;
                  }
                  else
                  {
                    System.out.println("Invalid entry: please select a valid"
                    + " entry when prompted");
                  }
                }
                
              }
              //input = sc.nextLine();
              break;
            }//end case '2' search for data UtilityInterface

            case"3": // writes data to file
            {
              String name = "";
              System.out.println("What would you like to name"
                    + " your file?");
              name = sc.nextLine();
              WriteFile.intWrite(array, name);
              break;
            }// end case '3' write data to file UtilityInterface
            
            case"4": //
            {
              return true;
            }//end case '4' UtilityInterface
           
            default:
            {
              System.out.println("Invalid entry: please select a valid"
                + " entry when prompted");
            }//end default UtilityInterface
        }//end Switch
      }// end While
        
      return runStart;
    }//end UtilityInterface *
    
    //*****************************************************************
    //*                       Quit Programme                          *
    //***************************************************************** 
    
    public boolean quitProgramme(boolean runStart)
    {
        while(runStart == false)
        {
            System.out.println("are you sure you want to quit?");
            System.out.println("press 'y' to quit programme");
            System.out.println("press 'n' to return\n");
            input = sc.nextLine();
            if(input.equalsIgnoreCase("y"))//quits the programme
            {
              return false;
            }
            else if(input.equalsIgnoreCase("n"))//returns user to ReadInterface
            {
                System.out.println("Returning to User Interface\n\n");
                runStart = true;
            }
            else//invalid entry, must be 'y' or 'n'
            {
                System.out.println("An error has occured");
                System.out.println("Please make valid entry");
            }
        }//end While
        
        return runStart;
    }//end quitProgramme *
}//end UserInterface ** END of Class  