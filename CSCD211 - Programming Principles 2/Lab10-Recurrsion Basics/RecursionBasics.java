/*
Name: Johanne McClenahan
Class: CSCD211
Description: this program demonstrates the difference between using recursion for methods and not using recursion.
             The methods that were tested included a basic recursion method, printing using iteration vs recursion,
             and finding a factorial of a number with and without using recursion
Factorial Definition: A factorial of a number is calculated by multiplying the number by every integer before it until it reaches one
                      An example of this is factorial of 5 which would be calculated by multiplying 5 * 4 * 3 * 2 * 1. Factorials
                      are symbolized by !(number) and cannot be negative or be decimals as only positive integers are being
                      multiplied
*/
//RecursionBasics class
public class RecursionBasics{
   //main class
	public static void main(String[] args) {
      //calling recursiveMethod with 0 parameter to test it
		recursiveMethod(0);
		//calling printNumbersIterative and printNumbersRecursive to show how they display the same content using different ways of printing
		printNumbersIterative();
		printNumbersRecursive(0);
		
      //calling factorial and factorialR with the same parameter 4 to demonstrate how they result in the same factorial of 4
		System.out.println("Factorial of 4 is: " + factorial(4));
		System.out.println("Factorial of 4 is: " + factorialR(4, 1));
	}
   //recursiveMethod prints from the parameter (int value n) to 10 using recursion
	private static void recursiveMethod(int n) {
      //if-statement is limit the number of times recursion is used to call the method (in this case. 10)
		if (n < 10){
         //displays the number of times the Recursive method has been called
         System.out.println("Recursive method called, n is: " + n);
         //recursion used and the method is called again with param int n being incremented by 1
         //this method is called until if-else exit condition is met (n < 10) then the else statement is done
         recursiveMethod(n + 1);
         			
		}
      //else-statement is used to display when the recursive method is done
		else
	      System.out.println("Base/terminal case reached, no more recursive calls!");
		
	}
	//printNumbersIterative prints the numbers using iterations
	private static void printNumbersIterative(){
      //int i is set to 0 and represents the starting point in which the printing begins
		int i = 0;
      //while-loop is used to print out i until it is greater than 0
		while (i < 10){
         System.out.print(i + " ");
         //i is incremented by 1 each time the while-loop iterates
         i++;
		}
      //newline character is printed at the end to separate next method from this method, ensuring a cleaner output
      System.out.println();
     	}
	//printNumbersRecursive prints a ranger between parameter int i and 10 using recursion
	private static void printNumbersRecursive(int i){
      //if-statement is used to limit the amount of times recursion is done and also limiting the number of printing done (in this case, the limit is 10)
		if (i < 10){
         //prints out i along with a space
			System.out.print(i + " ");
         //recursion is used when printNumbersRecursive is called but with a parameter of i plus 1, essentially incrementing i each
         //the if-statement exit condition isn't meant
			printNumbersRecursive(i+1);
		}
      //else-statement is used to printout extra line
      //newline character is printed at the end to separate next method from this method, ensuring a cleaner output
      else
         System.out.println();
	}
	//factorial method used to calculate the factorial of the parameter n without using recursion
	private static int factorial(int n){
      //fact is set to 1 and is used as a the base to start the calculation of the factorial of n
		int fact = 1;
		//for-loop used to iterate until parameter n has been reached by i
      //each time the loop iterates, fact is set to the result of i multiplied by fact
      //this means that each iteration, fact will be multiplied by the next number until reaching param n,
      //resulting the correct factorial calculation
		for(int i = fact; i <= n; i++){
         fact = fact * i;   
         }
      //fact is returned to where the method was called
		return fact;
	}
   //factorialR method calculates the factorial of param n using recursion, param i is used as the starting point for calculating the factorial
	private static int factorialR(int n, int i){
		//if-statement is used to ensures that factorialR is called until it reaches n, which means the factorial calculation is complete
		if(i <= n){
         //returns the the result of factorialR being multiplied by i
         //because i is being increased each time factorialR is called, and the if statement ensures, i doesn't go past n
         //factorial will start with i being multiplied by itself plus one until i equals 4 where the if-statement exit condition is reached
         //this results in a calculation of the factorial of n using recursion
			return factorialR(n, i + 1) * i; 
		}
      //if i is greater than n then else-statement triggers as method is only able to be used if i can be the starting point and if i < n then
      //i cannot be increased to reach n as its already larger and the calculation of factorials involves multiplying by every integer below n
      //and not any integers larger than n
		else
			return 1;
	}
}
