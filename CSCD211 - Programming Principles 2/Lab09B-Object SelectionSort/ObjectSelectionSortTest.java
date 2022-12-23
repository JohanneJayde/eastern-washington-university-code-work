/**
Name: Johanne McClenahan
Class: CSCD211
Description:

   This program tests the selectionSort method in the
   ObjectSelectionSorter class.
*/


public class ObjectSelectionSortTest {

   public static void main(String[] args) {
   
      // Create a String array with test values.
      // Note that String implements Comparable.
      
      // array stores String values made to show selectionSort method in use
      String [] array = new String[]{"Abby", "Johnny", "Melonie", "Todd", "Sky", "Sidney", "Jackson", "Matthew", "Luke"};
     
           
      // Display the array's contents.
      // using an enhanced-for-loop to print out the contents of array before being sorted
      System.out.println("Original order:");
      for(String s : array){
         System.out.print(s + " ");
      }
      
      // printing out new line character in order to separate displaying array before and after sorting
      System.out.println(); 
           
      // Sort the array.
      
      // Calling the selectionSort method with array as parameter
      ObjectSelectionSorter.selectionSort(array);
      
      
      // Display the array's contents.
      // using an enhanced-for-loop to print out the contents of array after being sorted
      System.out.println("Sorted order:");
      for(String s : array){
         System.out.print(s + " ");
      }
        
   }
}