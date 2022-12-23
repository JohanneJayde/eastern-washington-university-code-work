/*Name: Johanne McClenahn
 *Class: CSCD212
 *Description: GameCharacterSlash is a subclass of the superclass GameCharacter that serves as the basis for Slash
 *as a player. He has a default guitar as well as solo act. Two method are overridden from the superclass and are the only two subclass methods
 *playSolo(): shows Slash doing his solo act
 *playGuitar(): shows Slash playing his guitar
 *
 */

//GameCharacterSlash extends GameCharacter and therefore inherits all methods and the constructor from superclass GameCharacter
public class GameCharacterSlash extends GameCharacter{
	//constructor for GameCharacterSlash, contains two fields for the type of guitar and what solo act the Slash has
	//by default Slash has a Gibson Flying V guitar and his solo act is setting his guitar on fire
	public GameCharacterSlash(){
		guitarType = new GibsonFlyingV();
		soloActBehavior = new SetGuitarOnFire();
	}
	//constructor used for creating Slash with a different guitar and solo act different from his default.
	//accepts a GuitarType and SoloActBehavior and uses super() to call constructor of superclass
	public GameCharacterSlash(GuitarType gt, SoloActBehavior sb) {
		super(gt, sb);
	}
	
	//playGuitar() overrides the superclass method and displays Slash's name followed by using the guitar() method to display what guitar he is playing
	public void playGuitar(){
		System.out.print("Slash ");
		guitarType.guitar();
		
	}
	//playSolo() overrides the superclass method and displays Slash's name followed by using the soloAct() method to show what solo act he is doing
	public void playSolo() {
		System.out.print("Slash ");
		soloActBehavior.soloAct();
	}
}
