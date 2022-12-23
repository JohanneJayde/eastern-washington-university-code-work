package lab8.cscd211classes;
/*
Name: Johanne McClenahan
Class: CSCD211
Description: Team class is used to create Team objects and implements Taxable, Payroll, and Comparable interfaces
It contains one constructor, compareTo method, four accessor methods, calculate team tax rate method, calculate team's payroll, and toString method
and four data fields
Method Descriptions:
Team(): constructor for constructing a Team object
calculatePayroll(): calculates the int value of the total salary of each player plus the base payroll
calculateTaxes(): calculates a double value that is the amount of taxes for the team, uses the base taxrate
compareTo(): compares a team's city to another and if equal, then compares a team's name
getCity(): returns a team's city
getPayroll(); returns a team's payroll
getPlayers(): returns the list of players on a team
getTeamName(): returns a team's name
toString(): returns a String representation of the Team object
*/

//java.util.* is imported to use ArrayList class
import java.util.*;
//lab8.cscd211interfaces.* allows access to Taxable and Payroll interfaces
import lab8.cscd211interfaces.*;
//lab.cscd211classes.players.* allows access to superclass Player and subclass FootballPlayer, HockeyPlayer, and BaseballPlayer
import lab8.cscd211classes.players.*;
//Team class implements three interfaces, Comparable is specified to compare Team objects
public class Team implements Payroll, Taxable, Comparable<Team>{
   //String city used to store a team's city
   protected String city;
   //int payroll used to store a team's total payroll
   protected int payroll;
   //ArrayList players stores a team's players as Player objects
   protected ArrayList<Player> players = new ArrayList<Player>();
   //String teamName stores a team's name
   protected String teamName;

