package lab8.cscd211classes.players;
/*
Name: Johanne McClenahan
Class: CSCD211
Description: Player class used create Player objects. It has one constructor, one clone method, four accessor methods, and one toString method.
Player is an abstract class and is used as the superclass for FootballPlayer, HockeyPlayer, and BaseballPlayer
Player also implements Cloneable interface
Player(): Constructor
clone(): clone a Player object
getName(): return player's name
getPosition(): return player's position
getSalary(): return player's salary
getSSN(): returns player's ssn
toString(): returns String representation of Player object
*/
//Player abstract class is used as the base for three subclasses, "new" Player objects cannot be initialized
public abstract class Player implements Cloneable{
   //name represents a player's name
   protected String name;
   //position represents a player's position in the game
   protected String position;
   //salary represents a player's salary as a int value
   protected int salary;
   //ssn represents a player's social security number
   protected String ssn;
   
   //Constructor that takes in three Strings and a int value. NOTE* cannot be initialized
   protected Player(String name, String ssn, int salary, String position){
   //throws errors if one of the string values is null
      if(name == null)
         throw new IllegalArgumentException("parameter (name) in Player() is null");
      if(ssn == null)
         throw new IllegalArgumentException("parameter (ssn) in Player() is null");
      if(position == null)
         throw new IllegalArgumentException("parameter (position) in Player() is null");
   //throws error if salary is less than 0
      if(salary < 0)
         throw new IllegalArgumentException("parameter (salary) in Player() is less than 0");
         
      //name stores (param) name in Player's name data field
      this.name = name;
      //position stores (param) position in Player's position data field
      this.position = position;
      //salary stores (param) salary in Player's salary data field
      this.salary = salary;
      //ssn stores (param) snn in Player's ssn data field
      this.ssn = ssn;
   }
   //clone() method is used to clone a Player object using clone() method from Object class
   //throws CloneNotSupportedException in order to propagate clone method()
   //returns a cloned Object casted as a Player Object
   public Player clone() throws CloneNotSupportedException{
      //calls superclass version of clone() method and casts the Object as a Player
      return (Player)super.clone();
   }
   
   //four accessor method used to access Player data fields
   
   //getName() used to access a player's name
   public String getName()     { return this.name; }
   //getPosition() used to access a player's position
   public String getPosition() { return this.position; }
   //getSalary() used to access a player's salary
   public int getSalary()      { return this.salary; }
   //getSSN() used to access a player's social security number
   public String getSSN()      { return this.ssn; }
   
   //toString() method used to return String representation of a Player object
   @Override
   public String toString(){
      return this.name + " " + this.ssn + " " + this.salary + " " + this.position;   
   }

}