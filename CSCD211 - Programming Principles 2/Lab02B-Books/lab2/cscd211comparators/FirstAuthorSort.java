package lab2.cscd211comparators;

import lab2.cscd211classes.*;
import java.util.Comparator;
/*
Name: Johanne McClnehana
Class: FirstAuthorSort
Description: contains one compare method used to compare two book's first author
*/
public class FirstAuthorSort implements Comparator<Book>
{
/*
The compare method that compares two books by their first author reference contents.

Specified by: compare in interface Comparator<Book>

Parameter: b1 - The first Book to be compared
Parameter: b2 - The second Book to be compared

Returns: int - A negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second

Throws: IllegalArgumentException - if either Book 1 or Book 2 are null
*/
public int compare(Book b1, Book b2){
   if(b1 == null || b2 == null)
      throw new IllegalArgumentException("b1 or b1 are null in compare method");
      
   return b1.getFirstAuthor().compareTo(b2.getFirstAuthor());


}



}