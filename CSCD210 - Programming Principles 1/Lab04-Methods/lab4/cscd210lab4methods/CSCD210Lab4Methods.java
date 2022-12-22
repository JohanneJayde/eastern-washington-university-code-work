package lab4.cscd210lab4methods;

import java.util.Scanner;

public class CSCD210Lab4Methods
{
   public final static int YEAR = 2020;

   public static String	readName(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("kb is null in readName");
         
         System.out.print("Please enter a first middle last name: ");
         String name = kb.nextLine().trim();
     
         return name;
   }
   
      public static int	readBirthYear(final Scanner kb)
   {
      if(kb == null)
        throw new IllegalArgumentException("kb is null in readBirthYear");
         
         System.out.print("Please enter a enter your birth year: ");
         int birthYear = kb.nextInt();
         kb.nextLine();
               
         return birthYear;
   }
      
   public static String determineMiddleName(final String name)
   {
      if(name == null || name.isBlank())
         throw new IllegalArgumentException("kb is null in readLetter");
         
         String [] fullNameSeperator = name.split(" ");
         String middle = fullNameSeperator[1].trim();
           
         return middle;
   }
  
   public static char readLetter(final Scanner kb)
   {
   
     if(kb == null) {
         throw new IllegalArgumentException("kb is null in readLetter");
         }
         
         System.out.print("Please enter a enter a single letter: ");
         char randLetter = kb.next().charAt(0);
         kb.nextLine();
     
         return randLetter;
   }
   
   public static int	determineHashCode(final int birthYear, final String middle)
   {
   
    if(middle == null || middle.isBlank()){
         throw new IllegalArgumentException("kb is null in middle"); 
         }
         
    if(birthYear <= 1900){
         throw new IllegalArgumentException("birtJonahYear is less than or equal to 1990"); 
         }
         
    int totalHashCode = YEAR + birthYear + middle.hashCode();
      
         return totalHashCode;
   }
   
   public static void changeLetter(final char letter, final String name)
   {
   
      String letterStringVer = String.valueOf(letter); 
   
      String nameReplaceUpper = name.replace(letterStringVer.toLowerCase(), "$");
      String nameReplaceLower = nameReplaceUpper.replace(letterStringVer.toUpperCase(), "$").trim();
     
      System.out.println(nameReplaceLower);
 
   }
   
}