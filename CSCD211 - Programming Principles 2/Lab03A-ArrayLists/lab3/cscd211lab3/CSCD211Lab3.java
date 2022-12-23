package lab3.cscd211lab3;

import java.util.*;
import lab3.cscd211methods.*;

/**
 * The methods class for the CSCD211Lab3 that contains main<br>
 * The purpose of this main is to get practice working with an ArrayList.
 * An ArrayList can hold any kind of Object type (not primitives). In our case
 * the ArrayList will be of type Double.  Notice how the ArrayList type is specified at
 * declaration and in the method headers of CSCD211Lab3Methods.
 */
public class CSCD211Lab3
{
	/**
	 * The simple main for testing.  NOTE: there is no throws Exception on main because
	 * we don't need it we are not working with any File objects for this lab.
	 * @param args Representing the command line arguments
	 */
   public static void main(String [] args)
   {
      int num, choice;
      Scanner kb = new Scanner(System.in);
      ArrayList<Double> myArrayList = null;
      double mean, median, midpoint, stdDev;
      
     
      num = CSCD211Lab3Methods.readNum(kb);
      myArrayList = new ArrayList<Double>(num);
      CSCD211Lab3Methods.fillArrayList(num, myArrayList);
                  
      do
      {
         choice = CSCD211Lab3Methods.menu(kb);
         
         switch(choice)
         {
            case 1:  CSCD211Lab3Methods.addNum(myArrayList, kb);
                     break;
                     
            case 2:  CSCD211Lab3Methods.deleteValue(myArrayList, kb);
                     break;
                     
            case 3:  CSCD211Lab3Methods.deleteValueByIndex(myArrayList, kb);
                     break;
                     
            case 4:  CSCD211Lab3Methods.printArrayList(myArrayList);
                     break;
                     
            case 5:  mean = CSCD211Lab3Methods.computeMean(myArrayList);
                     CSCD211Lab3Methods.printResults("Mean", mean);
                     break;
                       
            case 6:  median = CSCD211Lab3Methods.computeMedian(myArrayList);
                     CSCD211Lab3Methods.printResults("Median", median);
                     break;

            case 7:  midpoint = CSCD211Lab3Methods.computeMidpoint(myArrayList);
                     CSCD211Lab3Methods.printResults("Midpoint", midpoint);
                     break;
                     
            case 8:  stdDev = CSCD211Lab3Methods.computeStandardDeviation(myArrayList);
            		   CSCD211Lab3Methods.printResults("Standard Deviation", stdDev);
            break;
                              
         }// end switch
      
      }while(choice != 9);
   
   }// end main   


}// end class