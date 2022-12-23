package lab8.cscd211classes.players;
/*
Name: Johanne McClenahan
Class: CSCD211
Description: BaseballPlayer class is a subclass of Player superclass and contains one constructor, clone method, and toString method
Also implements Cloneable interface
BaseballPlayer(): constructor
clone(): clones a BaseballPlayer object
toString(): returns a String representation of a BaseballPlayer object
*/
//BaseballPlayer class extends Player (superclass) and implements Cloneable (interface)
public class BaseballPlayer extends Player implements Cloneable{
   //batAvg used to store a Baseball Player's batting average
   protected double batAvg;
   //BaseballPlayer constructor that takes in three Strings, one int, and one double value
   public BaseballPlayer(String name, String ssn, int salary, String position, double batAvg){
      //uses super() in order to call Player() (superclass) constructor
      super(name, ssn, salary, position);
      //throw an error if batAvg is less than 0
      if(batAvg < 0)
         throw new IllegalArgumentException("parameter (batAvg) in BaseballPlayer() is less than 0"); 
      //batAvg stores (param) batAvg into BaseballPlayer's batAvg data field
      this.batAvg = batAvg;
   
   }
   //clone() method is used to clone a BaseballPlayer object using clone() method from Player class
   //throws CloneNotSupportedException in order to propagate clone method()
   //returns a cloned Object casted as a BaseballPlayer Object
   public BaseballPlayer clone() throws CloneNotSupportedException{
      //calls superclass version of clone() method and casts the Player as a BaseballPlayer
      return (BaseballPlayer)super.clone();
   
   }
   //toString method used to return a String representation of a BaseballPlayer object
   @Override
   public String toString(){
      return super.toString() + " Batting Avg: " + this.batAvg + "\n";
   
   }



}