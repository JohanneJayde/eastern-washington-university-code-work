package lab7.cscd210lab7methods;

import java.util.Scanner;

/**
 * The methods class for this lab. All parameters will be final and
 * all preconditions will be enforced.<br>
 */
public class CSCD210Lab7Methods
{
   /**
    * The readNum method prompts the user for a number that is between -10000 to 10000.
    * The method ensures the number is in range by continually prompting  <br>  
    *
    * <br> @NOTE: The input buffer will be left cleared before leaving the method <br>
    *     
    * @param kb Representing the Scanner to the keyboard
    * @return int Representing the number 
    *
    * @throws IllegalArgumentException if the Scanner is null
    */
   public static int readNum(final Scanner kb)
   {  
   if(kb == null)
      throw new IllegalArgumentException("kb is null in menu");
    
  int num = 0;
      
  do {
   
  System.out.print("Please enter a number between -10000 and 10000: ");
  
  num = Integer.parseInt(kb.nextLine());
   
  }while(num > 10000 || num < -10000);
    
  return num;  
  
    
   }// end readNum
   
   
   /**
    * The menu method prompts the user for a menu choice. This method ensures that the entered
    * choice is within the range of 1 to 5 inclusive.
    * <br>
    *
    * Menu choices are:<br>
    * 1) Enter a new number<br>
    * 2) Print the number backwards<br>
    * 3) Print if the number is light or heavy<br>
    * 4) Print the primes from 2 to the entered number<br>
    * 5) Quit<br>
    * <br>  
    *
    * <br> @NOTE: The input buffer will be left cleared before leaving the method <br>
    *     
    * @param kb Representing the Scanner to the keyboard
    * @return int Representing the menu choice, must ensure the number is between 1 and 5 inclusive 
    *
    * @throws IllegalArgumentException if the Scanner is null
    */
   public static int menu(final Scanner kb)
   {
   if(kb == null)
      throw new IllegalArgumentException("kb is null in menu");
      
   int choice = 0;
      
   do {
   System.out.println("Menu choices are:    ");
   System.out.println("1) Enter a new number");
   System.out.println("2) Print the number backwards");
   System.out.println("3) Print if the number is light or heavy");
   System.out.println("4) Print the primes from 2 to the entered number");
   System.out.println("5) Quit");
   System.out.print("Choice ---> ");
  
   choice = Integer.parseInt(kb.nextLine());
   
  }while(choice > 5 || choice < 0);
  
  return choice;
  
}
   /**
    * The numberBackwards prints the digits in the number in reverse order. If the number is 12345
    * what will be printed to the screen is 54321. You must do this without the use of String or any
    * String functions  
    *
    * @param theNum Representing a in range
    *
    * @throws IllegalArgumentException if the number is out of range
    */
   public static void numberBackwards(final int theNum){
   if(theNum > 10000 || theNum < -10000)
      throw new IllegalArgumentException("theNum is out of range");
 
   int num = theNum; 
   int numCopy1 = num;
   int numCopy2 = num;
   int numCopy1Digits = 0;  
   int reverseNum = 0;
   int digitWithNewPosition = 0;
   int counterForPrintingZero = 0;
   int numOfZeroes = 0;
   boolean posOrNegChecker = true;
   while(numCopy1 != 0) {
      numCopy1 = numCopy1 / 10;
      numCopy1Digits = numCopy1Digits + 1;
   }
   while(numCopy2 % 10 == 0 && numCopy2 != 0) {
      numOfZeroes++; 
      numCopy2 = numCopy2 /= 10;
   }
  
   int x = numCopy1Digits;
   for(int y = 0; y < numCopy1Digits; y++)
   {   
   int digitAsLeadingNum = (num % (int)Math.pow(10, x));  
   int singleDigit = (digitAsLeadingNum - (digitAsLeadingNum  % (int)Math.pow(10, x - 1))) / ((int)Math.pow(10, x - 1));
   if(posOrNegChecker == true && num < 0) { 
   System.out.print("-");
   posOrNegChecker = false;
   }
   if((num % 10) == 0 && counterForPrintingZero <= numOfZeroes - 1) {
   digitWithNewPosition = singleDigit * (int)(Math.pow(10, y));
   System.out.print(0);
   counterForPrintingZero = counterForPrintingZero + 1;
   }
   else {
   digitWithNewPosition = singleDigit * (int)(Math.pow(10, y));
      }
   reverseNum = digitWithNewPosition + reverseNum;
   x--;  
   }
   if(reverseNum < 0) {
   reverseNum = reverseNum * -1;
   System.out.println(reverseNum);
   }
   else
      System.out.println(reverseNum);
    
   }


