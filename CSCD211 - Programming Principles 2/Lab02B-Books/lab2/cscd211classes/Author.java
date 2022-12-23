package lab2.cscd211classes;
/*
Name: Johanne McClenahan
Class Author
Description: Author class that has a compareTo method, ToString method, two accesor methods, and explicit value constructor
*/

public class Author implements Comparable<Author>
{
//first used to store author's first name as a string
private String first;
//last used to store author's last name as a string
private String last;

/*
Explicit Value Constructor for an Author.

Parameter: first - Representing the first name
Parameter: last - Representing the last name

Throws: IllegalArgumentException - if any of the strings are null
Throws: IllegalArgumentException - if any of the strings are empty
*/
public Author(String first, String last){
   if(first == null || first.isBlank())
      throw new IllegalArgumentException("bad params. first is null or empty in Author class");
   if(last == null || last.isBlank())
      throw new IllegalArgumentException("bad params. last is null or empty in Author class");
      
   this.first = first;
   this.last = last;

}
/*
The Author compareTo method. First compares by last name and if the last names are the same then compares by first name

Specified by: compareTo in interface Comparable<Author>

Parameters: another - Representing an author object

Returns: int - Negative value, positive value or zero representing order

Throws: llegalArgumentException - if the Author object passed in is null
*/
@Override
public int compareTo(Author another){
   if(another == null)
      throw new IllegalArgumentException("bad params. another is null  in compareTo method");
   //int results used to store the results of whether a given Author data field is equal to another Author object
   int results;
   results = this.getLastName().compareTo(another.last);
      if(results != 0)
   //returns results if last names are not the same
         return results;
   results = this.getFirstName().compareTo(another.first);
   //returns the results of comparing the first names
      return results;
}
//Returns the String representation of the first name.
public String getFirstName(){return this.first;}
//Returns the String representation of the last name.
public String getLastName(){return this.last;}

/*
The Author toString method.

Overrides: toString in class Object

Returns: String last name space first name
*/
@Override
public String toString(){
   return (this.last + " " + this.first);

}
}