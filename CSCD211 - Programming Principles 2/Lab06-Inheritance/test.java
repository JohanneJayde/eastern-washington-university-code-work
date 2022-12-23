/*
Name: Johanne McClenahan
Class: CSCD211
Description:
test program used to test whether Student, Person, Employee, Faculty, and Staff objects are created correctly
and display them to show that the toString method for each of them works

UML drawing created after creating a project
*/

import java.util.*;

public class test{
   public static void main(String [] args){
   //creates a Person, Student, Employee, Faculty, and Staff object
      Person person = new Person("Jerry");
      Student student = new Student("Paul");
      Employee employee = new Employee("James");
      Faculty faculty = new Faculty("Simon");
      Staff staff = new Staff("Robert");
   //prints out person, student, employee, faculty, and staff to check whether or not the toString methods work
      System.out.println(person);
      System.out.println(student);
      System.out.println(employee);
      System.out.println(faculty);
      System.out.println(staff);
      
   }

}