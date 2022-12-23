package lab2.cscd211methods;
/*
Name: Johanne McClenahan
Class: CSCD211Lab2Methods
Description:
methods class that contains following methods:
addBook: add new book to an extended array
createBook: creates new Book object
fillArray: fills array with Book objects from selected File
getGenre: converts a String into a enum type Genre
menu: displays menu to user and ask user for choice
printBooks: prints Book Objects from an array to a selected output file
readFileName: asks user for output File name
*/
import java.util.Scanner;
import java.io.*;

import lab2.cscd211classes.*;
import lab2.cscd211enums.*;
import lab2.cscd211utils.*;

public class CSCD211Lab2Methods
{
   /**
    *The addBook method adds a book to the array increasing the size of the array by one. 
    *The array is then sorted in ascending order by calling the selectionSort method.
    *
    * @param array Representing the Book array
    * @param book Representing the Book to  be added to the array
    * @return temp[] Representing the new array one larger filled with the books from the
    *                old array, plus the new book. The array is sorted in ascending order.    
    *
    * @throws IllegalArgumentException if the array or the book are null
    */
public static Book [] addBook(final Book [] array, final Book book){
   if(array == null)
      throw new IllegalArgumentException("bad params. Book[] array is null in addBook method");
   if(book == null)
      throw new IllegalArgumentException("bad params. Book object is null in addBook method");
   //create temp that serves as new array with Book object references that is one more than the original Book array
   Book [] temp = new Book[array.length + 1];
   
   //for loop used to populate temp with contents of original Book array
   for(int i = 0; i < array.length; ++i){
      temp[i] = array[i];
   }
   //adds new Book book into the temp array as last element
      temp[array.length] = book;
   //sorts temp array using the selection sort method in SortUtils
      SortUtils.selectionSort(temp);
   //returns sorted temp array that contains new book
      return temp;

}
   /**
    *The createBook method prompts the user for the information in a book and creates a Book object.
    *
    * @param kb Representing Scanner object to the keyboard
    * @return Book Representing a Book object
    *                 
    * @throws IllegalArgumentException if the Scanner object is null
    */
public static Book createBook(final Scanner kb){
   if(kb == null)
      throw new IllegalArgumentException("bad params. Scannner object is null in createBook method");
   //ask user to input the book's title. assigns input to String title
   System.out.print("Please enter your book's title: ");
      String title = kb.nextLine();
   //ask user to input the book's ISBN. assigns input to String isbn
   System.out.print("Please enter your book's ISBN: ");
      String isbn = kb.nextLine();
   //ask user to input the book's number of pages. assigns input to int pages
   System.out.print("Please enter your book's number of pages: ");
      int pages = Integer.parseInt(kb.nextLine());
   //ask user to input the book's genre. assigns input to string type
   System.out.print("Please enter your book's genre: ");
      String type = kb.nextLine();
   //ask user to input publisher's name. assigns input to string pubName
   System.out.print("Please enter your publisher's name: ");
      String pubName = kb.nextLine();
   //ask user to input publisher's city. assigns input to pubCity
   System.out.print("Please enter your publisher's city: ");
      String pubCity = kb.nextLine();
   //ask user to input the number of authors in the book. assigns input to numAuthors
   System.out.print("Please enter your number of authors: ");
      int numAuthors = Integer.parseInt(kb.nextLine());
   //authors array contains Author objects that contain a book's first and last name of authors
   //size of array is based on numAuthors
      Author [] authors = new Author[numAuthors];
   //for loop used to ask for the first and last name of the book's authors
      for(int i = 0; i < numAuthors; ++i){
         System.out.print("Please enter your author's first name: ");
            String firstName = kb.nextLine();
         System.out.print("Please enter your author's last name: ");
            String lastName = kb.nextLine();
   //creates Author object containing first and last name and adds it into the authors array
            authors[i] = new Author(firstName, lastName);
      }
   //creates Book object newBook that uses user's input as parameters
      Book newBook = new Book(title, isbn, pages, type, pubName, pubCity, authors);
   //returns newBook
      return newBook;
}
   /**
    *The fillArray method reads from a file creates a Book object and puts that Book object 
    *into the array.
    *
    * @param fin Representing Scanner object to the File
    * @return Book[] Representing the filled array
    *                 
    * @throws IllegalArgumentException if the Scanner object is null
    */
public static Book [] fillArray(final Scanner fin){
   if(fin == null)
      throw new IllegalArgumentException("bad params. Scanner object is null in fillArray method");
   //creates total that represents the number of books in the file
   int total = Integer.parseInt(fin.nextLine());
   //creates array that will hold the Book objects obtained from the File. size based on total.   
   Book [] array = new Book[total];
   //for loop is used to read the File's content and turn it into new Book objects
   for(int j = 0; j < array.length; ++j){
   //title holds book's title
      String title = fin.nextLine();
   //isbn holds book's isbn
      String isbn = fin.nextLine();
   //pages holds book's number of pages
      int pages = Integer.parseInt(fin.nextLine());
   //type holds the book's type. Calls getGenre method to convert String into enum type Genre
      Genre type = getGenre(fin.nextLine().toUpperCase());
   //pubName holds the book publisher's name
      String pubName = fin.nextLine();
   //pubCity holds the book publisher's city   
      String pubCity = fin.nextLine();
   //pub represents Publisher object that holds publisher's name and city
      Publisher pub = new Publisher(pubName, pubCity);
   //numAuthors represents the number of authors that a book has   
      int numAuthors = Integer.parseInt(fin.nextLine());
   //authName holds the author's full name
      String authName;
   //authors represents array of Strings that represent the author's full names. 
   //length of authors based on numAuthors
      String [] authors = new String[numAuthors];
   //inner for loop used to read author's name from File
      for(int i = 0; i < numAuthors; ++i){
            authName = fin.nextLine();
            authors[i] = authName;
            
      }
   //creates new Book object using contents from File and adds it into Book array
     array[j] = new Book(title, isbn, pages, type, pub, authors);
   
   }
   //returns filled array of Book objects
      return array;
}
   /**
    *The getGenre method converts a String into a Genre. If the string does not contain a genre 
    *an IllegalArgumentException is thrown.
    *
    * @param g Representing the Genre
    * @return type Representing type enumerated Genre version of String
    *                 
    * @throws IllegalArgumentException if the string is null
    * @throws IllegalArgumentException if the string is empty
    */
public static Genre getGenre(final String g){
   if(g == null || g.isBlank())
      throw new IllegalArgumentException("bad params. g is null or empty in getGenre method");
   //type represents the string g as a enum type Genre using valueOf() from enums class
   Genre type = Genre.valueOf(g);
   //returns type
   return type;
}
   /**
    *The menu method displays menu options to the user and ask user to input their choice.
    *User's choice must be within range before being returned
    *
    * @param kb Representing the Scanner object to the keyboard
    * @return int Representing the menu choice
    *                 
    * @throws IllegalArgumentException if the Scanner object is null
    */
public static int menu(final Scanner kb){
   if(kb == null)
      throw new IllegalArgumentException("bad params. Scanner object is null in menu method");
   //choice is used to hold the choice the user chose from the menu
   int choice;
   //do-while loop is used to make sure the choice is between 1-5
   //do-while loop displays the menu choices to user
   do{
      System.out.println("1. Print the books to the screen");
      System.out.println("2. Print the books to a file");
      System.out.println("3. Sort the book using compareTo");
      System.out.println("4. Sort the books by first author as a Comparator");
      System.out.println("5. Add a book");
      System.out.println("6. Quit");
      System.out.print("Please enter a menu choice within range: ");
      choice = Integer.parseInt(kb.nextLine());
   }while(choice <= 0 || choice >= 7);
   //returns user's choice
   return choice;
}
   /**
    *The printBooks method prints the array one book at a time to the specified PrintStream. 
    *Each book is separated by a carriage return.
    *
    * @param array Representing the array of Books
    * @param fout Representing the PrintStream object for the file or the screen
    *                 
    * @throws IllegalArgumentException if either the array or the PrintStream object are null
    */
public static void printBooks(final Book [] array, final PrintStream fout){
   if(array == null)
      throw new IllegalArgumentException("bad params. Book [] array is null in printBook method");
   if(fout == null)
      throw new IllegalArgumentException("bad params. PrintStream fout is null in printBook method");
   //enchanced for loop is used to print each Book object to the PrintStream separated by newline character
   for(Book b: array){
      fout.println(b + "\n");
   
   }
}
   /**
    *The readFileName method reads the name of the output file from the keyboard. 
    *The carriage return is cleaned.
    *
    * @param kb Representing the Scanner object to the keyboard
    *                 
    * @throws IllegalArgumentException if the Scanner object is null
    */
public static String readFileName(final Scanner kb){
   if(kb == null)
      throw new IllegalArgumentException("bad params. Scanner object is null in readFileName method");
   //fileName represents the user's output file name
   String fileName;
   //prompts user to enter the file name
      System.out.print("Please enter your file name: ");
      fileName = kb.nextLine();
   //returns the file's name
      return fileName;
   
}

}
