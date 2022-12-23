package lab5.cscd211methods;

import java.util.Scanner;

/**
Name: Johanne McClenhan
Class: CSCD211
Description: basic methods used for inputing values for LinkedList methods along with menu method
 * Some basic methods we will need to use in conjunction with the LinkedList class
 * @NOTE All parameters will be final and all preconditions met
 */
public class CSCD211Lab5LinkedListMethods
{
   /**
    * menu method for testing your linked list
    * <br>  1) Print the List
    * <br>  2) addFirst
    * <br>  3) addLast
    * <br>  4) read and index and add at the index
    * <br>  5) Check the list to see if the list contains the item
    * <br>  6) Find the indexOf the item
    * <br>  7) removeFirst
    * <br>  8) removeLast
    * <br>  9) Read index remove Node at that index
    * <br> 10) removeFirstOccurrence of that item
    * <br> 11) removeLastOccurrence of that item
    * <br> 12) clear the list
    * <br> 13) Print the size of the list
    * <br> 14) Quit
    * <br> You must ensure the value entered in within range
    *
    * @param kb Representing the Scanner Object
    * @return int  - The choice guaranteed by you to be between 1 and 14 inclusive
    *
    * @throws IllegalArgumentException if kb is null
    * @NOTE The input buffer will be left clean
    */
   public static int menu(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("kb is null");
   //stores menu choice as int
      int choice;
   //do-while loop ensures user choice is within range of menu options and redisplays if menu choice isn't valid   
   do{
      System.out.println("1) Print the List\n" +
                      "2) addFirst\n" +
                      "3) addLast\n" +
                      "4) read and index and add at the index\n" +
                      "5) Check the list to see if the list contains the item\n" +
                      "6) Find the indexOf the item\n" +
                      "7) removeFirst\n" +
                      "8) removeLast\n" +
                      "9) Read index remove Node at that index\n" +
                      "10) removeFirstOccurrence of that item\n" +
                      "11) removeLastOccurrence of that item\n" +
                      "12) clear the list\n" +
                      "13) Print the size of the list\n" +
                      "14) Quit" );
      System.out.print("Please enter your choice within the range of the menu options: ");
      //choice is set to user input
      choice = Integer.parseInt(kb.nextLine());  
   }while(choice < 0 || choice > 14);
      //returns choice
	   return choice;      
   }
   
   /**
    * Prompts the user for a String and reads the String from the keyboard
    *
    * @param kb The Scanner object
    * @return String The String read from the keyboard
    *
    * @throws IllegalArgumentException if kb is null
    * @NOTE The input buffer will be left clean
    */
   public static String buildAString(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("kb is null");
   //userString stores the user's inputed string
      String userString;
   //prompt the user to input a string and set userString to that string
      System.out.print("Please enter a string: ");
      userString = kb.nextLine();
   //returns String
      return userString;
   }
   
   
   /**
    * readIndex reads a value greater than -1
    *
    * @param kb The Scanner object
    * @return int - The index will be guaranteed by you to be greater than -1
    *
    * @throws IllegalArgumentException if kb is null
    * @NOTE The input buffer will be left clean
    */
   public static int readIndex(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("kb is null");
   //stores index the user chooses
      int index;
   //do-while ensures that index will be greater than -1
      do{
      System.out.print("Please enter an index value greater than -1: ");
      index = Integer.parseInt(kb.nextLine());
      }while(index < 0);
   //returns index
      return index;
   }
   
   

}