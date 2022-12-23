/* Name: Johanne McClenahan
 * Class: CSCD212
 * Description: Star class is used to add a star to a HolidayItem. Star is a subclass of the TreeDecorator class
 * and inherits all methods from it and implements the price() method, overrides getDescription() method from superclass
 */

//Star is stored in holiday_decorations folder
package holiday_decorations;

//Star extends TreeDecorator, symbolizing that it is a subclass
public class Star extends TreeDecorator{

	//base serves as the base on which each tree decorator is put on, stored as a private HolidayItem object
	private HolidayItem base;
	
	//constructor that takes in (HolidayItem) base and sets it to the base data field of the Star object
	public Star(final HolidayItem base) {
			this.base = base;
		}
		
	//getStar() is used to retrieve a star and add it to a HolidayItem
	//method also stops a user from adding more than one star to a particular HolidayItem object
	public static HolidayItem getStar(HolidayItem base) {
		
		//if-statement used to check whether or not a tree's description contains the word "star"
		if(base.getDescription().contains("star")) {
			//if the base does already contain a star, the program will display message saying that the tree already contains a star
			System.out.println("This three already contains a star!");
			
			//the base is returned without the a new star being added to the total price or tree's description
			return base;
		}
		
		//if no star have been added, then a new star is created and the new base is returned
		base = new Star(base);
		return base;
	}
	
	//getDesciption() returns the base's description concatenated with a star added to the list as a String value
	public String getDescription() {
		
		return base.getDescription() + ", star";
				
	}
	
	//price() returns the price of a star added to the price of the base's price as an int value
	public int price() {
		
		return 4 + base.price();
		
	}

}
