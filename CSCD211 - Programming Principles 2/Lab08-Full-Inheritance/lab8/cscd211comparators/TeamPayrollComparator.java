package lab8.cscd211comparators;
/*
Name: Johanne McClenahan
Class: CSCD211
Description: TeamPayrollComparator implements Comparator interface to compare two team's payroll
*/
//import java.util.* in order to access the Comparator interface
import java.util.*;
//import lab8.cscd211classes.* in order to access the Team class and its method for calculating a team's total payroll
import lab8.cscd211classes.*;

//class TeamPayrollComparator using implements to use override compare() method found in Comparator interface
public class TeamPayrollComparator implements Comparator<Team> {
   //compare method is takes in two Team objects and returns an int value, which states which of the team's salary is higher
   public int compare(Team t1, Team t2){
      //throw an error if either Team objects passed in have null values
      if(t1 == null || t2 == null)
         throw new IllegalArgumentException("one or more of the parameters in compare(obj, obj) are null");
      //returns the result of t1's payroll being compared to t2's payroll
      //uses Integer.valueOf() in order to use compareTo() method as primitives cannot use it
      //uses calculatePayroll() method in order to calculate the team's total payroll from Team class
      return Integer.valueOf(t1.calculatePayroll()).compareTo(Integer.valueOf(t2.calculatePayroll()));
   
   }


}