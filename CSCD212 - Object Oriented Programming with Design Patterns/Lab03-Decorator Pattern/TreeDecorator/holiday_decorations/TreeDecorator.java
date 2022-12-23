/* Name: Johanne McClenahan
 * Class: CSCD212
 * Description: TreeDecorator serves as a decorator class that is a the subclass of HolidayItem.
 * This class serves as the framework for items that can be used to decorate a tree rather than just a 
 * generic holiday item
 * Method List:
 * 
 * (superclass) getDescription(): gets the description of the HolidayItem
 * (superclass) setDescription(): sets the description of the HolidayItem
 * price(): (abstract) store the price of the HolidayItem
 */

//HolidayItem is stored in holiday_decorations folder
package holiday_decorations;

//TreeDecorator extends HolidayItem and therefore must implement any abtract methods
public abstract class TreeDecorator extends HolidayItem{

	//empty constructor
	public TreeDecorator() {

	}

	//price() stores the price of a tree decorator as an int value and is an abstract method 
	public abstract int price();
}
