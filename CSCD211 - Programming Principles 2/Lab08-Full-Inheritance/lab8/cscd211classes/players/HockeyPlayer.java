package lab8.cscd211classes.players;
/*
Name: Johanne McClenahan
Class: CSCD211
Description: HockeyPlayer class is a subclass of Player superclass and contains one constructor, clone method, and toString method
Also implements Cloneable interface
HockeyPlayer(): constructor
clone(): clones a HockeyPlayer object
toString(): returns a String representation of a HockeyPlayer object
*/
//HockeyPlayer class extends Player (superclass) and implements Cloneable (interface)
public class HockeyPlayer extends Player implements Cloneable{
   //jerseyNumber stores a player's jersey
   protected int jerseyNumber;

   //HockeyPlayer constructor that takes in three Strings and two int values
   public HockeyPlayer(String name, String ssn, int salary, String position, int jerseyNumber){
      //uses super() in order to call Player() (superclass) constructor
      super(name, ssn, salary, position);
      //throw an error if jersey number is less than 0
      if(jerseyNumber < 0)
         throw new IllegalArgumentException("parameter (jerseyNumber) in HockeyPlayer() is less than 0"); 
      //jerseyNumber stores (param) jerseyNumber into HockeyPlayer's jerseyNumber data field
      this.jerseyNumber = jerseyNumber;

   }
   //clone() method is used to clone a HockeyPlayer object using clone() method from Player class
   //throws CloneNotSupportedException in order to propagate clone method()
   //returns a cloned Object casted as a HockeyPlayer Object   
   public HockeyPlayer clone() throws CloneNotSupportedException{
      //calls superclass version of clone() method and casts the Player as a HockeyPlayer
      return (HockeyPlayer)super.clone();
   
   }
   //toString method used to return a String representation of a HockeyPlayer object
   @Override
   public String toString(){
      return super.toString() + " " + this.jerseyNumber + "\n";
   
   }



}