package lab9.cscd210methods;

import java.io.*;
import java.util.*;

/**
 * The methods class that you must write<br>
 */
public class CSCD210Lab9Methods
{     
   /**
    * The fillArray method reads the string from the file and puts it into
    * the array. You must first create an array of Strings before you can add
    * items into the array.  
    *
    * @param fin Representing the Scanner to an open file
    * @param total Representing the number of elements for the array
    * @return String [] - Representing the filled array
    *
    * @throws IllegalArgumentException if the Scanner object is null
    * @throws IllegalArgumentException if total is &lt;= 0
    */
   public static String [] fillArray(final Scanner fin, final int total)
   {
      if(fin == null)
         throw new IllegalArgumentException("kb is null in fillArray");
      if(total <= 0)
         throw new IllegalArgumentException("total is less than or equal to 0");
         
      String [] array = new String[total];
   
      for(int i = 0; i < array.length; ++i){
         array[i] = fin.nextLine();
      
      }
   
  
      return array;
   }// end total
   
   /**
    * The printArray method walks through the array and prints each
    * element out one per line. <br>
    * <br>NOTE: the method is passed a PrintStream object which could be the screen
    * System.out or a file
    *
    * @param words Representing the array of Strings
    * @param fout Representing the PrintStream object for the output
    *
    * @throws IllegalArgumentException if the array is null or the length is &lt;= 0
    * @throws IllegalArgumentException if the PrintStream object is null
    */
   public static void printArray(final String [] words, final PrintStream fout)
   {
   if(words == null || words.length <= 0)
      throw new IllegalArgumentException("array does not have contents that can be printed");
   if(fout == null)
      throw new IllegalArgumentException("PrintStream is null in printArray");
   
   for(String val:words)
      fout.println(val);
   
   
 
   }// end printArray

}// end class