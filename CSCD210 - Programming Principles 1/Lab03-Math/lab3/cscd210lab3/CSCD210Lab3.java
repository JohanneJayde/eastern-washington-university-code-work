package lab3.cscd210lab3;

import java.util.Scanner;
import java.text.DecimalFormat;

public class CSCD210Lab3
{
   public static void main(String [] args)
   {      
   
   DecimalFormat twoDeciPoints;
   twoDeciPoints = new DecimalFormat("#.00");
   double userTime; 
   
   double metersPerSec;
   double FeetPerSec;
   double kilometersPerHour;
   double milesPerHour;
   double milesPerMin;
   double milesPerMinOnlySec;
   double yardsPerSec;
   
   Scanner userInput = new Scanner(System.in);
 
   System.out.print("Plase enter your time: ");
   userTime = userInput.nextDouble();
   
   metersPerSec = 100 / userTime;
   FeetPerSec = 100 * 3.28084 / userTime;
   kilometersPerHour = (double) (100 * 0.001) / (userTime / 60 / 60.00);
   milesPerHour = (100 * 0.000621371) / (userTime / 60 / 60);
   milesPerMin = (1 / milesPerHour) * 60;
   milesPerMinOnlySec = (milesPerMin - (int) milesPerMin) * 60;
   yardsPerSec = 91.44 / metersPerSec;
   
   System.out.println("This person was traveling at a rate of: ");
   System.out.println(twoDeciPoints.format(metersPerSec) + " meters per second,");
   System.out.println(twoDeciPoints.format(FeetPerSec) + " feet per second,");
   System.out.println(twoDeciPoints.format(kilometersPerHour) + " kilometers per hour,");
   System.out.println(twoDeciPoints.format(milesPerHour) + " miles per hour, \n"); 
   
   System.out.println("It would take " + (int) milesPerMin + " mintues and " + twoDeciPoints.format(milesPerMinOnlySec) + " seconds for the person to run one mile.");
   System.out.println("It would take " + twoDeciPoints.format(yardsPerSec) + " seconds for the person to run 100 yards. \n");

//Computer Generated Run  
   double lowTime = 9;
   double highTime = 35;
   double compGeneratedNum = (Math.random() * (highTime - lowTime + 1)) + lowTime;
  
   metersPerSec = 100 / (double) compGeneratedNum;
   FeetPerSec = 100 * 3.28084 / (double) compGeneratedNum;
   kilometersPerHour = (100 * 0.001) / ((double) compGeneratedNum / 60 / 60.00);
   milesPerHour = (100 * 0.000621371) / ((double) compGeneratedNum / 60 / 60);
   milesPerMin = (1 / milesPerHour) * 60;
   milesPerMinOnlySec = ((milesPerMin - (int) milesPerMin) * 60);
   yardsPerSec = 91.44 / metersPerSec;
   
   
   
   System.out.println("The computer generated a winning time of " + twoDeciPoints.format(compGeneratedNum) + "\n"); 
   System.out.println("This person was traveling at a rate of: ");
   System.out.printf("%.2f meters per second, \n", metersPerSec);
   System.out.printf("%.2f feet per second, \n", FeetPerSec);
   System.out.printf("%.2f kilometers per hour, \n", kilometersPerHour);
   System.out.printf("%.2f miles per hour, ", milesPerHour); 
   System.out.println("\n");
   
   System.out.printf("It would take %d minutes and %.2f seconds for the person to run one mile. \n", (int) milesPerMin, milesPerMinOnlySec); 
   System.out.printf("It would take %.2f seconds for the person to run 100 yards. \n", yardsPerSec);


   userInput.close();
   
   }// end main

}// end class

