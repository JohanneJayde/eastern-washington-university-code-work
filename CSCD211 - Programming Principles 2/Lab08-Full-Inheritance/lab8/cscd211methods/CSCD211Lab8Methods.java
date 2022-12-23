package lab8.cscd211methods;
/*
Name: Johanne McClenahan
Class: CSCD211
Description: methods that are used in lab 8.
fillArray: fills an array with a Team objects. Team objects are constructed using data in the file accessed using fin file scanner object
menu: used to display the choices that the user can select from. Ensures that the choice is within range of menu options
*/

//import java.util.* in order to use ArrayList class
import java.util.*;
//import cscd211classes.* in order use Team class for contructing Team objects
import lab8.cscd211classes.*;
//import cscd211classes.players.* in order to contruct a Player object array, and create FootballPlayer, HockeyPlayer, and Baseball Player objects
import lab8.cscd211classes.players.*;

/**
 * I have provided the menu method for you.  You must write the fill method. Please look at the file teamlist.txt
 * <br>
 * The file format is City\n Number of teams\n Type, Team Name\n Number of Players\n <br>
 * player name, ssn, salary, position, specific info based on type <br>
 * if football then # of touch downs, jersey number <br>
 * if baseball then batting average <br>
 * if hockey then jersey number <br>
 *
 * @NOTE All parameters passed must be final
 */
