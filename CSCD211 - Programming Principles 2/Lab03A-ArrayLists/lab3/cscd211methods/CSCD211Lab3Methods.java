package lab3.cscd211methods;

import java.util.*;

/**
 * The methods class for the Lab 3 methods that you must write<br>
 * This methods class contains methods for working with ArrayLists.
 * @NOTE you will need to use Double.valueOf at key places you will lose massive points
 * if the compiler displays<br>
 * Note: lab3/cscd211methods/CSCD211Lab3Methods.java uses or overrides a deprecated API.<br>
 * Note: Recompile with -Xlint:deprecation for details.
 */
public class CSCD211Lab3Methods
{   
   /**
    * The addNum method prompts the user to enter a number that
    * is between 0 and 100 inclusive.  The method ensures the number is between 0 and
    * 100 inclusive.  Once a proper number is received that number is added to the ArrayList
    *
    * @param myAList Representing the array list
    * @param kb - Representing the Scanner Object
    * @post. The ArrayList will be modified in place and trimmed to size
    *
    * @throws IllegalArgumentException if the Scanner object or the array list is null
    */
   public static void addNum(final ArrayList<Double> myAList, final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("bad params. Scanner object is null in addNum method");
      if(myAList == null)
         throw new IllegalArgumentException("bad params. myAList is null in empty in addNum method");
         
   //numChoice stores the double value of the number that the user would like to add to myAlist
         double numChoice;
   //do-while loop is used to ensure that the user inputs a value that is in between 0 and 100 inclusive
         do{
           //prompts the user to input value and stores that input into numChoice
            System.out.print("Please enter a number between 0 and 100: ");
               numChoice = Double.parseDouble(kb.nextLine());
         
         }while(numChoice > 100 && numChoice < 0);
   //appends the existing myAList array by adding numChoice to the end of list
         myAList.add(numChoice);
   //ensures that myAList is trimmed to size so that it contains no empty slots
         myAList.trimToSize();
         
   }// end addNum
   
   /**
    * The computeMean calculates the mean value of the array list.
    * The mean is average of the values in the array. Total the array list of numbers.
    * Divide by the size. You cannot produce a mean from an empty array list
    *
    * @param myAList Representing the array list
    * @return double - Representing the mean
    *
    * @throws IllegalArgumentException if the array list is null
    * @throws IllegalArgumentException if the array list size is 0
    */
   public static double computeMean(final ArrayList<Double> myAList)
   {
      if(myAList == null)
         throw new IllegalArgumentException("bad params. myAList is null");
      if(myAList.size() == 0)
         throw new IllegalArgumentException("bad params. myAList's size is 0");
   //myAListTotal stores the sum of the elements in myAList as a double value and is given 0 as the default value
      double myAListTotal = 0;
   //myAListMean stores the mean of myAList as a double value
      double myAListMean;
   //for-loop is used to iterate through myAList and add each element to the myAListTotal 
      for(int i = 0; i < myAList.size(); i++){
         myAListTotal = myAListTotal + myAList.get(i);
         
      }
   //calculate the mean of myAList by dividing myAListTotal by the size of the array and assign that value to myAListMean
      myAListMean = myAListTotal / myAList.size();
      
   //returns the mean to where the method is called
      return myAListMean;
   }
   
   /**
    * The computeMedian calculates the median value of the ArrayList.
    * The median is the middle value of a sorted ArrayList, 
    * you must first sort your array list from lowest value to highest.
    * The calculation for a median is different for an ArrayList of even length 
    * versus an array list of an odd size.

    * <br> An array list with an odd size. 
    * <br>Find the index of the middle element
    * <br>Compute middle index with size divided by 2. 
    * <br> The median would be the value at this array list index.<br>
    * <br>An ArrayList with an even size.
    * <br>There will be two middle values.
    * <br>Compute index #1 with array list length divided by 2.
    * <br>Compute index #2 with index #1 - 1.
    * <br>Get the values stored at index #1 and index #2.
    * <br>The median is the two values added together and divided by 2. 
    * (recall we are doing int arithmetic) Divide by the size.
    * @pre. You cannot produce a median from an empty array list
    *
    * @param myAList Representing the array list
    * @return double Representing the median
    *
    * @throws IllegalArgumentException if the array list is null
    * @throws IllegalArgumentException if the array list size is 0
    */
   public static double computeMedian(final ArrayList<Double> myAList)
   {
      if(myAList == null)
         throw new IllegalArgumentException("bad params. myAList is null");
      if(myAList.size() == 0)
         throw new IllegalArgumentException("bad params. myAList's size is 0");
   //median stores the median of myAList as a double value  
       double median;
   //sorting the myAList in ascending order using Collections.sort() method      
       Collections.sort(myAList);
   //using if statement to check whether or not myAList is even by seeing if the remainder of the size divided by 2 is 0
       if(myAList.size() % 2 == 0){
       //median get myAList two middle indexes added together and then divided by 2
       median = (myAList.get(myAList.size() / 2) + myAList.get((myAList.size() / 2) - 1)) / 2;
       //returns median to where the method was called
       return median;
       
       }
   //if myAList contains an odd amount of elements, median will get the middle index
       median = myAList.get(myAList.size() / 2);
   //returns median to where the method was called
      return median;
   }// end computeMedian
   
