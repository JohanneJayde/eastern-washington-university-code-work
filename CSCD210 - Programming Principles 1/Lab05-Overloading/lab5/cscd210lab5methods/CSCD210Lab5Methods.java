package lab5.cscd210lab5methods;

import java.util.Scanner;

public class CSCD210Lab5Methods 
{
   public final static String DEGREES = "°";
   
   public static String	readLength(final Scanner kb)
   {
   if(kb == null) {
   throw new IllegalArgumentException("kb is null in input");
   }
   
   System.out.print("Please enter the length from the center to the vertex: ");
   String length = kb.nextLine();
   
   return length.trim();
   
   }
   
   public static double calcArea(final String input)
   {
   if(input == null || input.isBlank()) {
   throw new IllegalArgumentException("kb is null in input");
   }
   
   double length = Double.parseDouble(input);
   
   double PentArea = calcArea(length);
   
   return PentArea;
   }  
   
   
   public static double calcArea(final double length)
   {
   if(length <= 0){
      throw new IllegalArgumentException("length is less than or equal to 0"); 
         }
   
   double sideLength = (2 * length * Math.sin(Math.PI/5)); 
   
   double PentArea = (5 * Math.pow(sideLength, 2.0)) / (4 * Math.tan(Math.PI/5)); 
  
   return PentArea; 
   
   }
  
   public static void displayResults(final double length, final double area)
   {
   if(length <= 0){
   throw new IllegalArgumentException("length is less than or equal to 0");
   }
   if(area <= 0) {
   throw new IllegalArgumentException("area is less than or equal to 0");
   }
   
   System.out.printf("The value of the length was: %.1f\n", length);
   System.out.printf("The area of the pentagon is: %.3f\n", area);
   
   }
   
   public static double	generateLength(final double min, final double max)
   {
   if(max < .1){
   throw new IllegalArgumentException("max is less than .01");
   }
   if(min > max){
   throw new IllegalArgumentException("min is greater than max");
   }
      
   double compGeneratedNum = (Math.random() * (max - min + 1)) + min;
   
   return compGeneratedNum;
   
   }
   
   public static double readMaxLength(final Scanner kb)
   {
  
   if(kb == null){
   throw new IllegalArgumentException("kb is null in readMaxLength");
   }

   System.out.print("Please enter a number greate than 0: ");
   
   double maxLength = kb.nextDouble();
   kb.nextLine();
   
   return maxLength;
   }





}