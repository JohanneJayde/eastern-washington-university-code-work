package lab8.cscd211classes.players;
/*
Name: Johanne McClenahan
Class: CSCD211
Description: FootballPlayer class is a subclass of Player superclass and contains one constructor, clone method, and toString method
Also implements Cloneable interface
FootballPlayer(): constructor
clone(): clones a FootballPlayer object
toString(): returns a String representation of a FootballPlayer object
*/
//FootballPlayer class extends Player (superclass) and implements Cloneable (interface)
public class FootballPlayer extends Player implements Cloneable{
   //jerseyNumber stores a player's jersey
   protected int jerseyNumber;
   //id stores the number of touchdowns a player has done
   protected int td;
   
   //BaseballPlayer constructor that takes in three Strings and three int values
   public FootballPlayer(String name, String ssn, int salary, String position, int td, int jerseyNumber){
      //uses super() in order to call Player() (superclass) constructor
      super(name, ssn, salary, position);
      //throw an error if jersey number is less than 0
      if(jerseyNumber < 0)
         throw new IllegalArgumentException("parameter (jerseyNumber) in FootballPlayer() is less than 0"); 
      //throw an error if td is less than 0
      if(td < 0)
         throw new IllegalArgumentException("parameter (td) in FootballPlayer() is less than 0"); 
      //jerseyNumber stores (param) jerseyNumber into FootballPlayer's jerseyNumber data field
      this.jerseyNumber = jerseyNumber;
      //td stores (param) td into FootballPlayer's td data field
      this.td = td;
   
   }
   //clone() method is used to clone a FootballPlayer object using clone() method from Player class
   //throws CloneNotSupportedException in order to propagate clone method()
   //returns a cloned Object casted as a FootballPlayer Object  
   public FootballPlayer clone() throws CloneNotSupportedException{
      //calls superclass version of clone() method and casts the Player as a FootballPlayer
      return (FootballPlayer)super.clone();
   
   }
   //toString method used to return a String representation of a FootballPlayer object
   @Override
   public String toString(){
      return super.toString() + " Touchdowns: " + this.td + " " + this.jerseyNumber + "\n";
   
   }



}