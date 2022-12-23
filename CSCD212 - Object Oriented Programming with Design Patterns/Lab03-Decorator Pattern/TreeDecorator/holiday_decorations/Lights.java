/* Name: Johanne McClenahan
 * Class: CSCD212
 * Description: Lights class is used to add Lights to a HolidayItem. Lights is a subclass of the TreeDecorator class
 * and inherits all methods from it and implements the price() method, overrides getDescription() method from superclass
 */

//Lights is stored in holiday_decorations folder
package holiday_decorations;

//Lights extends TreeDecorator, symbolizing that it is a subclass
public class Lights extends TreeDecorator{

	//base serves as the base on which each tree decorator is put on, stored as a private HolidayItem object
	private HolidayItem base;
	
	//constructor that takes in (HolidayItem) base and sets it to the base data field of the Lights object
	public Lights(HolidayItem base) {
		this.base = base;
	}
	
	//getDesciption() returns the base's description concatenated with Lights added to the list as a String value
	public String getDescription() {
		
		return base.getDescription() + ", Lights";
				
	}
	
	//price() returns the price of Lights added to the price of the base's price as an int value
	public int price() {
		
		return 5 + base.price();
		
	}

}
