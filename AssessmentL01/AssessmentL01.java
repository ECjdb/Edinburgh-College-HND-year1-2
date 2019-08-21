package assessmentl01;

//Joel Degner-Budd
//EC1524329
//10/10/2018
//Data Structures Assessment: Prep

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
public class AssessmentL01 {

    public static void main(String[] args) 
    {
       
        
        File myFile = new File("StackandQueueData.txt"); //creates File
        //creates an array for container objects called contItem that
        //holds 20 container objects
        container[] contItem = new container[20]; 

        /***************************************
         *                                     *
         *       Read .txt file and adding     *
         *      container objects to array     *
         *                                     *
         *                                     *
         ***************************************/
        try
        {
            FileReader fr = new FileReader(myFile); //creates file reader
            BufferedReader br = new BufferedReader(fr); //creates buffer
            
            String data ="";
            int index=0;

            System.out.println("Counting containers...");
            //while data is not empty do this loop
            while( (data = br.readLine()) != null )
            {
                //loop - creates 16 container objects
                
                //declares string tokenizer
                StringTokenizer st = new StringTokenizer(data,",");
                
                //while the tokenizer 'st' has got tokens do this loop
                while(st.hasMoreTokens())
                {
                    //creates a container object while there are tokens
                    contItem[index] = new container();
                    
                    contItem[index].setContID(st.nextToken());
                    contItem[index].setProduce(st.nextToken());
                    contItem[index].setQty(Integer.parseInt(st.nextToken()));
                    contItem[index].setDate(st.nextToken());
                    index++;
                } //end while tokens loop
            }//end while readLine loop
            br.close();//closes buffered reader
        }
        //catches any potential program errors
        catch(IOException e)
        {
            System.out.println("\nAn Error has occured!");
        }
        //if the van excedes more containers than it can hold
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("\nThe Van can only hold "+contItem.length+" containers");
        }
        //if there is any corrupt data in a .txt file the try catch will stop
        //creating objects
        catch(NumberFormatException e)
        {
            System.out.println("\nError: This file contains errors!");
        }

        /***************************************
         *                                     *
         *                Stack                *
         *                                     *
         ***************************************/
        
        //creates Stack called stVan
        Stack<container>stVan = new Stack<>(); 
        //creates backup stack called stVanBackup
        Stack<container>stVanBackup= new Stack<>();
        
        //containerCounter keeps track of how many containers there are
        int containerCounter = 0;

        //loop-adds a carList[object] to stack
        for(int m=0; m < contItem.length; m++)
        {
            containerCounter++;
            //checks to see if the van is empty and the element is not null
            if(m == 0 && contItem[m] !=null)
            {
                System.out.println("\nThe Van is currently empty...");
                System.out.println("It contains: "+m+" containers");
                System.out.println("Loading Van...");
            }
            //if the element is null in the contItem array is null(empty)   
            if(contItem[m] == null)
            {    
                //and m's current counter value is less than 12
                if(m < 12)
                {   
                    //there are not enough containers and the van cannot leave
                    System.out.println("There are not enough containers"+
                        " for the van to leave");
                    System.out.println("There is: "+(m)+" containers");
                    containerCounter--; //offsets counter to avoid empty element errors
                    break; // ends loop
                }
                //there are enough packages but the van is not full
                if(m >= 12 && m <= 16)
                {
                    System.out.println("The Van is not full but has"
                            + " enough containers to leave");
                    System.out.println("There is: "+(m)+" containers");
                    containerCounter--; //offsets counter to avoid empty element errors
                    break; //ends loop
                }   
            }
            //else the loop continues as normal
            else
            {
                //pushes contItem container object on to the stVan stack
                //and the backup stack
                stVan.push(contItem[m]);
                stVanBackup.push(contItem[m]);
                System.out.println("Container "+(1+m)+" "+contItem[m]);
            }
            //checks to see if the van is half full
            if(m == 16/2-1)
            {
                System.out.println("\nThe Van is half full");
                System.out.println("There are currently: "+(m+1)+" containers\n");
            }
            //checks to see if the van is full
            if(containerCounter == 16)
            {   
                System.out.println("\nContainers loaded on van");
                System.out.println("The Van is full");
                System.out.println("There are currently: "+(m+1)+" containers\n");
                break;
            }

        }//end-loop
        
