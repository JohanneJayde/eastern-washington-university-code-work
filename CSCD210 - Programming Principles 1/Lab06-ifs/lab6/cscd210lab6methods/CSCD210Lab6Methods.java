package lab6.cscd210lab6methods;

import java.util.Scanner;

/**
 * The methods class for Lab 6.<br>
 * @NOTE All parameters will be passed as final all preconditions and postconditions will be met<br>
 * You must have at least 5 output runs saved in a file named cscd210lab6out.txt<br> 
 * Zip your Lab6-ifs folder and name the zip file your last name first letter of first name
 * lab6.zip (example steinerslab6.zip)<br>
 */
public class CSCD210Lab6Methods
{
   
   /**
    * The readPosNum method prompts the user for a positive number that is greater than 0.
    * If the number entered is not greater than 0 then a RuntimeException is thrown
    *     
    * @param kb Representing the Scanner to the keyboard
    * @return int Representing the positive number 
    *
    * @throws IllegalArgumentException if the Scanner is null
    * @throws RuntimeException if the number entered is not greater than 0
    * @NOTE The input buffer will be left cleared before leaving the method
    */
   public static int readPosNum(final Scanner kb)
   {
   if(kb == null)
      throw new IllegalArgumentException("kb is null in readPosNum");

   System.out.print("Please enter a number greater than 0: ");
   int numPos = kb.nextInt();
   kb.nextLine();
   
   if(numPos <= 0)
      throw new RuntimeException("number is not greater than 0");  
   else
      return numPos;
   }// end readPosNum
   
   
   /**
    * The stringOrder method prompts the user for string of 4 characters or more.
    * If the string entered is not greater than 4 characters then a RuntimeException is thrown
    * Once two strings of length 4 or more are entered print out the alphabetical order of the 
    * strings.  Case is sensitive
    *     
    * @param kb Representing the Scanner to the keyboard
    *
    * @throws IllegalArgumentException if the Scanner is null
    * @throws RuntimeException if the string is not 4 characters
    * @NOTE The input buffer will be left cleared before leaving the method
    */
   public static void stringOrder(final Scanner kb)
   {
   if(kb == null)
   throw new IllegalArgumentException("kb is null in stringOrder");
   
   System.out.print("Please enter a string of four characters or more: ");
   String string1 = kb.nextLine();     
   System.out.print("Please enter another string of four characters or more: ");
   String string2 = kb.nextLine();
      
   if(string1.length() < 4 || string2.length() < 4)
      throw new RuntimeException("One of the strings entered is less than 4 characters.");
   else
      if(string1.compareTo(string2) < 0)
         System.out.println(string1 + ", " + string2);
      else
         System.out.println(string2 + ", " + string1);
   }// end readPosNum
   
   /**
    * The menu method prompts the user for a menu choice. 
    * Happy Stuland guarantees the number is between 1 to 3 inclusive.
    * <br>
    *
    * Menu choices are:<br>
    * 1) Enter a new number<br>
    * 2) Print if the number is even/odd/zero<br>
    * 3) Enter two strings and determine the strings order
    * 4) Quit<br>
    * <br>  
    *
    * @param kb Representing the Scanner to the keyboard
    * @return int Representing the menu choice 
    *
    * @NOTE The input buffer will be left cleared before leaving the method <br>
    * @throws IllegalArgumentException if the Scanner is null
    */
   public static int menu(final Scanner kb)
   {
   if(kb == null)
      throw new IllegalArgumentException("kb is null in menu");
   
   int choice = Integer.parseInt(kb.nextLine());
      
   do {
   System.out.println("Menu choices are:    ");
   System.out.println("1) Enter a new number");
   System.out.println("2) Print if the number is even/odd/zero");
   System.out.println("3) Enter two strings and determine the strings order");
   System.out.println("4) Quit");
   System.out.print("Choice ---> ");
  
   
  }while(choice > 5 || choice < 0);
  
         return choice;
      
   }


   /**3
    * The oddEvenZero method reports if the number is even or odd or zero.  
    *
    * @param theNum Representing a positive number &gt; 0
    *
    * @throws IllegalArgumentException if the number is &lt; 1
    */
   public static void oddEvenZero(final int theNum)
   {
   if(theNum < 1)
      throw new IllegalArgumentException("number is less than 1");
      if(theNum == 0) {
         System.out.println("the number is zero");
      }
      else if(theNum % 2 == 0) {
         System.out.println("the number is even");
      } 
      else
         System.out.println("the number is odd");

   }


  
}// end class