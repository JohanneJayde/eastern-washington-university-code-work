package lab7.cscd211comparators;
/*
Name: Johanne McClenahan
Class: CSCD211
Description: The SalaryComparator class the only compares by the Employee's salary The class ensures an Employee is compared. 
All preconditions will be met and all parameters are final
*/

//importing java.util for comparator interface
import java.util.*;
//importing cscd211inheriance to access Employee class
import lab7.cscd211inheritance.*;

//SalaryComparator class used to compare employee salaries and implements Comparator interface for Employee objects
public class SalaryComparator implements Comparator<Employee>{
   //The compare method compares based solely on the name
   public int compare(final Employee e1, final Employee e2){
      //throw IllegalArgumentException if either one of the employee object's are null
      if(e1 == null || e2 == null)
         throw new IllegalArgumentException("one of the employee's passed into compare method is null");
      //returns int value calculated when comparing two employee's salaries accessed using getSalary()
      //double salary primitive values are converted into Double objects using Double.valueOf and then compared
      return Double.valueOf(e1.getSalary()).compareTo(Double.valueOf(e2.getSalary()));

   }


}