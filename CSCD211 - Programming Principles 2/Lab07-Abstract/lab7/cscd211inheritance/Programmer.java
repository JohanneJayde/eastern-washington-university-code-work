package lab7.cscd211inheritance;
/*
Name: Johanne McClenahan
Class: CSCD211
Description: subclass Programmer class contains Programmer constructor, one accessor method, toString method, and subclass report method
Programmer is a subclass of the superclass Employee
*/

//Programmer class that is used to create Programmer objects
public class Programmer extends Employee{
//A programmer's status of having a bus pass or not
private boolean busPass;

//EVC additional parameter is a bus pass.
public Programmer(final String name, final double basePayrate, final double additionalPayrate, final boolean busPass){
   //calls super() in order to call superclass constructor (Employee)
   super(name, basePayrate, additionalPayrate);
   //assigns busPass to busPass field of Programmer object
   this.busPass = busPass;

}
//accessor method used to check whether or not a programmer has a bus pass or not
public boolean getBusPass(){
   return this.busPass;
}
//report method used to print out an programmer's salary and whether or not they have a bus pass
public void report(){
   //if-else statement calls getPass() method to check whether or not a bus pass is owned then the correct print statement is executed
   if(getBusPass() == false)
      System.out.printf("I am a programmer. I get %.1f, and I do not get a bus pass.\n", getSalary());
   else
      System.out.printf("I am a programmer. I get %.1f, and I get a bus pass.\n", getSalary());
}
//toString method used to print out an employee's job, along with superclass's toString, which prints an employee's name
@Override
public String toString(){
   ////calls superclass's toString method to print out an employee's name
   return "Programmer: " + super.toString();
}

}