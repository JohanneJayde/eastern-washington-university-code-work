
/*
Johanne McClenahan
Class: CSCD211_Ch0803_StockClass & Rectangle
Description:
program that creates a stock object with specified name and then computes the percentage change from the previous closing price
to the new current price and displays the it to the user along with the current price and the previous closing price
stock object is modified and accessed using mutator and accessor methods in Stock class.
*/

public class CSCD211_Ch0803_StockClass{
public static void main(String [] args){
//creates a stock object with name "Oracle Corporation" and symbol "ORCL"
   Stock stock = new Stock("Oracle Corporation", "ORCL");
//sets stock current price to 34.5
   stock.setCurrentPrice(34.5);
//sets previous closing price to 34.35 
   stock.setPreviousClosingPrice(34.35);
//displays the previous closing price, current price, and price change using accessor methods. each are displayed line by line
      System.out.println("Previous Closing Price: " + stock.getPreviousClosingPrice());
      System.out.println("Current Price: " + stock.getCurrentPrice());
      System.out.println("Price Change: " + stock.getChangePercnt() + "%");

}
}
