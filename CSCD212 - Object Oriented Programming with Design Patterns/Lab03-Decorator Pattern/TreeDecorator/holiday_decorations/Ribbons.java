/* Name: Johanne McClenahan
 * Class: CSCD212
 * Description: Ribbons class is used to add Ribbons to a HolidayItem. Ribbons is a subclass of the TreeDecorator class
 * and inherits all methods from it and implements the price() method, overrides getDescription() method from superclass
 */

//Ribbons is stored in holiday_decorations folder
package holiday_decorations;

//Ribbons extends TreeDecorator, symbolizing that it is a subclass
public class Ribbons extends TreeDecorator{
	
	//base serves as the base on which each tree decorator is put on, stored as a private HolidayItem object
	private HolidayItem base;
	
	//constructor that takes in (HolidayItem) base and sets it to the base data field of the Ribbons object
	public Ribbons(HolidayItem base) {
		this.base = base;
	}
	
	//getDesciption() returns the base's description concatenated with Ribbons added to the list as a String value
	public String getDescription() {
		
		return base.getDescription() + ", Ribbons";
				
	}
	
	//price() returns the price of Ribbons added to the price of the base's price as an int value
	public int price() {
		
		return 2 + base.price();
		
	}

}
