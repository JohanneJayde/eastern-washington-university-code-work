/* Name: Johanne McClenahan
 * Class: CSCD212
 * Description: DouglasFir class is used to create Douglas fir bases. It is a subclass of
 * HolidayItem and implements the abstract price() method
 */ 

//DouglasFir is stored in holiday_decorations folder
package holiday_decorations;

//DouglasFir extends HolidayItem, making it a subclass
public class DouglasFir extends HolidayItem {

	//constructor uses superclass setDecription() to set the description of the DouglasFir object 
	public DouglasFir() {
		this.setDecription("Douglas Fir decorated with");
	}
	
	//price() returns the price of the Douglas fir as an int value
	public int price() {
		return 30;
	}

}
