package lab1.cscd211enums;

/*
Name: Johanne McClenahan
Class: Color
Description: used to store Color enumerations that contains four different enums used to represent a given person's favorite color
*/

/*
The enumerated type Color.
Enumerated constant values for this lab are RED, GREEN, BLUE, PURPLE in this order
*/
public enum Color{
RED, GREEN, BLUE, PURPLE;

/*
toString method is used to convert Enumerated type Color into a string
Returns enum as a string with first letter capitalized and the rest in lower case
*/
public String toString(){
   return this.name().charAt(0) + this.name().substring(1).toLowerCase();

}



}