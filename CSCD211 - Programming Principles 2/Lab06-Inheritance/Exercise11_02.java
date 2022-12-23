/*

Name: Johanne McClenahan
Class: CSCD211 
Description:
Sections 11.5–11.14

11.2 (THE PERSON, STUDENT, EMPLOYEE, FACULTY, AND STAFF CLASSES) 
Design a class named Person and its two subclasses named Student and Employee. 
Make Faculty and Staff subclasses of Employee. A person has a name, address, phone number, and e-mail address. 
A student has a class status (freshman, sophomore, junior, or senior). Define the status as a constant. 
An employee has an office, salary, and date hired. 
Use the MyDate class defined in Programming Exercise 10.14 (Links to an external site.) to create an object for date hired. 
A faculty member has office hours and a rank. A staff member has a title. 
Override the toString method in each class to display the class name and the person’s name.

Draw the UML diagram for the classes and implement them. 
Write a test program that creates a Person, Student, Employee, Faculty, and Staff, and invokes their toString() methods.
*/

import java.util.*;

//Exercise11_02 used to test out creating each object and printing them to check toString methods
public class Exercise11_02{
   public static void main(String [] args){
      Person person = new Person("Jerry");
      Student student = new Student("Paul");
      Employee employee = new Employee("James");
      Faculty faculty = new Faculty("Simon");
      Staff staff = new Staff("Robert");
      
      System.out.println(person);
      System.out.println(student);
      System.out.println(employee);
      System.out.println(faculty);
      System.out.println(staff);
      
   }


}
//Person class that is used to create Person object
class Person{
   //name stores name of a person for the Person object
   protected String name;
   //email stores the email of a person for the Person object
   protected String email;
   //address stores the address of a person for the Person object
   protected String address;
   //phoneNumber stores the phone number of a person for the Person object
   protected String phoneNumber;
   
   //Constructor that takes in a String name, all other Person data fields are null
   Person(String name) {
      this.name = name;
   }
   //Constructor that takes in a name, email, address, and phone number as Strings
   Person(String name, String email, String address, String phoneNumber){
      this.name = name;
      this.email = email;
      this.address = address;
      this.phoneNumber = phoneNumber;
   }
   //accessor method used to retrieve name of Person
   public String getName() {
      return this.name;
   }
   //accessor method used to retrieve email of Person
   public String getEmail(){
      return this.email;
   }
   //accessor method used to retrieve address of Person
   public String getAddress(){
      return this.address;
   }
   //accessor method used to retrieve phone number of Person
   public String getPhoneNumber(){
      return this.phoneNumber;
   }
   //toString{} method used to override existing toString method and returns String representation of Person object
   @Override
   public String toString(){
      return "Person: " + getName();
   }   
}
//Student class used to create Student object. This is a subclass of superclass Person
class Student extends Person{
//FRESHMAN, SOPHOMORE, JUNIOR, SENIOR are constant int values that represent a student's grade
   public static final int FRESHMAN = 1;
   public static final int SOPHOMORE = 2;
   public static final int JUNIOR = 3;
   public static final int SENIOR = 4;
//status is used to store a student's grade (if applicable) as int value   
   protected int status;
   //Constructor that takes in a String name and creates a Student object. status is null. uses super() to call Person() constructor
   Student(String name){
      super(name);
   }
   //Constructor takes in a String name and a int status and constructs a Student object, uses super() to call Person() constructor
   Student(String name, int status){
      super(name);
      this.status = status;
   }
   //accessor method used to retrieve a student's status, if Student status doesn't match any constant, generic "High Schooler" is returned
   String getStatus(){
      if(status == 1)
         return "Freshman";
      if(status == 2)
         return "Sophomore";
      if(status == 3)
         return "Junior";
      if(status == 4)
         return "Senior";
      else
         return "High Schooler";
   }
   //toString used to print String representation of Student object
   @Override
   public String toString(){
      return "Student: " + getName();
   
   }

}
//Employee class used to create an Employee object. subclass of Person
class Employee extends Person {
   //office stores an employee's office name as a string value
   protected String office;
   //salary stores an employee's salary as a double value
   protected double salary;
   //dateHired stores the date that the employee was hired on as a string value
   protected String dateHired;
   //Constructor that takes in a name and creates an Employee object, uses super() to call Person() constructor
   Employee(String name){
      super(name);
   }
   //Constructor that takes in an employee's name, office, salary, and date hired and creates an employee object, uses super() to call Person() constructor
   Employee(String name, String office, double salary, String dateHired){
      super(name);
      this.office = office;
      this.salary = salary;
      this.dateHired = dateHired;
   }
   //accessor method used to return an employee's office
   String getOffice(){
      return this.office;
   }
   //accessor method used to return an employee's salary
   double getSalary(){
      return this.salary;
   }
   //accessor method used to return an employee's hiring date
   String getDateHired(){
      return this.dateHired;
   }
   //toString method used to return a String representation of an Employee object
   @Override
   public String toString(){
      return "Employee: " + getName();
   }

}
//Faculty class used to Create Faculty object. subclass of Employee
class Faculty extends Employee{
//LECTURER, ASSISTANT_PROFESSOR, ASSOCIATE_PROFESSOR, PROFESSOR are constant int value that represent a Faculty's rank
   public static final int LECTURER = 1;
   public static final int ASSISTANT_PROFESSOR = 2;
   public static final int ASSOCIATE_PROFESSOR = 3;
   public static final int PROFESSOR = 4;
//officeHour's represent a faculty's office hours
   protected String officeHours;
//rank holds a faculty's rank as a int value
   protected int rank;
   //Constructor that takes in a String name and create Faculty object, uses super() to call Employee() constructor
   Faculty(String name) {
      super(name);
   }
   //Constructor that takes in a name, office hours, and rank of a faculty member, uses super() to call Employee() constructor
   Faculty(String name, String officeHours, int rank){
      super(name);
      this.officeHours = officeHours;
      this.rank = rank;
   }
   //accessor method used to return a faculty member's office hours
   String getOfficeHours(){
      return this.officeHours;
   }
   //accessor method used to return a faculty member's rank
   //if a faculty member's rank doesn't match any constants, generic "Employee" is returned
   String getRank(){
      if(rank == 1)
         return "Lecturer";
      if(rank == 2)
         return "Assistant Professor";
      if(rank == 3)
         return "Associate Professor";
      if(rank == 4)
         return "Professor";
      else
         return "Employee";
   }
   //toString used to return a string representation of a Faculty object
   @Override
   public String toString(){
      return "Faculty: " + getName();
   }
}
//Staff class used to create Staff objects, subclass of Employee
class Staff extends Employee{
   //title stores a staff member's title as string value
   protected String title;
   //Constructor that takes in staff member's name and create's a Staff object, uses super() to call Employee() constructor
   Staff(String name){
      super(name);
   }
   //Constructor that takes in staff member's name and title to create a Staff object, uses super() to call Employee() constructor
   Staff(String name, String title){
      super(name);
      this.title = title;
   }
   //accessor method uses to return a staff member's title
   String getTitle(){
      return this.title;
   }
   //toString method used to return a String representation of a Staff object
   @Override
   public String toString() {
      return "Staff: " + getName();
   }

}                     