   //Constructor for Team object that takes in two strings and a Player array as a parameters. Throws CloneNotSupportedException in order to propagate clone() method
   public Team(String city, String teamName, Player[] players) throws CloneNotSupportedException{
      //throws errors if one of the parameter values are null
      if(city == null)
         throw new IllegalArgumentException("parameter (city) in Team() is null");
      if(teamName == null)
         throw new IllegalArgumentException("parameter (teamName) in Team() is null");
      if(players == null)
         throw new IllegalArgumentException("parameter (players) in Team() is null");
      //storing (param) city into Team object's city date field
      this.city = city;
      //storing (param) teamName into Team object's teamName data field
      this.teamName = teamName;
      //clonedPlayer is an ArrayList used to hold cloned Player objects taken from (param) players array
      ArrayList<Player> clonedPlayers = new ArrayList<Player>();
      
      //for-loop is used to iterate through players array and clone each Player object and add them to the clondedPlayer ArrayList
      //number of iterations based off of players array length
      //uses clone() method to clone each Player subclass object
      for(int i = 0; i < players.length; i++){
         clonedPlayers.add(players[i].clone());
      }
      //storing clondedPlayers into Team object's players data field
      this.players = clonedPlayers;
      
   } 
   //calculatePayroll() is used to calculate a team's payroll
   //this method is overriding calculatePayroll() method in Payroll interface
   //returns an int value representing a team's total salary
   public int calculatePayroll(){
      //teamSalary holds the total amount of salary for a team as an int value
      //teamSalary is set to BASE_PAYROLL from Payroll interface as all teams are payed this base amount
      int teamSalary = BASE_PAYROLL;
      
      //for-loop is used to trace through a Team object's players data field
      //for-loop's number of iterations is based on the length of players
      for(int i = 0; i < this.players.size(); i++){
         //teamSalary has each player's salary added to it
         //getSalary() is used to access each Player object's salary data field
         teamSalary = teamSalary + this.players.get(i).getSalary();     
      }
      
      //storing teamSalary into Team object's payroll data field
      this.payroll = teamSalary;
      //returning teamSalary to where the method was called
      return teamSalary;

   }
   //calculateTaxes() is used to calculate a team's taxes
   //this method is overriding calculateTaxes() method in Taxable interface
   //returns a double value representing a team's total taxes needed to be payed
   public double calculateTaxes(){
      //teamTaxes keeps track of the total amount of taxes owed by a team as a double value
      double teamTaxes = 0;
    
      //for-loop is used to trace through a Team object's players data field
      //for-loop's number of iterations is based on the length of players
      for(int i = 0; i < this.players.size(); i++){
         //if-statement used to check percentage of taxes a player must pay based on their salary
         //if a player has a salary of over 250000, they will pay the standard BASE_TAX_RATE from Taxable interface
         if(this.players.get(i).getSalary() > 250000){
            //teamTaxes has each player's taxes added to it
            //getSalary() is used to access each Player object's salary data field and it is multiplied by the base tax rate
            teamTaxes = teamTaxes + (this.players.get(i).getSalary() * BASE_TAX_RATE);
         }
         //if a player has a salary of under or equal to 250000, they will pay the standard BASE_TAX_RATE minus .1 from Taxable interface
         if(this.players.get(i).getSalary() <= 250000){
            //teamTaxes has each player's taxes added to it
            //getSalary() is used to access each Player object's salary data field and it is multiplied by the base tax rate minus .1
            teamTaxes = teamTaxes + (this.players.get(i).getSalary() * (BASE_TAX_RATE -.1));
            }
         }
         //teamTaxes is returned to where the method was called
         return teamTaxes;
      }
   //compareTo() method is used to compare an instance of a Team object with another Team object
   //method first compares Team's city data field, followed by their teamName data field if city are equal
   //compareTo() is overriding the method from the Comparable interface and it take in one Team object as a parameter
   public int compareTo(Team pi){
      //throw an error if parameter is null
      if(pi == null)
         throw new IllegalArgumentException("parameter in compareTo(Team) is null");
      //compareResults is used to hold the result of comparing two Team's data fields
      int compareResult;
      //compareResults is set the result of comparing two Team's city data fields
      compareResult = this.city.compareTo(pi.getCity());
      //if-statement used to check whether compareResult is 0 after first comparison as if it is 0, then that means teamName needs to be compared
      if(compareResult != 0)
         //return compareResults to where the method was called if city names are not the same
         return compareResult;
      //compareResults is set the result of comparing two Team's teamName data fields       
      compareResult = this.teamName.compareTo(pi.getTeamName());
         //return compareResults to where the method was called regardless of result as this helps sort Team objects based on their teamName
         //so long as their city match
         return compareResult;
   }
   //four accessor methods used to gain access a Team's data fields
   
   //getCity() returns the name of a team's city
   public String getCity()               { return this.city; }
   //getPayroll() returns a team's total salary calls .calculatePayroll() in order to get access to that value
   public int getPayroll()               { return this.calculatePayroll(); }
   //getPlayers() returns an array of all the players on a team
   public ArrayList<Player> getPlayers() { return this.players; }
   //getTeamName() returns a team's name
   public String getTeamName()           { return this.teamName; }
 
   //toString() method used to return a String representation of a Team object and its content
   public String toString(){ 
      //playerFormatted formats a Team's player data field in order to clean up output
      //three replace() methods are used to get rid of unneeded commas and brackets
      String playerFormatted = this.players.toString().replace("[", " ").replace("]", " ").replace(",", "");
      //titles stores all the names from Player data fields so that each Player's information displayed makes more sense
      String titles = "PLAYER NAME      SSN          SALARY      POSITION       STATS        NUMBER";
      //Separator is used to separate titles from playerFormatted to make output cleaner
      String seperator = "----------------------------------------------------------------------------";
      //returns all Strings above along with all data fields and total taxes to user
      //uses accessor methods and calculateTaxes() method
      return this.getCity() + " - " + this.getTeamName() + "\nPayroll: " + this.getPayroll() + "\nTaxes: " + this.calculateTaxes() + "\n" + titles + "\n" + seperator + "\n" + playerFormatted + "\n"; 
   }
}