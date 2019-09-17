package sortingassessmentpart2;

import java.util.Comparator;
import java.util.Scanner;

//EC1524329
//Joel Degner-Budd
//11/12/2018

//*****************************************************************************
//                     User Interface Guide
//
// 1. The 'ReadInterface' reads in text files, the user selects
//    the file they want read in.
// 2. Once read in the user can then continue to read in files, exit
//    programme, or can choose to go to the next user interface to
//    sort data.
// 3. Once the user has selected to sort data the programme calls
//    the 'SortingInterface'.
// 4. From here the user can select the type of sort(bubble or merge)
//    , what to sort on(city name, population or pop growth), and 
//    whether it will be ascending or descending order.
// 5. The data can be sorted from this menu, the user can choose to
//    move on to the next part of the UI or go back to 'ReadInterface'.
// 6. When the user selectes the 'UtilityInterface' the user is given
//    3 options, they can check to see how the data is sorted and
//    what it was sorted on (city name, population or pop growth),
//    find information(city name, population or pop growth),
//    write data to file or return to the sorting interface.
// 7. To end the programme the user must return to the start of the
//    programme 'ReadInterface' and choose the 'Quit' option.
//    The user is then prompted with whether they really want to
//    quit, selecting 'y' will end the programme and 'n' will return
//    the user to the ReadInterface.
//              
//                          END OF GUIDE
//*****************************************************************************

public class UserInterface 
{
    //*****************************************************************
    //*                     Private Varibles                          *
    //***************************************************************** 
   
    private CityComparator nameComp = new CityComparator();
    private popComparator popComp = new popComparator();
    private growthComparator growComp = new growthComparator(); 
    private ReadFile rf = new ReadFile();
    private AmericanCities[] array;
    private Scanner sc = new Scanner(System.in);
    private String input = "";
    
    //*****************************************************************
    //*                     Read UserInterface                        *
    //***************************************************************** 
    
