package lab11.cscd210classes;

/** 
 * A basic stock class to start to understand basic classes
 * @NOTE all parameters will be passed as final and all preconditions will be met
 */
public class Stock implements Comparable<Stock>
{
   /**
    * private data member for the company symbol known as the ticker symbol
    */
   private String ticker;

   /**
    * private data member for the company name
    */
   private String companyName;
   
   /**
    * private data member for the purchase price
    */
   private double purchasePrice;
   
   /**
    * DVC sets ticker to DOW, company name to DOW Jones Industrial Average
    * purchase price to 10 <br>
    * @NOTE you must use the this method to call the EVC
    */
   public Stock()
   {
      this("DOW", "DOW Jones Industrial Average", 10);
      
   }// end DVC
   
   
   /**
    * The EVC that sets the class level variables to the values passed in
    * @param ticker Representing the company symbol known as ticker
    * @param companyName Representing the company name
    * @param purchasePrice Representing the purchase price
    * @throws IllegalArgumentException if the strings are null or empty or the purchase
    * price is less than 0.01
    * @NOTE you must use this. for all class level variable calls
    * @NOTE All paramaters will be passed as final
    */
   public Stock(final String ticker, final String companyName, final double purchasePrice)
   {
      if(ticker == null || ticker.isEmpty() || companyName == null || companyName.isEmpty() || 
         purchasePrice < 0.01)
            throw new IllegalArgumentException("bad param EVC");
   
      this.ticker = ticker;
      this.companyName = companyName;
      this.purchasePrice = purchasePrice;
      
   }
   
   
   /**
    * The getTicker returns this ticker
    * @return String representing the ticker
    */
   public String getTicker(){return this.ticker;}
   
   /**
    * The getCompanyName returns this company name
    * @return String representing the company name
    */
   public String getCompanyName(){return this.companyName;}

   /**
    * The getPurchasePrice returns this purchase price
    * @return double representing the purchase price
    */
   public double getPurchasePrice(){return this.purchasePrice;}
  
   
    
   /**
    * The toString that returns company name - ticker CR Purchase Price: purchase price
    * @NOTE must declare @Override
    */ 
   @Override  
   public String toString()
   {
      return this.companyName + " - " + this.ticker + "\nPurchase Price: " + this.purchasePrice;
   }// end toString
   
   
  //============================================================================================ 
  // Your code goes below
  //============================================================================================ 
  
  /**
   * The setTicker method sets this ticker to the value passed in
   * @param ticker Representing the new ticker
   * @throws IllegalArgumentException if ticker is null or empty
   */
   
   public void setTicker(final String ticker) {
      if(ticker == null)
         throw new IllegalArgumentException("ticker is null in setTicker");
      if(ticker.isBlank())
         throw new IllegalArgumentException("ticker is blank in setTicker");
      this.ticker = ticker;
   }
      
   /**
   * The setCompanyName method sets this company name to the value passed in
   * @param companyName Representing the new companyName
   * @throws IllegalArgumentException if companyName is null or empty
   */
   
   public void setCompanyName(final String companyName) {
      if(companyName == null)
         throw new IllegalArgumentException("companyName is null in setCompanyName");
      if(companyName.isBlank())
         throw new IllegalArgumentException("companyName is blank in setCompanyName");
      this.companyName = companyName;
   }
    
   /**
   * The setPurchasePrice method sets this purchasePrice to the value passed in
   * @param purchasePrice Representing the new purchasePrice
   * @throws IllegalArgumentException if purchasePrice is less than 0.01
   */
   
   public void setPurchasePrice(final double purchasePrice) {
      if(purchasePrice < 0.01)
         throw new IllegalArgumentException("purchasePrice is less than 0.01");

      this.purchasePrice = purchasePrice;
   }
            
   
   /**
   * The equals methods checks in this order <br>
   * o equal to this returns true <br>
   * o equal to null returns false <br>
   * o not an instance of Stock returns false <br>
   * All class variables must be exactly equal the variables of another including
   * all 15 digits for the double.  YOU CAN'T USE THE == OPERATOR TO CHECK THE PURCHASE PRICE
   * @return boolean Representing if all class level variables exactly match another's variables
   * @NOTE Must use @Override
   */
   
   @Override
   public boolean equals(final Object o) {
   if(o == null)
      return false;
   if(o == this)   
     return true;
   if(o instanceof Stock == false)
      return false;
   Stock another = (Stock)o;
   
   return this.ticker.equals(another.ticker) && this.companyName.equals(another.companyName) && Double.valueOf(this.purchasePrice).equals(Double.valueOf(another.purchasePrice));
}
  
   /**
    * The compareTo method only compares based on the company name.  This method
    * calls and returns the value from the comapreTo method of the String class for the company name
    * @return int Representing the order of the companyName
    * @throws IllegalArgumentException if another is null
    * @NOTE Must use @Override
    */
  @Override
  public int compareTo(final Stock another) {
      if(another == null)
         throw new IllegalArgumentException("another is null in compareTo");
         
      int res = this.companyName.compareTo(another.companyName);
      if(res != 0)
         return res;
  
      return res;
}
      
   /**
   * The hashCode returns the value of the ticker hashCode from the String class + the value of the hashCode
   * for the companyName from the String class + the hashCode value of the purchasePrice from the Double class
   * @return int Representing the hashCode of the ticker plus the hashCode of the companyName + the hashCode of the 
   * purchase price
   * @NOTE Must use @Override
   */
   @Override
   public int hashCode() {
   int num = this.ticker.hashCode() + this.companyName.hashCode() + Double.hashCode(this.purchasePrice);
   return num;
   
}
   
}// end class