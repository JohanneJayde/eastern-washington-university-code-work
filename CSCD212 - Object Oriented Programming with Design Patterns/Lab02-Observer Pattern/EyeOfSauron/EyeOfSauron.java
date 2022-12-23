/* Name: Johanne McClenahan
 * Class: CSDC212
 * Description: EyeOfSauron Class is used to as a way to hold Observers (in this case, BadGuy objects) and holds one method: enemiesSpotted() which notifies all
 * observers registered with an EyeOfSauron that values have changed within a GoodGuys object. GoodGuys holds four int value data fields so if one of them change
 * an EyeOfSauron object is makes sure that any observers registered with be updated accordingly 
 * 
 */


import java.util.Observable;

@SuppressWarnings("deprecation")
public class EyeOfSauron extends Observable {

	//constructor for creating EyeOfSauron Object
	public EyeOfSauron() {
	
	}
	
	//enemiesSpotted used to notify BadGuys when any data fields of GoodGuys gg have changed
	void enemiesSpotted(GoodGuys gg){
		//setChanged() is used to show that gg has changed by setting its value to true
		setChanged();
		//notifyObservers is used to call update() and sends gg as an argument in order to properly inform observers of new values found in gg
		notifyObservers(gg);
		//clearChanged() sets the value from setChanged() back to false after each observer have been properly updated
		clearChanged();

		
	}

}
