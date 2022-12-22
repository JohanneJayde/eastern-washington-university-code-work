package lab8.cscd210lab8;

import java.util.Scanner;
import lab8.cscd210utils.ArrayUtils;
import lab8.cscd210utils.IntStatisticsUtils;
import lab8.cscd210methods.CSCD210Lab8Methods;

/**
 * The class that contains the main method
 */
public class CSCD210Lab8
{
   /**
    * The main method you can't change.<br>
    * @param args Representing the array of command line parameters
    */
   public static void main(String [] args)
   {
      int num, choice;
      int [] myArray = null;
      Scanner kb = new Scanner(System.in);
      double mean, median, midpoint, stdDev, mode;

      num = CSCD210Lab8Methods.readNum(kb);
      myArray = ArrayUtils.createAndFillArray(num, kb);

      do
      {
         choice = CSCD210Lab8Methods.menu(kb);

         switch(choice)
         {
            case 1:  myArray = ArrayUtils.addNum(myArray, kb);
                     break;

            case 2:  myArray = ArrayUtils.deleteValue(myArray, kb);
                     break;

            case 3:  myArray = ArrayUtils.deleteValueByIndex(myArray, kb);
                     break;

            case 4:  ArrayUtils.printArray(myArray);
                     break;

            case 5:  mean = IntStatisticsUtils.computeMean(myArray);
                     IntStatisticsUtils.printResults("Mean", mean);
                     break;

            case 6:  median = IntStatisticsUtils.computeMedian(myArray);
                     IntStatisticsUtils.printResults("median", median);
                     break;

            case 7:  midpoint = IntStatisticsUtils.computeMidpoint(myArray);
                     IntStatisticsUtils.printResults("Midpoint", midpoint);
                     break;

            case 8:  stdDev = IntStatisticsUtils.computeStdDev(myArray);
                     IntStatisticsUtils.printResults("Standard Deviation", stdDev);
                     break;

            case 9: System.out.println("All Done");

         }// end switch

      }while(choice != 9);

      System.out.println("Good Bye");

   }// end main

}// end class