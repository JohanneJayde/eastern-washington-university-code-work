package lab7.cscd211inheritance;
/*
Name: Johanne McClenahan
Class: CSCD211
Description: superclass Employee that contains a constructor, three accessor method, a toString method, and an compareTo method.
Employee is an abstract class that serves as the base for the Programmer, Accountant, and Lawyer classes. 
Also contains abstract report method and implements comparable interface.
*/

//importing java.util
import java.util.*;

//Abstract Employee class that implements comparable interface for Employee objects
public abstract class Employee implements Comparable<Employee> {
//constant representing the BASE pay and can't be changed. It is set as the first line of the constructor
private final double BASE;
//name of the employee
private String name;
//The salary is the BASE + the additional salary
protected double salary;

//EVC. All parameters are for the private class level variables.
public Employee(final String name, final double basePayrate, final double additionalPayrate){
   //throws IllegalArgumentException if name is empty or null
   if(name == null || name.isBlank())
      throw new IllegalArgumentException("(string) name is null or empty in Employee contructor");
   //throws IllegalArgumentException if basePayrate is less than 0
   if(basePayrate < 0)
      throw new IllegalArgumentException("(double) basePayrate is less than 0 in Employee contructor");      
   //throws IllegalArgumentException if additionalPayrate is less than 0
   if(additionalPayrate < 0)
      throw new IllegalArgumentException("(double) additionalPayrate is less than 0 in Employee contructor");   
   //assigning parameters to class level variables
   this.name = name;
   this.BASE = basePayrate;
   this.salary = this.BASE + additionalPayrate;
}

//accessor method used to return the salary value of an employee
public double getSalary(){
   return this.salary;
}

//accessor method used to return the base salary value of an employee
public double getBaseSalary(){
   return this.BASE;
}

//accessor method used to return the name of an employee
public String getName(){
   return this.name;
}

//accessor method used to return an employee's job type
//This methods first gets the class via getClass and then the simple name
public String getType(){
   return this.getClass().getSimpleName();
   }

//Overrides the toString in class Object and simply returns the name
@Override
public String toString(){
   return this.name;

}

//compareTo method compares two employees
//compareTo first by type if the types are the same then by salary
//another - - Representing the BCR to the DCO
//Specified by: compareTo in interface Comparable<Employee>
public int compareTo(Employee another){
   //throws IllegalArgumentException if another is empty
   if(another == null)
      throw new IllegalArgumentException("(Employee) another is null in compareTo method");
   //resultType stores the int value calculated from comparing two employee object's type
   int resultType = this.getType().compareTo(another.getType());
      //if resultType doesn't equal 0 then resultType is returned, showing that the type is not equal
      if(resultType != 0)
         return resultType;
   //resultSalary stores the int value calculated from comparing two employee object's salaries
   int resultSalary = Double.valueOf(this.salary).compareTo(Double.valueOf(another.salary));
         //returns resultSalary
         return resultSalary;

}
//The abstract method that will be overridden in the subclasses
public abstract void report();

}