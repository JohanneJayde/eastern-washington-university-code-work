package lab8.cscd210utils;

import lab8.cscd210utils.SortUtils;

/**
 * The IntStatisticsUtils class performs basic statistics on integer arrays.
 * <br>
 * NOTE: You will need import the SortUtils class<br>
 * NOTE: All parameters will be passed as final and all preconditions
 * will be enforced.
 */
public class IntStatisticsUtils
{

   /**
    * The computeMean method computes the mean of the array by summing the values in
    * the array and then dividing by the number of elements in the array
    * <br>
    * NOTE: Integer arithmetic happens so ensure you cast so double arithmetic happens
    * <br>
    *
    * @param myArray Representing the array of integers
    * @return double Representing the mean of the integers in the array
    *
    * @throws IllegalArgumentException if myArray is null
    * @throws IllegalArgumentException if the length of myArray is less than or equal to zero
    */
   public static double computeMean(final int [] myArray)
   {
   if(myArray == null)
      throw new IllegalArgumentException("myArray is null");
   if(myArray.length <= 0)
      throw new IllegalArgumentException("length of myArray is less than or equal to zero");
      
   int n = 0;
   double mean = 0;
      
   for(; n <= (myArray.length - 1); ++n) {
      mean = mean + myArray[n];
   }
   mean = mean / myArray.length;
   
      return mean;
      
   }// end method

   /**
    * The printResults methods prints the results of the statistical calculation
    * String type is once again a literal string that will be printed to the screen
    *
    * @param type Representing a literal String to what is being printed
    * @param result Representing the result of the statistical calculation
    *
    * @throws IllegalArgumentException if type is null
    * @throws IllegalArgumentException if type is empty
    */
   public static void printResults(final String type, final double result)
   {
   if(type == null || type.isBlank())
      throw new IllegalArgumentException("type is null or blank");
   
   System.out.println("The " + type + "is: " + result);

   }
   
   /**
    * The computeMedian method computes the median value of the array<br>
    * First the array is sorted by calling the SortUtils method<br>
    * <br>
    * The calculation for a median is different for an array of even length versus an array of an odd length.<br>
    * An array with an odd length:<br>
    * 1.	Find the index of the middle element of the array.<br>
    * 2.	Compute middle index with length divided by 2.<br>
    * 3.	The median would be the value at this array index.<br>
    * <br>
    * An array with an even length:<br>
    * 1.	There will be the two middle values.<br>
    * 2.	Compute index #1 with array length divided by 2.<br>
    * 3.	Compute index #2 with index #1 - 1<br>
    * 4.	Get the values stored at index #1 and index #2<br>
    * 5.	The median is the two values added together and divided by 2.<br>
    * <br>
    * NOTE: Integer arithmetic happens so ensure you cast so double arithmetic happens
    * <br>
    *
    * @param myArray Representing the array of integers
    * @return double Representing the median of the integers in the array
    *
    * @throws IllegalArgumentException if myArray is null
    * @throws IllegalArgumentException if the length of myArray is less than or equal to zero
    */
   public static double computeMedian(final int [] myArray)
   {
      
   double median = 0;
   int middleIndex = 0;
   int middleIndex2 = 0;
   SortUtils.selectionSort(myArray);
   
   if(myArray.length % 2 != 0) {
      middleIndex = (myArray.length) / 2;
      median = myArray[middleIndex];
      }
   else {
      middleIndex = myArray.length / 2;
      middleIndex2 = middleIndex - 1;
      median = (myArray[middleIndex] + myArray[middleIndex2]) / 2.0;
      }
      return median;
   
   }
       

   /**
    * The midpoint is the mean of the smallest and largest values in your array.<br>
    * 1.	Sort your array in ascending order by calling SortUtils<br>
    * 2.	Retrieve the values from the beginning and end of the array<br>
    * 3.	The midpoint is those two values added together and divided by 2<br>
    * <br>
    * NOTE: Integer arithmetic happens so ensure you cast so double arithmetic happens
    * <br>
    *
    * @param myArray Representing the array of integers
    * @return double Representing the midpoint of the integers in the array
    *
    * @throws IllegalArgumentException if myArray is null
    * @throws IllegalArgumentException if the length of myArray is less than or equal to zero
    */
   public static double computeMidpoint(final int [] myArray)
   {
   if(myArray == null)
      throw new IllegalArgumentException("myArray is null");
   if(myArray.length <= 0)
      throw new IllegalArgumentException("length of myArray is less than or equal to zero");
      
   double midPoint = 0;
   int startPoint = 0;
   int endPoint = 0;
   
   SortUtils.selectionSort(myArray);
   startPoint = myArray[startPoint];
   endPoint = myArray[myArray.length - 1];
   
   midPoint = (startPoint + endPoint) / 2;
      
      
      return midPoint;
   }
   
   /**
    * The standard deviation shows how much variation from the average exists.<br>
    * 1.	Compute the mean of the array.<br>
    * 2.	Create a new array of deviations by subtracting the mean from each member from the original array.<br>
    * 3.	Square each member of the deviations array.<br>
    * 4.	Total those squared deviations.<br>
    * 5.	Divide by one less than the original array length.<br>
    * 6.	The standard deviation is the square root of that number.<br>   
    * <br>
    * NOTE: Integer arithmetic happens so ensure you cast so double arithmetic happens
    * <br>
    *
    * @param myArray Representing the array of integers
    * @return double Representing the mean of the integers in the array
    *
    * @throws IllegalArgumentException if myArray is null
    * @throws IllegalArgumentException if the length of myArray is less than or equal to zero
    */
   public static double computeStdDev(final int [] myArray)
   {
   
   int i = 0;
   double arraySum = 0;
   double standardDeviation = 0;
   double newArray [] = new double[myArray.length];
   double mean = IntStatisticsUtils.computeMean(myArray);
     
   for(; i <= myArray.length - 1; i++) {
      newArray[i] = (myArray[i] - mean);
      newArray[i] = Math.pow(newArray[i], 2.0); 
      arraySum = arraySum + newArray[i];
   }

   standardDeviation = Math.sqrt(arraySum / (myArray.length - 1));
  
      return standardDeviation;
   }

}// end class