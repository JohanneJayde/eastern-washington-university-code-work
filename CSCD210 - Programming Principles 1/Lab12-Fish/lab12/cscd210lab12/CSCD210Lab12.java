package lab12.cscd210lab12;

import java.io.*;
import java.util.Scanner;
import lab12.cscd210utils.*;
import lab12.cscd210classes.*;
import lab12.cscd210methods.*;


public class CSCD210Lab12
{
   public static void main(String [] args) throws Exception
   {
      File inf = null;
      Fish [] myFish = null;
      int totalFish, choice;
      Scanner kb = new Scanner(System.in), fin = null;
      
      inf = FileUtils.openInputFile(kb);
      fin = new Scanner(inf);
      
      totalFish = FileUtils.countRecords(fin, 2);
      fin.close();
      
      fin = new Scanner(inf);
      myFish = CSCD210Lab12Methods.fillArray(fin, totalFish);
      fin.close();
      
      SortUtils.selectionSort(myFish); 
            
      do
      {
         choice = CSCD210Lab12Methods.menu(kb);
         
         if(choice == 1)
            CSCD210Lab12Methods.printArray(myFish, System.out);
            
         else if(choice == 2)
         {
            PrintStream fout = new PrintStream(new File("output.txt"));
            CSCD210Lab12Methods.printArray(myFish, fout);
            fout.close();
         }// end else if choice == 2
         
         else if(choice == 3) // compare two fish for equality
         {
            int index1 = CSCD210Lab12Methods.readIndex(0, myFish.length - 1, kb);
            int index2 = CSCD210Lab12Methods.readIndex(0, myFish.length - 1, kb);
            
            if(myFish[index2].equals(myFish[index1]))
               System.out.println("The two fish are equal in both species and weight");
               
            else
               System.out.println("The two fish are not equal");

         }// end else choice == 3
         
        else
            System.out.println("Exiting");
         
      }while(choice != 4);
      
      kb.close();
            
   }// end main  
   
}// end class
