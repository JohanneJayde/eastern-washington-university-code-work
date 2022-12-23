package lab1.cscd211classes;
import lab1.cscd211enums.*;

/*
Name: Johanne McClenahan
Class: Person
Description: Person class contains Person object that stores a given person's favorite color, first name, and last name.
Also contains compareTo method for comparing two Person Object's contents, getColor method that allows to access a Person Object's color,
and toString method used for displaying a Person object
*/

public class Person implements Comparable<Person> 
{
   //Color color that stores a given person's favorite color
   private Color color;
   //String fn that stores first name of a given person
   private String fn;
   //String ln that stores last name of a given person
   private String ln;
   
   //Explicit Value Constructor for Person
   //Params: String fn, String ln, Color color
   //Stores given params into private addresses in Person class
   public Person(final String fn, final String ln, final Color color){
      this.fn = fn;
      this.ln = ln;
      this.color = color;
   }
   /*
   *compares by last name, if the last names are the same then by first name.
   *If the first names are then same then by color
   *
   *Specified by: compareTo in interface Comparable<Person>
   *
   *Throws: illegalArgumentException - if another is null
   */
   
   @Override
   public int compareTo(final Person another){
      if(another == null)
         throw new IllegalArgumentException("bad params. another is null in compareTo method");
      //int results represents whether or not a Person's last name, first name, and color are equal
      int results;
      //comparing two Person element's last names, if results not equal to 0, then last names are not equal
         results = this.ln.compareTo(another.ln);
            if(results != 0)
               return results;
      //comparing two Person element's first names, if results not equal to 0, then first names are not equal
         results = this.fn.compareTo(another.fn);
            if(results != 0)
     //comparing two Person element's colors names, returns results
         results = this.color.compareTo(another.color);
            return results;   
   }
   //accessor method that returns color of a given Person object
   public Color getColor(){
      return this.color;
   }
   /*
    *the toString returns the first name space last name, color
    *Overrides: toString in class Object
    *Returns: first name space last name, color
   */
   public String toString(){
      return (this.fn + " " + this.ln + ", " + this.color);
      
   }

}