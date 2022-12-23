package lab8.cscd211interfaces;
/*
Name: Johanne McClenahan
Class: CSCD211
Description: Payroll is used to store the base payroll all teams are payed and contains abstract calculatePayroll() method
*/
/**
 * The interface Taxable that contains a constant for the current tax rate and an abstract method to calculateTaxes
 */
public interface Payroll
{
   /**
    * Tax rate is set to 0.09
    */
   public static final int BASE_PAYROLL = 1500000;
   
   /**
    * The calculateTaxes is defined in the implementing class
    * @return double Representing the calculated taxes
    */
   public abstract int calculatePayroll();
}