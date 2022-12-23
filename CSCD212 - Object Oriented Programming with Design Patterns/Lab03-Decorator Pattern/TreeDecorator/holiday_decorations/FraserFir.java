/* Name: Johanne McClenahan
 * Class: CSCD212
 * Description: FraserFir class is used to create Fraser fir bases. It is a subclass of
 * HolidayItem and implements the abstract price() method
 */ 

//FraserFir is stored in holiday_decorations folder
package holiday_decorations;

//FraserFir extends HolidayItem, making it a subclass
public class FraserFir extends HolidayItem {

	//constructor uses superclass setDecription() to set the description of the FraserFir object
	public FraserFir() {
		this.setDecription("Fraser Fir decorated with");
	}

	//price() returns the price of the Fraser fir as an int value
	public int price() {
		return 35;
	}
}
