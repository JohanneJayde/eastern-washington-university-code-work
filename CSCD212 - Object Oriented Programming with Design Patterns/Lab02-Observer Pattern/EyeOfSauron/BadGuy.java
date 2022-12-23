/* Name: Johanne McClenahan
 * Class: CSDC212
 * Description: BadGuy class is used for creating BadGuy objects. It contains one constructor and a defeated() method. BadGuy implements the Observer interface
 * because of this, it implements an update() method used for in tandem with EyeOfSauron's enemiesSpotted() method in order to properly update BadGuy objects
 * if they are registered as an observer
 * 
 * 
 */

//importing built-libraries to use in BadGuy class
import java.util.Observer;
import java.util.Observable;

@SuppressWarnings("deprecation")
//BadGuy class implements the Observer interface
public class BadGuy implements Observer {
	//String name stores the name of the bad guy as private variable
	private String name;
	//EyeOfSauron eyeofSauron is used to observe GoodGuys Objects
	private EyeOfSauron eyeOfSauron;
	
	//constructor that takes in an EyeOfSauron object and String name
	//eos.addObserver(this) is used in order to add the instance of the BadGuy objects as an observer of an EyeOfSauron object, in this case eos
	public BadGuy(EyeOfSauron eos,String name) {
		this.name = name;
		this.eyeOfSauron = eos;
		eos.addObserver(this);
	}
	
	//update() takes in an Observable object as well as a Object arg
	public void update(Observable obs, Object arg){
		//if-statement is used to check whether obs is a a instance of EyeOfSauron which is of type Observable
		if(obs instanceof EyeOfSauron) {
			//gg is assigned to arg which has been casted as a GoodGuys object in order to display the new values of GoodGuys gg
			GoodGuys gg = (GoodGuys) arg;
			//printing out the name of the instance of the BadGuy object and printing printing gg (calls the tostirng method from GoodGuys class)
			System.out.println(this.name + " knows about - \n" + gg + "\n");
		}
	}
	
	//defaeted() is used to unregister a BadGuy as an observer and display a message saying the BadGuy was defeated
	void defeated() {
		//prints that the BadGuy's name data field was defeated
		System.out.println(this.name + " was defeated");
		//deleteObserver(this) is used to unregister the instance of a BadGuy object with the Observable eyeOfSauron
		//(this) is used to remove the BadGuy object who called defeated() as an observer 
		eyeOfSauron.deleteObserver(this);
		
	}

}
