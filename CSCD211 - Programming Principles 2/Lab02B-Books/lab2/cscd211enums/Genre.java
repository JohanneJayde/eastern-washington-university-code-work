package lab2.cscd211enums;

public enum Genre
{
   //enum constants
   FICTION(10, "fiction"), NONFICTION(20, "non-fiction"), ROMANCE(5, "romance"), 
   SCIFI(30, "sci-fi"), EDUCATION(15, "education");
  
   
   private String name;
   private int value;
   
   //The private constructor of Genre that takes a value and a name *
   private Genre(int value, String name){}
   
   //Returns the String value of the name for the Genre
   public int getValue(){return value;}
   //Returns the integer value for the Genre.
   public String getName(){return name;}
   
  //returns the lower case version if it is two words the words are hyphenated. 
  //NONFICTION becomes non-fiction and SCIFI becomes sci-fi.
  //Overrides: toString in class Enum<Genre>
   public String toString(){
      if(this.name == "nonfiction")
         return "non-fiction";
      if(this.name == "scifi")
         return "sci-fi";
         
      return this.name.toLowerCase();
   
   }

}