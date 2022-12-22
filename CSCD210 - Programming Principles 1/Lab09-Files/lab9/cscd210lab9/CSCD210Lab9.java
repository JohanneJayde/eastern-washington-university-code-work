package lab9.cscd210lab9;

import java.io.*;
import java.util.*;
import lab9.cscd210methods.*;
import lab9.cscd210utils.FileUtils;
import lab9.cscd210utils.SortUtils;

/**
 * The provided class used to test your code.  This file will
 * not be changed!<br>
 */
public class CSCD210Lab9
{
   public static void main(String [] args) throws Exception
   {
      File inf = null;
      int total, choice;
      String [] words = null;
      Scanner kb = new Scanner(System.in), fin = null;
      
      inf = FileUtils.openInputFile(kb);
      fin = new Scanner(inf);
      total = FileUtils.countRecords(fin, 1);
      fin.close();
      
      fin = new Scanner(inf);
      words = CSCD210Lab9Methods.fillArray(fin, total);
      SortUtils.selectionSort(words);
      fin.close();
      
      CSCD210Lab9Methods.printArray(words, System.out);    
      System.out.println("\n\n");
      words = null;
      
      
      inf = FileUtils.openInputFile("words2.txt");
      fin = new Scanner(inf);
      total = FileUtils.countRecords(fin, 1);
      fin.close();
      
      fin = new Scanner(inf);
      words = CSCD210Lab9Methods.fillArray(fin, total);
      SortUtils.selectionSort(words);
      fin.close();
      
      CSCD210Lab9Methods.printArray(words, System.out);        
      words = null;
      
      System.out.println("\n\n");
      inf = FileUtils.openInputFile("thereisnofileandthisshouldthrowanerror.txt");
              
         
   }// end main
      
}// end class 