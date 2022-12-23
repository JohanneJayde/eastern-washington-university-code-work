/*
Student Name: Johanne McClenahan
Class: CSCD211
Date: December 04, 2020

Description of program:  Enter a number of array elements and find the largest number.

*/

import java.util.Scanner;
public class RecursionLargestInArray 
{ 
public static void main (String[] args) 
{ 
    //int max stores the -999 to ensure that the method starts and represent the max value of the array
    int max = -999; 
    //scan is a Scanner object used so that the user can input values from the keyboard
    Scanner scan = new Scanner (System.in); 
    //prompt the user to enter the size of their array
    System.out.print("Enter the size of the array: "); 
    //arraySize is used to store the user's chosen array size
    //Integer.parseInt() is used to ensure a clear input buffer
    int arraySize = Integer.parseInt(scan.nextLine());
    System.out.println();
    //myArray is an array that has its size determined by arraySize variable. Stores int values
    int[] myArray = new int[arraySize]; 
    //prompt the user to enter in the number of integers based on their array size
    System.out.print("Enter the " + arraySize + " values of the array: "); 
    System.out.println();
    //for-loop is used to have them enter in their chosen int values for myArray
    //loop's number of iterations is based off myArray's length
    for (int i = 0; i < myArray.length; i++) {
    	int numValue = i + 1;
    	System.out.print("Enter value number " + numValue + " of the array: ");
        //Integer.parseInt() is used to ensure a clear input buffer
        //user enters int values from the keyboard and they are assigned to each array element
        myArray[i] = Integer.parseInt(scan.nextLine());

    }
        
    //for-loop prints each array element line by line
    //loop's number of iterations is based off myArray's length     
    for (int i = 0; i < myArray.length; i++) 
        System.out.println(myArray[i]);
    //display the results of calling getLargest() method   
    //myArray and max are passed in as arguments to getLargest() method  
        System.out.println("In the array entered, the larget value is " + getLargest(myArray, max) + "."); 
} 

//getLargest() is a method used to find the largest value in a given int array using recursion
//returns an int value and takes in an int array and int value as parameters
public static int getLargest(int[] myArray, int max) 
{     
    //initializing variables
    int i = 0, j = 0, tempmax = 0; 
    //if-statement checks if myArray.legnth is 1, which means that either the max has been located or that the max is the only element in the array
    if (myArray.length == 1) 
    { 
    //if-else statement checks whether or not the last element is larger than max
      if(myArray[0] > max)
         return myArray[0];
      else
         return max;
    } 
    //else-statement used to check whether a given element of myArray[i] is greater than max parameter
    else if (max < myArray[i]) 
    { 
        //max is set to myArray[i] because above statement proves it is larger than original max value
        max = myArray[i];
        //new tempArray is created in order to setup recursion
        //tempArray's size is one less because each method call checks, one element, meaning we don't have to use it anymore
        int[] tempArray = new int[myArray.length-1];
        //for-loop copies myArray into tempArray besides the first element, as it as already been checked in above else-if statement
        for (i = 1; i < myArray.length; i++) 
        { 
            tempArray[i - 1] = myArray[i];
        } 
        //tempmax = getLagest(tempArray. max) allows to call the getLargest(tempArray, max) with tempArray and new max value
        //this means that the next element of myArray will be checked against the new max
        tempmax = getLargest(tempArray, max); 
        //returns tempmax when it after the getLarges() method has found its largest value
        return tempmax; 
    } 
    //else-statement if myArray[i] is not greater than max
    else
    { 
        //tempArray's size is one less because each method call checks, one element, meaning we don't have to use it anymore
        int[] tempArray = new int[myArray.length-1]; 
        //for-loop copies myArray into tempArray besides the first element, as it as already been checked in above else-if statement
        for (i = 1; i < myArray.length; i++) 
        { 
            tempArray[i - 1] = myArray[i];
        } 
        //tempmax = getLagest(tempArray. max) allows to call the getLargest(tempArray, max) with tempArray and new max value
        //this means that the next element of myArray will be checked against the new max
        tempmax = getLargest(tempArray, max);
        //returns tempmax when it after the getLarges() method has found its largest value
        return tempmax;
    } 
} 
}