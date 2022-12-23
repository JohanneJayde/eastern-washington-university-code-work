package lab4.cscd211methods;

import java.util.Scanner;

/**
 * Some basic methods we will need to use in conjunction with the LinkedList class
 * NOTE all parameters will be final and all preconditions will be enforced
 */
public class LinkedListMethods
{
   /**
    * menu method for testing your linked list
    * <br>  1) Print the List
    * <br>  2) Append the specified element to the end of this list.
    * <br>  3) addAll(index, array)
    * <br>  4) Read an index and get the data at that index
    * <br>  5) getLast
    * <br>  6) remove
    * <br>  7) removeIndex
    * <br>  8) removeLast
    * <br>  9) toArray
    * <br> 10) removeAllOccurrences
    * <br> 11) clear the list
    * <br> 12) Quit
    * <br> You must ensure the value entered is within range
    *
    * @param kb Representing the Scanner Object
    * @return int The choice
    *
    * @throws IllegalArgumentException if kb is null
    * @NOTE The input buffer will be left empty
    */
   public static int menu(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("bad params. kb is null in menu method");
   //choice stores the user's choice entered from the keyboard as a integer value
      int choice;
   //do-while loop is used to display the menu. if the user picks a choice that isn't within range of menu, the user will be re prompted to enter a choice
   do{
      System.out.println("1) Print the List\n" +
                       "2) Append the specified element to the end of this list\n" +
                       "3) addAll(index, array)\n" +
                       "4) Read an index and get the data at that index\n" +
                       "5) getLast\n" +
                       "6) remove\n" +
                       "7) removeIndex\n" +
                       "8) removeLast\n" +
                       "9) toArray\n" +
                       "10) removeAllOccurrences\n" +
                       "11) clear the list\n" +
                       "12) Quit\n"
                       );
      System.out.print("Please enter a choice within the range of the menu: ");
    //user is prompt2ed to input choice using keyboard. parseInt is used to ensure the input buffer is cleared
      choice = Integer.parseInt(kb.nextLine());
    }while(choice < 0 || choice > 12);
    //returns choice to where the menu method was called
      return choice;
   }// end menu
   
      
   /**
    * readIndex reads a value greater than -1
    *
    * @param kb The Scanner object
    * @return int The index
    *
    * @throws IllegalArgumentException if kb is null
    * @NOTE The input buffer will be left empty
    */
   public static int readIndex(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("bad params. kb is null in the readIndex method");
   //index stores the index that the user inputs from the keyboard as an integer value
      int index;
   //do-while loop is used to prompt the user to input an integer value. if the value is not greater than or equal to 0, the user will be re prompted to input a value
      do{
      System.out.print("Please enter an integer greater or equal to 0: ");
  //parseInt is used to ensure the input buffer is empty
         index = Integer.parseInt(kb.nextLine());
      }while(index < 0);
   //returns index to where the readIndex method was called
      return index;
   }// end readIndex
   
   /** 
    * Fill the array fills the passed in array with Integers by prompting
    * the user to enter an int and then building an Integer
    *
    * @param kb Representing the Scanner
    * @param array Representing an array of Integers
    *
    * @throws IllegalArgumentException if total less than 1 or kb is null
    * @NOTE The input buffer will be left empty
    */
   public static void fillArray(final Scanner kb, final Integer [] array)
   {
      if(kb == null)
         throw new IllegalArgumentException("bad params. kb is null in fillArray method");
   //for-loop is used to prompt the user to input value for each array element. Loop iteration is based on the length of the array
      for(int i = 0; i < array.length; i++){
   //calls the createInteger method for user to input values for each array element
         array[i] = createInteger(kb);
         
         }
      
      
   }// end fillArray
   
   
   /**
    * This method prompts the user for an int and builds and returns an Integer with
    * that value
    * @param kb Representing the Scanner to the keyboard
    * @return Integer Representing the desired entered value by the user
    * 
    * @throws IllegalArgumentException if kb is null
    * @NOTE The input buffer will be left empty
    */
   public static Integer createInteger(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("bad params. kb is null in createInteger method");
   //integerPrimative stores the user's input from the keyboard as a int value
      int integerPrimative;
   //prompts the user to input an integer value
      System.out.print("Please enter an integer value: ");
      integerPrimative = Integer.parseInt(kb.nextLine());
  //assigns the int value (integerPrimative) to an Integer object (intObj)
      Integer intObj = integerPrimative;
      
  //returns intObj where the method was called
      return intObj;   
   }// end createInteger
   
   
   /** 
    * Fill the array creates an array of Integers and fills the array with
    * values entered by the user.
    *
    * @param kb Representing the Scanner
    * @param total Representing the total size of the array to make
    * 
    * @return Integer[] The array of Integers
    *
    * @throws IllegalArgumentException if total less than 1 or kb is null
    * @NOTE The input buffer will be left empty
    */   
   public static Integer[] fillArray(final Scanner kb, final int total)
   {
      if(total < 1)
         throw new IllegalArgumentException("bad params. total is less than 1 in fillArray method");
      if(kb == null)
         throw new IllegalArgumentException("bad params. kb is null in fillArray method");
   //creates array that stores Integer objects named array. Array length is determined by total param passed in
      Integer [] array = new Integer[total];
   //for-loop is used to prompt the user to input values to fill each array element. loop iteration is based on total parameter
      for(int i = 0; i < total; i++){
      //calls the createInteger method for user to input values for each array element
         array[i] = createInteger(kb);
         
         }
   //returns the array to where the method was called
      return array;
   }// end fillArray
   
}// end class