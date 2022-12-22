package lab10.cscd210lab10;

import java.io.*;
import java.util.*;
import lab10.cscd210classes.*;

public class CSCD210Lab10
{
   public static void main(String [] args)
   {
      Stock bStock = null;
      Stock aStock = new Stock();
      Scanner kb = new Scanner(System.in);
      
      String ticker, compName;
      double purchPrice;
      
      System.out.print("Please enter the ticker ");
      ticker = kb.nextLine();
      
      System.out.print("Please enter the company name ");
      compName = kb.nextLine();
      
      System.out.print("Please enter the purchase price ");
      purchPrice = Double.parseDouble(kb.nextLine());
      
      bStock = new Stock(ticker, compName, purchPrice);
      
      System.out.println("Print using gets");
      System.out.printf("%s - %s\nPurchase Price: %f\n",aStock.getTicker(),
                        aStock.getCompanyName(), aStock.getPurchasePrice());
      System.out.println();
                             
      System.out.println("Print using implicit call to toString");
      System.out.println(bStock);    
      System.out.println();

            
    

   }// end main
}// end class