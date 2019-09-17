package AssessmentBinarySearch;

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
    private SortCheck sortChk = new SortCheck();
    private SearchFunction SF = new SearchFunction();
    private boolean dataSort;
    
    //*****************************************************************
    //*                     Read UserInterface                        *
    //***************************************************************** 
    
    public void ReadInterface(boolean runStart)
    {        
      while(runStart == true)
      {
        System.out.println("\nPlease select one of the following options:\n");
        System.out.println("Select '1' to read 'BinSearchOne.txt'");
        System.out.println("Select '2' to read 'BinSearchTwo.txt'");
        System.out.println("Select '3' to Quit");
        input = sc.nextLine();
            
        switch(input)
        {
          case "1": //reads in first file
          {                   
            array = rf.getNumArr("BinSearchOne.txt");
                   
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
              dataSort = sortChk.LinearArrChecker(array);
              
              if(dataSort == true)
              {
                System.out.println("\nLoading further options...\n");
                SortingInterface(runStart, array);
              }
              else
              {
                System.out.println("Data is not sorted");
                System.out.println("Please select one of the following "
                                                                + "options:\n");
                System.out.println("Select '1' to perform Linear Data Search");
                System.out.println("Select '2' to sort the data");
                System.out.println("Select '3' to go to back");
                
                input = sc.nextLine();

                if(input.equalsIgnoreCase("1"))
                {
                  SF.LinearSearchFunction(array, 0);
                  break;
                }
                else if(input.equalsIgnoreCase("2"))
                {
                  SortingInterface(runStart, array);
                }
                else if(input.equalsIgnoreCase("3"))
                {
                  break;
                }
                else
                {
                    System.out.println("\nAn error has occured: "
                                                        + "Invalid entry\n\n");
                }
                
              }
              //UtilityInterface(runStart);
              break;
            }
          }//end case '1' Read Interface
          
          case "2": //reads in second file
          {
            array = rf.getNumArr("BinSearchTwo.txt");
                   
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
              dataSort = sortChk.LinearArrChecker(array);
              
              if(dataSort == true)
              {
                System.out.println("\nLoading further options...\n");
                SortingInterface(runStart, array);
              }
              else
              {
                System.out.println("Data is not sorted");
                System.out.println("Please select one of the following "
                                                                + "options:\n");
                System.out.println("Select '1' to perform Linear Data Search");
                System.out.println("Select '2' to sort the data");
                System.out.println("Select '3' to go to back");
                
                input = sc.nextLine();

                if(input.equalsIgnoreCase("1"))
                {
                  LinearItemFinder();
                  break;
                }
                else if(input.equalsIgnoreCase("2"))
                {
                  SortingInterface(runStart, array);
                }
                else if(input.equalsIgnoreCase("3"))
                {
                  break;
                }
                else
                {
                    System.out.println("\nAn error has occured: "
                                                        + "Invalid entry\n\n");
                }
              }
            }
            
            break;
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
    
    private boolean SortingInterface(boolean runStart, int[] array)
    {
      while(runStart == true) //selects sort type
      {
        System.out.println("\nPlease select one of the following options:");
        System.out.println("Select '1' to sort data");
        System.out.println("Select '2' to check data sort");
        System.out.println("Select '3' to find data");
        System.out.println("Select '4' to return to previous Interface");
        input = sc.nextLine();
            
        switch(input)
        {
          case "1"://selects mergesort ascending
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
          }//end case '2' mergesort SortingInterface
          
          case "2": 
          {
            CheckInterface();
            break;
          }//end case '2' SortingInterface
          case"3":
          {
            System.out.println("Please select one of the following options: ");
            System.out.println("Select '1' for Linear Search");
            System.out.println("Select '2' for Binary Search");
            System.out.println("Select '3' to go back");
            
            input = sc.nextLine();
            
            if(input.equalsIgnoreCase("1"))
            {
              LinearItemFinder();
            }
            else if(input.equalsIgnoreCase("2"))
            {
              BinaryItemFinder();
            }
            else if(input.equalsIgnoreCase("3"))
            {
              break;
            }
            else
            {
              System.out.println("Invalid entry: please select a valid"
                + " entry when prompted");
            }
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
    //*                         Data Checker                          *
    //***************************************************************** 
    private void CheckInterface()
    {
      sortChk.LinearArrChecker(array);
    }
   
    //*****************************************************************
    //*                        Linear Item Finder                     *
    //***************************************************************** 
    private void LinearItemFinder()
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
          found = sf.LinearSearchFunction(array, numFind);
          
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
          System.out.println("Select '2' to return to menu");
                  
          input = sc.nextLine();
          if(input.equalsIgnoreCase("1"))
          {
            itemFinder = true;
          }
          else if(input.equalsIgnoreCase("2"))
          {
            break;
          }
          else
          {
            System.out.println("Invalid entry: please select a valid"
                + " entry when prompted");
          }
        }//end inner while
      }//end outer while
    }
    
    //*****************************************************************
    //*                        Binary Item Finder                     *
    //***************************************************************** 
    
    private void BinaryItemFinder()
    {
      int result;
      int searchValue = 0;
      
      boolean itemFinder = true;

      while(itemFinder == true)
      {
        System.out.println("Please enter a number to find: ");
        
        if(sc.hasNextInt())
        {
          searchValue = sc.nextInt();
          result = SF.BinarySearchFunction(array,searchValue);
          
          if(result < 0)
          {
            System.out.println("Sorry "+searchValue +" was not found"); 
            itemFinder = false;
            input = sc.nextLine();
          }
          else
          {
            System.out.println(searchValue + " found at position "+result);
            itemFinder = false;
            input = sc.nextLine();
          }
        }
        else
        {
          System.out.println("Invalid Entry: Please enter a number");
          sc.nextLine();
        }
        while(itemFinder == false)
        {
          System.out.println("\nPlease Select an option to continue");
          System.out.println("Select '1' to find another item");
          System.out.println("Select '2' to return to menu");
                  
          input = sc.nextLine();
          if(input.equalsIgnoreCase("1"))
          {
            itemFinder = true;
          }
          else if(input.equalsIgnoreCase("2"))
          {
            break;
          }
          else
          {
            System.out.println("Invalid entry: please select a valid"
                + " entry when prompted");
          }
        }//end inner while
      }//end outer while 
    }//end BinaryItemFinder ** END OF CLASS

    //*****************************************************************
    //*                       Quit Programme                          *
    //***************************************************************** 
    
    private boolean quitProgramme(boolean runStart)
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