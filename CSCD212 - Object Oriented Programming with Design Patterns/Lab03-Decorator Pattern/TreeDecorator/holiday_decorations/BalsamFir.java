/* Name: Johanne McClenahan
 * Class: CSCD212
 * Description: BalsamFir class is used to create Colorado Balsam fir bases. It is a subclass of
 * HolidayItem and implements the abstract price() method
 */

//BalsamFir is stored in holiday_decorations folder
package holiday_decorations;

//BalsamFir extends HolidayItem, making it a subclass
public class BalsamFir extends HolidayItem {
	
	//constructor uses superclass setDecription() to set the description of the BalsamFir object 
	public BalsamFir() {
		this.setDecription("Balsam Fir decorated with");
	}
	
	//price() returns the price of the Balsam fir as an int value
	public int price() {
		return 25;
	}

}