   /**
    * The computeMidpoint calculates the midpoint value of the ArrayList.
    * The midpoint is the mean of the smallest and largest values in your array list.
    * <br>Sort your array list in ascending order. 
    * <br>Retrieve the values from the beginning and end of the array list. 
    * <br>The midpoint is those two values added together and divided by 2. 
    * @pre. You cannot produce a midpoint from an empty array list
    *
    * @param myAList Representing the array list
    * @return double Representing the midpoint
    *
    * @throws IllegalArgumentException if the array list is null
    * @throws IllegalArgumentException if the array list size is 0
    */
   public static double computeMidpoint(final ArrayList<Double> myAList)
   {
      if(myAList == null)
         throw new IllegalArgumentException("bad params. myAList is null");
      if(myAList.size() == 0)
         throw new IllegalArgumentException("bad params. myAList's size is 0");
   //midpoint stores the midpoint of myAList as a double value      
         double midpoint;
   //sorting myAList in ascending order using Collections.sort() method
         Collections.sort(myAList);
   //calculate the midpoint of myAList by adding the first element to the last element and dividing that sum by 2
         midpoint = (myAList.get(0) + myAList.get(myAList.size() - 1)) / 2;
         
   //return midpoint to where the method was called
      return midpoint;
      
   }// end computeMidPoint
   
   /**
    * The computeStandardDeviation calculates the amount of variation form the average
    * <br>Compute the mean of the ArrayList
    * <br>Create a new ArrayList of deviations by subtracting the mean from each member from the original ArrayList.
    * <br>Square each member of the deviations ArrayList.
    * <br>Total those squared deviations.
    * <br>Divide by one less than the original ArrayList size. The standard deviation is the square root of this number.
     * @pre. You cannot produce a midpoint from an empty array list
    *
    * @param myAList Representing the array list
    * @return double - Representing the midpoint
    *
    * @throws IllegalArgumentException if the array list is null
    * @throws IllegalArgumentException if the array list size is 0
    */
   public static double computeStandardDeviation(final ArrayList<Double> myAList)
   {
      if(myAList == null)
         throw new IllegalArgumentException("Invalid Array List");            
      if(myAList.size() == 0)
         throw new IllegalArgumentException("Array List is Emtpy");
   //standardDevation stores myAList standard deviation as a double value
      double standardDeviation;
   //totalSum stores the sum of all the elements of arrayDeviations and has a default value of 0
      double totalSum = 0;
   //mean stores the mean of myAList that is calculated using computeMean() method 
      double mean = computeMean(myAList);
   //arrayDevations stores an myAList after each element has been altered
      ArrayList<Double> arrayDeviations = new ArrayList<Double>();
   //for-loop is used to:
   //1. add modified elements of myAList into arrayDeviations
   //2. total the elements of arrayDeviations and assign that sum to totalSum
      for(int i = 0; i < myAList.size(); i++){
      //each myAList element is squared using Math.pow(element, 2.0) and then added into arrayDeviations 
      arrayDeviations.add(Math.pow((myAList.get(i) - mean), 2.0));
      //each element of arrayDeviations is added into totalSum
      totalSum = totalSum + arrayDeviations.get(i);
      
      }
   //calculate the standard deviation of myAList by taking the square root of totalSum divided by myAList's size minus 1
      standardDeviation = Math.sqrt(totalSum / (myAList.size() - 1));
   //return standardDeviation to where the method was called
      return standardDeviation;
      
   }         
   
