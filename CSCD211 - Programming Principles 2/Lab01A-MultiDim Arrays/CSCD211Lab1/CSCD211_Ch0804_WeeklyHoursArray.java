
/*
Johanne McClenahan - CSCD211 Lab01 from Ch08 Section04 - WeeklyHoursArray

Objective of Program: 
1. Calculate eight employees total work hours across seven days
2. Sort the eight employees total work hours in descending order
3. Display the employee's index along with total hours worked in ascending order based on total work hours
4. display the results using the format: "Employee [employeeIndex#]'s total hours is [employeeTotalWorkHours]"
*/

public class CSCD211_Ch0804_WeeklyHoursArray {
//main method
   public static void main(String [] args) {
//define workHours array which is 8 rows by 7 columns with each row representing an employee and each column representing the day of the week 
      int [][] workHours = {
      {2, 4, 3, 4, 5, 8, 8},
      {7, 3, 4, 3, 3, 4, 4},
      {3, 3, 4, 3, 3, 2, 2},
      {9, 3, 4, 7, 3, 4, 1},
      {3, 5, 4, 3, 6, 3, 8},
      {3, 4, 4, 6, 3, 4, 4},
      {3, 7, 4, 8, 3, 8, 4},
      {6, 3, 5, 9, 2, 7, 9},
                           };
//define totalEmployeeHours array which is 2 rows by 8 columns with row #0 representing the total amount of employee hours of each employee,- 
//-row #1 representing the employee's index number, and each column representing one of the employees                           
  int [][] totalEmployeeHours = new int[2][8];
//calculate the total work hours done by all the employees         
  for(int j = 0; j < workHours.length; j++) {
//define totalSum which keeps track of the number of total hours done by a given employee
      int totalSum = 0;
//cycles through each column which means that each loop iteration calculates the total hours worked by a employee
      for(int i = 0; i < workHours.length - 1; i++) {
         totalSum = workHours[j][i] + totalSum;      
      }
//Assigns row#0 with the total work hours of an employee
     totalEmployeeHours[0][j] = totalSum;
//Assigns row#1 with the corresponding employee index number
     totalEmployeeHours[1][j] = j;
  }
//Sorting employees in descending order based on total work hours while keeping track of their index number
  for(int i = 0; i < totalEmployeeHours[0].length; i++) {
      int temp = totalEmployeeHours[0][i];
//sort employee's work hours in descending order
      for(int j = i+1; j < totalEmployeeHours[0].length; j++) {
         if(totalEmployeeHours[0][i] < totalEmployeeHours[0][j]) {
            temp = totalEmployeeHours[0][i];
            totalEmployeeHours[0][i] = totalEmployeeHours[0][j]; 
            totalEmployeeHours[0][j] = temp;
//sort employee's index number based on the their total work hours 
            temp = totalEmployeeHours[1][i];
            totalEmployeeHours[1][i] = totalEmployeeHours[1][j]; 
            totalEmployeeHours[1][j] = temp;  
          }
      }
  }
//print results in order of total employee hours with employee index number
  for(int n = 0; n < totalEmployeeHours[0].length; n++) {
      System.out.println("Employee " + totalEmployeeHours[1][n] + "'s total hours is " + totalEmployeeHours[0][n]);
  }
   
  }           
  
}