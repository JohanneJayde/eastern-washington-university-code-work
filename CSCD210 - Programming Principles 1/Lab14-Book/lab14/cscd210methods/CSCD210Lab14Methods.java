package lab14.cscd210methods;

import java.io.*;
import java.util.*;
import lab14.cscd210classes.Book;

/**
 * The class contains a set of methods required for the lab to work properly
 *
 * @NOTE All parameters passed to method must be passed as final.  You don't need to write a default value constructor
 * since we don't have any class level variable.
 */
public class CSCD210Lab14Methods
{
   /**
    * The fillArray method first creates an array of books, and then fills each index of the book array with
    * a new Book object.
    *
    * @param fin Representing the Scanner object to the file
    * @param total Representing the total number of elements to be contained in the array
    * @return Book [] Representing array filled with Book objects
    *
    * @throws IllegalArgumentException if fin is null
    * @throws IllegalArgumentException if total is less than 1
    *
    * @NOTE The file contents are comma separated values in the order title, isbn, pages, authors
    */
   public static Book [] fillArray(final Scanner fin, final int total)
   {
   if(fin == null)
      throw new IllegalArgumentException("fin is null in fillArray method");
   if(total < 1)
      throw new IllegalArgumentException("total is less than 1 in fillArray method");
   
     Book array [] = new Book[total];
     for(int i = 0; i < array.length; ++i) {
      String title = fin.nextLine();
      String isbn = fin.nextLine();
      int pages = Integer.parseInt(fin.nextLine());
      String author = fin.nextLine();
     
      array[i] = new Book(title, isbn, pages, author);     
     
     }
      return array;
   
   }// end fillArray
   
   /**
    * The printBooks calls the toString method of book and prints each book out followed by a CR
    *
    * @param array Representing the array of books
    * @param output Representing the PrintStream object to the screen or the file
    *
    * @throws IllegalArgumentException if array is null or the length is &lt; 1
    * @throws IllegalArgumentException if output stream is null
    */
   public static void printBooks(final Book [] array, final PrintStream output)
   {
   if(array == null || array.length < 1)
      throw new IllegalArgumentException("array is null or empty in printBooks method");
   if(output == null)
      throw new IllegalArgumentException("(PrintStream) output is null in printBooks method");
   
   for(Book s: array)
      output.println(s + "\n");
      
   }// end printBooks
   
   
   /**
    * The menu method offers the user a choice from:<br>
    * 1) Print the books to the screen<br>
    * 2) Print the books to a file<br>
    * 3) Sort the books based on natural order<br>
    * 4) Sort the books based on total order<br>
    * 5) Add a new book to the bookshelf<br>
    * 6) Search the bookshelf for a book<br>
    * 7) Quit<br>
    * 
    * @param kb Representing the Scanner object to the keyboard
    * @return int Representing the menu choice which is ensured by you
    * to be between 1 and 7 inclusive
    *
    * @throws IllegalArgumentException if kb is null
    *
    * @NOTE You must ensure the input buffer is empty at the end of the method
    */
   public static int menu(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("bad scanner menu");
         
      int choice;
      do
      {
         System.out.println("Please choose from the following");
         System.out.println("1) Print the books to the screen");
         System.out.println("2) Print the books to a file");
         System.out.println("3) Sort the books based on natural order");
         System.out.println("4) Sort the books based on total order");
         System.out.println("5) Add a new book to the bookshelf");
         System.out.println("6) Search the bookshelf for a book");
         System.out.println("7) Quit");
         System.out.print("Choice --> ");
         choice = Integer.parseInt(kb.nextLine());
         System.out.println();
      }while(choice < 1 || choice > 7);

      return choice;
   }// end menu
   
   
   /**
    * The addBook method makes a new array of the old size plus one<br>
    * Next it copies the books from the old array to the new array<br>
    * Next it adds the new book in last index of the new array
    *
    * @param array Representing the old array to be copied
    * @param aBook Representing the book to add to the array
    * @return Book [] Representing the new array with the old books copied over
    * and the new book in the last index of the new array.
    *
    * @throws IllegalArgumentException if array is null or length &lt; 1
    * @throws IllegalArgumentException if aBook is null
    *
    * @NOTE You must ensure the input buffer is empty at the end of the method
    */
   public static Book[] addBook(final Book [] array, final Book aBook)
   {
   if(array == null || array.length < 1)
      throw new IllegalArgumentException("array is null or empty in addBook method");
   if(aBook == null)
      throw new IllegalArgumentException("aBook is null in addBook method");
   
   
   Book newArray [] = new Book[array.length + 1];
   
   for(int i = 0; i < array.length; ++i) {
      newArray[i] = array[i];
   }
   newArray[newArray.length - 1] = aBook;
   
      return newArray;
   }// end addBook

   /**
    * The createBook method prompts the user to enter title, isbn, pages, and author.
    * Entering the information is done by the private method readString.
    * The method must ensure that the pages is &gt; 0 
    *
    * @param kb Representing the Scanner object to the keyboard
    * @return Book Representing a new Book object
    *
    * @throws IllegalArgumentException if kb is null
    *
    * @NOTE You must ensure the input buffer is empty at the end of the method
    */ 
   public static Book createBook(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("kb is null in createBook method");
         
      String title = readString("title", kb);
      String isbn = readString("ISBN", kb);
      String pagesAsString = readString("pages", kb);
      int pages = Integer.parseInt(pagesAsString);
      String author = readString("author", kb);
      
      Book newBook = new Book(title, isbn, pages, author);
   
      return newBook;      
   }// end createBook
   
   /**
    * The readOutputFilename calls the readString to read a output filename
    *
    * @param kb Representing the Scanner object to the keyboard
    * @return String Representing the output filename
    *
    * @throws IllegalArgumentException if kb is null
    *
    * @NOTE You must ensure the input buffer is empty at the end of the method
    */ 
   public static String readOutputFilename(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("Bad param readOutputFilename");

      return readString("output filename", kb);
   }
   
   /** 
    * The readString reads a string from the keyboard and ensures the string is not null or empty
    *
    * @param type Representing a String for the prompt on what to enter
    * @param kb Representing the Scanner object to the keyboard
    * @return String Representing the appropriate String
    *
    * @throws IllegalArgumentException if kb is null
    *
    * @NOTE You must ensure the input buffer is empty at the end of the method
    */ 
   private static String readString(final String type, final Scanner kb)
   {
      if(type == null || type.isEmpty() || kb == null)
         throw new IllegalArgumentException("Bad param readString");
         
      String str = "";
      
      System.out.print("Please enter the " + type  + ": ");
      str = kb.nextLine();
           
      return str;
   }// end readString

}// end class