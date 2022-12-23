/* Name: Johanne McClenahan
 * Class: CSCD212
 * Description: BallsBlue class is used to add blue balls to a HolidayItem. BallsBlue is a subclass of the TreeDecorator class
 * and inherits all methods from it and implements the price() method, overrides getDescription() method from superclass
 */

//BallsBlue is stored in holiday_decorations folder
package holiday_decorations;

//BallsBlue extends TreeDecorator, symbolizing that it is a subclass
public class BallsBlue extends TreeDecorator{

	//base serves as the base on which each tree decorator is put on, stored as a private HolidayItem object
	private HolidayItem base;

	//constructor that takes in (HolidayItem) base and sets it to the base data field of the BallsBlue object
	public BallsBlue(HolidayItem base) {
		this.base = base;
	}
	
	//getDesciption() returns the base's description concatenated with blue balls added to the list as a String value
	public String getDescription() {
		
		return base.getDescription() + ", Blue Balls";
				
	}

	//price() returns the price of blue balls added to the price of the base's price as an int value
	public int price() {
		
		return 2 + base.price();
		
	}

}
