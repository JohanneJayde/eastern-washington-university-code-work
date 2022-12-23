/* Name: Johanne McClenahan
 * Class: CSCD212
 * Description: BallsRed class is used to add red balls to a HolidayItem. BallsRed is a subclass of the TreeDecorator class
 * and inherits all methods from it and implements the price() method, overrides getDescription() method from superclass
 */

//BallsRed is stored in holiday_decorations folder
package holiday_decorations;

//BallsRed extends TreeDecorator, symbolizing that it is a subclass
public class BallsRed extends TreeDecorator{

	//base serves as the base on which each tree decorator is put on, stored as a private HolidayItem object
	private HolidayItem base;
	
	//constructor that takes in (HolidayItem) base and sets it to the base data field of the BallsRed object
	public BallsRed(HolidayItem base) {
		this.base = base;
	}
	
	//getDesciption() returns the base's description concatenated with red balls added to the list as a String value
	public String getDescription() {
		
		return base.getDescription() + ", Red Balls";
				
	}
	
	//price() returns the price of red balls added to the price of the base's price as an int value
	public int price() {
		
		return 1 + base.price();
		
	}

}
