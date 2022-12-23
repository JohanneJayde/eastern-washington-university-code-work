//class that contains Stock class and methods that access and modify the object
public class Stock{
//String symbol used to store symbol of a given Stock
String symbol;
//String name used to store name of a given Stock
String name;
//double previousClosingPrice used to store stock's previous closing price
double previousClosingPrice;
//double currentPrice used to store stock's current price
double currentPrice;

//default constructor
public Stock(){

}
//Stock contractor that takes in params of String sym and String name 
public Stock(String sym, String name){
   this.symbol = sym;
   this.name = name;

}
//accessor method that returns a double value of the previous closing price
public double getPreviousClosingPrice(){
   return this.previousClosingPrice;
}
//accessor method that returns a double value  of the current price
public double getCurrentPrice(){
   return this.currentPrice;
}
//computes the change in percent between the current and previous prices as a double percent
public double getChangePercnt(){
   return ((currentPrice - previousClosingPrice) / previousClosingPrice) * 100;
}
//mutator method that is used to set the current price to the new current price
public void setCurrentPrice(double currentPrice){
   this.currentPrice = currentPrice;
}
//mutator method that is used to set the previous closing price to a new previous closing price
public void setPreviousClosingPrice(double previousClosingPrice){
   this.previousClosingPrice = previousClosingPrice;
}

}

