public class TestSauronEye {

	public static void main(String[] args) {
		//creating an EyeOfSauron object in order to test adding Observers for it to hold
        EyeOfSauron eye = new EyeOfSauron();
        //two BadGuy objects are constructed with different names and should be added to eye as Observers
        BadGuy saruman = new BadGuy(eye, "Saruman");
        BadGuy witchKing= new BadGuy(eye, "Witch King");
        //creating GoodGuys object with values in order to call the enemiesSpotted() method so that each BadGuy is updated with the GoodGuys int values
        eye.enemiesSpotted(new GoodGuys(1, 1, 2, 0)); //hobbits, elves, dwarves, men
 
        //enemiesSpotted call should result in a message from Saruman

        //and the Witch King that they know about 1 hobbit, 1 elf, 2 dwarves
        //BTW, the above numbers are HORRIBLE coding style and a bad code smell

        saruman.defeated(); //Saruman is no longer registered with the Eye
        eye.enemiesSpotted(new GoodGuys(4, 2, 2, 100)); //only the Witch King reports on the enemies
	

	}

}
