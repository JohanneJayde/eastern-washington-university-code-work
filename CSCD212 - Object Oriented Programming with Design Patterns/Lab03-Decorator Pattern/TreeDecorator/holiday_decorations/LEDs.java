/* Name: Johanne McClenahan
 * Class: CSCD212
 * Description: LEDs class is used to add LEDs to a HolidayItem. LEDs is a subclass of the TreeDecorator class
 * and inherits all methods from it and implements the price() method, overrides getDescription() method from superclass
 */

//LEDs is stored in holiday_decorations folder
package holiday_decorations;

//LEDs extends TreeDecorator, symbolizing that it is a subclass
public class LEDs extends TreeDecorator{

	//base serves as the base on which each tree decorator is put on, stored as a private HolidayItem object
	private HolidayItem base;
	
	//constructor that takes in (HolidayItem) base and sets it to the base data field of the LEDs object
	public LEDs(HolidayItem base) {
		this.base = base;
	}
	
	//getDesciption() returns the base's description concatenated with LEDs added to the list as a String value
	public String getDescription() {
		
		return base.getDescription() + ", LEDs";
				
	}
	
	//price() returns the price of LEDs added to the price of the base's price as an int value
	public int price() {
		
		return 10 + base.price();
		
	}

}
