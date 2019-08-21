package golfplayersapp;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

//EC1524329
//Joel Degner-Budd
//15/11/2018

public class GolfPlayersApp 
{
    
    public static void main(String[] args) 
    {
        ReadData rd = new ReadData();
        NumberFormat nf = new DecimalFormat("#0.00");
        
        //============================================================
        //======================== Part 1 ============================
        //============================================================
        
        //add all players from the file to map
        Map<String,GolfPlayer> gpMap1 = new LinkedHashMap<>
        (rd.ReadData("Golf Map Data.txt"));
        //backup of the map
        Map<String,GolfPlayer> gpBckMap1 = new LinkedHashMap<>(gpMap1);
        
        //**********display Map data**********
        System.out.println("===============Display gpMap1 Data===============");
        System.out.println("Displaying data...\n");
        System.out.println(gpMap1); //shows map data
        System.out.println("===============END-Display "
                + "gpMap1 Data===============");
        //------------------------------------
        
        //**********Display Map Backup Data**********
        System.out.println("===============Display gpBckMap1 Data"
                + "===============");
        System.out.println("Displaying backup data...\n");
        System.out.println(gpBckMap1); //shows map backup data
        System.out.println("===============END-Display gpBckMap1 Data"
                + "===============");
        //-------------------------------------------
        
        //**********list keys only**********
        System.out.println("\n-----list keys only-----");
        Set<String> keys = gpMap1.keySet();//creates String set containing keys
        for(String x : keys)
        {
            System.out.println("Key = "+x);  
        }
        //----------------------------------
        
        //**********Collect of Values**********
        System.out.println("\n-----collection of values-----");
        Collection<GolfPlayer> values = gpMap1.values();
        //prints out each object and its values from the collection
        for(GolfPlayer x : values)
        {
            System.out.println("values = "+x);
        }
        //-------------------------------------
        
        //**********list the key and values using map.Entry**********
        System.out.println("\n-----list keys and values using Map.Entry-----");
        //Creates Set using Map.Entry to go through each entry in the collection
        //and adds it to the Set.
        Set<Map.Entry<String,GolfPlayer>> keyvalue1 = gpMap1.entrySet();
        //prints out each element using Map.Entry
        for(Map.Entry<String,GolfPlayer> kv1 : keyvalue1)
        {
            System.out.println("Key = "+kv1);  
        }
        //-----------------------------------------------------------
        
        //**********sum and display the total points**********
        System.out.println("-----total points-----");
        FN function = new FN();
        double max = 0;
        max = function.totalPoints(gpMap1); //stores return value in 'max'
        //----------------------------------------------------
        
        //**********given a key find a player with that key**********
        System.out.println("\n-----find player given key-----");
        //finds player given this specific key
        System.out.println("\n"+gpMap1.get("JOSPIETH"));
        
        //-----------------------------------------------------------
        
        //*****given a key that does not exist display relevant message*****
        System.out.println("\n-----key that does not exist-----");
        //attempts to find non-existant key.
        if(gpMap1.containsKey("ABCDE"))
        {
            System.out.println("\n"+gpMap1.get("ABCDE"));
        }
        else
        {
            //key is not found and displays this message
            System.out.println("Error has occured: Key does not exist");
        }
        //-----------------------------------------------------------
        
        //**********try to add a player that already exists**********
        //attempts to add already existing golf player to Map.
        System.out.println("\n-----key that already exists-----");
        GolfPlayer gp1 = new GolfPlayer("Jordan","Spieth",52,613.65,"USA");
        //output if player exists
        if(gpMap1.containsKey("JOSPIETH"))
        {
            System.out.println("Player already exists");
        }
        else
        {   
            //else if they don't exist they are added
            System.out.println("\nAdding new player");
            gpMap1.put("JOSPIETH", gp1);
            System.out.println(gpMap1);
        }
        //----------------------------------------------------------
        
        //============================================================
        //======================== Part 2 ============================
        //============================================================
        
        //**********add all players from the second file to a map**********
        Map<String,GolfPlayer> gpMap2 = new LinkedHashMap<>
        (rd.ReadData("Golf Map Data 2.txt"));
        System.out.println(gpMap2);
        //-----------------------------------------------------------------
        
        //***adds the points in both maps, determines who has the most points***
        System.out.println("\n-----map with most points-----");
        double max2 = 0;
        System.out.println("gpMap1 totalPoints = "+max); //displays value 'max'
        System.out.print("gpMap2 totalPoints = ");
        //adds total points in gpMap2
        max2 = function.totalPoints(gpMap2);
        //finds the greatest value and difference between the two Maps
        function.greatestValue(max, max2); //finds greatest value
        //----------------------------------------------------------------------
        
        //*****which mapping has the most American Players in it*****
        System.out.println("\n-----map with most American players-----");
        int counter1 = 0;
        int counter2 = 0;
        
        System.out.println("-----gpMap1-----");
        //function call to find all American players
        //returns numerical value and places it in counter.
        counter1 = function.mostAmericans(gpMap1);
        System.out.println("\n-----gpMap2-----");
        //same as above
        counter2 = function.mostAmericans(gpMap2);

        if(counter1 > counter2)
        {
            System.out.println("Table one contains more USA players: "+counter1);
        }
        else
        {
            System.out.println("Table two contains more USA players:" +counter2);
        }
        //------------------------------------------------------------
        
        //***create a union and find out who has played the most events***
        System.out.println("\n-----set1-----");
        //creates set from all elements in the collection Map1
        Set<GolfPlayer> set1 = new LinkedHashSet<>(gpMap1.values());
        System.out.println(set1);
        System.out.println("\n-----set2-----");
        //creates set from all elements in the collection Map2
        Set<GolfPlayer> set2 = new LinkedHashSet<>(gpMap2.values());
        System.out.println(set2);
        System.out.println("\n-----MapUnion-----");
        //creates a union of both Sets
        Set<GolfPlayer> unionAll = new LinkedHashSet<>(SF.union(set2, set1));
        
        //creates a Map union
        Map<String,GolfPlayer>gpUnion = new LinkedHashMap<>();
        //adds all values from Map2
        gpUnion = gpMap2;
        //adds all elements from Map1 that do not match elements already
        //present in the Map gpUnion.
        gpUnion.putAll(gpMap1);
        System.out.println(gpUnion);
        System.out.println(gpUnion.size());
        
        //============================================================
        //====== Using Sets, finds most and least events player ======
        //============================================================
        Set<GolfPlayer> mostEvents = new LinkedHashSet<>();
        Set<GolfPlayer> leastEvents = new LinkedHashSet<>();
        
        int maxEvents = 0;
        int minEvents = 100;
        
        for(GolfPlayer x : unionAll)
        {
            if(x.getEvents() > maxEvents)
            {
                mostEvents.clear();
                mostEvents.add(x);
                maxEvents = x.getEvents();
            }
            if(x.getEvents() < minEvents)
            {
                leastEvents.clear();
                leastEvents.add(x);
                minEvents = x.getEvents();
            }
        }
        System.out.println("\n-----most events-----");
        System.out.println(mostEvents);
        System.out.println("\n-----least events-----");
        System.out.println(leastEvents);
        //-----------------------------------------------------------
        
        //***finds how many different players there are in total***
        Set<String>gPlayers1 = new LinkedHashSet<>();
        Set<String>gPlayers2 = new LinkedHashSet<>();
        
        //runs through each element in the Set union 'unionAll'
        for(GolfPlayer x : unionAll)
        {
            //finds the name and Surname of each player
            //and places those elements into linkedHashSet gPlayers1
            gPlayers1.add("\n"+String.format("%-20s", x.getName()+" "
                                                    +x.getSurName()));
        }
        System.out.println("\n-----list of all different players-----");
        System.out.println(gPlayers1);
        System.out.println("\nnumber of players total = "+gPlayers1.size());
        //---------------------------------------------------------
        
        //****create a mapping of non american players****
        System.out.println("\n-----mapping of nonAmerican-----");
        Map<String,GolfPlayer>nonAmer = new LinkedHashMap<>();
        
        //for each element that doesn't match the value 'USA' in getCountry
        //add to Map nonAmer. Creates Map of non-American players.
        for(GolfPlayer x : gpMap1.values())
        {
            String kV = x.setKey();
            if(!(x.getCountry().equalsIgnoreCase("USA")))
            {
                nonAmer.put(kV, x);
            }
        }
        for(GolfPlayer x : gpMap2.values())
        {
            String kV = x.setKey();
            if(!(x.getCountry().equalsIgnoreCase("USA")))
            {
                nonAmer.put(kV, x);
            }
        }
        System.out.println(nonAmer);
        //-------------------------------------------------
        
        //****List the keys for non American players****
        System.out.println("\n-----keys for nonAmerican-----");
        //for each element in nonAmer finds the key only and outputs it.
        for(GolfPlayer x : nonAmer.values())
        {
            String kV = x.setKey();
            System.out.println("Key = "+kV);
        }
        //----------------------------------------------
        
        //****List the values for non American players****
        System.out.println("\n-----values for nonAmerican-----");
        //for each element in nonAmer finds the values only and outputs it.
        for(GolfPlayer x : nonAmer.values())
        {
            System.out.print("values = "+x);
        }
        //------------------------------------------------
        
        //**list the key and values using Map.Entry<> for non american players**
        
        //for each element in nonAmer finds the keys and values 
        // using Map.Entry and outputs it.
        System.out.println("\n-----keys and values/nonAmerican-----");
        Set<Map.Entry<String,GolfPlayer>> kvNonAmer = nonAmer.entrySet();
        for(Map.Entry<String,GolfPlayer> kv : kvNonAmer)
        {
            System.out.print("Key = "+kv);
        }
        //----------------------------------------------------------------------
        
        //***Sum and display the total points for non american players***
        System.out.println("\n-----nonAmerican total points-----");
        double naTotal = 0;
        
        //adds up each elements totalPoints and places it in the double variable
        // 'naTotal' and displays the final total.
        for(GolfPlayer x : nonAmer.values())
        {
            naTotal += x.getTotalPts();
        }
        
        System.out.println(nf.format(naTotal));
        //---------------------------------------------------------------
        
        //****remove all players with less than 45 events played****    
        System.out.println("\n-----remove all players with "
                + "less than 45 events played-----");
        System.out.println("-----gpMap1-----");
        //using the Iterator,goews through each golf player using Map.Entry
        //in the Map 'gpMap1'. The Iterator the removes the players with less
        //than 45 events played via the Iterators .remove() function.
        for(Iterator<Map.Entry<String, GolfPlayer>> itr = 
                gpMap1.entrySet().iterator(); itr.hasNext();) 
        {
            Map.Entry<String, GolfPlayer> entry = itr.next();
            int lessEvents = entry.getValue().getEvents();
            if(lessEvents < 45) 
            {
                itr.remove();
            }
        }
        System.out.println(gpMap1);
        //----------------------------------------------------------
        
        //*****empty both maps and show that they are empty*****
        System.out.println("\n-----Clear all Maps-----");
        //using .clear() function to empty all Maps
        gpMap1.clear();
        gpMap2.clear();
        nonAmer.clear();
        System.out.println("gpMap1 = "+gpMap1);
        System.out.println("gpMap2 = "+gpMap2);
        System.out.println("nonAmer = "+nonAmer);
        //-------------------------------------------------------
    }//end of main
}//end of program