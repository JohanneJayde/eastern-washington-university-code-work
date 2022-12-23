package lab2.cscd211classes;

import lab2.cscd211enums.Genre;
/*
Name: Johanne McClenahan
Class: Book
Description: Book class has two explicit constructors, three mutator methods, five accesor methods, toString, compareTo, hashcode, and equals methods.

*/
public class Book implements Comparable<Book> 
{
//authors array used to store a book's authors consisting of their first and last name
private Author [] authors;
//isbn used to store the isbn number as a string
private String isbn;
//pages used to store the number of pages as an int
private int pages;
//pub used to store the book's publisher information as publisher's name and city as a Publisher object
private Publisher pub;
//title used to store book's title as a string
private String title;
//type used to store book's genre as type enumerated Genre
private Genre type;
   /**
    *Explicit Value Constructor for a Book
    *
    * @param title Representing the title
    * @param isbn Representing the isbn
    * @param pages Representing the total pages in the book
    * @param type Representing an enumerated type Genre
    * @param pubs Representing a Publisher reference
    * @param author Representing the Scanner object to the keyboard
    *                 
    * @throws IllegalArgumentException if any of the references are null
    * @throws IllegalArgumentException if any of the strings are empty or the pages is less than or equal to 0
    */
public Book(String title, String isbn, int pages, Genre type, Publisher pubs, String [] author){
   if(title == null || title.isBlank())
      throw new IllegalArgumentException("bad params. title is null or empty in Book contructor");
   if(isbn == null || isbn.isBlank())
      throw new IllegalArgumentException("bad params. isbn is null or empty in Book contructor");
   if(pages <= 0)
      throw new IllegalArgumentException("bad params. pages is less than or equal to 0 in Book contructor");
   if(type == null)
      throw new IllegalArgumentException("bad params. type is null in Book contructor");
   if(pubs == null)
      throw new IllegalArgumentException("bad params. pubs is null in Book contructor");
   if(author == null)
      throw new IllegalArgumentException("bad params. author is null iin Book contructor");
   //assigns parameters into each field of the Book object
   this.title = title;
   this.isbn = isbn;
   this.pages = pages;
   this.type = type;
   this.pub = new Publisher(pubs.getPubName(), pubs.getPubCity());
   
   //creates a authorObject array to convert array of string authors into Author objects
   Author [] authorObject = new Author[author.length];
   
   //for loop is used to convert first name and last name of author into Author objects
   //for loop iterates based on author array's length
   for(int i = 0; i < author.length; ++i){
         String first;
         first = author[i].substring(0, author[i].indexOf(" "));  
         String last;
         last = author[i].substring(author[i].indexOf(" "));
   
         authorObject[i] = new Author(first, last);
   }
   //assigns converted new Authors array to authors field in Book object
   this.authors = authorObject;


}
   /**
    *Explicit Value Constructor for a Book
    *
    * @param title Representing the title
    * @param isbn Representing the isbn
    * @param pages Representing the total pages in the book
    * @param type Representing A String that will be converted to an enumerated type Genre
    * @param pubName Representing A String representing the publisher name
    * @param pubCity Representing A String representing the publisher city
    * @param array Representing an array of Mutable Author objects
    *                 
    * @throws IllegalArgumentException if any of the references are null
    * @throws IllegalArgumentException if any of the strings are empty or the pages is less than or equal to 0
    */
public Book(String title, String isbn, int pages, String type, String pubName, String pubCity, Author [] array){
   if(title == null || title.isBlank())
      throw new IllegalArgumentException("bad params. title is null or empty in Book contructor");
   if(isbn == null || isbn.isBlank())
      throw new IllegalArgumentException("bad params. isbn is null or empty in Book contructor");
   if(pages <= 0)
      throw new IllegalArgumentException("bad params. pages is less than or equal to 0 in Book contructor");
   if(type == null || type.isBlank())
      throw new IllegalArgumentException("bad params. type is null or empty in Book contructor");
   if(pubName == null || pubName.isBlank())
      throw new IllegalArgumentException("bad params. pubName is null or empty in Book contructor");
   if(pubCity == null || pubCity.isBlank())
      throw new IllegalArgumentException("bad params. pubCity is null or empty in Book contructor");
   if(array == null)
      throw new IllegalArgumentException("bad params. array is null iin Book contructor");
   //assigns parameters into each field of the Book object
   this.title = title;
   this.isbn = isbn;
   this.pages = pages;
   //converts string to type enumerated Genre
   this.type = Genre.valueOf(type.toUpperCase());
   //creates new Publisher object using pubCity and pubName
   this.pub = new Publisher(pubCity, pubName);
   this.authors = array;

}
/*
//the compareTo method compares by publisher. If the publishers are the same then by title 
//if the titles are the same then by isbn.
//
//Specified by: compareTo interface Comparable<Book>
*/
@Override
public int compareTo(Book passedIn){
   //creates int results to see whether or not the two books are the same
   int results;
   results = this.pub.compareTo(passedIn.pub);
      if(results != 0)
   //returns the results if Publisher Objects are not the same
         return results;
   results = this.getTitle().compareTo(passedIn.title);
      if(results != 0)
  //returns the results if the title are not the same
         return results;
   results = this.getISBN().compareTo(passedIn.isbn);
 //returns the results on whether or not the isbn are the same
         return results;
}
/*
//the equals returns true if the title, isbn and number of pages all match, false otherwise.
//
//Overrides: equals in class Object
*/
@Override
public boolean equals(Object obj)
{
   //series of checks that make sure the obj is of type Book and not null
   if(obj == null) return false;
   if(obj == this) return true;
   if(obj instanceof Book == false) return false;
   Book another = (Book)obj;
   //returns the boolean of if the title, isbn, and title are equal or not
      return this.title.equals(another.title) && this.isbn.equals(another.isbn) && Integer.valueOf(this.pages).equals(Integer.valueOf(another.pages));

}
/*
//The hashCode of the title added to the hashCode of the isbn
//
//Overrides: hashCode in class Object
*/
@Override
public int hashCode(){
   return this.title.hashCode() + this.isbn.hashCode();

}
/*
//The Book toString method
//
// @ returns Title, ISBN: ISBN number
//
//Overrides: toString in class Object
*/
@Override
public String toString(){
   return (this.title + " " + this.isbn.substring(0,3) + ": " + this.isbn.substring(4));

}
//Returns the first Author reference representation of the Author object.
public Author getFirstAuthor()    {return this.authors[0];}
//Returns the String representation of the isbn.
public String getISBN()           {return this.isbn;}
//Returns the String representation of the isbn.
public int gePages()              {return this.pages;}
//Returns the String representation of the title.
public String getTitle()          {return this.title;}
//The getType returns the Genre for the appropriate type
public Genre getType()            {return this.type;}

//The setISBN method sets the isbn of the book
public void setISBN(String isbn)    {this.isbn = isbn;}
//The setPages method sets the number of pages for the book
public void setPages(int pages)     {this.pages = pages;}
public void setTitle(String title)  {this.title = title;}


}