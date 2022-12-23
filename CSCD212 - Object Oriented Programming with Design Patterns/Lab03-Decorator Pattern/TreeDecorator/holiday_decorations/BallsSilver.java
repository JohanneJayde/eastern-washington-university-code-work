/* Name: Johanne McClenahan
 * Class: CSCD212
 * Description: BallsSilver class is used to add silver balls to a HolidayItem. BallsSilver is a subclass of the TreeDecorator class
 * and inherits all methods from it and implements the price() method, overrides getDescription() method from superclass
 */

//BallsSilver is stored in holiday_decorations folder
package holiday_decorations;

//BallsSilver extends TreeDecorator, symbolizing that it is a subclass
public class BallsSilver extends TreeDecorator{

	//base serves as the base on which each tree decorator is put on, stored as a private HolidayItem object
	private HolidayItem base;
	
	//constructor that takes in (HolidayItem) base and sets it to the base data field of the BallsSilver object
	public BallsSilver(HolidayItem base) {
		this.base = base;
	}
	
	//getDesciption() returns the base's description concatenated with silver balls added to the list as a String value
	public String getDescription() {
		
		return base.getDescription() + ", Silver Balls";
				
	}
	
	//price() returns the price of silver balls added to the price of the base's price as an int value
	public int price() {
		
		return 3 + base.price();
		
	}

}
