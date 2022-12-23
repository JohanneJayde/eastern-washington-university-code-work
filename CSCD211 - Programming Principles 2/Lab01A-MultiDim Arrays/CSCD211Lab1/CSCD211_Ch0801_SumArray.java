
/*
Johanne McClenahan - CSCD211 Lab01 from Ch08 Section01 - SumArray

Objective of Program: 
1. Write a method that returns the sum of all the elements in a specified column in a m(Sum
   elements column by column) matrix.
2. Method header must be: public static double sumColumn(double[][] m, int columnIndex).
3. Read a 3-by-4 matrix row by row entered by the user's keyboard.
4. Display the sum of each column in the format: "Sum of the elements at column [column#] is [column sum].
*/

//import scanner class to be used for inputing values (numbers in this case) to the program via keyboard)
import java.util.Scanner;

public class CSCD211_Ch0801_SumArray {
//main method
   public static void main(String[] args) {
//define kb (keyboard) scanner object to accept inputs from user keyboard
   Scanner kb = new Scanner(System.in);
//define columnIndex which indicates which array column is being tracked
   int columnIndex = 0;
//define doubleArray which is a 3 row by 4 column matrix which holds 12 elements
   double [][] doubleArray = new double[3][4];
//prompts the user to input four numbers (integer or decimals) with spaces three times, each set seperated by the Enter key
   System.out.println("Enter a 3-by-4 matrix row by row: ");

//takes each set of the user's four numbers and adds them into the three rows of doubleArray
   for(int i = 0; i < doubleArray.length; i++) {
      for(int j = 0; j < doubleArray[i].length; j++) {
         doubleArray[i][j] = kb.nextDouble();
         }
      }
//displays the sum of each column to the user along with the number column
     for(int j = 0; j < doubleArray[1].length; j++) {
            System.out.println("Sum of the elements at column " + j + " is " + sumColumn(doubleArray, j));       
     }
   }
//method used to calculate the sum of each column
public static double sumColumn(double [][] m, int columnIndex) {
//define totalSum that is the total of all the elements in each column of the given matrix
   double totalSum = 0;
//loop cycles through each column and adds each element of a given column into the totalSum variable
   for(int num = 0; num < m.length; num++) {
      totalSum = m[num][columnIndex] + totalSum;
   }
//returns totalSum to where the method was called so it can be displayed to the user
      return totalSum;
      }

}