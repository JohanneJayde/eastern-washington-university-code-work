package lab4.cscd210lab4;

import java.util.Scanner;
import lab4.cscd210lab4methods.CSCD210Lab4Methods;

public class CSCD210Lab4
{
		
	public static void main(String[] args)
	{
		char ltr;
		int birthYear;
		String name = null;
		Scanner kb = new Scanner(System.in);
		
		name = CSCD210Lab4Methods.readName(kb);
		birthYear = CSCD210Lab4Methods.readBirthYear(kb);
		ltr = CSCD210Lab4Methods.readLetter(kb);
		String middle = CSCD210Lab4Methods.determineMiddleName(name);
           		
		System.out.printf("The hash code of the constant named year %d + ", CSCD210Lab4Methods.YEAR);
	   System.out.printf("the entered birth year %d + ", birthYear);
		System.out.printf("hash code of the middle name is %d\n", CSCD210Lab4Methods.determineHashCode(birthYear, middle));
		System.out.printf("The results of replacing all letters of %c with $ is ", ltr);
      CSCD210Lab4Methods.changeLetter(ltr, name);
      
		kb.close();		
		
	}// end main

}// end class$
