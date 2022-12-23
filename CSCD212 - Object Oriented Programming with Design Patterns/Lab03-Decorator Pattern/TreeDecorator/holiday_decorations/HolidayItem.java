/* Name: Johanne McClenahan
 * Class: CSCD212
 * Description: HolidayItem is a abstract class that is used to create other objects
 * HolidayItem stores a description and price and also has an getter and setter method for the description
 * Method List:
 * getDescription(): gets the description of the HolidayItem
 * setDescription(): sets the description of the HolidayItem
 * price(): (abstract) store the price of the HolidayItem
 */


//HolidayItem is stored in holiday_decorations folder
package holiday_decorations;

//HolidayItem is used as an abstract class and doesn't directly initialized
public abstract class HolidayItem {

	//description stores the description of a HolidayItem as a protected String value
	protected String description;
	
	//empty constructor
	public HolidayItem() {
		
	}
	
	//getDescription() is used to return the description of the object who called it
	public String getDescription() {
		return this.description;
	}
	
	//setDescription() is used to set the description of an object 
	//takes in parameter desc
	public void setDecription(String desc) {
		this.description = desc;
	}
	
	
	//price() stores the price of an object as an int value
	//method is abstract and therefore, must be implemented by any subclasses 
	public abstract int price();

}
