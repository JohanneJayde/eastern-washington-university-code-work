/*Name: Jonah McClenahn
 *Class: CSCD212
 *Description: JumpOffStage is used to store how jumping off stage behaves and implements SoloActBehavior and the soloAct() method
 *
 */

//JumpOffStage Class
public class JumpOffStage implements SoloActBehavior{
	//soloAct() is implemented from SoloActBehavior and displays that the player is jumping off the stage
	public void soloAct() {
		System.out.println("jumped off the stage!");
	}

}
