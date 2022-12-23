/*
Name: Johanne McClenahan
Class: CSCD21
Description:
TestSort4 is an example of sorting user-defined classes. Student class objects are the ones being sorted. compareTo method is overridden.
Printing the list involves an enhanced for-loop

*/

//importing java.util.* in order to use Collections class and ArrayList class
import java.util.*;

//Student class implements Comparable in order to sort objects defined in the class using an overridden compareTo method
class Student implements Comparable<Student>{
   //String name is used to store a student's name
   public String name;
   //Student object constructor with parameter name
   public Student(String name){
      this.name = name;
   }
   //Overridden compareTo method that is used to compare Student objects' name data fields
   //new compareTo method is also written in order to make Collections.sort() function as it relies on this method to sort a list
   public int compareTo(Student person){
     //returns int value which indicates if a name comes before or after another name
     return name.compareTo(person.name);
   
   }
}
//TestSort4 class
public class TestSort4 {
   //main class
   public static void main(String [] args){
   //al is an ArrayList that stores Student objects
   ArrayList<Student> al = new ArrayList<Student>();
   
   //using .add() from Array class in order to add Student objects to al
   al.add(new Student("Viru"));
   al.add(new Student("Saurav"));
   al.add(new Student("Mukesh"));
   al.add(new Student("Tahir"));

   //using Collections.sort() to sort al in ascending order
   Collections.sort(al);
   
   //enhanced-for-loop is used to iterate through al and print each element after sorting
   //enhanced-for-loop prints each Student s in ArrayList al
   for(Student s : al) {
      System.out.println(s.name);
   
   }
   
   }
}