/*Name: Johanne McClenahn
 *Class: CSCD212
 *Description: GameCharacterYoung is a subclass of the superclass GameCharacter that serves as the basis for Angus Young
 *as a player. He has a default guitar as well as solo act. Two method are overridden from the superclass and are the only two subclass methods
 *playSolo(): shows Young doing his solo act
 *playGuitar(): shows Young playing his guitar
 *
 */

//GameCharacterYoung extends GameCharacter and therefore inherits all methods and the constructor from superclass GameCharacter
public class GameCharacterYoung extends GameCharacter{
	//constructor for GameCharacterYoung, contains two fields for the type of guitar and what solo act the Young has
	//by default Young has a Fender Telecaster guitar and his solo act is setting his guitar on fire
	public GameCharacterYoung(){
		guitarType = new FenderTelecaster();
		soloActBehavior = new SetGuitarOnFire();
	}
	//constructor used for creating Angus Young with a different guitar and solo act different from his default.
	//accepts a GuitarType and SoloActBehavior and uses super() to call constructor of superclass
	public GameCharacterYoung(GuitarType gt, SoloActBehavior sb) {
		super(gt, sb);
	}
	
	//playGuitar() overrides the superclass method and displays Young's name followed by using the guitar() method to display what guitar he is playing	
	public void playGuitar(){
		System.out.print("Angus Young ");
		guitarType.guitar();
		
	}
	//playSolo() overrides the superclass method and displays Young's name followed by using the soloAct() method to show what solo act he is doing
	public void playSolo() {
		System.out.print("Angus Young ");
		soloActBehavior.soloAct();
	}
}
