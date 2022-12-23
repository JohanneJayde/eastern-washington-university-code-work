package lab1.cscd211comparators;

import lab1.cscd211classes.Person;
import java.util.Comparator;
/*
Name: Johanne McClenahan
Class: ColorComparator
Description: this class has one method that is used to compare two Person
object's color enumerations

*/
public class ColorComparator implements Comparator<Person>{
/*
The compare method that compares two persons by the Color reference contents.
Specified by: compare in interface Comparator<Person>
Parameters:
p1 - The first Person to be compared
p2 - The second Person to be compared
Returns: int - A negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second
*/
public int compare(final Person p1, final Person p2){

   return p1.getColor().compareTo(p2.getColor());

}



}