    public void ReadInterface(boolean runStart)
    {        
      while(runStart == true)
      {
        System.out.println("Please select one of the following options:\n");
        System.out.println("Select '1' to read 'AssessUsaCities1.txt'");
        System.out.println("Select '2' to read 'AssessUsaCities2.txt'");
        System.out.println("Select '3' to Quit");
        input = sc.nextLine();
            
        switch(input)
        {
          case "1": //reads in first file
          {                   
            array = rf.getArray("AssessUsaCities1.txt");
                   
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
            array = rf.getArray("AssessUsaCities2.txt");
                   
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
    
    public boolean SortingInterface(boolean runStart, Comparator[] array)
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
            System.out.println("Select '3' to go back");
            input = sc.nextLine();
                    
            if(input.equalsIgnoreCase("1")) //Selects what to sort on
            {
              System.out.println("What would you like to sort on?");
              System.out.println("Select '1' to sort by City name");
              System.out.println("Select '2' to sort by Population Growth");
              System.out.println("Select '3' to sort by Population");
                
              input = sc.nextLine();
              
              if(input.equalsIgnoreCase("1"))//sort city name ascending
              {
                BubbleSortComparator.BubbleSortAscending(array, nameComp);
                rf.displaySorted(array, "Bubble Ascend"); //displays array
                break;
              }//end inner if '1'
              else if(input.equalsIgnoreCase("2"))//sort pop growth ascending
              {
                BubbleSortComparator.BubbleSortAscending(array, growComp);
                rf.displaySorted(array, "Bubble Ascend"); //displays array
                break;
              }//end inner if '2'
              else if(input.equalsIgnoreCase("3"))//sort population ascending
              {
                BubbleSortComparator.BubbleSortAscending(array, popComp);
                rf.displaySorted(array, "Bubble Ascend"); //displays array
                break;
              }//end inner if '3'
              else
              {
                System.out.println("Invalid entry: please select a valid"
                + " entry when prompted");
              }
              
            }//end outer if '1'
            else if(input.equalsIgnoreCase("2")) //part of switch case '1'
            {
              System.out.println("What would you like to sort on?");
              System.out.println("Select '1' to sort by City name");
              System.out.println("Select '2' to sort by Population Growth");
              System.out.println("Select '3' to sort by Population");
                
              input = sc.nextLine();
              
              if(input.equalsIgnoreCase("1"))//sort city name descending
              {
                BubbleSortComparator.BubbleSortDescending(array, nameComp);
                rf.displaySorted(array, "Bubble Descend"); //displays array
                break;
              }//end inner if '1'
              
              else if(input.equalsIgnoreCase("2"))//sort pop growth descending
              {
                BubbleSortComparator.BubbleSortDescending(array, growComp);
                rf.displaySorted(array, "Bubble Descend"); //displays array
                break;
              }//end inner if '2'
              
              else if(input.equalsIgnoreCase("3"))//sort popualtion descending
              {
                BubbleSortComparator.BubbleSortDescending(array, popComp);
                rf.displaySorted(array, "Bubble Descend"); //displays array
                break;
              }//end inner if '3'
              
              else //prompts user with invalid message if entry is not valid
              {
                System.out.println("Invalid entry: please select a valid"
                + " entry when prompted");
              }//end inner else
              rf.displaySorted(array, "Bubble Descend"); //displays array
            }//end outer if '2'
            
            else if(input.equalsIgnoreCase("3"))//goes back to start of loop
            {
              break;
            }//end outer if '3'
            
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
            System.out.println("Select '3' to go back");
            input = sc.nextLine();
                    
            if(input.equalsIgnoreCase("1"))
            {
              System.out.println("What would you like to sort on?");
              System.out.println("Select '1' to sort by City name");
              System.out.println("Select '2' to sort by Population Growth");
              System.out.println("Select '3' to sort by Population");
                
              input = sc.nextLine();
              
              if(input.equalsIgnoreCase("1"))//sort city name ascending
              {
                MergeSortComparator.mergeSortAscending(array, nameComp);
                rf.displaySorted(array, "Merge Ascend"); //displays array
                break;
              }//end inner if '1' mergeAscend
              else if(input.equalsIgnoreCase("2"))//sort pop growth ascending
              {
                MergeSortComparator.mergeSortAscending(array, growComp);
                rf.displaySorted(array, "Merge Ascend"); //displays array
                break;
              }//end inner if '2' mergeAscend
              else if(input.equalsIgnoreCase("3"))//sort population ascending
              {
                MergeSortComparator.mergeSortAscending(array, popComp);
                rf.displaySorted(array, "Merge Ascend"); //displays array
                break;
              }//end inner if '3' mergeAscend
              else //prompts user with invalid message if entry is not valid
              {
                System.out.println("Invalid entry: please select a valid"
                + " entry when prompted");
              }
              
            }//end outer if '1' mergeAscend
            else if(input.equalsIgnoreCase("2")) //part of switch case '2'
            {
              System.out.println("What would you like to sort on?");
              System.out.println("Select '1' to sort by City name");
              System.out.println("Select '2' to sort by Population Growth");
              System.out.println("Select '3' to sort by Population");
                
              input = sc.nextLine();
              
              if(input.equalsIgnoreCase("1"))//sort city name descending
              {
                MergeSortComparator.mergeSortDescending(array, nameComp);
                rf.displaySorted(array, "Merge Descend"); //displays array
                break;
              }//end inner if '1' mergeDescend
              else if(input.equalsIgnoreCase("2"))//sort pop growth descending
              {
                MergeSortComparator.mergeSortDescending(array, growComp);
                rf.displaySorted(array, "Merge Descend"); //displays array
                break;
              }//end inner if '2' mergeDescend
              else if(input.equalsIgnoreCase("3"))//sort population descending
              {
                MergeSortComparator.mergeSortDescending(array, popComp);
                rf.displaySorted(array, "Merge Descend"); //displays array
                break;
              }//end inner if '3' mergeDescend
              else //prompts user with invalid message if entry is not valid
              {
                System.out.println("Invalid entry: please select a valid"
                + " entry when prompted");
              }
              
            }//end outer if '2' mergeDescend
            else if(input.equalsIgnoreCase("3"))
            {
              break;
            }//end outer if '3' mergeAscend
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
          
          case "4": //goes back to start of loop
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
              System.out.println("Select '1' check sorted by City name");
              System.out.println("Select '2' check sorted by Growth");
              System.out.println("Select '3' check sorted by Population");
                
              input = sc.nextLine();
              //checks city name sorted ascending and descending
              if(input.equalsIgnoreCase("1"))
              {
                SortChecker.AscendingChecker(array, nameComp);
                SortChecker.DescendingChecker(array, nameComp);
                break;
              }//end inner if '1' case'1'
              //checks pop growth sorted ascending and descending
              else if(input.equalsIgnoreCase("2"))
              {
                SortChecker.AscendingChecker(array, growComp);
                SortChecker.DescendingChecker(array, growComp);
                break;
              }//end inner if '2' case'1'
              //checks population sorted ascending and descending
              else if(input.equalsIgnoreCase("3"))
              {
                SortChecker.AscendingChecker(array, popComp);
                SortChecker.DescendingChecker(array, popComp);
                break;
              }//end inner if '3' case'1'
              else
              {
                System.out.println("Invalid entry: please select a valid"
                    + " entry when prompted");
              }//end else
              break;
            }//end case '1' datachecker UtilityInterface
            case"2": //finds specific item in sorted data
            {
              String itemFind = ""; 
              int numFind = 0;
              double doubFind = 0;
              SearchFunction sf = new SearchFunction();
              String str = "";
             
              System.out.println("Select '1' to find city name");
              System.out.println("Select '2' to find population");
              System.out.println("Select '3' to find growth");
              
              input = sc.nextLine();
              if(input.equalsIgnoreCase("1"))//searches for city name
              {
                System.out.println("What would you like to search for?");
                System.out.println("Example: City name - 'Yuma'");
                input = sc.nextLine();
                itemFind = input;
                str = sf.StringSearch(array,itemFind);
                  
                if(str.equalsIgnoreCase(""))
                {
                  System.out.println("Object not found");
                }
                else
                {
                  System.out.println("Writing search item to file");
                  System.out.println("What would you like to name"
                       + " your file?");
                  input = sc.nextLine();
                  WriteFile.comparatorWrite(input, str);
                }
                break;
              }//end inner case '1'
              else if(input.equalsIgnoreCase("2"))//searches for population
              {
                System.out.println("What would you like to search for?");
                System.out.println("Example: 8405837");
                if(sc.hasNextInt())
                {
                  numFind = sc.nextInt();
                  str = sf.PopSearch(array, numFind);
                  input = sc.nextLine();
                  
                  if(str.equalsIgnoreCase(""))
                  {
                      System.out.println("Object not found");
                  }
                  else
                  {
                      System.out.println("Writing search item to file");
                      System.out.println("What would you like to name"
                           + " your file?");
                      input = sc.nextLine();
                      WriteFile.comparatorWrite(input, str);
                      System.out.println("Press any key to continue");
                  }
                }
                else
                {
                  System.out.println("Invalid Entry: Please enter a number");
                }
                input = sc.nextLine();
                break;
              }//end inner case '2'
              else if(input.equalsIgnoreCase("3"))//searches for pop growth
              {
                System.out.println("What would you like to search for?");
                System.out.println("Example: 4.0");
                if(sc.hasNextDouble())
                {
                  doubFind = sc.nextDouble();
                  str = sf.PopGrowthSearch(array, doubFind);
                  
                  input = sc.nextLine();
                  
                  if(str.equalsIgnoreCase(""))
                  {
                      System.out.println("Object not found");
                  }
                  else
                  {
                      System.out.println("Writing search item to file");
                      System.out.println("What would you like to name"
                           + " your file?");
                      input = sc.nextLine();
                      WriteFile.comparatorWrite(input, str);
                      System.out.println("Press any key to continue");
                  }
                }//end inner if case '3'
                else
                {
                  System.out.println("Invalid Entry: Please enter a number");
                }//end inner else case '3'
                input = sc.nextLine();
                break;
              }//end inner case '3'
              else
              {
                System.out.println("Invalid entry: please select a valid"
                    + " entry when prompted");
              }//end else
              break;
            }//end case '2' search for data UtilityInterface
            
            case"3": // writes data to file
            {
              String name = "";
              System.out.println("What would you like to name"
                    + " your file?");
              name = sc.nextLine();
              WriteFile.comparatorWrite(array, name);
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