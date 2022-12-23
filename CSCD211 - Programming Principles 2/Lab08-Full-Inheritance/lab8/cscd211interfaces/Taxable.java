package lab8.cscd211interfaces;
/*
Name: Johanne McClenahan
Class: CSCD211
Description: Taxable is used to store the base tax rate all teams are charged and contains abstract calculateTaxes() method
*/
/**
 * The interface Taxable that contains a constant for the current tax rate and an abstract method to calculateTaxes
 */
public interface Taxable
{
   /**
    * Tax rate is set to 0.09
    */
   public static final double BASE_TAX_RATE = .09;
   
   /**
    * The calculateTaxes is defined in the implementing class
    * @return double Representing the calculated taxes
    */
   public abstract double calculateTaxes();
}