        //if there were less than 12 packages, displays message and ends program
        if(containerCounter < 12)
        {
            System.out.println("There were not enough containers to load"
                    + " the van");
        }
        //if there are enough containers the program continues as normal
        else
        {   
            System.out.println("\nThe van is enroute to Store Room...");
            System.out.println("Contents of Van:\n"+stVan);
        
            /***************************************
            *                                      *
            *                Queue                 *
            *                                      *
            ***************************************/
        
            //creates queues called c1Belt and c2Belt
            BlockingQueue<container>c1Belt = new ArrayBlockingQueue<>(12);
            BlockingQueue<container>c2Belt = new ArrayBlockingQueue<>(8);
            
            System.out.println("\nThe Van has not arrived yet\n");
            System.out.println("--user guide-- null = empty");
            System.out.println("Conveyor belt 1 currently contains: "
                                + c1Belt.peek());
            System.out.println("Conveyor belt 2 currently contains: "
                                + c1Belt.peek()+"\n");
            System.out.println("The van has arrived!"+"\nloading containers"
                    + " on to conveyor belts...");
                        
            //loop-pops off elements of the stack stVan and places
            //them on to the conveyor belts
            for(int b=0; b<containerCounter; b++)
            {
                if(b < 12)
                {
                    //adds car to queue by popping off element from Stack to c2Belt
                    c1Belt.add(stVan.pop());  
                }
                //if there are more than 12 containers it places it on to the
                //2nd conveyor belt instead.
                else
                {
                    //adds car to queue by popping off element from Stack to c1Belt
                    c2Belt.add(stVan.pop());
                }
            }//end loop
        
            System.out.println("\nContents on Belt 1:\n"+c1Belt);
            System.out.println("\nContents on Belt 2:\n"+c2Belt);
            System.out.println("\nThe van contains: "+stVan);
            System.out.println("The van is now leaving...");
        
            /***************************************
            *                                      *
            *              Array List              *
            *                                      *
            ***************************************/
        
            //creates an ArrayList called storeRoom
            ArrayList<container>storeRoom = new ArrayList<>();
            
            System.out.println("\nStore man checking list...");
        
            //while the conveyor belt has containers
            while(!c1Belt.isEmpty())
            {
                //adds it to the storeRoom
                storeRoom.add(c1Belt.remove());
            }
            //while the conveyor belt has containers
            while(!c2Belt.isEmpty())
            {   
                //adds it to the storeRoom
                storeRoom.add(c2Belt.remove());
            }
            
            System.out.println("\nStore Room contains:\n"+storeRoom);
        
            /***************************************
            *                                      *
            *            Write to File             *
            *                                      *
            ***************************************/
        
            //creates a new file called ContainerStockList
            File warehouseStorage = new File("ContainerStockList.txt");
        
            try
            {
                //creates file writer and buffered writer
                FileWriter fw = new FileWriter(warehouseStorage);
                BufferedWriter bw = new BufferedWriter(fw);
                
                System.out.println("\nItems have been checked");
                System.out.println("Writing to checklist...");

                //used to print container number
                int count=0;
                
                //loop-for each container
                for(int k=0;k<containerCounter;k++)
                {
                    count++;
                    //takes the container at the current index using get method
                    //and writes it to the file using the toString method
                    String str = storeRoom.get(k).toString();
                    fw.write(count+str);
                    //makes a new line in the document
                    fw.write(System.lineSeparator());
                }
            
                //flushes memory
                bw.flush();
                //closes BufferWriter
                bw.close();
                System.out.println("Checklist complete '"+warehouseStorage+"' successful!");
            }
            catch(IOException e)
            {
                System.out.println("An error has occured");
            }
        }

    }

}//end of program
