package lab2.cscd210lab2;

import java.util.Scanner;

public class CSCD210Lab2
{
   public static int YEAR = 2020;
   
   public static void main(String [] args)
   {
      String fullName;
      int birthYear;
      String randLetter;
      String middleName;
      String lastName;
      int totalHashCode;
      char firstLetter;
      char lastLetter;
      
      Scanner userInupt = new Scanner(System.in);
     
      System.out.print("Please enter your full name: ");
      fullName = userInupt.nextLine().trim();
      
      middleName = fullName.substring(fullName.indexOf(" "), fullName.lastIndexOf(" ")).trim();
      lastName = fullName.substring(fullName.lastIndexOf(" "), fullName.length()).trim();
    
      firstLetter = fullName.charAt(0);
      lastLetter = fullName.charAt(fullName.length()-1);
             
      System.out.print("Please enter your birth year: ");
      birthYear = userInupt.nextInt();
      userInupt.nextLine();
      
      System.out.print("Please enter a single letter: ");
      randLetter = userInupt.nextLine();
      
      fullName = fullName.replace(randLetter.toUpperCase().trim(), "$");
      fullName = fullName.replace(randLetter.toLowerCase().trim(), "$");

      totalHashCode = lastName.hashCode() + birthYear + YEAR;
      
      System.out.println("The first letter of your name is: " + firstLetter);
      System.out.println("The Last Letter of your name is: " + lastLetter);
      System.out.println("Your middle name is: " + middleName);
      System.out.println("The hashCode of your name added to the year of 2020 and your birth year " + birthYear + " is: " + totalHashCode);
      System.out.printf("Replacing all the characters of %s in your name becomes %s", randLetter, fullName);
      
      userInupt.close();
   
   }
   
   
} 