/* Name: Johanne McClenahan
 * Class: CSCD212
 * Description: ColoradoBlueSpruce class is used to create Colorado blue spruce bases. It is a subclass of
 * HolidayItem and implements the abstract price() method
 */

//ColoradoBlueSpruce is stored in holiday_decorations folder
package holiday_decorations;

//ColoradoBlueSpruce extends HolidayItem, making it a subclass  
public class ColoradoBlueSpruce extends HolidayItem {

	//constructor uses superclass setDecription() to set the description of the ColoradoBlueSpruce object 
	public ColoradoBlueSpruce() {
		this.setDecription("Colorado Blue Spruce decorated with");
	}
	
	//price() returns the price of the Colorado Blue Spruce as an int value
	public int price() {
		return 50;
	}

}
