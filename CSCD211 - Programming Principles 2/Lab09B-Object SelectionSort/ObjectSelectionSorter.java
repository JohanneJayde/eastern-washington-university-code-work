/**s
Name: Johanne McClenahan
Class: CSCD211
Description:

   The ObjectSelectionSorter class provides a public static
   method for performing a selection sort on an array of
   objects that implement the Comparable interface.
*/

public class ObjectSelectionSorter
{

   /**
      The selectionSort method performs a selection sort on an
      array of objects that implement the Comparable interface.
      @param array The array to sort.
   */

   public static void selectionSort(Comparable[] array)
   {
      int startScan;       // Starting position of the scan
      int index;           // To hold a subscript value
      int minIndex;        // Element with smallest value in the scan
      Comparable minValue; // The smallest value found in the scan

      // The outer loop iterates once for each element in the
      // array. The startScan variable marks the position where
      // the scan should begin.
      // for-loop is used to iterate through the array, and checks each index one by one to see if its the minimum value
      for(startScan = 0; startScan < array.length; startScan++)
      {
            
         // Assume the first element in the scannable area
         // is the smallest value.
         // minIndex is set to startScan since each iteration, the minIndex is assured to be smallest value that isn't already sorted
         minIndex = startScan;
         
         
                  
         // Scan the array, starting at the 2nd element in
         // the scannable area. We are looking for the smallest
         // value in the scannable area. 
         for(index = startScan + 1; index < array.length; index++)
         {
            // if-statement along with compareTo method to check if the element one ahead of the startScan index is larger or smaller
            // if the value is bigger, minIndex will get the index of the element smaller than the element at index minIndex
            if(array[index].compareTo(array[minIndex]) < 0)
           {
            minIndex = index;
           }
         }

         // Swap the element with the smallest value 
         // with the first element in the scannable area.
         // temp is used to store the element at the minIndex (the smallest value)
              Comparable temp = array[minIndex];
         // element at index minIndex is then swapped to the element at index startScan
              array[minIndex] = array[startScan];
         // element at index startScan is set to temp to complete swap
              array[startScan] = temp;
        
        
              }
   }
}