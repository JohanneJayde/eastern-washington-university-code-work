/*Name: Johanne McClenahn
 *Class: CSCD212
 *Description: Main file used to illustrate how to create a GameCharacter object, use methods to have the
 *character play a guitar and do a solo act. Two other methods are used to change the solo or guitar type
 */

//GuitarHero used to create objects and execute methods
public class GuitarHero {

	public static void main(String[] args) {
		//creating a GameCharacterSlash and wrapping it as a GameCharacter object player1. 
        GameCharacter player1 = new GameCharacterSlash(); //note that constructor could be designed to accept initial behaviors

        // e.g. GameCharacter player1 = new GameCharacterSlash(new GibsonFlyingV(), new SetGuitarOnFire());
        GameCharacter player3 = new GameCharacterYoung(new GibsonFlyingV(), new SetGuitarOnFire());
        //demonstrating how you can create one of the three game characters with different guitars and solo acts different from their default ones
        //Angus Young no longer has his default Fender Telecaster but instead created with a Gibson Flying V
        player3.playGuitar();		
        player3.playSolo();
        		
        //creating a GameCharacterHendrix and wrapping it as a GameCharacter object player2. 
        GameCharacter player2 = new GameCharacterHendrix();
        //using playGuitar() method to show how each GameCharacter object has a different guitar equipped
        player1.playGuitar();  //should print a message saying Slash is playing a Gibson Flying V
        player2.playGuitar(); //should print a message saying Jimi Hendrix is playing whatever you assigned in constructor
        //using playGuitar() method to show how each GameCharacter object has a different solo act
        player1.playSolo(); //should print a message saying Slash just set guitar on fire
        player2.playSolo(); //etc.

        //add code below to show the swapping of behaviors
        //setSolo() method is used to change the solo act for player1 followed by the playSolo() method
        player1.setSolo(new JumpOffStage()); 
        player1.playSolo();
        //setGuitar() method is used to change the guitar for player2 followed by the playGuitar() method
        player2.setGuitar(new FenderTelecaster()); 
        player2.playGuitar();
	}

}
