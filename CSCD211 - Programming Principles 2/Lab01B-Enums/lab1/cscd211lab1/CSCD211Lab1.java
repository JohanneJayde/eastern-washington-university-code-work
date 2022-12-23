package lab1.cscd211lab1;

import java.io.*;
import java.util.*;
import lab1.cscd211enums.*;
import lab1.cscd211classes.*;
import lab1.cscd211methods.*;
import lab1.cscd211utils.FileUtils;
import lab1.cscd211utils.SortUtils;
import lab1.cscd211comparators.*;


/**
 * The provided class used to test your code.  This file will
 * not be changed!<br>
 * 
 * <br>NOTE: FileUtils and SortUtils are provided 
 */
public class CSCD211Lab1
{
   public static void main(String [] args) throws Exception
   {
      File inf = null;
      int total, choice;
      Person [] myPeeps = null;
      Scanner kb = new Scanner(System.in), fin = null;
      
      inf = FileUtils.openInputFile(kb);
      fin = new Scanner(inf);
      total = FileUtils.countRecords(fin, 3);
      fin.close();
      
      fin = new Scanner(inf);
      myPeeps = CSCD211Lab1Methods.fillArray(fin, total);
      SortUtils.selectionSort(myPeeps);
      fin.close();
      
      do
      {
         choice = CSCD211Lab1Methods.menu(kb);
         
         if(choice == 1)
            CSCD211Lab1Methods.printArray(myPeeps);
         
         else if(choice == 2)
         {
            Color toFind = CSCD211Lab1Methods.readColor(kb);
            CSCD211Lab1Methods.displayAll(toFind, myPeeps);
         }// end choice == 2
         
         else if(choice == 3)
            Arrays.sort(myPeeps, new ColorComparator());
         
         else if(choice == 4)
            Arrays.sort(myPeeps);
            
      }while(choice != 5);
   
   }// end main
      
}// end class 