   /**
    * The lightOrHeavy method calculates the average of the number passed in. Take the sum of the 
    * digits and divide by the total number of numbers in the number passed in.
    * <br>Next prompt the user for a second number.  Take the sum of the digits and divide
    * by the total number of numbers in the number entered. If the average of the number passed
    * in is greater than the average of the second number than the number is heavy otherwise
    * it is light. <br>  
    *
    * <br> @NOTE: The input buffer will be left cleared before leaving the method <br>
    *
    * @param theNum Representing a number in range
    * @param kb Representing the Scanner to the keyboard
    *
    * @throws IllegalArgumentException if theNum is out of range
    * @throws IllegalArgumentException if the Scanner is null
    */
   public static void lightOrHeavy(final int theNum, final Scanner kb)
   {
   if(theNum > 10000 || theNum < -10000)
      throw new IllegalArgumentException("theNum m is not in range");
   if(kb == null)
      throw new IllegalArgumentException("kb is null in lightOrHeavy");   
      
   int num = theNum; 
   int numCopy1 = num;
   int numDigits = 0;  
   while(numCopy1 != 0) {
      numCopy1 = numCopy1 / 10;
      numDigits = numDigits + 1;
   }
   int x = numDigits;
   int digitSum = 0;
   for(int y = 0; y < numDigits; y++)
   {   
   int digitAsLeadingNum = (num % (int)Math.pow(10, x));   
   int singleDigit = (digitAsLeadingNum - (digitAsLeadingNum  % (int)Math.pow(10, x - 1))) / ((int)Math.pow(10, x - 1)) ;   
   x--;  
   digitSum = digitSum + singleDigit; 

   }
   double avgNum1 = digitSum / numDigits;
   
   do{
   System.out.print("Please enter another numCopy1ber between -10000 and 10000: ");
   num = Integer.parseInt(kb.nextLine());  
   }while(num > 10000 || num < -10000);
   
   numCopy1 = num;
   numDigits = 0;  
   while(numCopy1 != 0) {
      numCopy1 = numCopy1 / 10;
      numDigits = numDigits + 1;
   }
   x = numDigits;
   digitSum = 0;
   for(int y = 0; y < numDigits; y++)
   {   
   int digitAsLeadingNum = (num % (int)Math.pow(10, x));   
   int singleDigit = (digitAsLeadingNum - (digitAsLeadingNum  % (int)Math.pow(10, x - 1))) / ((int)Math.pow(10, x - 1)) ;   
   x--;  
   digitSum = digitSum + singleDigit;  
   }
   double avgNum2 = digitSum / numDigits;
   
   if(avgNum1 < avgNum2) 
      System.out.println("The num is light"); 
   else if(avgNum1 > avgNum2)
     System.out.println("The num is heavy");
   else
     System.out.println("the num is the same");


   }


   /**
   * The printPrimes method prints the prime numbers from 2 to the passed in number. <br>  
   *
   * <br> @NOTE: You can't use arrays or any methods from any classes, such as String.  You have to 
   * brute for the answer<br>
   *
   * @param theNum Representing the number in range
   *
   * @throws IllegalArgumentException if the theNum passed in is out of range  
   */
   public static void printPrimes(final int theNum)
   {
   if(theNum > 10000 || theNum < -10000)
      throw new IllegalArgumentException("theNum m is not in range");
      
   int n = theNum;
   if(n > 0) {
        while (n % 2 == 0) { 
            System.out.print(2 + " "); 
            n /= 2; 
        } 
        for (int i = 3; i <= Math.sqrt(n); i += 2) { 
            while (n % i == 0) { 
                System.out.print(i + " "); 
                n /= i; 
            } 
        } 
        if (n > 2) 
            System.out.print(n); 
   }
   else {
   n = n * -1;
           while (n % 2 == 0) { 
            System.out.print(-2 + " "); 
            n /= 2; 
        } 
        for (int i = 3; i <= Math.sqrt(n); i += 2) { 
            while (n % i == 0) { 
                System.out.print((i * -1) + " "); 
                n /= i; 
            } 
        } 
        if (n > 2) 
            System.out.print(n * -1);
      }  
      System.out.print("\n");
   }

}// end class