//Method class for lab 8
public class CSCD211Lab8Methods
{
   /**
    * reads from the file and creates the appropriate player for the array and
    * creates the appropriate team
    *
    * @param fin Scanner object
    * @param myTeam ArrayList of type Team
    *
    * @throws IllegalArgumentException for fin or myTeam being null
    * @throws CloneNotSupportedException to propagate the clone method
    *
    * @NOTE To add to MyArrayList it is an addLast method call myTeam.addLast(team stuff)
    */
   public static void fillArrayList(final Scanner fin, final ArrayList<Team>myTeam)throws CloneNotSupportedException
   {
      //throwing an error if either parameters are null
      if(fin == null || myTeam == null)
         throw new IllegalArgumentException("Error Precond: Scanner or Team cannot be null");
      //declaring variables to be set using data in the file
      String teamCity, teamName, playerName, ssn, position, stats, type, whiteSpace;
      //array is used for storing a string after it has been split in order to properly assign each array element to variables used for creating Player subclass objects
      String [] array;
      //typeSplit is used to split a String line in file that stores the type of Player object a team has as well as the team's name
      String [] typeSplit;
      //declaring int variables for usage in constructing objects to store in myTeam ArrayList
      int numPlayers, salary, td = 0, numTeams, jerseyNum;
      double batAvg = 0;
      
      //while-loop and hasNextLine used in conjunction in order to parse through each line of the file
      //loop stops if hasNextLine() results in false            
      while(fin.hasNextLine() == true){
         //whiteSpace is used to check whether or not a blank line is found in order to stop the loop
         //this is used as a way to avoid errors when reaching end of teamlist file that has blank lines at the end
         whiteSpace = fin.nextLine();
            //if-statement is used to check whether or not whitespace is empty, if true, while-loop stops execution as there is no more lines to read
            if(whiteSpace.isEmpty())
               break;
         //teamCity is used to store the team's city (set as whiteSpace as whiteSpace is the first line of the file)
         teamCity = whiteSpace;
         //numTeam is used to store the amount of teams a city has, this affects how many times a for-loop iterates
         //uses Integer.parseInt() to convert line of data from file to int value (Auto unboxing)
         numTeams = Integer.parseInt(fin.nextLine());
         //for-loop is used to create a specific amount of Team objects based on the number of teams found in the file
         for(int i = 0; i < numTeams; i++){
            //typeSplit used to store the team's type of players and the team name
            //split() method is used to separate the data as they are combined onto one line in file
            typeSplit = fin.nextLine().split(", ");
            //teamName stores a team's name and is found in the second element of the typeSplit array
            teamName = typeSplit[1];
            //teamName stores a team's type and is found in the first element of the typeSplit array
            type = typeSplit[0];
            //numPlayers stores the number of players a team has. This is used to dictate how many times a for-loop iterates
            //uses Integer.parseInt() to convert line of data from file to int value (Auto unboxing)
            numPlayers = Integer.parseInt(fin.nextLine());
            //playerArray is used to store the players and their information on a team, size is based of numPlayers
            Player [] playerArray = new Player[numPlayers];
            //for-loop is used to iterate and create Player objects of a given type based on the number of players
            for(int j = 0; j < numPlayers; j++){
               //array is used to store a line of data split into String data for use in creating Player objects
               //split() method is used to separate the data as they are combined onto one line in file
               //size of array is based on what type of player the current line stores
               array = fin.nextLine().split(", ");
               //playerName is used to store the player's name and is set from the first element of array
               playerName = array[0];
               //ssn is used to store the player's social security number and is set from the second element of array
               ssn = array[1];
               //salary is used to store the player's salary and is set from the third element of array
               //uses Integer.parseInt() to convert line of data from file to int value (Auto unboxing)
               salary = Integer.parseInt(array[2]);
               //position is used to store the player's position and is set from the fourth element of array 
               position = array[3];
                                      
               //series of if-statements used to check what the type of Player object needs to be constructed based on the team's type
               //equals() method is used to check type against the three possible Player types
               
               //FootballPlayer objects contain two additional data fields for jersey number and touchdowns made
               if(type.equals("Football")){
                  //td is used to store the player's number of touchdowns and is set from the fifth element of array
                  //uses Integer.parseInt() to convert line of data from file to int value (Auto unboxing)
                  td = Integer.parseInt(array[4]);
                  //jerseyNum is used to store the player's jersey number and is set from the sixth element of array
                  //uses Integer.parseInt() to convert line of data from file to int value (Auto unboxing)
                  jerseyNum = Integer.parseInt(array[5]);
                  //fb is a FootballPlayer object created using data stored in each variable
                  //fb is a Player object in order to properly store it in a Player array
                  Player fb = new FootballPlayer(playerName, ssn, salary, position, td, jerseyNum);
                  //fb is added to the playerArray
                  playerArray[j] = fb;
               }
               //BaseballPlayer objects contain one additional data field for the average batting record
               if(type.equals("Baseball")){
                  //batAvg is used to store the player's batting average and is set from the fifth element of array
                  //uses Double.valueOf() to convert line of data from file to double value (Auto unboxing)
                  batAvg = Double.valueOf(array[4]);
                  //bb is a BaseballPlayer object created using data stored in each variable
                  //bb is a Player object in order to properly store it in a Player array
                  Player bb = new BaseballPlayer(playerName, ssn, salary, position, batAvg);
                  //bb is added to the playerArrray
                  playerArray[j] = bb;  
               }
               //HockeyPlayer objects contain one additional data field for a player's jersey number
               if(type.equals("Hockey")){
                  //jerseyNum is used to store the player's jersey number and is set from the sixth element of array
                  //uses Integer.parseInt() to convert line of data from file to int value (Auto unboxing)
                  
                  //NOTE* this is done in due to extra comma on line 16 of teamlist.txt
                  //if-statement used to trim extra comma off of jersey number from line 16
                  //.indexOf() is used to check whether array[4] has a comma (line 16 does)
                  //if the text file has been changed to correct this error, this statement will not execute
                  if(array[4].indexOf(",") != -1)
                     //.subString used to replace array[4] with itself minus ending character which is a comma
                     array[4] = array[4].substring(0,2);
                     
                  jerseyNum = Integer.parseInt(array[4]);
                  //hk is a HockeyPlayer object created using data stored in each variable
                  //hk is a Player object in order to properly store it in a Player array
                  Player hk = new HockeyPlayer(playerName, ssn, salary, position, jerseyNum);
                  //hk is added to the playerArray
                  playerArray[j] = hk;
               }
               
            }
            //after for-loop for populating playerArray is done, a new Team object is constructed using variables that have data from file stored in them
            //using .add() method from ArrayList class
            myTeam.add(new Team(teamCity, teamName, playerArray));   
         }
      
      }      
      //myTeam ArrayList is trimmed to size to ensure no empty elements
      myTeam.trimToSize();
   }// end createAndFill

   /**
    * The menu method ensures a valid choice is entered and returns that value
    * <br> 1 Print all Teams
    * <br> 2 Sort all Teams by city and team name
    * <br> 3 Sort all Teams by Payroll
    * <br> 4 Exit program
    *
    * @param kb Representing a valid Scanner object
    * @return int Representing the menu choice
    *
    * @throws IllegalArgumentException If Scanner is null
    */
   public static int menu(final Scanner kb)
   {
      //throws error if scanner object is null
      if (kb == null)
         throw new IllegalArgumentException("Error Precond: Scanner cannot be null - menu");
      //int choice stores the user's choice for what option from the menu that they chose
      int choice;
      //do-while loop used to ensure choice is within the range of the menu options
      do
      {
         //displaying contents of menu
         System.out.println("Please choose from the following");
         System.out.println("1) Print all Teams");
         System.out.println("2) Sort all Teams by city and team name");
         System.out.println("3) Sort all Teams by Payroll");
         System.out.println("4) Exit program");
         System.out.print("Choice --> ");
         //choice is set the int value the user enters from the keyboard
         choice = kb.nextInt();
         //kb.nextLine() ensures input buffer is cleared
         kb.nextLine();
      } while (choice < 1 || choice > 4);
      //choice is returned
      return choice;
   }// end menu

}// end class