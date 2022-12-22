package lab14.cscd210lab14;

import java.io.*;
import java.util.*;
import lab14.cscd210utils.*;
import lab14.cscd210utils.*;
import lab14.cscd210classes.Book;
import lab14.cscd210comparators.*;
import lab14.cscd210methods.CSCD210Lab14Methods;

/**
 * The class that contains main.
 *
 * @NOTE You CANNOT change this class or methods in any fashion
 */
public class CSCD210Lab14
{
   public static void main(String [] args) throws Exception
   {
      Book [] myBooks = null;
      int choice, total, results;
      Scanner kb = new Scanner(System.in);
      
      File inf = FileUtils.openInputFile(kb); 
      
      Scanner fin = new Scanner(inf);
      total = FileUtils.countRecords(fin, 4);
      fin.close();
      
      fin = new Scanner(inf);
      myBooks = CSCD210Lab14Methods.fillArray(fin, total);
      fin.close();

      do
      {
         choice = CSCD210Lab14Methods.menu(kb);
         
         switch(choice)
         {
            case 1:  CSCD210Lab14Methods.printBooks(myBooks, System.out);
                     break;
                     
            case 2:  PrintStream fout = new PrintStream(CSCD210Lab14Methods.readOutputFilename(kb));  
                     CSCD210Lab14Methods.printBooks(myBooks, fout);
                     break;
                     
            case 3:  SortUtils.selectionSort(myBooks);
                     break;
            
            case 4:  Arrays.sort(myBooks, new BookISBNComparator());
                     break;
                     
            case 5:  myBooks = CSCD210Lab14Methods.addBook(myBooks, CSCD210Lab14Methods.createBook(kb));
                     break;
                     
            case 6:  results = SearchUtils.linearSearch(myBooks, CSCD210Lab14Methods.createBook(kb));
                     if(results != -1)
                        System.out.println("Book information: " + myBooks[results]);
                        
                     else
                        System.out.println("Book was not found");
                     break;
                     
            case 7:  System.out.println("Program Ending");
         
         }// end choice
         
      }while(choice != 7);
      
   }// end main

}// end class