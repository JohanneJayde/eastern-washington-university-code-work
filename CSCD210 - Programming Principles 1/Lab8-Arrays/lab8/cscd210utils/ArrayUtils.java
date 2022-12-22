package lab8.cscd210utils;

import java.util.Scanner;

/**
 * The ArrayUtils class performs basic array functions, such as adding an item to the array
 * removing items from the array, printing the arrays.<br>
 * NOTE: All parameters will be passed as final and all preconditions
 * will be enforced.
 */
public class ArrayUtils
{
   /**
    * The createAndFillArray method creates the integer array of size num and then fills the array by 
    * asking the user to enter an integer.
    *
    * @param num Representing the size of the array to create
    * @param kb Representing the Scanner object to the keyboard
    * @return int[] Representing created array that if filled with integ                                                                                     u8rs
    *
    * @throws IllegalArgumentException if num is less than or equal to 0
    * @throws IllegalArgumentException if kb is null
    */
   public static int [] createAndFillArray(final int num, final Scanner kb)
   {
   if(kb == null)
      throw new IllegalArgumentException("kb is null in createAndFillArray");
   if(num <= 0)
      throw new IllegalArgumentException("num is less than or equal to zero");

   int userArray[];
   int i = 0;
   userArray = new int[num];
   
   for(; i <= userArray.length - 1; i++) {
      System.out.print("Please enter an integer: ");
      int arrayElement = Integer.parseInt(kb.nextLine());
      userArray[i] = arrayElement;
      
   }
   
      return userArray;
   }// end method

   /**
    * The addNum method makes a new array that is one more in length the old array which is passed in.
    * The method then copies the values from the old array (index by index) and places the values in the new array.
    * Finally the user is prompted to enter a value and that value is placed within the new array in the last index.
    *
    * @param myArray Representing the old array of integers that will be copied.
    * @param kb Representing the Scanner object to the keyboard
    * @return int[] Representing the new array with a value added
    *
    * @throws IllegalArgumentException if kb is null
    * @throws IllegalArgumentException if myArray is null
    * @throws IllegalArgumentException if the length of myArray is less than or equal to zero
    */
   public static int [] addNum(final int [] myArray, final Scanner kb)
   {
   if(kb == null)
      throw new IllegalArgumentException("kb is null in addNum");
   if(myArray == null)
      throw new IllegalArgumentException("myArray is null");
   if(myArray.length <= 0)
      throw new IllegalArgumentException("myArray length is less than or equal to 0");
      
   int newArray[];
   int j = 0;
   newArray = new int[myArray.length + 1];
   
   for(; j < (newArray.length - 1); ++j) {
     newArray[j] = myArray[j];   
   }
   
   System.out.print("Please enter the new element for array: ");
   newArray[newArray.length - 1] = Integer.parseInt(kb.nextLine());
  
      
      return newArray;
      
   }// end method

   /**
    * The deleteValue method first prompts the user to enter a value that should be deleted.<br>
    * Next the method searches through the array to determine if that value was in the array.<br>
    * If the value is not in the array, a message "Value NOT found" is displayed and the old array is returned.<br>
    * If the value is found a new array is made with the length being one less than the old array being passed in.<br>
    * Next the values are copied over except the value that will be deleted.<br>
    * Finally the new array is returned<br>
    *
    * @param myArray Representing the old array of integers
    * @param kb Representing the Scanner object to the keyboard
    * @return int[] Representing the new/old array
    *
    * @throws IllegalArgumentException if kb is null
    * @throws IllegalArgumentException if myArray is null
    * @throws IllegalArgumentException if the length of myArray is less than or equal to zero
    */
   public static int [] deleteValue(final int [] myArray, final Scanner kb)
   {
   if(kb == null)
      throw new IllegalArgumentException("kb is null in deleteValue");
   if(myArray == null)
      throw new IllegalArgumentException("myArray is null");
   if(myArray.length <= 0)
      throw new IllegalArgumentException("myArray length is less than or equal to 0");
      
   int j = 0;
   int n = 0;
   boolean numExists = true;
   boolean skipValue = true;
   int newArray[];
   System.out.print("Please enter the number you want to be removed from the array: ");
   int numRemove = Integer.parseInt(kb.nextLine());
         
   for(; j <= (myArray.length - 1); j++) {   
      if(myArray[j] == numRemove) {
         numExists = false;
         break;
     }
      else {
         numExists = true;    
         }
   }
   if(numExists == true) {
   System.out.println("Value NOT found");
      return myArray;
   }
   else {
   newArray = new int[(myArray.length - 1)];  
   for(; n < (newArray.length); ++n) {
     if(myArray[n] == numRemove) {
        newArray[n] = myArray[n + 1];  
        skipValue = false;  
        continue;         
     }
     if(skipValue == false) {
         newArray[n] = myArray[n + 1];   
     }
     else {
         newArray[n] = myArray[n];  
     }
   }  
   return newArray;
      }
 
   }// end method

   /**
    * The deleteValueByIndex method first prompts the user to enter an index and ensures the index is between 0 and the length of the 
    * old array minus 1.<br>
    * A new array is made with the length being one less than the old array being passed in.<br>
    * Next the values are copied over except the value at the index that will be deleted.<br>
    * Finally the new array is returned<br>
    *
    * @param myArray Representing the old array of integers
    * @param kb Representing the Scanner object to the keyboard
    * @return int[] Representing the new array with that is one less in length than the old array passed in 
    *
    * @throws IllegalArgumentException if kb is null
    * @throws IllegalArgumentException if myArray is null
    * @throws IllegalArgumentException if the length of myArray is less than or equal to zero
    */
   public static int [] deleteValueByIndex(final int [] myArray, final Scanner kb)
   {
   if(kb == null)
      throw new IllegalArgumentException("kb is null in deleteValueByIndex");
   if(myArray == null)
      throw new IllegalArgumentException("myArray is null");
   if(myArray.length <= 0)
      throw new IllegalArgumentException("myArray length is less than or equal to 0");
   
    
   int n = 0;
   int indexRemove;
   int newArray[];
   boolean skipIndex = true;
   
   do{
   System.out.print("Please enter the index number that you want to delete: ");
   indexRemove = Integer.parseInt(kb.nextLine());         
   
   }while(indexRemove > (myArray.length - 1) || indexRemove < 0);
    
   newArray = new int[(myArray.length - 1)];  
   for(; n < (newArray.length); ++n) {
     if(n == indexRemove) { 
        skipIndex = false;
        newArray[n] = myArray[n + 1]; 
        continue;         
     }
     else {
     if(skipIndex == false) {
         newArray[n] = myArray[n + 1];  
          
         } 
     else{
         newArray[n] = myArray[n];  
     }
    }
   }   
   return newArray;

   }

   /**
    * The printArray method prints the array in the following fashion<br>
    * [value, value, value, ..., value]
    *
    * @param myArray Representing the array of integers to be printed
    *
    * @throws IllegalArgumentException if myArray is null
    * @throws IllegalArgumentException if the length of myArray is less than or equal to zero
    */
   public static void printArray(final int [] myArray)
   {
   int i = 0;
   System.out.print("[");
   
   for(; i < myArray.length - 1; ++i)
      System.out.print(myArray[i] + ", ");
      
   System.out.print(myArray[i]);
   System.out.print("]\n");
   
   } // end printArray

}// end class