   /**
    * The deleteValue prompts the user for a value that may be in the array list
    * and removes the item from the array list.
    * The entered value must be between 0 and 100 inclusive
    * The removed item is printed to the screen or the value does not exist
    *
    * @param myAList Representing the array list
    * @param kb Representing the Scanner object
    * @post. The ArrayList will be modified in place and trimmed to size if the precondition was met
    * @pre. The ArrayList must contain at least 1 item for the list to be modified - If the ArrayList does not 
    * contain 1 item the ArrayList is not modified<br>
    * NOTE: You must use an if statement to enforce the precondition properly<br>
    * <br>if(myAList.size() = 0)<br>
    * return<br><br>
    * will earn 0 points for this method!
    *
    * @throws IllegalArgumentException if the array list or the Scanner is null
    * @throws IllegalArgumentException if the size of the array list is less than 1
    */
   public static void deleteValue(final ArrayList<Double> myAList, final Scanner kb)
   {
      if(myAList == null)
         throw new IllegalArgumentException("bad params. myAList is null in deleteValue method");
      if(myAList.size() < 1)
         throw new IllegalArgumentException("bad params. myAList is less than 1 in deleteValue method");
      if(kb == null)
         throw new IllegalArgumentException("bad params. kb is null in deleteValue method");
   //valueToFind stores the value that user wants to delete from myAList as a double value;
      double valueToFind;
   //do-while loop is used so that the user's input is ensured to be between 0 and 100 inclusive
      do{
         //prompt the user to enter a value that would like to delete from myAList
         System.out.print("Please enter a number between 0 and 100 to be deleted: ");
         valueToFind = Double.parseDouble(kb.nextLine()); 
      
      }while(valueToFind < 0 && valueToFind > 100);
   //for-loop is used to iterate through each of element of myAList to check whether any of them are equal to valueToFind
      for(int i = 0; i < myAList.size(); i++){
      //if an element is found to be equal to valueToFind, myAList is trimmed to correct size that is one less due to removal of one element
         if(myAList.get(i) == valueToFind){
            myAList.remove(i);
            myAList.trimToSize();
            }
      //if valueToFind is not found within a given element, the loop will not execute anything and move to the next element
      }
      //if valueToFind is not found within myAList, it will not be altered
           
   }// end deleteValue
   
   
   /**
    * The deleteValueByIndex prompts the user for an index value
    * and removes the item at that index from the array list.
    * The entered index must be between 0 and the list size - 1
    *
    * @param myAList Representing the array list
    * @param kb Representing the Scanner object
    * @post. The ArrayList will be modified in place and trimmed to size if the precondition was met
    * @pre. The ArrayList must contain at least 1 item for the list to be modified - If the ArrayList does not 
    * contain 1 item the ArrayList is not modified<br>
    * NOTE: You must use an if statement to enforce the precondition properly<br>
    * <br>if(myAList.size() = 0)<br>
    * return<br><br>
    * will earn 0 points for this method!
    *
    * @throws IllegalArgumentException if the array list or the Scanner is null
    * @throws IllegalArgumentException if the size of the array list is less than 1
    */
   public static void deleteValueByIndex(final ArrayList<Double> myAList, final Scanner kb)
   {
      if(myAList == null)
         throw new IllegalArgumentException("bad params. myAList is null in deleteValueByIndex method");
      if(myAList.size() < 1)
         throw new IllegalArgumentException("bad params. myAList is less than 1 in deleteValueByIndex method");
      if(kb == null)
         throw new IllegalArgumentException("bad params. kb is null in deleteValueByIndex method");
   //index stores the index that the user would like to remove as a integer value
         int index;
   //do-while loop ensure the index the user would like to remove is not less than 0 or larger that myAList's size
         do{
         //prompts the user to enter the index that they would like to removed from myAList
            System.out.print("Please enter an index of the value you want to delete within the list: ");
            index = Integer.parseInt(kb.nextLine());
         
         }while(index < 0 && index > myAList.size());
   //user's inputed index is removed from myAList using the remove() method
         myAList.remove(index);
   //myAList is trimmed to correct size that is one less due to removal of one element
         myAList.trimToSize();
         
      	  
   }// end deleteValueByIndex
   
   /**
    * The fillArrayList method fills the ArrayList with random Double values between
    * 0 and 100 inclusive or close enough to it. All random number generators return a value
    * between 0 and .99 inclusive.  Multiplying .99 * 100 gives 99.99 -- multiplying .99 * 101 gives 
    * 100.98 I call that close enough. You can either use Math.random or the Random class.
    *
    * @param size Representing the number of elements to fill the array list with
    * @param myAList Representing the array list
    * @post. The ArrayList will be modified in place and trimmed to size
    *
    * @throws IllegalArgumentException if the array list is null
    * @throws IllegalArgumentException if the size of the array list is less than 1
    */
   public static void fillArrayList(final int size, final ArrayList<Double> myAList)
   {
      if(myAList == null)
         throw new IllegalArgumentException("Invalid Array List");            
      if(size < 1)
         throw new IllegalArgumentException("Array List size is less than 1"); 
   //for-loop is used to populate myAList with random double values between 0 and 100.0
   //for-loop's number of iterations is based on size parameter
      for(int i = 0; i < size; i++){
      //Math.random() is used to generate random values from 0-1.0 and those values are multiplied by 100 to create random values from 0-100.0
         myAList.add(Math.random() * 100);
      
      }
        
   }// end fillArrayList
   
