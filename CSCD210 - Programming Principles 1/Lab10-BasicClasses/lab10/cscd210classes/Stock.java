package lab10.cscd210classes;

public class Stock implements Comparable<Stock> {
   private String companyName;
   private double purchasePrice;
   private String ticker;
   
public Stock() {
   this("DOW", "DOW Jones Industrial Average", 10);

}   
   
public Stock(final String ticker, final String companyName, final double purchasePrice) {
   if(ticker == null || ticker.isBlank())
      throw new IllegalArgumentException("ticker is blank or null");
   if(companyName == null || companyName.isBlank())
      throw new IllegalArgumentException("companyName is blank or null");   
   if(purchasePrice < 0.01)
      throw new IllegalArgumentException("purchasePrice is less than 0.01");//
   
   this.companyName = companyName;
   this.purchasePrice = purchasePrice;
   this.ticker = ticker;
   
}    

public String getTicker() { 
   return this.ticker;

}

public String getCompanyName() {
   return this.companyName;
   
}

public double getPurchasePrice() {  
   return this.purchasePrice;
   
}

@Override
public String toString() {
   String str = this.companyName + " - " + this.ticker + "\nPurchase Price: " + this.purchasePrice;

   return str;
}

@Override
public int hashCode() {
   int num = this.id + this.name.hashCode() + Double.hashCode(this.purchasePrice);
   return num;
   
}
@Override
public boolean equals(final Object o) {
   if(o == null)
      return false;
   if(o == this)   
     return true;
   if(0 instanceof o == false)
      return false;
   Student another = (Student)0;
   return this.id == another.id && this.name.equals(another.name);
   
   Double.valueOf(this.purchasePrice).equals(Double.valueOf(another.purchasePrice));
}
@Overrride
public int compareTo(final Stock another) {
   // if.variable comes before another.variable < 0;
      if this.variable coemes after > 0
      if this.variable == 0 return 0;
      int res = this.nameCompareTo(another.name);
      if(res != 0)
         return res;
      res = this.id - another.id
      
   return res;

}

}