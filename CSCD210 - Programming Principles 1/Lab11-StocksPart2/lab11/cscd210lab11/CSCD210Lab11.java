package lab11.cscd210lab11;

import java.io.*;
import java.util.*;
import lab11.cscd210classes.Stock;

public class CSCD210Lab11
{
   public static void main(String [] args)
   {
      Stock bStock = null;
      Stock aStock = new Stock();
      Scanner kb = new Scanner(System.in);
      
      String ticker, compName;
      double purchPrice, curPrice;
      
      System.out.print("Please enter the ticker ");
      ticker = kb.nextLine();
      
      System.out.print("Please enter the company name ");
      compName = kb.nextLine();
      
      System.out.print("Please enter the purchase price ");
      purchPrice = kb.nextDouble();
      
      bStock = new Stock(ticker, compName, purchPrice);
      
      System.out.println("Print using gets");
      System.out.printf("%s - %s\nPurchase Price: %f\n",aStock.getTicker(),
                        aStock.getCompanyName(), aStock.getPurchasePrice());
      System.out.println();
                             
      System.out.println("Print using implicit call to toString");
      System.out.println(bStock); // implicit call to toString   
      System.out.println();

      kb.nextLine();
      
  //============================================================================================ 
  // Method calls for the code you will write in Stock
  //============================================================================================ 
      System.out.println("\nUSING SET METHODS");
      System.out.print("Please enter the ticker ");
      ticker = kb.nextLine();
      aStock.setTicker(ticker);
      
      System.out.print("Please enter the company name ");
      compName = kb.nextLine();
      aStock.setCompanyName(compName);
      
      System.out.print("Please enter the purchase price ");
      purchPrice = kb.nextDouble();
      aStock.setPurchasePrice(purchPrice);
                
      System.out.println();
      System.out.println("Print using implicit call to toString already written in the last lab");
      System.out.println(aStock); // implicit call to toString   
      
      System.out.println("\nCALLING THE EQUALS METHOD");
      if(bStock.equals(aStock))
         System.out.println("The stocks are the same");
         
      else
         System.out.println("The stocks are NOT the same");  
         
      System.out.println("\nCALLING THE COMPARETO METHOD");
      if(aStock.compareTo(bStock) < 0)
         System.out.println("aStock is less than bStock");
         
      else
         System.out.println("bStock is less than or equal to aStock");  
         
      System.out.println("\nCALLING THE HASHCODE METHOD");
      System.out.println("Your value will be different than mine");
      System.out.println("The hashCode for bStock is " + bStock.hashCode());
   }// end main
}// end class