   /**
    * The menu method guarantees that a menu choice between 1 and 9 inclusive is entered. 
    * <br>The menu choices are:<br>
    * <br>1) Add a value to the ArrayList
    * <br>2) Delete a value from the ArrayList (by value)
    * <br>3) Delete a value from the ArrayList (by index/location)
    * <br>4) Display the ArrayList
    * <br>5) Compute the mean of the ArrayList
    * <br>6) Compute the median of the ArrayList
    * <br>7) Compute the midpoint of the ArrayList
    * <br>8) Compute the standard deviation of the ArrayList
    * <br>9) Quit
    * <br>
    * 
    * @param kb Representing the Scanner object to the keyboard
    * @return int - Representing the menu choice guaranteed by you the programmer to be between 1 and 9 inclusive
    * @throws IllegalArgumentException if the Scanner fin is null
    * @post. You must ensure the input buffer is empty at the end of the method. 
    */
   public static int menu(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("Error: Invalid Scanner");
   //num is used to store user's menu choice as an integer value and its default value is 0
      int num = 0;
   //do-while loop is used to ensure the user's input is within range of menu choices
      do
      {
      //displays menu choices to the user and prompts them to input a menu choice
         System.out.println("Enter a menu choice:"); 
         System.out.println("1) Add a value to the ArrayList");
         System.out.println("2) Delete a value from the ArrayList (by value)");
         System.out.println("3) Delete a value from the ArrayList (by index/location)");
         System.out.println("4) Display the ArrayList");
         System.out.println("5) Compute the mean of the ArrayList");
         System.out.println("6) Compute the median of the ArrayList");
         System.out.println("7) Compute the midpoint of the ArrayList");
         System.out.println("8) Compute the standard deviation of the ArrayList");
         System.out.println("9) Quit");
         System.out.print("Choice --> ");
         num = Integer.parseInt(kb.nextLine());
      }while(num < 1 || num > 9);
   //returns num to where the method was called
      return num;
      
   }// end method
   
   /**
    * The printArrayList prints the contents of the list out in the following
    * format [#, #, #] (This is the standard format when printing an ArrayList object)
    * or empty list if the list size is 0
    *
    * @param myAList Representing the array list
    *
    * @throws IllegalArgumentException if the array list is null
    */
   public static void printArrayList(final ArrayList<Double> myAList)
   {
      if(myAList == null)
         throw new IllegalArgumentException("bad params. myAList is null in printArrayList method");
   //myAList is printed to the user
      System.out.println(myAList);
      
   }// end printArrayList
   
   /**
    * The printResults prints the message and the results of the calculation.
    *
    * @param type Representing the String to be printed
    * @param value Representing the value to be printed 
    *
    * @throws IllegalArgumentException if the String is null
    * @throws IllegalArgumentException if the String is empty
    */
   public static void printResults(final String type, final double value)
   {
      if(type == null)
         throw new IllegalArgumentException("Invalid String");
      if(type.isEmpty())
         throw new IllegalArgumentException("String is empty");
   //prints the calculation type and the result of that calculation to the user
      System.out.println(type + ": " + value);
   }// end printResults
   
    
   /**
    * The readNum method prompts and ensures the user will enter a positive number that
    * is at least 1
    *
    * @param kb Representing the Scanner Object
    * @return int - Representing the entered numbered that will be greater than 0
    *
    * @throws IllegalArgumentException if the Scanner object is null
    */
   public static int readNum(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("Error: Invalid Scanner");
   //num stores the user's number they input as an integer value and the default value is 0
      int num = 0;
   //do-while loop ensures number is a positive number greater than 1
      do{
      //prompts the user to input an integer that is greater than 0
         System.out.print("Please enter a positive integer that is larger than 0: ");
         num = Integer.parseInt(kb.nextLine());
      
      
      }while(num < 0);
  //returns num to where the method was called
      return num;
   }// end readNum
   
}// end of class
   
