/*Name: Johanne McClenahn
 *Class: CSCD212
 *Description: GameCharacter class is used for creating game characters and contains, the following methods
 *playSolo(): makes the player execute their solo act
 *playGuitar(): player plays their specific guitar
 *setSolo(): changes a player's solo to another one
 *setGuitar(): changes the guitar type of a player
 *
 */

//GameCharacter class used to create GameCharacter object and its methods. It is a superclass
public abstract class GameCharacter{
	//soloActBehavior stores what type of solo act a game character has. soloActBehavior is of type SoloBehavior
	protected SoloActBehavior soloActBehavior;
	//guitarType stores what type of guitar a game character is using. guitarType is of type GuitarType
	protected GuitarType guitarType;
	
	//constructor used for accepting parameters gt and sb, this is for the subclasses and creating their objects
	public GameCharacter(GuitarType gt,SoloActBehavior sb){
		guitarType = gt;
		soloActBehavior = sb;
	}
	//default constructor 
	public GameCharacter(){

	}
	
	//two setter methods that can set a new solo act or guitar type
	public void setSolo(SoloActBehavior soloActBehavior) {this.soloActBehavior = soloActBehavior;}
	public void setGuitar(GuitarType guitarType) {this.guitarType = guitarType;}
	
	//playSolo() used to have character do their solo act. uses soloAct() method from soloActBehavior interface, method itself is based on its
	//implementation from classes implementing the interface
	public void playSolo() {
		soloActBehavior.soloAct();
	}
	//playGuitar() used to have character do their solo act. uses guitar() method from GuitarType interface, method itself is based on its
	//implementation from classes implementing the interface
	public void playGuitar() {
		guitarType.guitar();
	}
	
	}
