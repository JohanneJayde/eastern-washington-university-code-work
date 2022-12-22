package lab12.cscd210methods;

import java.io.*;
import java.util.*;
import lab12.cscd210classes.Fish;

public class CSCD210Lab12Methods
{
   /**
    * The fillArray method reads two lines from the file and creates a Fish object and 
    * then puts that Fish object into the array.
    *
    * @param fin Representing the Scanner object to the file
    * @param total Representing the number of fish in the array
    * @return Fish array
    *
    * @throws IllegalArgumentException if fin is null or total is less than 1
    */    
   public static Fish[] fillArray(final Scanner fin, final int total)
   {
   if(fin == null)
      throw new IllegalArgumentException("fin is null in the fillArray method");
   if(total < 1)
      throw new IllegalArgumentException("total is less than 1 in the fillArray method");
   
   Fish array [] = new Fish[total];
   for(int x = 0; x < array.length; ++x) {
      String species = fin.nextLine();
      double weight = Double.parseDouble(fin.nextLine());
      
      array[x] = new Fish(species, weight);
      
    }
    
      return array;
   }// end fillArray
   
   
   /**
    * The printArray utilizes the enhanced for loop to print each fish to the PrintStream
    * output. One fish per line is printed.
    *
    * @param array Representing the array of Fish
    * @param output Representing the PrintStream to the file or the screen
    *
    * @throws IllegalArgumentException if array is null or array length is 0 or output is null
    */
   public static void printArray(final Fish [] array, final PrintStream output)
   {
   if(array == null)
      throw new IllegalArgumentException("array is null in the printArray method");
   if(array.length == 0)
      throw new IllegalArgumentException("array length is 0 in the printArray method");
   if(output == null)
      throw new IllegalArgumentException("(PrintStream) output is null in the printArray method");
   
   for(Fish type: array)
      output.println(type + "\n");
    
  
   }// end printArray
   
   
   /**
    * readIndex prompts the user to enter a number between the two numbers passed in inclusive.  
    * You must ensure the number entered is within range.
    *
    * @param low Representing the bottom number of the range 
    * @param high Representing the top number of the range
    * @param kb Representing the Scanner object to the keyboard
    * @return int Representing a number in range inclusive between low and high
    *
    * @throws IllegalArgumentException if low is less than 0 or high is less than 0 or high is less than low or 
    * if kb is null
    */
   public static int readIndex(final int low, final int high, final Scanner kb)
   {
   if(low < 0 || high < 0)
      throw new IllegalArgumentException("high and/or low is less than zero in the readIndex method");
   if(high < low)
      throw new IllegalArgumentException("high is less than low in the readIndexMethod");
   
   int input;
   do{
   
   System.out.printf("Enter a number that is in the range of %d - %d: ", low, high);
   input = Integer.parseInt(kb.nextLine());
   
   }while(input < low && input > high);
   
      return input;
   }// end readIndex
   
   
   /**
    * Menu choices are provided by me below
    *
    * @param kb Representing the Scanner object to the keyboard
    * @return int Representing a menu choice in range from 1 to 4 inclusive
    *
    * @throws IllegalArgumentException if kb is null
    */
   public static int menu(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("Bad Params menu");
         
      int choice;
      do
      {
         System.out.println("Please choose from the following");
         System.out.println("1) Print the array to the screen");
         System.out.println("2) Print the array to the specified file");
         System.out.println("3) Read an index and compare the two fish for equality");
         System.out.println("4) Quit");
         System.out.print("Choice --> ");
         choice = Integer.parseInt(kb.nextLine());      
      
      }while(choice < 1 || choice > 4);
      
      return choice;
   
   }// end menu


}// end class