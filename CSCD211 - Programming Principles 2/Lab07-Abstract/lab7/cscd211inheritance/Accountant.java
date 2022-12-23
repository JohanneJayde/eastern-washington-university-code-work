package lab7.cscd211inheritance;
/*
Name: Johanne McClenahan
Class: CSCD211
Description: subclass Accountant class contains Accountant constructor, one accessor method, toString method, and subclass report method
Accountant is a subclass of the superclass Employee
*/

//Accountant class that is used to create Accountant objects
public class Accountant extends Employee{
//The parkingStipend accountants receive
private double parkingStipend;

//EVC additional parameter is a parking stipend.
public Accountant(final String name, final double basePayrate, final double additionalPayrate, final double parkingStipend){
   //calls super() in order to call superclass constructor (Employee)
   super(name, basePayrate, additionalPayrate);
   //throw IllegalArgumentException if parking stipend is less than 0.00
   if(parkingStipend < 0.00)
      throw new IllegalArgumentException("parking stipend is less than 0.00 in Accountant contructor");

   //assigns parkingStipend to parkingStipend field of Accountant object
   this.parkingStipend = parkingStipend;

}

//accessor method used to get an accountant's parking stipend
public double getParkingStipend(){
   return this.parkingStipend;
}
//report method used to print out an accountant's salary and parking stipend
public void report(){
   System.out.printf("I am an accountant. I make %.1f plus a parking allowance of %.1f\n", getSalary(), getParkingStipend());

}
//toString method used to print out an employee's job, along with superclass's toString, which prints an employee's name
public String toString(){
   //calls superclass's toString method to print out an employee's name
   return "Accountant: " + super.toString();
}

}