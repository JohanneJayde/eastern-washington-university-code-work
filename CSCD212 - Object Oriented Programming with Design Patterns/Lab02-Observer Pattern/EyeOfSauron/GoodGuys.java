/* Name: Johanne McClenahan
 * Class: CSCD212
 * Description: GoodGuys class is used to create GoodGuys objects. Holds a toString() method that is used to print the object out as a String object
 * also holds two constructors, one empty and one for taking in four int values 
 * 
 */

//GoodGuys class represents the amount of GoodGuys the good guys on the field such as hobbits, dwarves, elves, and humans
public class GoodGuys {
	//private hobbits represents the number of hobbits as an int value
	private int hobbits;
	//private elves represents the number of elves as an int value
	private int elves;
	//private dwarves represents the number of dwarves as an int value
	private int dwarves;
	//private humans represents the number of humans as an int value
	private int humans;
	
	//empty constructor 
	public GoodGuys() {
		
	}
	
	//constructor that takes in four int values that represent how many hobbits, elves, dwarves, and humans there are
	public GoodGuys(int hobbits, int elves, int dwarves, int humans) {
		this.hobbits = hobbits;
		this.elves = elves;
		this.dwarves = dwarves;
		this.humans = humans;
	}

	//toString() is used to show a String representation of a GoodGuys object
	public String toString() {
		
		return ("Hobbits: " + this.hobbits + "\nElves: " + this.elves + "\nDwarves: " + this.dwarves + "\nHumans: " + this.humans);
	}
}
