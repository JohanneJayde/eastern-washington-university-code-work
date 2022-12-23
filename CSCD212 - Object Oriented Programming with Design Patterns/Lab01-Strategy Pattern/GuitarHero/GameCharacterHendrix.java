/*Name: Johanne McClenahn
 *Class: CSCD212
 *Description: GameCharacterHendrix is a subclass of the superclass GameCharacter that serves as the basis for Jimi Hendrix
 *as a player. He has a default guitar as well as solo act. Two method are overridden from the superclass and are the only two subclass methods
 *playSolo(): shows Hendrix doing his solo act
 *playGuitar(): shows Hendrix playing his guitar
 *
 */

//GameCharacterHendrix extends GameCharacter and therefore inherits all methods and the constructor from superclass GameCharacter
public class GameCharacterHendrix extends GameCharacter{
	//constructor for GameCharacterHendrix, contains two fields for the type of guitar and what solo act the Slash has
	//by default Hendrix has a Gibson SG guitar and his solo act is jumping off the stage
	public GameCharacterHendrix() {
		guitarType = new GibsonSG();
		soloActBehavior = new JumpOffStage();
	}
	//constructor used for creating Jimi Hendrix with a different guitar and solo act different from his default.
	//accepts a GuitarType and SoloActBehavior and uses super() to call constructor of superclass
	public GameCharacterHendrix(GuitarType gt, SoloActBehavior sb) {
		super(gt, sb);
	}
	
	//playGuitar() overrides the superclass method and displays Hendrix's name followed by using the guitar() method to display what guitar he is playing	
	public void playGuitar(){
		System.out.print("Hendrix ");
		guitarType.guitar();
		
	}
	//playSolo() overrides the superclass method and displays Hendrix's name followed by using the soloAct() method to show what solo act he is doing
	public void playSolo() {
		System.out.print("Hendrix ");
		soloActBehavior.soloAct();
	}
}
