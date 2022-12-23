package lab7.cscd211inheritance;
/*
Name: Johanne McClenahan
Class: CSCD211
Description: subclass Lawyer class contains Lawyer constructor, one accessor method, toString method, and subclass report method
Lawyer is a subclass of the superclass Employee
*/

//Lawyer class that is used to create Lawyer objects
public class Lawyer extends Employee{
//the number of stock options a lawyer has
private int stockOptions;

//EVC additional parameter is stock options.
public Lawyer(final String name, final double basePayrate, final double additionalPayrate, final int stockOptions){
   //calls super() in order to call superclass constructor (Employee)
   super(name, basePayrate, additionalPayrate);
   //throw IllegalArgumentException if the stock option is less than 0
   if(stockOptions < 0)
      throw new IllegalArgumentException("stockOptions is less than 0 in Lawyer contructor");
   //assigns stockOptions to stockOptions field of Lawyer object
   this.stockOptions = stockOptions;

}
//accessor method that gets a lawyer's number of stock options
public int stockOptions(){
   return this.stockOptions;
}
//report method used to print out an lawyer's salary and stock options
public void report(){
   System.out.printf("I am a Lawyer. I get %.1f, and I have %d shares of stock.\n", getSalary(), stockOptions());

}
//toString method used to print out an employee's job, along with superclass's toString, which prints an employee's name
public String toString(){
   //calls superclass's toString method to print out an employee's name
   return "Lawyer: " + super.toString();
}


}