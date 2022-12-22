package lab5.cscd210lab5;

import java.util.Scanner;
import lab5.cscd210lab5utils.CSCD210Lab5Utils;
import lab5.cscd210lab5methods.CSCD210Lab5Methods;

/**
 * The testing file for your lab. You may not change any code in this file
 * in any fashion.
 */
public class CSCD210Lab5
{

	/**
	 * The main method
	 * @param args Representing command line input
	 */
	public static void main(String[] args)
	{
		int choice;
		String input = null;
		double length, area, max;
	    
	    Scanner kb = new Scanner(System.in);
	    
	    do
	    {
	    	choice = CSCD210Lab5Utils.menu(kb);
	    	
	    	if(choice == 1)
	    	{
	    		input = CSCD210Lab5Methods.readLength(kb);
	    		area = CSCD210Lab5Methods.calcArea(input);
	    		CSCD210Lab5Methods.displayResults(Double.valueOf(input), area);	    		
	    	}
	    	
	    	else if(choice == 2)
	    	{
	    		max = CSCD210Lab5Methods.readMaxLength(kb);
	    		length = CSCD210Lab5Methods.generateLength(0.1, max);
	    		area = CSCD210Lab5Methods.calcArea(length);
	    		CSCD210Lab5Methods.displayResults(length, area);
	    	}
	    	else
	    		System.out.println("Thank you for playing");
	    	
	    }while(choice != 3);
	    
	}// end main

}// end class
