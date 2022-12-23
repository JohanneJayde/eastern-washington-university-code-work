package lab1.cscd211methods;

import java.util.Scanner;
import lab1.cscd211enums.Color;
import lab1.cscd211classes.Person;

/*
Name: Johanne McClenahan
Class: CSCD211Lab1Methods
Description: CSCD211Lab1Methods contains methods that are used to alter an array. 
Methods include:
fillArray: fills an array using contents from a given file
convertColor: converts a string representation of a color into an enum
menu: display a menu that list choices that user may pick from
printArray: prints contents of the array, element by element
readColor: allows user to input a color
displayAll: displays an array element who's color content matches the color that is being searched for
*/

public class CSCD211Lab1Methods
{
   /**
    *The fillArray method creates an array of type person. Reads the information from the file, creates a person and places 
    *the person object into the array. The array is returned.
    *
    * @param fin Representing an Scanner object to the file 
    * @param total Representing the total items will be in the array
    * @return Person [] Representing a filled array containing Person objects
    *
    * @throws IllegalArgumentException if Scanner object is null
    * @throws IllegalArgumentException if total is less than or equal to 0
    */
public static Person [] fillArray(final Scanner fin, final int total){
   if(fin == null)
      throw new IllegalArgumentException("bad params. Scanner is null in fillArray method");
   if(total <= 0)
      throw new IllegalArgumentException("bad params. total is less than or equal to 0 in fillArray method");   
   //String fn represents the person's first name found in the user's selected file
   String fn;
   //String ln represents the person's last name found in the user's selected file
   String ln;
   //String color represents the person's favorite color in the user's selected file
   String color;
   //Enum colorEnum represents the person's favorite color as an enumeration
   Color colorEnum;
   
   //Person array represents an array filed with Person objects
   //Person array's amount of element objects is based on the total(integer) parameter
   Person [] array = new Person[total];
     
   //Loop is used to cycle through contents of user's file and creates a new Person object every
   //cycle until the length of the array or number of max elements has been reached
   for(int i = 0; i < array.length; i++) {
      fn = fin.nextLine();
      //formats String fn into fnCaptial so that the first letter of the first name is capitalized
      String fnCapital = (fn.substring(0, 1).toUpperCase() + fn.substring(1));
      ln = fin.nextLine();
      //formats String ln into lnCaptial so that the first letter of the last name is capitalized
      String lnCapital = (ln.substring(0, 1).toUpperCase() + ln.substring(1));
      color = fin.nextLine();
      //converts String color into Color colorEnum using convertColor(String) method
      colorEnum = convertColor(color);
      //creates new Person object to be added into the array
      array[i] = new Person(fnCapital, lnCapital, colorEnum);
   }
      //returns filled array with Person objects
      return array;

}
   /**
    *The convertColor method converts a string to a color. This method is called 
    *from various other methods.
    *
    * @param color Representing color as a String
    * @return The color object obtained from the String as a enumeration  
    * This method must convert the color generically
    *
    * @throws IllegalArgumentException if the String is null
    * @throws IllegalArgumentException If no color matches
    * 
    */ 
public static Color convertColor(final String color) {
   if(color == null || color.isBlank())
      throw new IllegalArgumentException("bad params. color is null in convertColor method");

      try{
         return Color.valueOf(color.toUpperCase());
         }
     catch(IllegalArgumentException e){
            throw new IllegalArgumentException("color not found in enums");
         }
      
      
   //returns String color as enumeration
}
   /**
    *The menu method. Valid menu choices are:
    *1. Print the Array to the screen
    *2. Display all people that contain a certain color
    *3. Sort the array by Color
    *4. Sort the array by the 'natural order'
    *5. Quit
    *You must ensure the value entered is within range You must ensure 
    *the input buffer is left empty
    *
    * @param kb Representing the Scanner object to the keyboard
    * @return int Choice Representing the menu choice
    * 
    * @throws IllegalArgumentException if the Scanner object is null
    * 
    */ 
public static int menu(final Scanner kb){
   if(kb == null)
      throw new IllegalArgumentException("bad params. Scanner kb is null in menu method");
   //int choice represents the menu choice inputed by the user
   int choice;
   
   //do while loop is used to iterate once and then iterate 
   //again if choice is greater than 5 or less or equal to 0
 do{
      System.out.println("1. Print the Array to the screen");
      System.out.println("2. Display all people that contain a certain color");
      System.out.println("3. Sort the array by Color");
      System.out.println("4. Sort the array by the 'natural order'");
      System.out.println("5. Quit");
      System.out.print("Please enter a choice between 1 and 5: ");
   //user inputs number within range of do while loop, Integer.parseInt is used to convert
   //String input into integer with clear input buffer
      choice = Integer.parseInt(kb.nextLine()); 
   }while(choice > 5 || choice <= 0);
   //returns choice to where menu method was called
      return choice;
}
   /**
    *The print array method prints the individual person to the screen and then 
    *a carriage return between people.
    *
    * @param myPeeps Representing the filled array of type Person
    * 
    * @throws IllegalArgumentException if the array is null
    * 
    */ 
public static void printArray(final Person [] myPeeps){
   if(myPeeps == null)
      throw new IllegalArgumentException("bad params. myPeeps is null in printArray method");
    //enhanced for loop used to print each Person element in myPeep Array with new line character
    for(Person s: myPeeps)
      System.out.println(s + "\n");
   
}
   /**
    *The readColor method reads a string from the keyboard and then converts it 
    *to a color by calling the private method convertColor
    *
    * @param kb Representing the Scanner object
    * 
    * @throws IllegalArgumentException if the Scanner object is null
    * 
    */ 
public static Color readColor(final Scanner kb){
   if(kb == null)
      throw new IllegalArgumentException("bad params. Scanner kb is null in readColor method");
   //prompts user to input color that will be searched for in Person array
   System.out.print("Please enter your color: ");
   String color = kb.nextLine();
   //calls connvertColor method and converts the user inputed String color into an enumeration
   return convertColor(color);

}
 /**
    *The displayAll method displays all Person objects that contain a specific color.
    *
    * @param toFind Representing Color enum of color to find
    * @param myPeeps Representing the Person array 
    *
    * @throws IllegalArgumentException if the array is null
    * 
    */ 

public static void displayAll(final Color toFind, final Person [] myPeeps){
   if(myPeeps == null)
      throw new IllegalArgumentException("bad params. myPeeps is null in displayAll method");
   //for loop used to see if toFind color matches any of the colors in myPeeps array
   for(int i = 0; i < myPeeps.length; ++i){
      if(toFind == myPeeps[i].getColor())
  //if toFind matches color in array, then the corresponding Person object is printed
         System.out.println(myPeeps[i].toString() + "\n");
 
   }


}

}