/* Name: Johanne McClenahan
 * Class: CSCD212
 * Description: Ruffles class is used to add ruffles to a HolidayItem. Ruffles is a subclass of the TreeDecorator class
 * and inherits all methods from it and implements the price() method, overrides getDescription() method from superclass
 */

//Ruffles is stored in holiday_decorations folder
package holiday_decorations;

//Ruffles extends TreeDecorator, symbolizing that it is a subclass
public class Ruffles extends TreeDecorator{

	//base serves as the base on which each tree decorator is put on, stored as a private HolidayItem object
	private HolidayItem base;
	
	//constructor that takes in (HolidayItem) base and sets it to the base data field of the Ruffles object
	public Ruffles(HolidayItem base) {
		this.base = base;
	}
	
	//getDesciption() returns the base's description concatenated with ruffles added to the list as a String value
	public String getDescription() {
		
		return base.getDescription() + ", Ruffles";
				
	}
	
	//price() returns the price of ruffles added to the price of the base's price as an int value
	public int price() {
		
		return 1 + base.price();
		
	}

}
