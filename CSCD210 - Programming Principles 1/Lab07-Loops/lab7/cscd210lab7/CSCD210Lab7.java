package lab7.cscd210lab7;

import java.util.Scanner;
import lab7.cscd210lab7methods.CSCD210Lab7Methods;

public class CSCD210Lab7
{
   /**
    * The main method.  You can't change the code in this method
    * or this class in any fashion
    *
    * @param args Representing any command line arguments passed into main
    */
   public static void main(String [] args)
   {
      int theNum, choice;
      Scanner kb = new Scanner(System.in);
      
      theNum = CSCD210Lab7Methods.readNum(kb);
      
      do
      {
         choice = CSCD210Lab7Methods.menu(kb);
         
         switch(choice)
         {
            case 1:  theNum = CSCD210Lab7Methods.readNum(kb);
                     break;
                    
            case 2:  CSCD210Lab7Methods.numberBackwards(theNum);
                     break;  
            
            case 3:  CSCD210Lab7Methods.lightOrHeavy(theNum, kb);
                     break;
                     
            case 4:  CSCD210Lab7Methods.printPrimes(theNum);
                     break;
                     
            default: System.out.println("Good Bye");         
         
         }// end switch
            
      }while(choice != 5);
  
   }// end main

}// end class